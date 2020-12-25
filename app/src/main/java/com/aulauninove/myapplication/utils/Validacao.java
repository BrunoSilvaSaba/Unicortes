package com.aulauninove.myapplication.utils;

public class Validacao {

    public boolean nome(String name) {
        String namePattern = "^[\\p{L} .'-]+$";
        return name.matches(namePattern);
    }

    public boolean email(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+.[a-z]+";
        return (email.matches(emailPattern));
    }

    public boolean celular(String tel) {
        String telPattern = "([0-9]{2})?([0-9]{2})?([0-9]{8,9})";
        return tel.matches(telPattern);
    }

    public boolean cep(String cep) {
        String cePpattern = "([0-9]{2})?([0-9]{2})?([0-9]{8,9})";
        return cep.matches(cePpattern);
    }

}
