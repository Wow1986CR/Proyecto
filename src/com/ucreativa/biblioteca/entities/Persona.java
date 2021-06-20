package com.ucreativa.biblioteca.entities;

public abstract class Persona {
    private String name;
    private int phoneNumber;
    private String email;

    public Persona(String name,int phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Persona(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

}
