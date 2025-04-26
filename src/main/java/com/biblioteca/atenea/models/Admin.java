package com.biblioteca.atenea.models;

import com.biblioteca.atenea.utils.PasswordHasher;

public class Admin extends Person {
    private String adminUser;
    private String adminPassword;

    public Admin() {
        super();
        this.role = "ADMIN";
    }

    public Admin(String name, String middleName, String lastName, String idNumber, String adminUser,
            String plainPassword) {
        super(name, middleName, lastName, idNumber);
        this.role = "ADMIN";
        this.adminUser = adminUser;
        this.adminPassword = PasswordHasher.hashPassword(plainPassword);
    }

    public void setAdminPassword(String plainPassword) {
        this.adminPassword = PasswordHasher.hashPassword(plainPassword);
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }
}
