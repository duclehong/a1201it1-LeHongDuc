package codegym.dao;



import codegym.common.Validate;
import codegym.model.Customer;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDAO implements ICustomerDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study3?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO customers" + "  (customer_type_id, customer_name, customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) VALUES " +
            " (?,?,?,?,?,?,?,?);";

    private static final String SELECT_USER_BY_ID = "select id,name,email,country from users where id =?";
    private static final String SELECT_CUSTOMER_BY_ID = "select customer_type_id , customer_name,customer_birthday, customer_gender, customer_id_card, customer_phone , customer_email, customer_address from customers where customer_id =?";
    private static final String SELECT_ALL_CUSTOMER = "select * from customers";
    private static final String SELECT_CUSTOMER_FIND = "select * from customers where customer_id = ?";
    private static final String DELETE_CUSTOMER_SQL = "delete from customers where customer_id = ?";
    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customers set customer_type_id = ?, customer_name = ?,customer_birthday= ?, customer_gender =?, customer_id_card =?, customer_phone =?, customer_email =?, customer_address =? where customer_id = ?;";

//    private static List<Customer> customers2;
//    static {
//        customers2 = new ArrayList<>();
//        customers2.add(new Customer(1,2,"hehe",2020-04-01,));
//        customers2.add(new Customer(2,3,"duck5", Validate.strToDate("2001-01-01"),"22.5","0256142654","dyc@gmail.com","na"));
//        customers2.add(new Customer(3,1,"duck37","2021-09-04","15233321",22.5,"0256142654","dyc@gmail.com","nghệ an",2,2,2,"dau"));
//        customers2.add(new Customer(4,2,"duck55","2021-09-04","15233321",22.5,"0256142654","dyc@gmail.com","nghệ an",2,2,2,"dau"));
//        customers2.add(new Customer(5,2,"duck1","2021-09-04","15233321",22.5,"0256142654","dyc@gmail.com","nghệ an",2,2,2,"dau"));
//        customers2.add(new Customer(6,2,"duck4","2021-09-04","15233321",22.5,"0256142654","dyc@gmail.com","nghệ an",2,2,2,"dau"));
//    }

    public CustomerDAO() {
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
    public void insertCustomer(Customer customer) throws SQLException {

        System.out.println(INSERT_CUSTOMER_SQL);
        // try-with-resource statement will auto close the connection.
        System.out.println(customer.getType());
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getType());
            preparedStatement.setString(2, customer.getName());
            preparedStatement.setDate(3, (java.sql.Date) customer.getBirthday());
            preparedStatement.setString(4, customer.getGender());
            preparedStatement.setString(5, customer.getIdCard());
            preparedStatement.setString(6, customer.getPhone());
            preparedStatement.setString(7, customer.getEmail());
            preparedStatement.setString(8, customer.getAddress());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int type = rs.getInt("customer_type_id");
                String name = rs.getString("customer_name");
                Date birthday = rs.getDate("customer_birthday");
                String gender = rs.getString("customer_gender");
                String idCard = rs.getString("customer_id_card");
                String phone = rs.getString("customer_phone");
                String email = rs.getString("customer_email");
                String address = rs.getString("customer_address");
                customer = new Customer(id,type,name,birthday,gender,idCard,phone,email,address);
            }
        } catch (SQLException e) {
        }
        return customer;
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return null;
    }

    @Override
    public boolean deleteCustomer(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateCustomer(Customer customer) throws SQLException {
        return false;
    }

    @Override
    public List<Customer> showAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER);) {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    System.out.println(id);
                    int type = rs.getInt("customer_type_id");
                    String name = rs.getString("customer_name");
                    Date birthday = rs.getDate("customer_birthday");
                    String gender = rs.getString("customer_gender");
                    String idCard = rs.getString("customer_id_card");
                    String phone = rs.getString("customer_phone");
                    String email = rs.getString("customer_email");
                    String address = rs.getString("customer_address");
                    customers.add(new Customer(id,type,name,birthday,gender,idCard,phone,email,address));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;

    }

    @Override
    public void insertCustomer2(int type, String name, Date birthday, String gender, String idCard, String phone, String email, String address) {
        System.out.println(INSERT_CUSTOMER_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, type);
            System.out.println(type);
            preparedStatement.setString(2, name);
            System.out.println(name);
            preparedStatement.setDate(3, new java.sql.Date(birthday.getTime()));
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, idCard);
            preparedStatement.setString(6, phone);
            preparedStatement.setString(7, email);
            preparedStatement.setString(8, address);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean updateCustomer(int id, int type, String name, Date birthday, String gender, String idCard, String phone, String email, String address) {
        boolean rowUpdated = false;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL);) {
            statement.setInt(1, type);
            System.out.println(type);
            statement.setString(2, name);
            System.out.println(name);
            statement.setDate(3, new java.sql.Date(birthday.getTime()));
            statement.setString(4, gender);
            statement.setString(5, idCard);
            statement.setString(6, phone);
            statement.setString(7, email);
            statement.setString(8, address);
            statement.setInt(9, id);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Customer> showCustomerFind(int idFind) {
        List<Customer> customers = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_FIND);) {
                preparedStatement.setInt(1,idFind);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("customer_id");
                    System.out.println(id);
                    int type = rs.getInt("customer_type_id");
                    String name = rs.getString("customer_name");
                    Date birthday = rs.getDate("customer_birthday");
                    String gender = rs.getString("customer_gender");
                    String idCard = rs.getString("customer_id_card");
                    String phone = rs.getString("customer_phone");
                    String email = rs.getString("customer_email");
                    String address = rs.getString("customer_address");
                    customers.add(new Customer(id,type,name,birthday,gender,idCard,phone,email,address));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customers;
    }


}
