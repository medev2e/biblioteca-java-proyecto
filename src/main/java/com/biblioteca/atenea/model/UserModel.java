package com.biblioteca.atenea.model;

import com.biblioteca.atenea.model.base.PersonModel;

public class UserModel extends PersonModel {

    private String nationalId;
    private String email;
    private String address;
    private long phoneNumber;

    public UserModel() {
        super();
    }

    public UserModel(String name, String middleName, String lastName, String surName,
            String nationalId, String email,
            String address,
            long phoneNumber) {
        super(name, middleName, lastName, surName);
        this.nationalId = nationalId;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
