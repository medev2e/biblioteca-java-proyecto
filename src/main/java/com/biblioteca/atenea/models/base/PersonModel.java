package com.biblioteca.atenea.models.base;

public class PersonModel {
    private final String systemId;
    private String name;
    private String middleName;
    private String lastName;
    private String nationalId;
    private String email;
    private String address;
    private long phoneNumber;
    // private int age;

    public PersonModel() {
        this.systemId = null;
    }

    public PersonModel(String systemId, String name, String middleName, String lastName, String nationalId,
            String email, String address, long phoneNumber) {
        this.systemId = systemId;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.nationalId = nationalId;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getSystemId() {
        return systemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        if (middleName != null) {
            return middleName;
        } else {
            return "No hay segundo nombre";
        }
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
