package exercise;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductManagerLinkedList {
    static List<Product> listProducts;
    static Scanner scanner = new Scanner(System.in);
    static{
        listProducts = new LinkedList<Product>();
        listProducts.add(new Product(1,"Pug",3000000));
        listProducts.add(new Product(2,"Chihuahua",2500000));
        listProducts.add(new Product(3,"Dachshund",2000000));
        listProducts.add(new Product(4,"Maltese",6000000));
        listProducts.add(new Product(5,"Golden Retriever",7000000));
    }
    public static void menu() {
        int choice = -1;
        do {
            System.out.println("Please enter choice:" +
                    "\n 1. Show all product" +
                    "\n 2. Add new product" +
                    "\n 3. Edit product" +
                    "\n 4. Search product" +
                    "\n 5. Delete product" +
                    "\n 6. Exit");
            choice = scanner.nextInt();
            scanner.skip("\\R");
            switch (choice) {
                case 1:
                    displayAllProduct();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    editProductById();
                    break;
                case 4:
                    findProduct();
                    break;
                case 5:
                    deleteProductById();
                    break;
                case 6:
                    System.exit(0);
                    break;

            }
        } while (true);
    }

    public static void displayAllProduct() {
        for (Product product :
                listProducts) {
            System.out.println(product);
        }
    }

    public static void addProduct() {
        int id = -1;
        if (listProducts.isEmpty()) {
            id = 1;
        } else {
            id = listProducts.get(listProducts.size() - 1).getId() + 1;
        }
        System.out.println("Please enter name product");
        String nameProduct = scanner.nextLine();
        System.out.println("Please enter price");
        double price = scanner.nextDouble();
        scanner.skip("\\R");
        Product product = new Product(id, nameProduct, price);
        listProducts.add(product);
    }

    public static boolean checkId(int id) {
        for (Product product :
                listProducts) {
            if (product.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static void deleteProductById() {
        System.out.println("Please enter id product");
        int id = scanner.nextInt();
        scanner.skip("\\R");
        if (checkId(id)) {
            for (int i = 0; i < listProducts.size(); i++) {
                if (id == listProducts.get(i).getId()) {
                    listProducts.remove(i);
                    menu();
                    break;
                }
            }
        } else {
            System.out.println("Element not found");
            deleteProductById();
        }

    }

    public static void findProduct() {
        int choice = -1;
        boolean find = false;
        System.out.println("Please choice:" +
                "\n 1. Find by id" +
                "\n 2. Find by name" +
                "\n 3. Find by price" +
                "\n 4. Exit");
        choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter id: ");
                int id = scanner.nextInt();
                scanner.skip("\\R");
                for (Product product :
                        listProducts) {
                    if (id == product.getId()) {
                        System.out.println(product);
                        find = true;
                    }
                }
                if (find == false){
                    System.out.println("Id not found");
                }
                break;
            case 2:
                scanner.skip("\\R");
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                for (Product product :
                        listProducts) {
                    if (product.getName().equals(name)) {
                        System.out.println(product);
                        find = true;
                    }
                }
                if (find == false){
                    System.out.println("Name not found");
                }

                break;
            case 3:
                System.out.println("Enter price: ");
                double price = scanner.nextDouble();
                scanner.skip("\\R");
                for (Product product :
                        listProducts) {
                    if (price == product.getPrice()) {
                        System.out.println(product);
                        find = true;
                    }
                }
                if (find == false){
                    System.out.println("Price not found");
                }
                break;
            case 4:
                menu();
                break;
        }

    }

    public static void editProductById() {
        System.out.println("Please enter id product");
        int id = scanner.nextInt();
        scanner.skip("\\R");
        int choice = -1;
        if (checkId(id)) {
            for (int i = 0; i < listProducts.size(); i++) {
                if (id == listProducts.get(i).getId()) {
                    System.out.println("Please enter property edit" +
                            "\n 1. Name" +
                            "\n 2. Price" +
                            "\n 3. Back to menu");
                    choice = scanner.nextInt();
                    scanner.skip("\\R");
                    switch (choice) {
                        case 1:
                            System.out.println("Please enter name");
                            String name = scanner.nextLine();
                            listProducts.get(i).setName(name);
                            break;
                        case 2:
                            System.out.println("Please enter price");
                            Double price = scanner.nextDouble();
                            listProducts.get(i).setPrice(price);
                            break;
                        case 3:
                            menu();
                            break;
                        default:
                            System.out.println("Please choice again");
                    }
                }
            }
        } else {
            System.out.println("Element not found");
            editProductById();
        }
    }

}
