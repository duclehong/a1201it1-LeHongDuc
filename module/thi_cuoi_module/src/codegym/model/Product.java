package codegym.model;

import java.util.Date;

public class Product {
    private int id;
    private String name;
    private double cost;
    private int quantity;
    private String color;
    private String des;
    private int category;

    public Product() {
    }

    public Product(String name, double cost, int quantity, String color, String des, int category) {
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.color = color;
        this.des = des;
        this.category = category;
    }

    public Product(int id, String name, double cost, int quantity, String color, String des, int category) {
        this.id = id;
        this.name = name;
        this.cost = cost;
        this.quantity = quantity;
        this.color = color;
        this.des = des;
        this.category = category;
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
