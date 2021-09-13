package codegym.dao;

import codegym.model.Product;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IProductDAO {
    public Product selectProduct(int id);
    public boolean deleteProduct(int id) throws SQLException;
    public List<Product> showAllProduct();

    public  void insertProduct(
             String name,
             double cost,
             int quantity,
             String color,
             String des,
             int category);

    public boolean updateProduct(int id,
                                 String name,
                                 double cost,
                                 int quantity,
                                 String color,
                                 String des,
                                 int category);
    public List<Product> showProductFind(int id);
}
