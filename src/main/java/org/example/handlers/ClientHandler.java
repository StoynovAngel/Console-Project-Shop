package org.example.handlers;

import org.example.actions.ProductAction;
import org.example.actions.UserAction;

import java.util.Scanner;

public class ClientHandler {
    public static void handleClient() {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Hello, how can we help you?");
            System.out.println("1. Get a specific user.");
            System.out.println("2. Add new user.");
            System.out.println("3. Add new product.");
            System.out.println("4. Login.");
            System.out.println("5. Get all users.");
            System.out.println("6. Get all products.");
            System.out.println("==".repeat(40));

            int choice = in.nextInt();

            switch (choice) {
                case 1 -> UserAction.displaySpecificUser(in);
                case 2 -> UserAction.addNewUser(in);
                case 3 -> ProductAction.addNewProduct(in);
                case 4 -> UserAction.login(in);
                case 5 -> UserAction.allUsers();
                case 6 -> ProductAction.allProducts();
                default -> System.out.println("Invalid choice.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
