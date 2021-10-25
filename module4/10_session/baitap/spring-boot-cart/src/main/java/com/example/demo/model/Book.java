package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue
    private long bookId;
    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;
    private String bookName;
    private String bookImage;
    private double bookPrice;
    private int bookView;
    private String bookDescription;
    private boolean bookStatus;
}
