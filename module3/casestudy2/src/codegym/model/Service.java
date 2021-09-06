package codegym.model;

public class Service {
    private int id;
    private String name;
    private int area;
    private double cost;
    private int maxPeople;
    private int typeRent;
    private int type;
    private String standardRoom;
    private String description;
    private double poolArea;
    private int numberOfFloors;

    public Service() {
    }

    public Service(int id, String name, int area, double cost, int maxPeople, int typeRent, int type, String standardRoom, String description, double poolArea, int numberOfFloors) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.typeRent = typeRent;
        this.type = type;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public int getTypeRent() {
        return typeRent;
    }

    public void setTypeRent(int typeRent) {
        this.typeRent = typeRent;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }
}
