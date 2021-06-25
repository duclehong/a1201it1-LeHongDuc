package models;

public class Villa extends Services {
    private String roomStanadard;
    private String otherDescription;
    private double swimingPoolArea;
    private int numOfFloors;

    public Villa() {
    }

    public Villa(String id, String name, double acreage, double rentalCosts, int maxNumOfPeople, String rentalType, String roomStanadard, String otherDescription, double swimingPoolArea, int numOfFloors) {
        super(id, name, acreage, rentalCosts, maxNumOfPeople, rentalType);
        this.roomStanadard = roomStanadard;
        this.otherDescription = otherDescription;
        this.swimingPoolArea = swimingPoolArea;
        this.numOfFloors = numOfFloors;
    }

    public String getRoomStanadard() {
        return roomStanadard;
    }

    public void setRoomStanadard(String roomStanadard) {
        this.roomStanadard = roomStanadard;
    }

    public String getOtherDescription() {
        return otherDescription;
    }

    public void setOtherDescription(String otherDescription) {
        this.otherDescription = otherDescription;
    }

    public double getSwimingPoolArea() {
        return swimingPoolArea;
    }

    public void setSwimingPoolArea(double swimingPoolArea) {
        this.swimingPoolArea = swimingPoolArea;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStanadard=" + roomStanadard +
                ", otherDescription='" + otherDescription + '\'' +
                ", swimingPoolArea=" + swimingPoolArea +
                ", numOfFloors=" + numOfFloors +
                '}' + super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(this.toString());
    }
}
