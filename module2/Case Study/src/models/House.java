package models;

public class House extends Services {
    private String roomStanadard;
    private String otherDescription;
    private int numOfFloors;

    public House() {
    }

    public House(String id, String name, double acreage, double rentalCosts, int maxNumOfPeople, String rentalType, String roomStanadard, String otherDescription, int numOfFloors) {
        super(id, name, acreage, rentalCosts, maxNumOfPeople, rentalType);
        this.roomStanadard = roomStanadard;
        this.otherDescription = otherDescription;
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

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStanadard=" + roomStanadard +
                ", otherDescription='" + otherDescription + '\'' +
                ", numOfFloors=" + numOfFloors +
                '}' + super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }
}
