package codegym.dao;

import codegym.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductDAO implements IProductDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_module?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    public ProductDAO() {
    }
    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
    @Override


    public Product selectProduct(int id) {
        Product product = null;
        String SELECT_CUSTOMER_BY_ID = "select product_name, product_cost,product_quantity,product_color,product_des,cartegory_id from product where product_id =?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("product_name");
                double cost = rs.getDouble("product_cost");
                int quantity = rs.getInt("product_quantity");
                String color = rs.getString("product_color");
                String des = rs.getString("product_des");
                int category = rs.getInt("cartegory_id");
                product = new Product(id,name,cost,quantity,color,des,category);
            }
        } catch (SQLException e) {
        }
        return product;
    }

    @Override
    public boolean deleteProduct(int id) throws SQLException {
        String DELETE_PRODUCT_SQL = "delete from product where product_id = ?";
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_PRODUCT_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Product> showAllProduct() {
        String SELECT_ALL_PRODUCT = "select * from product";
        List<Product> products = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);) {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {

                    int id = rs.getInt("product_id");
                    String name = rs.getString("product_name");
                    double cost = rs.getDouble("product_cost");
                    int quantity = rs.getInt("product_quantity");
                    String color = rs.getString("product_color");
                    String des = rs.getString("product_des");
                    int category = rs.getInt("cartegory_id");

                    products.add(new Product(id,name,cost,quantity,color,des,category));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }

    @Override
    public void insertProduct(String name, double cost, int quantity, String color, String des, int category) {
        String INSERT_PRODUCT_SQL = "INSERT INTO product" + "  ( product_name, product_cost,product_quantity,product_color,product_des,cartegory_id) VALUES " +
                " (?,?,?,?,?,?);";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, cost);
            preparedStatement.setInt(3, quantity);
            preparedStatement.setString(4, color);
            preparedStatement.setString(5, des);
            preparedStatement.setInt(6, category);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean updateProduct(int id, String name, double cost, int quantity, String color, String des, int category) {
        boolean rowUpdated = false;
        String UPDATE_PRODUCT_SQL = "update product set  product_name =?, product_cost =?,product_quantity =?,product_color =?,product_des =?,cartegory_id =? where product_id = ?;";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            System.out.println("hehe");
            System.out.println(statement);
            statement.setString(1, name);
            statement.setDouble(2, cost);
            statement.setInt(3, quantity);
            statement.setString(4, color);
            statement.setString(5, des);
            statement.setInt(6, category);
            statement.setInt(7, id);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Product> showProductFind(int id) {
        String SELECT_PRODUCT = "select * from product where product_cost = ?";
        List<Product> products = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT);) {
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {

                    String name = rs.getString("product_name");
                    double cost = rs.getDouble("product_cost");
                    int quantity = rs.getInt("product_quantity");
                    String color = rs.getString("product_color");
                    String des = rs.getString("product_des");
                    int category = rs.getInt("cartegory_id");

                    products.add(new Product(id,name,cost,quantity,color,des,category));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return products;
    }
}
