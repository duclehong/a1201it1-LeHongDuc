package com.codegym.demo.model;

import javax.persistence.*;

@Entity
public class Product {

    @Id
    @TableGenerator(
            name = "clazz_gen",
            table = "id_gen",
            pkColumnName = "genName",
            valueColumnName = "gen_val",
            allocationSize = 2
    )
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "clazz_gen")
    private int id;
    private String name;
    private Double price;

    @ManyToOne
    private Category category;

    public Product(){

    }

    public Product(int id, String name, Double price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
