package com.biblioteca.atenea.models;

public class Persons {
    private String name;
    private String middleName;
    private String lastName;
    private String idCard;
    // private int age;

    public Persons() {
    }

    public Persons(String name, String middleName, String lastName, String idCard) {
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
