package org.example.Roles;

import org.example.handlers.ActionHandler;
import org.example.models.User;

import java.util.Scanner;

public class Admin extends User {
    public Admin(int id, String name, String password, String userRole) {
        super(id, name, password, userRole);
    }

    @Override
    public void showMenu(ActionHandler actionHandler, Scanner in) {
        int choice;

        do {
            System.out.println("Admin Menu:");
            System.out.println("1. View all users");
            System.out.println("2. View all orders");
            System.out.println("3. Add a new product");
            System.out.println("4. View all products");
            System.out.println("5. Add new user");
            System.out.println("6. Display a specific user");
            System.out.println("7. Display a specific product by id");
            System.out.println("8. Display all users by role");
            System.out.println("9. Delete user by id");
            System.out.println("10. Change order status");
            System.out.println("11.  Delete product by id.");
            System.out.println("0. Logout");
            System.out.print("Enter your choice: ");
            choice = in.nextInt();
            in.nextLine();

            switch (choice) {
                case 1 -> actionHandler.userAction.allUsers();
                case 2 -> actionHandler.orderAction.viewAllOrders();
                case 3 -> actionHandler.productAction.addNewProduct(in);
                case 4 -> actionHandler.productAction.allProducts();
                case 5 -> actionHandler.userAction.addNewUser(in);
                case 6 -> actionHandler.userAction.displaySpecificUser(in);
                case 7 -> actionHandler.productAction.gedProductById(in);
                case 8 -> actionHandler.userAction.usersByRole(in);
                case 9 -> actionHandler.userAction.deleteUser(in);
                case 10 -> actionHandler.orderAction.changeStatus(in);
                case 11 -> actionHandler.productAction.deleteById(in);
                case 0 -> System.out.println("Logging out...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
            System.out.println();
        } while (choice != 0);
    }
}
