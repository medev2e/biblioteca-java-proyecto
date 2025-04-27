package com.biblioteca.atenea.models;

import com.biblioteca.atenea.models.base.PersonModel;

public class UserModel extends PersonModel {

    public UserModel() {
        super();
    }

    public UserModel(String systemId, String name, String middleName, String lastName, String nationalId, String email,
            String address,
            long phoneNumber) {
        super(systemId, name, middleName, lastName, nationalId, email, address, phoneNumber);
    }
}
