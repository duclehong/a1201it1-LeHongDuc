package codegym.model;

import java.util.Date;

public class Contract {
    private int id;
    private Date start;
    private Date end;
    private double deposit;
    private double totalMoney;
    private int employee;
    private int customer;
    private int service;

    public Contract() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getEmployee() {
        return employee;
    }

    public void setEmployee(int employee) {
        this.employee = employee;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public int getService() {
        return service;
    }

    public void setService(int service) {
        this.service = service;
    }
}
