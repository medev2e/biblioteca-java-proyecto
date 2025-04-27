package com.biblioteca.atenea.models;

import com.biblioteca.atenea.models.base.PersonModel;

public class EmployeeModel extends PersonModel {

    private String employeeUsername;
    private String employeePassword;

    public EmployeeModel() {
        super();
    }

    public EmployeeModel(String systemId, String name, String middleName, String lastName, String nationalId,
            String email, String address, long phoneNumber,
            String employeeUsername,
            String employeePassword) {
        super(systemId, name, middleName, lastName, nationalId, email, address, phoneNumber);
        this.employeeUsername = employeeUsername;
        this.employeePassword = employeePassword;
    }

    public void setAdminPassword(String employeePassword) {
        this.employeePassword = employeePassword;
    }

    public String getEmployeeUsername() {
        return employeeUsername;
    }

    public void setEmployeeUsername(String employeeUsername) {
        this.employeeUsername = employeeUsername;
    }
}
