package org.example.models;

import org.example.handlers.ActionHandler;

import java.io.Serializable;
import java.util.Scanner;

public abstract class User{
    private String name;
    private String password;
    private String userRole;

    public User(String name, String password, String userRole) {
        this.name = name;
        this.password = password;
        this.userRole = userRole;
    }
    public abstract void showMenu(ActionHandler actionHandler, Scanner in);

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
