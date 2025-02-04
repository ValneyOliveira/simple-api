package com.example.store.models.dtos;

import com.example.store.models.CustomerModel;

import java.time.LocalDate;

public class CustomerDTO {

    private int customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private LocalDate joinDate;

    public CustomerDTO(){
    }

    public CustomerDTO(int customerId, String name, String phoneNumber, String email, String address) {
        this.customerId = customerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.setJoinDate(LocalDate.now());
    }

    public CustomerDTO(CustomerModel customerModel) {
        this.customerId = customerModel.getCustumerId();
        this.name = customerModel.getName();
        this.phoneNumber = customerModel.getPhoneNumber();
        this.email = customerModel.getEmail();
        this.address = customerModel.getAddress();
        this.joinDate = customerModel.getJoinDate();
    }

    public int getCustumerId() {
        return customerId;
    }

    public void setCustumerId(int custumerId) {
        this.customerId = custumerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

}
