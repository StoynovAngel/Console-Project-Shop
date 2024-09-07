package org.example.handlers;

import org.example.actions.OrderAction;
import org.example.actions.ProductAction;
import org.example.actions.UserAction;

import java.util.Scanner;

public class ClientHandler {
    private final UserAction userAction;
    private final ProductAction productAction;
    private final OrderAction orderAction;

    public ClientHandler(UserAction userAction, ProductAction productAction, OrderAction orderAction) {
        this.userAction = userAction;
        this.productAction = productAction;
        this.orderAction = orderAction;
    }

    public void handleClient() {
        try (Scanner in = new Scanner(System.in)) {
            int choice;

            do {
                System.out.println("Hello, how can we help you?");
                System.out.println("1. Get a specific user.");
                System.out.println("2. Add new user.");
                System.out.println("3. Add new product.");
                System.out.println("4. Login.");
                System.out.println("5. Get all users.");
                System.out.println("6. Get all products.");
                System.out.println("7. Add new order.");
                System.out.println("8. Get my role.");
                System.out.println("0. Stop");
                System.out.println("==".repeat(40));

                choice = in.nextInt();
                in.nextLine();

                switch (choice) {
                    case 1 -> userAction.displaySpecificUser(in);
                    case 2 -> userAction.addNewUser(in);
                    case 3 -> productAction.addNewProduct(in);
                    case 4 -> userAction.login(in);
                    case 5 -> userAction.allUsers();
                    case 6 -> productAction.allProducts();
                    case 7 -> orderAction.newOrder(in);
                    case 8 -> userAction.role(in);
                    case 0 -> System.out.println("Goodbye!");
                    default -> System.out.println("Invalid choice. Please try again.");
                }

                System.out.println();
            } while (choice != 0);

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
