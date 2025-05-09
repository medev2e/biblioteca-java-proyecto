package com.biblioteca.atenea.models.base;

import com.biblioteca.atenea.utils.IdProviderUtil;

public class PersonModel {
    private String systemId;
    private String name;
    private String middleName;
    private String lastName;
    private String surName;

    public PersonModel() {
    }

    public PersonModel(String name, String middleName, String lastName, String surName) {
        this.systemId = IdProviderUtil.generate();
        this.name = name;
        this.middleName = middleName;
        this.lastName = lastName;
        this.surName = surName;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
