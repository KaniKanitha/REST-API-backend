package com.example.springboot.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Invoice {

    @Id
    private int productId;
    private String productName;
    private String password;
    private String mobileNumber;
    private int age;
    private String address;
    private String productType;
    private String accountNumber;

    public Invoice(int productId, String productName, String password, String mobileNumber, int age, String address, String productType, String accountNumber) {
        this.productId = productId;
        this.productName = productName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.productType = productType;
        this.accountNumber = accountNumber;
    }

    public Invoice() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
 
    @OneToOne(mappedBy = "passenger", cascade = CascadeType.ALL ,fetch=FetchType.LAZY)
    @JoinColumn(name = "productId")
    @JsonManagedReference
    private User user;
    
    public User getUser() {
        return user;
    }
    
    public void setUser(User user) {
        this.user = user;
    } 
}
