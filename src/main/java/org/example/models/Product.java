package org.example.models;

public class Product {
    private int id;
    private String brand;
    private String name;
    private double originalPrice;
    private double finalPrice;
    private int discount, quantity;


    public Product(int id, String brand, String name, double originalPrice, int discount, double finalPrice, int quantity) {
        this.id = id;
        this.brand = brand;
        this.name = name;
        this.originalPrice = originalPrice;
        this.discount = discount;
        this.finalPrice = finalPrice;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getName() {
        return name;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public String toString() {
        return "\n[User Details:]\n" +
                "----------------------------\n" +
                "Id                 : " + id + "\n" +
                "Brand              : " + brand + "\n" +
                "Name               : " + name + "\n" +
                "Original price     : " + originalPrice + "$" + "\n" +
                "Current price      : " + finalPrice + "$" + "\n" +
                "Discount           : " + discount + "\n" +
                "Quantity           : " + quantity + "\n" +
                "----------------------------\n";
    }
}
