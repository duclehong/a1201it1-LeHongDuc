package codegym.dao;

import codegym.model.Emplyoee;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IEmplyeeDAO {
    public Emplyoee selectEmployee(int id);
    public boolean deleteEmployee(int id) throws SQLException;
    public List<Emplyoee> showShowAllEmployee();

    public  void insertEmployee(String name,
             Date birthday,
             String idCard,
             double salary,
             String phone,
             String email,
             String address,
             int position,
             int education,
             int division);

    public boolean updateEmployee(int id,
                                  String name,
                                  Date birthday,
                                  String idCard,
                                  double salary,
                                  String phone,
                                  String email,
                                  String address,
                                  int position,
                                  int education,
                                  int division);
    public List<Emplyoee> showEmployee(int id);
}
