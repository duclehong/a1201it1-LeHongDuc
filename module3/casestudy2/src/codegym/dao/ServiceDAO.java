package codegym.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceDAO implements IServiceDAO {
    public ServiceDAO() {
    }
    protected Connection getConnection() {
         String jdbcURL = "jdbc:mysql://localhost:3306/case_study3?allowPublicKeyRetrieval=true&useSSL=false";
         String jdbcUsername = "root";
         String jdbcPassword = "123456";
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
    public void insertService(String name, int area, double cost, int maxPeople, int typeRent, int type, String standardRoom, String description, double poolArea, int numberOfFloors) {
        String INSERT_SERVICE_SQL = "INSERT INTO services" + "  (service_name, service_area, service_cost,service_max_people,rent_type_id,service_type_id,standard_room,des_other_convenient,pool_area,number_of_floors) VALUES " +
                " (?,?,?,?,?,?,?,?,?,?);";

                System.out.println(INSERT_SERVICE_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL)) {
            preparedStatement.setString(1, name);
            System.out.println(type);
            preparedStatement.setInt(2, area);
            System.out.println(name);
            preparedStatement.setDouble(3, cost);
            preparedStatement.setInt(4, maxPeople);
            preparedStatement.setInt(5, typeRent);
            preparedStatement.setInt(6, type);
            preparedStatement.setString(7, standardRoom);
            preparedStatement.setString(8, description);
            preparedStatement.setDouble(9, poolArea);
            preparedStatement.setInt(10, numberOfFloors);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
        }
    }
}
