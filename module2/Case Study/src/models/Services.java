package models;

public abstract class Services {
    private String id;
    private String name;
    private double acreage;
    private double rentalCosts;
    private int maxNumOfPeople;
    private String rentalType;

    public Services() {
    }

    public Services(String id, String name, double acreage, double rentalCosts, int maxNumOfPeople, String rentalType) {
        this.id = id;
        this.name = name;
        this.acreage = acreage;
        this.rentalCosts = rentalCosts;
        this.maxNumOfPeople = maxNumOfPeople;
        this.rentalType = rentalType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAcreage() {
        return acreage;
    }

    public void setAcreage(double acreage) {
        this.acreage = acreage;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getMaxNumOfPeople() {
        return maxNumOfPeople;
    }

    public void setMaxNumOfPeople(int maxNumOfPeople) {
        this.maxNumOfPeople = maxNumOfPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "Services{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", acreage=" + acreage +
                ", rentalCosts=" + rentalCosts +
                ", maxNumOfPeople=" + maxNumOfPeople +
                ", rentalType=" + rentalType +
                '}';
    }

    public abstract void showInfor();
}
