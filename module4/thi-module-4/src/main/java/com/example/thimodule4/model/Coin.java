package com.example.thimodule4.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@Table
public class Coin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Name coin not blank")
    private String name;

//    @Pattern(regexp = "", message = "mess")
//    @NotBlank(message = "Price not blank")
    private double price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Coin() {
    }

    public Coin(@NotBlank(message = "Name coin not blank") String name, @NotBlank(message = "Price not blank") double price, Date birthday) {
        this.name = name;
        this.price = price;
        this.birthday = birthday;
    }

    public Coin(int id, @NotBlank(message = "Name coin not blank") String name, @NotBlank(message = "Price not blank") double price, Date birthday) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.birthday = birthday;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
