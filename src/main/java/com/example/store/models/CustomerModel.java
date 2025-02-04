package com.example.store.models;

import com.example.store.models.dtos.CustomerDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
public class CustomerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id", nullable = false, unique = true)
    private int customerId;

    @Column(nullable = false)
    private String name;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(name = "join_date", nullable = false)
    private LocalDate joinDate;

    public CustomerModel(){

    }

    public CustomerModel(CustomerDTO customerDTO) {
        this.customerId = customerDTO.getCustumerId();
        this.name = customerDTO.getName();
        this.phoneNumber = customerDTO.getPhoneNumber();
        this.email = customerDTO.getEmail();
        this.address = customerDTO.getAddress();
        this.joinDate = LocalDate.now();
    }

    public int getCustumerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
    public void setJoinDate(LocalDate date) {
        this.joinDate = date;
    }

}
