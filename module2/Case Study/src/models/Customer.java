package models;

import java.util.Comparator;

public class Customer implements Comparable<Customer>{
    private String name;
    private String dateBirth;
    private String gender;
    private String idCard;
    private String phoneNumber;
    private String email;
    private String typeOfCustomer;
    private String address;
    private Services services;

    public Customer() {
    }

    public Customer(String name, String dateBirth, String gender, String idCard, String phoneNumber, String email, String typeOfCustomer, String address, Services services) {
        this.name = name;
        this.dateBirth = dateBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.typeOfCustomer = typeOfCustomer;
        this.address = address;
        this.services = services;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public void setTypeOfCustomer(String typeOfCustomer) {
        this.typeOfCustomer = typeOfCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }

    public void addNewCustomer(){

    }
    public void showInformationCustomer(){

    }

    public void showInfor(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", dateBirth='" + dateBirth + '\'' +
                ", gender='" + gender + '\'' +
                ", idCard='" + idCard + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", typeOfCustomer='" + typeOfCustomer + '\'' +
                ", address='" + address + '\'' +
                ", services=" + services +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        int result = this.getName().compareTo(o.getName());
        if (result ==0){
            int yearThis = Integer.parseInt(this.getDateBirth().split("/")[2]);
            int yearThat = Integer.parseInt(o.getDateBirth().split("/")[2]);
            if(yearThis>yearThat){
                return 1;
            }else if(yearThis<yearThat){
                return -1;
            }
        }
        return result;
    }
}

