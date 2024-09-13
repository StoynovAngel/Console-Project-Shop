package org.example.Roles;

import org.example.handlers.ActionHandler;
import org.example.models.User;

import java.util.Scanner;

public class Client extends User {

    public Client(int id, String name, String password, String userRole) {
        super(id, name, password, userRole);
    }

    @Override
    public void showMenu(ActionHandler actionHandler, Scanner in) {
        int choice;

        do {
            System.out.println("Client Menu:");
            System.out.println("1. View available products");
            System.out.println("2. View your orders");
            System.out.println("3. Place a new order");
            System.out.println("4. View specific product.");
            System.out.println("5. Product by price range.");
            System.out.println("6. Get order details.");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");

            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1 -> actionHandler.productAction.allProducts();
                case 2 -> actionHandler.orderAction.viewUserOrders(getId());
                case 3 -> actionHandler.orderAction.newOrder(getId(), in);
                case 4 -> actionHandler.productAction.productByName(in);
                case 5 -> actionHandler.productAction.productPriceRange(in);
                case 6 -> actionHandler.orderAction.viewOrderDetails(in, getId());
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }
}
