package codegym.dao;



import codegym.model.Customer;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ICustomerDAO {
    public Customer selectCustomer(int id);
    public boolean deleteCustomer(int id) throws SQLException;
    public List<Customer> showAllCustomer();

    public  void insertCustomer2(int type, String name, Date birthday, String gender, String idCard, String phone, String email, String address);

    public boolean updateCustomer(int id, int type, String name, Date birthday, String gender, String idCard, String phone, String email, String address);
    public List<Customer> showCustomerFind(int id);

}
