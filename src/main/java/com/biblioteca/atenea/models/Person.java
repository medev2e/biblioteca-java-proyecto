package com.biblioteca.atenea.models;

import java.util.UUID;

public class Person {
    private final String id;
    protected String role;
    private String name;
    private String middleName;
    private String lastName;
    private String idNumber;
    // private int age;

    public Person() {
        this.id = UUID.randomUUID().toString();
    }

    public Person(String name, String middleName, String lastName, String idNumber) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.idNumber = idNumber;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
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

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }
}
