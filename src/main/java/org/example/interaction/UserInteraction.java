package org.example.interaction;

import org.example.actions.OrderAction;
import org.example.actions.ProductAction;
import org.example.actions.UserAction;
import org.example.handlers.ActionHandler;
import org.example.models.User;

import java.util.Scanner;

public class UserInteraction {
    public static void run() {
        UserAction userAction = new UserAction();
        ProductAction productAction = new ProductAction();
        OrderAction orderAction = new OrderAction();

        ActionHandler actionHandler = new ActionHandler(userAction, productAction, orderAction);
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome! Please login or register.");
        System.out.println("1. Login");
        System.out.println("2. Register");
        int choice = in.nextInt();

        switch (choice){
            case 1 -> {
                User user = userAction.login(in);
                if (user != null) {
                    user.showMenu(actionHandler, in);
                } else {
                    System.out.println("Login failed. Please try again.");
                }
            }
            case 2 -> {
                userAction.register(in);
                System.out.println("You have been registered.");
            }
        }

    }
}
