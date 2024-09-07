package org.example.actions;

import org.example.dao.ProductDAO;

import java.util.Locale;
import java.util.Scanner;

public class ProductAction {
    private final ProductDAO productDAO = new ProductDAO();
    public void addNewProduct(Scanner in){

        in.nextLine();
        System.out.print("Brand: ");
        String brand = in.nextLine();

        System.out.print("Name of the product: ");
        String name = in.nextLine();

        System.out.print("Price: ");
        double originalPrice = in.nextDouble();

        System.out.print("Discount: ");
        int discount = in.nextInt();

        System.out.print("Quantity: ");
        int quantity = in.nextInt();

        productDAO.addProduct(brand, name, originalPrice, discount, quantity);
        System.out.println("Product added successfully.");

    }

    public void allProducts(){
        System.out.println(productDAO.getAllProducts());
    }
}
