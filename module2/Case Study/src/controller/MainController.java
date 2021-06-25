package controller;

import commons.FileUtils;
import commons.StringUtils;
import commons.Validators;
import models.*;

import java.util.*;

public class MainController {
    private static Scanner sc = new Scanner(System.in);
    private static boolean isExit;
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";
    private static boolean isBackMenu;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int numSelect = -1;
//        for (int i= 0; i<1000; i++){
//            System.out.println("Anh iu em nhìu lắm Đậu Thanh Lươn!!!");
//        }
        do {
            System.out.println("Select function\n" +
                    "1.\tAdd New Services\n" +
                    "2.\tShow Services\n" +
                    "3.\tAdd New Customer\n" +
                    "4.\tShow Information of Customer\n" +
                    "5.\tAdd New Booking\n" +
                    "6.\tShow Information of Employee\n" +
                    "7.\tExit\n");

            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
//                case 3:
//                    addNewCustomer();
//                    break;
//                case 4:
//                    showInformationOfCustomer();
//                    break;
//                case 5:
//                    addNewBooking();
//                    break;
//                case 6:
//                    showInfomationOfEmployee();
//                    break;
                case 7:
                    isExit = true;
                    break;
            }
            if (isBackMenu || isExit) {
                return;
            }
        } while (numSelect >= 1 && numSelect < 7);
    }

    private static void showServices() {
        int numSelect = -1;

        do {

            System.out.println("Select function\n" +
                    "1.\tShow all Villa\n" +
                    "2.\tShow all House\n" +
                    "3.\tShow all Room\n" +
                    "4.\tShow All Name Villa Not Duplicate\n" +
                    "5.\tShow All Name House Not Duplicate\n" +
                    "6.\tShow All Name Name Not Duplicate\n" +
                    "7.\tBack to menu\n" +
                    "8.\tExit\n");

            Scanner sc = new Scanner(System.in);
            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    showAllService(VILLA);
                    isBackMenu = false;
                    break;
                case 2:
                    showAllService(HOUSE);
                    isBackMenu = false;
                    break;
                case 3:
                    showAllService(ROOM);
                    isBackMenu = false;
                    break;
                case 4:
                    showAllServiceNotDup(VILLA);
                    isBackMenu = true;
                    break;
                case 5:
                    showAllServiceNotDup(HOUSE);
                    isBackMenu = true;
                    break;
                case 6:
                    showAllServiceNotDup(ROOM);
                    isBackMenu = true;
                    break;
                case 7:
                    isBackMenu = true;
                    break;
                case 8:
                    isExit = true;
                    break;
            }
            if (isBackMenu || isExit) {
                return;
            }
        } while (numSelect >= 1 && numSelect <= 8);
    }

    private static void showAllServiceNotDup(String fileName) {
        System.out.println("---------------------------------");
        System.out.println("List Of Service Not Duplicatr: ");
        Set<String> setOfService = new TreeSet<>();
        for (Services service : readAllService(fileName)
        ) {
            setOfService.add(service.getName());
        }
        for (String name : setOfService
        ) {
            System.out.println(name);
        }

    }

    private static void showAllService(String fileName) {
        System.out.println("---------------------------------");
        System.out.println("List Of Service: ");
        for (Services service : readAllService(fileName)
        ) {
            service.showInfor();
        }
    }


    public static List<Services> readAllService(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesServices = FileUtils.readFile();
        List<Services> listOfServices = new ArrayList<>();
        String[] propertiesElement = null;

        Services services = null;
        ExtraService extraService = null;
        for (String properties : propertiesServices) {
            propertiesElement = properties.split(StringUtils.COMMA);
            if (fileName.equals(VILLA)) {
                services = new Villa();
                ((Villa) services).setRoomStanadard(propertiesElement[6]);
                ((Villa) services).setOtherDescription(propertiesElement[7]);
                ((Villa) services).setSwimingPoolArea(Double.parseDouble(propertiesElement[8]));
                ((Villa) services).setNumOfFloors(Integer.parseInt(propertiesElement[9]));

            } else if (fileName.equals(HOUSE)) {
                services = new House();
                ((House) services).setRoomStanadard(propertiesElement[6]);
                ((House) services).setOtherDescription(propertiesElement[7]);
                ((House) services).setNumOfFloors(Integer.parseInt(propertiesElement[8]));
            } else if (fileName.equals(ROOM)) {
                extraService = new ExtraService(propertiesElement[6], propertiesElement[7], Double.parseDouble(propertiesElement[8]));
                services = new Room();
                ((Room)services).setExtraService(extraService);
            }
            services.setId(propertiesElement[0]);
            services.setName(propertiesElement[1]);
            services.setAcreage(Double.parseDouble(propertiesElement[2]));
            services.setRentalCosts(Double.parseDouble(propertiesElement[3]));
            services.setMaxNumOfPeople(Integer.parseInt(propertiesElement[4]));
            services.setRentalType(propertiesElement[5]);

            listOfServices.add(services);

        }
        return listOfServices;
    }

    public static void addNewServices() {
        int numSelect = -1;
        do {

            System.out.println("Select function\n" +
                    "1.\tAdd New Villa\n" +
                    "2.\tAdd New House\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            Scanner sc = new Scanner(System.in);
            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    addNewServices(VILLA);
                    isBackMenu = false;
                    break;
                case 2:
                    addNewServices(HOUSE);
                    isBackMenu = false;
                    break;
                case 3:
                    addNewServices(ROOM);
                    isBackMenu = false;
                    break;
                case 4:
                    isBackMenu = true;
                    break;
                case 5:
                    isExit = true;
                    break;
            }
            if (isBackMenu || isExit) {
                return;
            }
        } while (numSelect >= 1 && numSelect <= 5);
    }

    private static void addNewServices(String name) {
        FileUtils.setFullPathFile(name);
        String id = null;
        int numPeople;
        do {
            System.out.println("Input id ");
            id = sc.nextLine();
        } while (!Validators.isValidators(id, Validators.SERVICES_CODE_REGEX));
        String serviceName;
        do {
            System.out.println("Input name");
            serviceName = sc.nextLine();
        } while (!Validators.isValidators(serviceName, Validators.SERVICE_NAME_REGEX));
        double area;
        do {
            System.out.println("Area");
            area = sc.nextDouble();
        } while (!Validators.isMoreThan(area, 30));
        double rentCost;
        do {
            System.out.println("rent cost");
            rentCost = sc.nextDouble();
        }while(!Validators.isMoreThan(rentCost, 0));
        do {
            System.out.println("number people");
            numPeople = sc.nextInt();
        }while(!Validators.isMoreThan(numPeople,0,20));
        sc.nextLine();
        System.out.println("type rent");
        String typeRent = sc.nextLine();
        if (name.equals(VILLA)) {

            double areaPool;
            String standardRoom;
            int numberOfFloor;
            do {
                System.out.println("standard room");
                standardRoom = sc.nextLine();
            }while(!Validators.isValidators(standardRoom,Validators.SERVICE_NAME_REGEX));

            System.out.println("description");
            String description = sc.nextLine();
            do {
                System.out.println("area pool");
                areaPool = sc.nextDouble();
            }while(!Validators.isMoreThan(areaPool,30));
            do {
                System.out.println("numer of floors");
                numberOfFloor = sc.nextInt();
            }while (!Validators.isMoreThan(numberOfFloor,0));

            sc.nextLine();
            FileUtils.writeFile(new String[]{id, serviceName, String.valueOf(area), String.valueOf(rentCost), String.valueOf(numPeople), typeRent, standardRoom, description, String.valueOf(areaPool), String.valueOf(numberOfFloor)});
        } else if (name.equals(HOUSE)) {
            double areaPool;
            String standardRoom;
            int numberOfFloor;
            do {
                System.out.println("standard room");
                standardRoom = sc.nextLine();
            }while(!Validators.isValidators(standardRoom,Validators.SERVICE_NAME_REGEX));

            System.out.println("description");
            String description = sc.nextLine();
            do {
                System.out.println("numer of floors");
                numberOfFloor = sc.nextInt();
            }while (!Validators.isMoreThan(numberOfFloor,0));

            sc.nextLine();
            FileUtils.writeFile(new String[]{id, serviceName, String.valueOf(area), String.valueOf(rentCost), String.valueOf(numPeople), typeRent, standardRoom, description, String.valueOf(numberOfFloor)});
        } else if(name.equals(ROOM)){
            String extraServiceName;
            String unit;
            double money;
            do {
                System.out.println("Extra Service Name");
                extraServiceName = sc.nextLine();
            }while(!Validators.isValiExtraServiceName(extraServiceName));
            System.out.println("Extra Unit");
            unit = sc.nextLine();
            System.out.println("Extra Money");
            money = sc.nextDouble();
            sc.nextLine();
            FileUtils.writeFile(new String[]{id, serviceName, String.valueOf(area), String.valueOf(rentCost), String.valueOf(numPeople), typeRent, extraServiceName, unit, String.valueOf(money)});

        }
    }
}
