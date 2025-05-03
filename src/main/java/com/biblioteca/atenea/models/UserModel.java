package com.biblioteca.atenea.models;

import java.util.ArrayList;
import java.util.List;

import com.biblioteca.atenea.models.base.LoansModel;
import com.biblioteca.atenea.models.base.PenaltyModel;
import com.biblioteca.atenea.models.base.PersonModel;

public class UserModel extends PersonModel {

    private String nationalId;
    private String email;
    private String address;
    private long phoneNumber;
    private List<LoansModel> loans;
    private List<PenaltyModel> penalties;

    public UserModel() {
        super();
        this.penalties = new ArrayList<>();
        this.loans = new ArrayList<>();
    }

    public UserModel(String systemId, String name, String middleName, String lastName, String nationalId, String email,
            String address,
            long phoneNumber) {
        super(systemId, name, middleName, lastName);
        this.nationalId = nationalId;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.penalties = new ArrayList<>();
        this.loans = new ArrayList<>();
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

    public List<PenaltyModel> getPenalties() {
        return penalties;
    }

    public void addPenalty(PenaltyModel penalty) {
        this.penalties.add(penalty);
    }

    public void removePenalty(PenaltyModel penalty) {
        this.penalties.remove(penalty);
    }

    public void addLoans(LoansModel book) {
        this.loans.add(book);
    }

    public void removeLoans(LoansModel book) {
        this.loans.remove(book);
    }
}
