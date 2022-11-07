package com.revhalisi.appchurch.api.models;

public class User {
    private int id;
    private String name,phoneNumber, email, password,type;


    public int getId() {
        return id;
    }
    public String getType(){return type;}
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String name,String type, String phoneNumber, String email, String password) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.type = type;
        this.password = password;
    }
}
