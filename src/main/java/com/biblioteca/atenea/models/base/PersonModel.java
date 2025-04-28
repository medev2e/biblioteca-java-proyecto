package com.biblioteca.atenea.models.base;

public class PersonModel {
    private String systemId;
    private String name;
    private String middleName;
    private String lastName;

    public PersonModel() {
    }

    public PersonModel(String systemId, String name, String middleName, String lastName) {
        this.systemId = systemId;
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
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
}
