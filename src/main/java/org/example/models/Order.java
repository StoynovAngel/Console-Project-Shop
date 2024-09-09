package org.example.models;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private int id;
    private double value;
    private String status;
    private String address;
    private Timestamp orderDate;

    public Order(int id, double value, String status, String address, Timestamp orderDate) {
        this.id = id;
        this.value = value;
        this.status = status;
        this.address = address;
        this.orderDate = orderDate;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public Timestamp getOrderDate() { return orderDate; }
    public void setOrderDate(Timestamp orderDate) { this.orderDate = orderDate; }
}