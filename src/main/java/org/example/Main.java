package org.example;

import org.example.actions.OrderAction;
import org.example.actions.ProductAction;
import org.example.actions.UserAction;
import org.example.handlers.ClientHandler;

public class Main {
    public static void main(String[] args) {
        UserAction userAction = new UserAction();
        ProductAction productAction = new ProductAction();
        OrderAction orderAction = new OrderAction();
        ClientHandler clientHandler = new ClientHandler(userAction, productAction, orderAction);
        clientHandler.handleClient();
    }
}