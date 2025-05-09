package com.biblioteca.atenea.models;

import com.biblioteca.atenea.models.base.PersonModel;
import com.biblioteca.atenea.models.base.PenaltyModel;
import com.biblioteca.atenea.models.base.LoansModel;

public class UserModel extends PersonModel {

    private String nationalId;
    private String email;
    private String address;
    private long phoneNumber;
    private PenaltyModel penalties = new PenaltyModel();
    private LoansModel loans = new LoansModel();

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

    public PenaltyModel getPenalties() {
        return penalties;
    }

    public void setPenalty(PenaltyModel penalty) {
        this.penalties = penalty;
    }

    public LoansModel getLoans() {
        return loans;
    }

    public void setLoan(LoansModel loans) {
        this.loans = loans;
    }
}
