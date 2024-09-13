package org.example.actions;

import org.example.dao.OrderDAO;
import org.example.dao.OrderProductDAO;
import org.example.dao.ProductDAO;
import org.example.models.CombinedOrderProducts;
import org.example.models.Order;
import org.example.models.OrderProduct;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderAction {
    private final OrderDAO orderDAO = new OrderDAO();
    private final ProductAction productAction = new ProductAction();

    public void viewUserOrders(int userId) {
        List<Order> orders = orderDAO.getOrdersByUserID(userId);
        if (orders.isEmpty()) {
            System.out.println("You have no orders.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public void viewOrderDetails(Scanner in, int userID) {
        viewUserOrders(userID);
        System.out.print("Enter order id: ");
        int orderId = in.nextInt();
        Order order = orderDAO.getOrderByID(orderId);

        if (order == null) {
            System.out.println("Order not found.");
            return;
        }

        System.out.println("Order Details:");
        System.out.println(order);

        OrderProductDAO orderProductDAO = new OrderProductDAO();
        List<CombinedOrderProducts> combinedOrderProducts = orderProductDAO.getCombinedOrderProductsByOrderId(orderId);

        if (combinedOrderProducts.isEmpty()) {
            System.out.println("No products in this order.");
        } else {
            System.out.println("Products in this order:");
            for (CombinedOrderProducts cop : combinedOrderProducts) {
                System.out.println(cop);
            }
        }
    }



    public void newOrder(int userId, Scanner in) {
        System.out.println("Address to receive the delivery: ");
        String address = in.nextLine();
        orderDAO.createOrder(userId, address);

        Order newOrder = orderDAO.getOrdersByUserID(userId).stream().max(Comparator.comparingInt(Order::getId)).orElse(null);

        if (newOrder == null) {
            System.out.println("Order could not be created.");
            return;
        }

        OrderProductDAO orderProductDAO = new OrderProductDAO();
        String choice;
        do {
            productAction.allProducts();
            System.out.println("Enter product ID to add to order:");
            int productId = in.nextInt();
            System.out.println("Enter quantity:");
            int quantity = in.nextInt();

            orderProductDAO.addProductsToOrder(newOrder.getId(), productId, quantity);

            System.out.println("Do you want to add more products? (yes/no):");
            choice = in.next();

        } while (choice.equalsIgnoreCase("yes"));

        try {
            orderDAO.updateOrderValue(newOrder.getId());
        } catch (SQLException e) {
            System.out.println("Error updating the order value: " + e.getMessage());
        }

        System.out.println("Order created and completed!");
    }

    public void viewAllOrders() {
        List<Order> orders = orderDAO.getAllOrders();
        if (orders.isEmpty()) {
            System.out.println("No orders.");
        } else {
            for (Order order : orders) {
                System.out.println(order);
            }
        }
    }

    public void changeStatus(Scanner in){
        System.out.print("Order id: ");
        int orderID = in.nextInt();
        in.nextLine();
        System.out.print("Status: ");
        String status = in.nextLine().toUpperCase();
        String[] possibleStatus = {"CANCELLED", "COMPLETED", "PENDING"};
        for(String s: possibleStatus){
            if(s.equals(status)){
                orderDAO.updateStatus(status, orderID);
            }
        }

    }
}
