package com.biblioteca.atenea.models;

public class User extends Person {

    private String email;
    private String adress;
    private long phoneNumber;

    public User() {
        super();
        this.role = "USER";
    }

    public User(String name, String middleName, String lastName, String idNumber, String email,
            String adress,
            int phoneNumber) {
        super(name, middleName, lastName, idNumber);
        this.role = "USER";
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

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
