package com.biblioteca.atenea.models;

import com.biblioteca.atenea.models.base.PersonModel;

public class EmployeeModel extends PersonModel {

    private String username;
    private String password;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(String systemId, String name, String middleName, String lastName,
            String username,
            String password) {
        super(systemId, name, middleName, lastName);
        this.username = username;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
