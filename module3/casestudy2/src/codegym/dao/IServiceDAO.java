package codegym.dao;

import java.util.Date;

public interface IServiceDAO {
    public  void insertService(  String name,
             int area,
             double cost,
             int maxPeople,
             int typeRent,
             int type,
             String standardRoom,
             String description,
             double poolArea,
             int numberOfFloors);
}
