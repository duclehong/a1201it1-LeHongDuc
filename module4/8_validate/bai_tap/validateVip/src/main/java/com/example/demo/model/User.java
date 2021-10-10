package com.example.demo.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class User implements Validator {

    @NotEmpty
    @Size(min = 5, max = 45)
    private String firsName;
    @Size(min = 5, max = 45)
    private String lastName;
    @NotNull
    @NotBlank(message="Please enter your phone number")
    private String phoneNumber;
    @Min(18)
    private int age;
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$",message = "email chua dung dinh dang")

    private String email;


    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        String phoneNumber = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
        if (phoneNumber.length()>11 || phoneNumber.length()<10){
            errors.rejectValue("phoneNumber", "phoneNumber.length");
        }
        if (!phoneNumber.startsWith("0")){
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
        }
        if (!phoneNumber.matches("(^$|[0-9]*$)")){
            errors.rejectValue("phoneNumber", "phoneNumber.matches");
        }
    }

}
