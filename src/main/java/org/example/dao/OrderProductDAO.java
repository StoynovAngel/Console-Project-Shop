package org.example.dao;

import org.example.connection.DatabaseConnection;
import org.example.handlers.MapResultSets;
import org.example.handlers.ResultSetHandler;
import org.example.handlers.UpdateHandler;
import org.example.models.OrderProduct;
import org.example.models.Product;

import java.sql.Connection;

public class OrderProductDAO {
    public final Connection conn = DatabaseConnection.connectToDB();
    public void addProductsToOrder(int order_id, int product_id, int quantity){
        String sql = "INSERT INTO public.order_products(order_id, product_id, purchase_price, quantity) VALUES (?, ?, ?, ?)";
        double purchase_price = getProductCurrentPrice(product_id) * quantity;
        UpdateHandler.executeUpdate(sql, conn, order_id, product_id, purchase_price, quantity);

    }

    private double getProductCurrentPrice(int product_id){
        String sql = "SELECT * FROM public.products WHERE products.id = ?";
        Product product = ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToProduct, product_id);
        return  product.getFinalPrice();
    }
}
