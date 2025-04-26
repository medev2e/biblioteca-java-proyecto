package com.biblioteca.atenea.models;

import org.mindrot.jbcrypt.BCrypt;

public class Admin extends Person {
    private String adminUser;
    private String hashedPassword;

    public Admin() {
        super();
        this.role = "ADMIN";
    }

    public Admin(String name, String middleName, String lastName, String idNumber, String adminUser,
            String plainPassword) {
        super(name, middleName, lastName, idNumber);
        this.role = "ADMIN";
        this.adminUser = adminUser;
        setHashedPassword(plainPassword);
    }

    public String getAdminUser() {
        return adminUser;
    }

    public void setAdminUser(String adminUser) {
        this.adminUser = adminUser;
    }

    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.hashedPassword);
    }

    public void setHashedPassword(String plainPassword) {
        this.hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

}
