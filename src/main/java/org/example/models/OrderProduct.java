package org.example.models;


public class OrderProduct {
    private int orderId;
    private int productId;
    private double purchasePrice;
    private int quantity;

    public OrderProduct(int orderId, int productId, double purchasePrice, int quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.purchasePrice = purchasePrice;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getOrderId() { return orderId; }
    public void setOrderId(int orderId) { this.orderId = orderId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public double getPurchasePrice() { return purchasePrice; }
    public void setPurchasePrice(double purchasePrice) { this.purchasePrice = purchasePrice; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}