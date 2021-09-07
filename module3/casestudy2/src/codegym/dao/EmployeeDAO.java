package codegym.dao;

import codegym.model.Customer;
import codegym.model.Emplyoee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeDAO implements IEmplyeeDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study3?allowPublicKeyRetrieval=true&useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456";

    public EmployeeDAO() {
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
    public Emplyoee selectEmployee(int id) {
        String SELECT_EMPLOYEE_BY_ID = "select employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_id,division_id from employees where employee_id =?";
        Emplyoee emplyoee = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String name = rs.getString("employee_name");
                Date birthday = rs.getDate("employee_birthday");
                String idCard = rs.getString("employee_id_card");
                double salary = rs.getDouble("employee_salary");
                String phone = rs.getString("employee_phone");
                String email = rs.getString("employee_email");
                String address = rs.getString("employee_address");
                int position = rs.getInt("position_id");
                int education = rs.getInt("education_id");
                int division = rs.getInt("division_id");
                emplyoee = new Emplyoee(id,name,birthday,idCard,salary,phone,email,address,position,education,division);
            }
        } catch (SQLException e) {
        }
        return emplyoee;
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        String DELETE_EMPLOYEE_SQL = "delete from employees where employee_id = ?";
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public List<Emplyoee> showShowAllEmployee() {
        String SELECT_ALL_EMPLOYEE = "select * from employees";
        List<Emplyoee> emplyees = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);) {
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("employee_id");
                    String name = rs.getString("employee_name");
                    Date birthday = rs.getDate("employee_birthday");
                    String idCard = rs.getString("employee_id_card");
                    double salary = rs.getDouble("employee_salary");
                    String phone = rs.getString("employee_phone");
                    String email = rs.getString("employee_email");
                    String address = rs.getString("employee_address");
                    int position = rs.getInt("position_id");
                    int education = rs.getInt("education_id");
                    int division = rs.getInt("division_id");
                    emplyees.add(new Emplyoee(id,name,birthday,idCard,salary,phone,email,address,position,education,division));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emplyees;
    }

    @Override
    public void insertEmployee(String name, Date birthday, String idCard, double salary, String phone, String email, String address, int position, int education, int division) {
        String INSERT_EMPLOYEE_SQL = "INSERT INTO employees" + "  (employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_id,division_id) VALUES " +
                " (?,?,?,?,?,?,?,?,?,?);";
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, name);
            preparedStatement.setDate(2, new java.sql.Date(birthday.getTime()));
            preparedStatement.setString(3, idCard);
            preparedStatement.setDouble(4, salary);
            preparedStatement.setString(5, phone);
            preparedStatement.setString(6, email);
            preparedStatement.setString(7, address);
            preparedStatement.setInt(8, position);
            preparedStatement.setInt(9, education);
            preparedStatement.setInt(10, division);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }

    @Override
    public boolean updateEmployee(int id, String name, Date birthday, String idCard, double salary, String phone, String email, String address, int position, int education, int division) {
        boolean rowUpdated = false;
        System.out.println("hihi");
        String UPDATE_EMPLOYEE_SQL = "update employees set employee_name = ?, employee_birthday = ?,employee_id_card= ?, employee_salary =?, employee_phone =?, employee_email =?, employee_address =?, position_id =?, education_id =?, division_id =? where employee_id = ?;";
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL);) {
            System.out.println("hehe");
            System.out.println(statement);
            statement.setString(1, name);
            statement.setDate(2, new java.sql.Date(birthday.getTime()));
            statement.setString(3, idCard);
            statement.setDouble(4, salary);
            statement.setString(5, phone);
            statement.setString(6, email);
            statement.setString(7, address);
            statement.setInt(8, position);
            statement.setInt(9, education);
            statement.setInt(10, division);
            statement.setInt(11, id);

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Emplyoee> showEmployee(int id) {
        String SELECT_EMPLOYEE_FIND = "select * from employees where employee_id = ?";
        List<Emplyoee> emplyoees = new ArrayList<>();
        try {
            try (Connection connection = getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_FIND);) {
                preparedStatement.setInt(1,id);
                System.out.println(preparedStatement);
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int ide = rs.getInt("employee_id");
                    String name = rs.getString("employee_name");
                    Date birthday = rs.getDate("employee_birthday");
                    String idCard = rs.getString("employee_id_card");
                    double salary = rs.getDouble("employee_salary");
                    String phone = rs.getString("employee_phone");
                    String email = rs.getString("employee_email");
                    String address = rs.getString("employee_address");
                    int position = rs.getInt("position_id");
                    int education = rs.getInt("education_id");
                    int division = rs.getInt("division_id");
                    emplyoees.add(new Emplyoee(id,name,birthday,idCard,salary,phone,email,address,position,education,division));
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return emplyoees;
    }


}
