package controller;

import commons.ConvertString;
import commons.FileUtils;
import commons.StringUtils;
import commons.Validators;
import exceptions.BirthdayException;
import exceptions.EmailException;
import exceptions.GenderException;
import exceptions.IdCardException;
import models.*;

import java.util.*;

public class MainController {
    private static Scanner sc = new Scanner(System.in);
    private static boolean isExit;
    private static String VILLA = "villa";
    private static String HOUSE = "house";
    private static String ROOM = "room";
    private static String CUSTOMER = "customer";
    private static String BOOKING = "booking";
    private static String EMPLOYEE = "employee";
    private static boolean isBackMenu;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int numSelect = -1;
        do {
            System.out.println("Select function\n" +
                    " 1.\tAdd New Services\n" +
                    " 2.\tShow Services\n" +
                    " 3.\tAdd New Customer\n" +
                    " 4.\tShow Information of Customer\n" +
                    " 5.\tAdd New Booking\n" +
                    " 6.\tShow Information of Employee\n" +
                    " 7.\tEdit Service\n" +
                    " 8.\tDelete Service\n" +
                    " 9.\tEdit Customer\n" +
                    "10.\tDelete Customer\n" +
                    "11.\tExit\n");

            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    addNewServices();
                    break;
                case 2:
                    showServices();
                    break;
                case 3:
                    addNewCustomer(CUSTOMER);
                    break;
                case 4:
                    showInformationOfCustomer(CUSTOMER);
                    break;
                case 5:
                    addNewBooking();
                    break;
                case 6:
                    showInfomationOfEmployee();
                    break;
                case 7:
                    editServices();
                    break;
                case 8:
                    deleteServices();
                    break;
                case 9:
                    editCustomer();
                    break;
                case 10:
                    deleteCustomer();
                    break;
                case 11:
                    isExit = true;
                    break;
            }
            if (isBackMenu || isExit) {
                return;
            }
        } while (numSelect >= 1 && numSelect < 11);
    }

    private static void editCustomer() {
        String name = null;
        String dateBirth = null;
        String gender = null;
        String idCard = null;
        String phoneNumber = null;
        String email = null;
        String typeOfCustomer = null;
        String address = null;
        Services services = null;
        Boolean flag = false;
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Select Customer");
        int chooseCustomer = sc.nextInt();

        List<Customer> customerList = readCustomer(CUSTOMER);
//        customerList.remove(chooseCustomer-1);
        System.out.println("Select function\n" +
                " 1.\tName\n" +
                " 2.\tBirth\n" +
                " 3.\tGender\n" +
                " 4.\tId\n" +
                " 5.\tPhone\n" +
                " 6.\tEmail\n" +
                " 7.\tType Of Customer\n" +
                " 8.\tAddress\n" +
                " 9.\tService\n" +
                "11.\tExit\n");
        FileUtils.setFullPathFile(CUSTOMER);
        FileUtils.writeFileEdit();
        List<String[]> customersStringList = new ArrayList<>();
        String String_Array[] = null;
        int numSelect = sc.nextInt();
        sc.nextLine();
        switch (numSelect) {
            case 1:
                System.out.println("Input name customer");
                name = sc.nextLine();
                break;
            case 2:
                do {
                    flag = true;
                    System.out.println("Input date birth");
                    dateBirth = sc.nextLine();
                    try {
                        Validators.checkDayBirthCustomer(dateBirth);
                    } catch (BirthdayException e) {
                        flag = false;
                        e.printStackTrace();
                    }
                } while (!flag);
                break;
            case 3:
                do {
                    flag = true;
                    System.out.println("Input name gender");
                    gender = sc.nextLine();
                    try {
                        Validators.checkGenderCustomer(gender);
                    } catch (GenderException e) {
                        flag = false;
                        e.printStackTrace();
                    }

                } while (!flag);
                break;
            case 4:
                do {
                    flag = true;
                    System.out.println("Input name id card");
                    idCard = sc.nextLine();
                    try {
                        Validators.checkIdCustomer(idCard);
                    } catch (IdCardException e) {
                        flag = false;
                        e.printStackTrace();
                    }
                } while (!flag);
                break;
            case 5:
                System.out.println("Input date phoneNumber");
                phoneNumber = sc.nextLine();
                break;
            case 6:
                do {
                    flag = true;
                    System.out.println("Input email");
                    email = sc.nextLine();
                    try {
                        Validators.checkEmailCustomer(email);
                    } catch (EmailException e) {
                        flag = false;
                        e.printStackTrace();
                    }
                } while (!flag);
                break;
            case 7:
                System.out.println("Input date typeOfCustomer");
                typeOfCustomer = sc.nextLine();
                break;
            case 8:
                System.out.println("Input name address");
                address = sc.nextLine();
                break;
            case 9:
                break;
            case 10:
                return;
        }
        for (int i = 0; i < customerList.size(); i++) {

            String_Array = new String[9];
            String_Array[0] = customerList.get(i).getName();
            String_Array[1] = customerList.get(i).getDateBirth();
            String_Array[2] = customerList.get(i).getGender();
            String_Array[3] = customerList.get(i).getIdCard();
            String_Array[4] = customerList.get(i).getPhoneNumber();
            String_Array[5] = customerList.get(i).getEmail();
            String_Array[6] = customerList.get(i).getTypeOfCustomer();
            String_Array[7] = customerList.get(i).getAddress();
            String_Array[8] = null;
            if (i == chooseCustomer - 1) {
                System.out.println("find");
                switch (numSelect) {
                    case 1:
                        String_Array[0] = name;
                        break;
                    case 2:
                        String_Array[1] = dateBirth;
                        break;
                    case 3:
                        gender = ConvertString.covertFirstCharToUp(gender);
                        String_Array[2] = gender;
                        break;
                    case 4:
                        String_Array[4] = idCard;
                        break;
                    case 5:
                        String_Array[5] = phoneNumber;
                        break;
                    case 6:
                        String_Array[6] = email;
                        break;
                    case 7:
                        String_Array[7] = typeOfCustomer;
                        break;
                    case 8:
                        String_Array[8] = address;
                        break;
                    case 9:
                        break;
                    case 10:
                        return;
                }
            }
            FileUtils.writeFile(new String[]{String_Array[0], String_Array[1], String_Array[2], String_Array[3], String_Array[4], String_Array[5], String_Array[6], String_Array[7], String_Array[8]});
            System.out.println();
        }
        System.out.println(customersStringList);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Okey");
    }

    private static void deleteServices() {
        System.out.println("Select Service\n" +
                " 1.\tVilla\n" +
                " 2.\tHouse\n" +
                " 3.\tRoom\n" +
                " 4.\tExit\n");
        int numService = sc.nextInt();
        List<String> serviceList = null;
        String name = null;
        switch (numService) {
            case 1:
                name = VILLA;
                break;
            case 2:
                name = HOUSE;
                break;
            case 3:
                name = ROOM;
                break;
        }
        showAllService(name);
        FileUtils.setFullPathFile(name);
        serviceList = FileUtils.readFile();
        System.out.println("Select Service");
        int chooseCustomer = sc.nextInt();
        System.out.println("Are you sure?");
        System.out.println("1. YES      2. NO");
        FileUtils.writeFileEdit();
        int yN = sc.nextInt();
        if (yN == 2) {
            deleteServices();
            return;
        }
        serviceList.remove(chooseCustomer - 1);
        System.out.println("remove" + serviceList);
        FileUtils.writeFileEdit();
            for (String service :
                    serviceList) {
                String[] propertiesElement = service.split(StringUtils.COMMA);
                FileUtils.writeFile(new String[]{propertiesElement[0], propertiesElement[1], propertiesElement[2], propertiesElement[3], propertiesElement[4], propertiesElement[5], propertiesElement[6], propertiesElement[7], propertiesElement[8],propertiesElement[9]});
                System.out.println();
            }
        System.out.println("Okey");
        showAllService(name);
    }

    private static void editServices() {
        System.out.println("Select Service\n" +
                " 1.\tVilla\n" +
                " 2.\tHouse\n" +
                " 3.\tRoom\n" +
                " 4.\tExit\n");
        int numService = sc.nextInt();
        List<String> serviceList = null;
        String name = null;
        switch (numService) {
            case 1:
                name = VILLA;
                break;
            case 2:
                name = HOUSE;
                break;
            case 3:
                name = ROOM;
                break;
        }
        showAllService(name);
        FileUtils.setFullPathFile(name);
        serviceList = FileUtils.readFile();
        System.out.println("Select Service");
        int chooseCustomer = sc.nextInt();
//        serviceList.remove(chooseCustomer - 1);
        System.out.println("remove" + serviceList);
        FileUtils.writeFileEdit();
        System.out.println("Select function\n" +
                " 1.\tId\n" +
                " 2.\tName\n" +
                " 3.\tacreage\n" +
                " 4.\trentalCosts\n" +
                " 5.\tmaxNumOfPeople\n" +
                " 6.\trentalType\n" +
                "11.\tExit\n");
        int numSelect = sc.nextInt();
        sc.nextLine();
        String id = null;
        String serviceName;
        double area;
        double rentCost;
        int numPeople;
        String typeRent;
        String editElement = null;
        switch (numSelect) {
            case 1:
                do {
                    System.out.println("Input id ");
                    id = sc.nextLine();
                } while (!Validators.isValidators(id, Validators.SERVICES_CODE_REGEX));
                editElement = id;
                break;
            case 2:
                do {
                    System.out.println("Input name");
                    serviceName = sc.nextLine();
                } while (!Validators.isValidators(serviceName, Validators.SERVICE_NAME_REGEX));
                editElement = serviceName;
                break;
            case 3:
                do {
                    System.out.println("Area");
                    area = sc.nextDouble();
                } while (!Validators.isMoreThan(area, 30));
                editElement = String.valueOf(area);
                break;
            case 4:
                do {
                    System.out.println("rent cost");
                    rentCost = sc.nextDouble();
                } while (!Validators.isMoreThan(rentCost, 0));
                editElement = String.valueOf(rentCost);
                break;
            case 5:
                do {
                    System.out.println("number people");
                    numPeople = sc.nextInt();
                } while (!Validators.isMoreThan(numPeople, 0, 20));
                editElement = String.valueOf(numPeople);
                break;
            case 6:
                System.out.println("type rent");
                editElement = sc.nextLine();
                break;

            case 9:
                break;
            case 10:
                return;
        }
        int i =0;
        for (String service :
                serviceList) {

            String[] propertiesElement = service.split(StringUtils.COMMA);
            if(i==numSelect-1){
                propertiesElement[i] = editElement;
            }
            FileUtils.writeFile(new String[]{propertiesElement[0], propertiesElement[1], propertiesElement[2], propertiesElement[3], propertiesElement[4], propertiesElement[5], propertiesElement[6], propertiesElement[7], propertiesElement[8],propertiesElement[9]});
            System.out.println();
            i++;
        }
        System.out.println("Okey");
        showAllService(name);
    }

    private static void deleteCustomer() {

        showInformationOfCustomer(CUSTOMER);
        System.out.println("Select Customer");
        int chooseCustomer = sc.nextInt();
        System.out.println("Are you sure?");
        System.out.println("1. YES      2. NO");
        int yN = sc.nextInt();
        if (yN == 2) {
            deleteCustomer();
            return;
        }
        List<Customer> customerList = readCustomer(CUSTOMER);
        customerList.remove(chooseCustomer - 1);
        System.out.println("remove" + customerList);
        FileUtils.setFullPathFile(CUSTOMER);
        FileUtils.writeFileEdit();
        List<String[]> customersStringList = new ArrayList<>();
        String String_Array[] = null;
        for (Customer customer :
                customerList) {
            String_Array = new String[9];
            String_Array[0] = customer.getName();
            String_Array[1] = customer.getDateBirth();
            String_Array[2] = customer.getGender();
            String_Array[3] = customer.getIdCard();
            String_Array[4] = customer.getPhoneNumber();
            String_Array[5] = customer.getEmail();
            String_Array[6] = customer.getTypeOfCustomer();
            String_Array[7] = customer.getAddress();
            String_Array[8] = null;
            FileUtils.writeFile(new String[]{String_Array[0], String_Array[1], String_Array[2], String_Array[3], String_Array[4], String_Array[5], String_Array[6], String_Array[7], String_Array[8]});
            System.out.println();
        }
        System.out.println(customersStringList);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Okey");
    }

    private static void showInformationOfCustomer(String fileName) {
        System.out.println("Lis of customer");
        System.out.println("--------------------------");
        List<Customer> customerList = readALlCustomer(fileName);
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            customer = customerList.get(i);
            System.out.print((i + 1) + ". ");
            customer.showInfor();
        }
    }

    private static Map<String, Employee> readAllEmployee(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesEmployee = FileUtils.readFile();
        Map<String, Employee> employeeMap = new HashMap<>();
        String[] arrPropertyEmployee = null;
        Employee employee = null;
        for (String property : propertiesEmployee
        ) {
            arrPropertyEmployee = property.split(StringUtils.COMMA);
            employee = new Employee();
            employee.setId(arrPropertyEmployee[0]);
            employee.setName(arrPropertyEmployee[1]);
            employee.setAge(arrPropertyEmployee[2]);
            employee.setAddress(arrPropertyEmployee[3]);
            employeeMap.put(employee.getId(), employee);
        }
        return employeeMap;
    }

    private static void showInfomationOfEmployee() {
        Map<String, Employee> employeeMap = readAllEmployee(EMPLOYEE);
        System.out.println("List employee");
        System.out.println("----------------------");
        for (Map.Entry<String, Employee> employee : employeeMap.entrySet()
        ) {
            System.out.println(employee.getKey() + " " + employee.getValue().toString());
        }

    }

    private static void addNewBooking() {
        List<Customer> customerList = readALlCustomer(CUSTOMER);
        showInformationOfCustomer(CUSTOMER);
        System.out.println("Select customer:");
        int choiceCustomer = sc.nextInt();
        System.out.println("Select service\n" +
                "1.\tVilla\n" +
                "2.\tHouse\n" +
                "3.\tRoom\n");
        int choiceService = sc.nextInt();
        sc.nextLine();
        List<Services> servicesList = null;
        switch (choiceService) {
            case 1:
                servicesList = readAllService(VILLA);
                showAllService(VILLA);
                System.out.println("Select villa");
                break;
            case 2:
                servicesList = readAllService(HOUSE);
                showAllService(HOUSE);
                System.out.println("Select villa");
                break;
            case 3:
                servicesList = readAllService(ROOM);
                showAllService(ROOM);
                System.out.println("Select villa");
                break;
            default:
                break;
        }
        Customer customer = customerList.get(choiceCustomer - 1);
        int chooseService = sc.nextInt();
        sc.nextLine();
        customer.setServices(servicesList.get(chooseService - 1));
        FileUtils.setFullPathFile(BOOKING);
        FileUtils.writeFile(new String[]{customer.toString()});
        System.out.println("Okey");
    }

    private static void addNewCustomer(String fileName) {
        String name;
        String dateBirth;
        String gender;
        String idCard;
        String phoneNumber;
        String email;
        String typeOfCustomer;
        String address;
        Services services;
        boolean flag = false;
        System.out.println("Input name customer");
        name = sc.nextLine();
        do {
            flag = true;
            System.out.println("Input date birth");
            dateBirth = sc.nextLine();
            try {
                Validators.checkDayBirthCustomer(dateBirth);
            } catch (BirthdayException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        do {
            flag = true;
            System.out.println("Input name gender");
            gender = sc.nextLine();
            try {
                Validators.checkGenderCustomer(gender);
            } catch (GenderException e) {
                flag = false;
                e.printStackTrace();
            }

        } while (!flag);
        gender = ConvertString.covertFirstCharToUp(gender);
        do {
            flag = true;
            System.out.println("Input name id card");
            idCard = sc.nextLine();
            try {
                Validators.checkIdCustomer(idCard);
            } catch (IdCardException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);
        System.out.println("Input date phoneNumber");
        phoneNumber = sc.nextLine();
        do {
            flag = true;
            System.out.println("Input email");
            email = sc.nextLine();
            try {
                Validators.checkEmailCustomer(email);
            } catch (EmailException e) {
                flag = false;
                e.printStackTrace();
            }
        } while (!flag);

        System.out.println("Input date typeOfCustomer");
        typeOfCustomer = sc.nextLine();
        System.out.println("Input name address");
        address = sc.nextLine();

        FileUtils.setFullPathFile(fileName);
        FileUtils.writeFile(new String[]{name, dateBirth, gender, idCard, phoneNumber, email, typeOfCustomer, address});
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
        System.out.println("List Of Service Not Duplicate: ");
        Set<String> setOfService = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

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
        List<Services> servicesList = readAllService(fileName);
        Collections.sort(servicesList);
        Services services = null;
        for (int i = 0; i < servicesList.size(); i++) {
            services = servicesList.get(i);
            System.out.print((i + 1) + ". ");
            services.showInfor();
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
                ((Room) services).setExtraService(extraService);
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
    public static List<Services> readService(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesServices = FileUtils.readFileDeleteElement();
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
                ((Room) services).setExtraService(extraService);
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
    public static List<Customer> readALlCustomer(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesCustomer = FileUtils.readFile();
        String[] propertiesElement;
        List<Customer> customerList = new ArrayList<>();
        for (String providerElement :
                propertiesCustomer) {
            Customer customer = new Customer();
            propertiesElement = providerElement.split(StringUtils.COMMA);
            customer.setName(propertiesElement[0]);
            customer.setDateBirth(propertiesElement[1]);
            customer.setGender(propertiesElement[2]);
            customer.setIdCard(propertiesElement[3]);
            customer.setPhoneNumber(propertiesElement[4]);
            customer.setEmail(propertiesElement[5]);
            customer.setTypeOfCustomer(propertiesElement[6]);
            customer.setAddress(propertiesElement[7]);
            customerList.add(customer);
        }
        Collections.sort(customerList);
        return customerList;
    }

    public static List<Customer> readCustomer(String fileName) {
        FileUtils.setFullPathFile(fileName);
        List<String> propertiesCustomer = FileUtils.readFileDeleteElement();
        String[] propertiesElement;
        List<Customer> customerList = new ArrayList<>();
        for (String providerElement :
                propertiesCustomer) {
            Customer customer = new Customer();
            propertiesElement = providerElement.split(StringUtils.COMMA);
            customer.setName(propertiesElement[0]);
            customer.setDateBirth(propertiesElement[1]);
            customer.setGender(propertiesElement[2]);
            customer.setIdCard(propertiesElement[3]);
            customer.setPhoneNumber(propertiesElement[4]);
            customer.setEmail(propertiesElement[5]);
            customer.setTypeOfCustomer(propertiesElement[6]);
            customer.setAddress(propertiesElement[7]);
            customerList.add(customer);
        }
        Collections.sort(customerList);
        return customerList;
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
        } while (!Validators.isMoreThan(rentCost, 0));
        do {
            System.out.println("number people");
            numPeople = sc.nextInt();
        } while (!Validators.isMoreThan(numPeople, 0, 20));
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
            } while (!Validators.isValidators(standardRoom, Validators.SERVICE_NAME_REGEX));

            System.out.println("description");
            String description = sc.nextLine();
            do {
                System.out.println("area pool");
                areaPool = sc.nextDouble();
            } while (!Validators.isMoreThan(areaPool, 30));
            do {
                System.out.println("numer of floors");
                numberOfFloor = sc.nextInt();
            } while (!Validators.isMoreThan(numberOfFloor, 0));

            sc.nextLine();
            FileUtils.writeFile(new String[]{id, serviceName, String.valueOf(area), String.valueOf(rentCost), String.valueOf(numPeople), typeRent, standardRoom, description, String.valueOf(areaPool), String.valueOf(numberOfFloor)});
        } else if (name.equals(HOUSE)) {
            double areaPool;
            String standardRoom;
            int numberOfFloor;
            do {
                System.out.println("standard room");
                standardRoom = sc.nextLine();
            } while (!Validators.isValidators(standardRoom, Validators.SERVICE_NAME_REGEX));

            System.out.println("description");
            String description = sc.nextLine();
            do {
                System.out.println("numer of floors");
                numberOfFloor = sc.nextInt();
            } while (!Validators.isMoreThan(numberOfFloor, 0));

            sc.nextLine();
            FileUtils.writeFile(new String[]{id, serviceName, String.valueOf(area), String.valueOf(rentCost), String.valueOf(numPeople), typeRent, standardRoom, description, String.valueOf(numberOfFloor)});
        } else if (name.equals(ROOM)) {
            String extraServiceName;
            String unit;
            double money;
            do {
                System.out.println("Extra Service Name");
                extraServiceName = sc.nextLine();
            } while (!Validators.isValiExtraServiceName(extraServiceName));
            System.out.println("Extra Unit");
            unit = sc.nextLine();
            System.out.println("Extra Money");
            money = sc.nextDouble();
            sc.nextLine();
            FileUtils.writeFile(new String[]{id, serviceName, String.valueOf(area), String.valueOf(rentCost), String.valueOf(numPeople), typeRent, extraServiceName, unit, String.valueOf(money)});

        }
    }
}