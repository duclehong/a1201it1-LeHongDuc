package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customerType")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerTypeId;
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private List<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(String customerTypeName, List<Customer> customerList) {
        this.customerTypeName = customerTypeName;
        this.customerList = customerList;
    }

    public CustomerType(int id, String customerTypeName, List<Customer> customerList) {
        this.customerTypeId = id;
        this.customerTypeName = customerTypeName;
        this.customerList = customerList;
    }

    public void setCustomerTypeId(int id) {
        this.customerTypeId = id;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
