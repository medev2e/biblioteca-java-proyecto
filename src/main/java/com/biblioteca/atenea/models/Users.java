package com.biblioteca.atenea.models;

public class Users extends Persons {

    private String email;
    private String adress;
    private int phoneNumber;

    public Users() {
    }

    public Users(String name, String middleName, String lastName, String idCard, String email, String adress,
            int phoneNumber) {
        super(name, middleName, lastName, idCard);
        this.email = email;
        this.adress = adress;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
