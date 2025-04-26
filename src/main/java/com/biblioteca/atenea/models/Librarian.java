package com.biblioteca.atenea.models;

import org.mindrot.jbcrypt.BCrypt;

public class Librarian extends Person {

    private String librarianUser;
    private String hashedPassword;

    public Librarian() {
        super();
        this.role = "LIBRARIAN";
    }

    public Librarian(String name, String middleName, String lastName, String idNumber, String librarianUser,
            String plainPassword) {
        super(name, middleName, lastName, idNumber);
        this.role = "LIBRARIAN";
        this.librarianUser = librarianUser;
        setHashedPassword(plainPassword);
    }

    public String getLibrarianUser() {
        return librarianUser;
    }

    public void setLibrarianUser(String librarianUser) {
        this.librarianUser = librarianUser;
    }

    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.hashedPassword);
    }

    public void setHashedPassword(String plainPassword) {
        this.hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }

}
