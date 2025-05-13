package model;

import model.base.PersonModel;
import util.SecurityUtil;

public class EmployeeModel extends PersonModel {

    private String username;
    private String password;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(String name, String middleName, String lastName, String surName,
            String username,
            String password) {
        super(name, middleName, lastName, surName);
        this.username = username;
        this.password = SecurityUtil.hashPassword(password);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = SecurityUtil.hashPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
