package com.example.utsmcs.Model;

import com.example.utsmcs.Database.UserHelper;

import java.util.ArrayList;
import java.util.Vector;

public class User {
    Integer id;
    String username, password, email;

    private UserHelper userHelper;

    public User(Integer id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public User(){

    }

    public void setId(Integer id){this.id = id;}


    public Vector<User> getAllUser(){
        return userHelper.getAllUser();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
