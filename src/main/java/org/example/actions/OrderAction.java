package org.example.actions;

import org.example.dao.OrderDAO;
import org.example.dao.OrderProductDAO;
import java.util.Scanner;

public class OrderAction {
    private final OrderDAO orderDAO = new OrderDAO();

    public void newOrder(Scanner in){
        in.nextLine();
        System.out.println("Address to receive the delivery: ");
        String address = in.nextLine();
    }
}
