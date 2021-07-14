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

    private static String ROOM = "room";
    private static String PRODUCTS = "products";
    private static String IMPORTED_PRODUCTS = "imperedProduct";
    private static String EXPORT_PRODUCTS = "exportProduct";
    private static boolean isBackMenu;

    public static void main(String[] args) {
        displayMainMenu();
    }

    public static void displayMainMenu() {
        int numSelect = -1;
        do {
            System.out.println("Select function\n" +
                    "1.\tAdd\n" +
                    "2.\tDelete\n" +
                    "3.\tShow list products\n" +
                    "4.\tFind\n" +
                    "5.\tExit\n");

            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    deleteProduct();
                    break;
                case 3:
                    showListProduct(EXPORT_PRODUCTS);
                    break;
                case 4:
                    findProduct(PRODUCTS);
                    break;
                case 5:
                    isExit = true;
                    break;
            }
            if (isBackMenu || isExit) {
                return;
            }
        } while (numSelect >= 1 && numSelect < 5);
    }

    private static void findProduct(String filename) {
        System.out.println("input code product");
        List<String> products = null;
        FileUtils.setFullPathFile(PRODUCTS);
        products = FileUtils.readFile();
        System.out.println("Input id");
        String id = sc.nextLine();
        int i =0;
        boolean check = false;
        for (String a:
                products) {
            String[] b = a.split(",");
            if(b[0].equals(id)){
                check = true;
                for (String c:
                        b) {
                    System.out.println(c + " ");
                }
                break;

            }
            i++;
        }
        if (check == false){
            System.out.println("Can't find");
        }
    }

    private static void showListProduct(String EXPORT_PRODUCTS) {
        System.out.println("---------------------------------");
        System.out.println("List Of Product: ");
        List<Product> productList = readProduct(EXPORT_PRODUCTS);
        Product product = null;
        FileUtils.setFullPathFile(PRODUCTS);
        List<String> listProducts = FileUtils.readFile();
        for (String pro:
                listProducts) {
            String[] infor = pro.split(",");
            System.out.println(pro);
        }
    }

    private static void deleteProduct() {
        boolean check = false;
        List<String> products = null;
        String name = null;
        FileUtils.setFullPathFile(PRODUCTS);
        products = FileUtils.readFile();
        System.out.println("Input id");
        String id = sc.nextLine();
        int i =0;
        for (String a:
                products) {
            String[] b = a.split(",");
            if(b[0].equals(id)){
                check = true;
                break;
            }
            i++;
        }

        System.out.println("Are you sure?");
        System.out.println("1. YES      2. NO");
        products.remove(i-1);
        FileUtils.writeFileEdit();
        int yN = sc.nextInt();
        if (yN == 2) {
            deleteServices();
            return;
        }

        FileUtils.writeFileEdit();
        for (String product :
                products) {
            String[] propertiesElement = product.split(StringUtils.COMMA);
            FileUtils.writeFile(new String[]{propertiesElement[0], propertiesElement[1], propertiesElement[2], propertiesElement[3], propertiesElement[4], propertiesElement[5], propertiesElement[6], propertiesElement[7]});
            System.out.println();
        }
        System.out.println("Okey");
        if(check == false){
            System.out.println("can't find");
        }
    }

    private static void addNewProduct() {
        int numSelect = -1;
        do {

            System.out.println("Select function\n" +
                    "1.\tAdd New IMPORTED_PRODUCTS\n" +
                    "2.\tAdd New EXPORT_PRODUCTS\n" +
                    "3.\tExit\n");
            Scanner sc = new Scanner(System.in);
            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    addNewProduct(IMPORTED_PRODUCTS);
                    isBackMenu = false;
                    break;
                case 2:
                    addNewProduct(EXPORT_PRODUCTS);
                    isBackMenu = false;
                    break;
                case 3:
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
        } while (numSelect >= 1 && numSelect <= 3);
    }

    private static void deleteServices() {
        System.out.println("input code product");
        int numService = sc.nextInt();
        List<String> serviceList = null;
        String name = null;
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
            FileUtils.writeFile(new String[]{propertiesElement[0], propertiesElement[1], propertiesElement[2], propertiesElement[3], propertiesElement[4], propertiesElement[5], propertiesElement[6], propertiesElement[7], propertiesElement[8], propertiesElement[9]});
            System.out.println();
        }
        System.out.println("Okey");
    }
    


    

    
    public static List<Product> readProduct(String fileName) {
        FileUtils.setFullPathFile(PRODUCTS);
        List<String> propertiesProduct = FileUtils.readFile();
        List<Product> listOfProduct = new ArrayList<>();
        String[] propertiesElement = null;

        Product product = null;
        System.out.println(propertiesProduct);
        for (String properties : propertiesProduct) {
            System.out.println(properties);
            propertiesElement = properties.split(StringUtils.COMMA);
            System.out.println(propertiesElement[0]);

            if (fileName.equals(IMPORTED_PRODUCTS)) {
                product = new ImportedProducts();
                ((ImportedProducts) product).setImportPrices(Double.parseDouble(propertiesElement[6]));
                ((ImportedProducts) product).setNameProvince(propertiesElement[7]);
                ((ImportedProducts) product).setTax(Double.parseDouble(propertiesElement[8]));
            } else if (fileName.equals(EXPORT_PRODUCTS)) {
                product = new ExportProducts();
                ((ExportProducts) product).setExportPrice(Double.parseDouble(propertiesElement[6]));
                ((ExportProducts) product).setNameCountryOfProductEntry(propertiesElement[7]);
            }
            product.setId(propertiesElement[0]);
            product.setProductCode(propertiesElement[1]);
            product.setName(String.valueOf(Double.parseDouble(propertiesElement[2])));
            product.setCosts(Double.parseDouble(propertiesElement[3]));
            product.setAmount(Integer.parseInt(propertiesElement[4]));
            product.setProducer(propertiesElement[5]);

            listOfProduct.add(product);

        }

        return listOfProduct;

        }

    public static List<Product> readProduct2(String fileName) {
        FileUtils.setFullPathFile(PRODUCTS);
        List<String> propertiesProduct = FileUtils.readFile();
        List<Product> listOfProduct = new ArrayList<>();
        String[] propertiesElement = null;

        Product product = null;
        System.out.println(propertiesProduct);
        for (String properties : propertiesProduct) {
            System.out.println(properties);
            propertiesElement = properties.split(StringUtils.COMMA);
            System.out.println(propertiesElement[0]);

            if (fileName.equals(IMPORTED_PRODUCTS)) {
                product = new ImportedProducts();
                ((ImportedProducts) product).setImportPrices(Double.parseDouble(propertiesElement[6]));
                ((ImportedProducts) product).setNameProvince(propertiesElement[7]);
                ((ImportedProducts) product).setTax(Double.parseDouble(propertiesElement[8]));
            } else if (fileName.equals(EXPORT_PRODUCTS)) {
                product = new ExportProducts();
                ((ExportProducts) product).setExportPrice(Double.parseDouble(propertiesElement[5]));
                ((ExportProducts) product).setNameCountryOfProductEntry(propertiesElement[6]);
            }
            product.setId(propertiesElement[0]);
            product.setProductCode(propertiesElement[1]);
            product.setName(String.valueOf(Double.parseDouble(propertiesElement[2])));
            product.setCosts(Double.parseDouble(propertiesElement[3]));
            product.setAmount(Integer.parseInt(propertiesElement[4]));
            product.setProducer(propertiesElement[5]);

            listOfProduct.add(product);

        }

        return listOfProduct;

    }

        

    public static void add() {
        int numSelect = -1;
        do {

            System.out.println("Select function\n" +
                    "1.\tAdd New Imported products\n" +
                    "2.\tAdd New Export products\n" +
                    "3.\tAdd New Room\n" +
                    "4.\tBack to menu\n" +
                    "5.\tExit\n");
            Scanner sc = new Scanner(System.in);
            numSelect = sc.nextInt();
            sc.nextLine();
            switch (numSelect) {
                case 1:
                    addNewProduct(IMPORTED_PRODUCTS);
                    isBackMenu = false;
                    break;
                case 2:
                    addNewProduct(EXPORT_PRODUCTS);
                    isBackMenu = false;
                    break;
                case 3:
                    addNewProduct(ROOM);
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

    private static void addNewProduct(String name) {
       FileUtils.setFullPathFile(PRODUCTS);
//    List<String> listProduct = FileUtils.readFile();
        String id;
        String product_code;
        String nameProduct;
        double costs;
        int amount;
        String producer = null;

        FileUtils.setFullPathFile(PRODUCTS);
        System.out.println("Input id ");
        id = sc.nextLine();
//        List<Product> productList = readProduct(PRODUCTS);
//        if(productList.size() ==0 ){
//            id = "0";
//        }else{
//            id = String.valueOf((Integer.parseInt(productList.get(productList.size() - 1).getId())+1))  ;
//        }
        System.out.println("Input product code ");
        product_code = sc.nextLine();
        System.out.println("Input name ");
        nameProduct = sc.nextLine();
        do {
            System.out.println("Input product cost ");
            costs = sc.nextDouble();
        }while(!Validators.isMoreThan(costs,0));
        do {
            System.out.println("Input amount ");
            amount = sc.nextInt();;
        }while(!Validators.isMoreThan(amount,0));

        sc.nextLine();
        System.out.println("Input producer ");
        producer = sc.nextLine();

        if (name.equals(IMPORTED_PRODUCTS)) {
            double importPrices;
            String nameProvince;
            double tax;
            do {
                System.out.println("rent importPrices");
                importPrices = sc.nextDouble();
            }while(!Validators.isMoreThan(importPrices,0));

            sc.nextLine();
            System.out.println("nameProvince");
            nameProvince = sc.nextLine();
            do {
                System.out.println("rent tax");
                tax = sc.nextDouble();
            }while(!Validators.isMoreThan(tax,0));

            sc.nextLine();
            FileUtils.writeFile(new String[]{id, product_code, nameProduct, String.valueOf(costs), String.valueOf(amount), producer, String.valueOf(importPrices), nameProvince, String.valueOf(tax)});
        } else if (name.equals(EXPORT_PRODUCTS)) {
            double exportPrice;
            String NameCountryOfProductEntry;

            do {
                System.out.println("exportPrice");
                exportPrice = sc.nextDouble();
            }while(!Validators.isMoreThan(exportPrice,0));
            System.out.println("NameCountryOfProductEntry");
            NameCountryOfProductEntry = sc.nextLine();

            sc.nextLine();
            FileUtils.writeFile(new String[]{id, product_code, nameProduct, String.valueOf(costs), String.valueOf(amount), producer, String.valueOf(exportPrice), NameCountryOfProductEntry, ""});
        } 
    }
}