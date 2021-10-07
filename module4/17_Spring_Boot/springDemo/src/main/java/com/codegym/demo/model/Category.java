package com.codegym.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

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

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    List<Product> productList = new ArrayList<>();

    public Category() {
    }

    public Category(int id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }
}
