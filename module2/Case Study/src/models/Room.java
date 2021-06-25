package models;

public class Room extends Services {
    private ExtraService extraService;

    public Room() {
    }

    public Room(String id, String name, double acreage, double rentalCosts, int maxNumOfPeople, String rentalType, ExtraService extraService) {
        super(id, name, acreage, rentalCosts, maxNumOfPeople, rentalType);
        this.extraService = extraService;
    }

    public ExtraService getExtraService() {
        return extraService;
    }

    public void setExtraService(ExtraService extraService) {
        this.extraService = extraService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "extraService=" + extraService +
                '}'+super.toString();
    }

    @Override
    public void showInfor() {
        System.out.println(toString());
    }
}
