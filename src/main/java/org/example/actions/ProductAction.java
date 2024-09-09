package org.example.actions;

import org.example.dao.ProductDAO;
import org.example.models.Product;

import java.util.Locale;
import java.util.Scanner;

public class ProductAction {
    private final ProductDAO productDAO = new ProductDAO();
    public void addNewProduct(Scanner in){
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

    public void gedProductById(Scanner in){
        System.out.print("Id: ");
        int id = in.nextInt();

        Product product = productDAO.getProductByID(id);
        System.out.println(product);
    }

    public void productPriceRange(Scanner in){
        System.out.print("Low range: ");
        int low = in.nextInt();
        System.out.print("High range: ");
        int high = in.nextInt();

        System.out.println(productDAO.getProductByPriceRange(low, high));
    }

    public void productByName(Scanner in){
        System.out.print("The name of the product: ");
        String name = in.nextLine();

        System.out.println(productDAO.getProductByName(name));
    }
}
