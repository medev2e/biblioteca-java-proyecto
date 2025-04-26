package com.biblioteca.atenea.models;

import com.biblioteca.atenea.utils.PasswordHasher;

public class Employee extends Person {

    private String employeeUser;
    private String employeePassword;

    public Employee() {
        super();
        this.role = "EMPLOYEE";
    }

    public Employee(String name, String middleName, String lastName, String idNumber, String employeeUser,
            String plainPassword) {
        super(name, middleName, lastName, idNumber);
        this.role = "EMPLOYEE";
        this.employeeUser = employeeUser;
        this.employeePassword = PasswordHasher.hashPassword(plainPassword);
    }

    public void setAdminPassword(String plainPassword) {
        this.employeePassword = PasswordHasher.hashPassword(plainPassword);
    }

    public String getEmployeeUser() {
        return employeeUser;
    }

    public void setEmployeeUser(String employeeUser) {
        this.employeeUser = employeeUser;
    }
}
