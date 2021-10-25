package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "category")
public class Category implements Serializable {

    @Id
    @GeneratedValue
    private long categoryId;
    private String categoryName;
    private String categoryUrl;
    private boolean categoryStatus;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "categoryId")
    private List<Book> listProduct;
}
