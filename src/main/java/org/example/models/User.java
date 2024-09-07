package org.example.models;

import org.example.handlers.ClientHandler;

import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
    private int id;
    private String name;
    private String password;
    private String userRole;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public String toString() {
        return "\n[User Details:]\n" +
                "----------------------------\n" +
                "Name    : " + name + "\n" +
                "Role    : " + userRole + "\n" +
                "----------------------------\n";
    }
}
