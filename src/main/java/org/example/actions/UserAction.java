package org.example.actions;

import org.example.dao.UserDAO;
import org.example.models.User;
import org.example.security.Security;

import java.util.Scanner;


public class UserAction {
    private final UserDAO userDAO = new UserDAO();

    public void displaySpecificUser(Scanner in){
        System.out.print("Enter user ID: ");
        int userId = in.nextInt();

        User user = userDAO.getSpecificUser(userId);
        if (user != null) {
            System.out.println(user);
        } else {
            System.out.println("User not found!");
        }
    }

    public void addNewUser(Scanner in){
        in.nextLine();
        System.out.print("Name: ");
        String name = in.nextLine();

        System.out.print("Password: ");
        String password = in.nextLine();

        String encodedPassword = Security.encryption(password);

        userDAO.addUser(name, encodedPassword);
    }

    public User login(Scanner in){
        in.nextLine();
        System.out.print("Name: ");
        String name = in.nextLine();
        System.out.print("Password: ");
        String password = in.nextLine();

        return userDAO.getLoggedUser(name, password);
    }

    public void register(Scanner in){
        in.nextLine();
        System.out.print("What is your name: ");
        String name = in.nextLine();
        System.out.print("What is your password: ");
        String password = in.nextLine();
        userDAO.addUser(name, Security.encryption(password));
    }

    public void allUsers(){
        System.out.println(userDAO.getAllUsers());
    }

    public void usersByRole(Scanner in){
        System.out.print("Role: ");
        String role = in.nextLine();

        System.out.println(userDAO.getAllUsersBySpecificRole(role));

    }

    public void deleteUser(Scanner in){
        System.out.println("Are you sure you want to delete a user? (yes/no)");
        String answer = in.nextLine();
        switch (answer.toLowerCase()){
            case "yes" -> {
                System.out.print("ID: ");
                int id = in.nextInt();
                userDAO.deleteUserByID(id);
            }
            case "no" -> System.out.println("Goodbye.");
            default -> System.out.println("Invalid choice");
        }
    }
}
