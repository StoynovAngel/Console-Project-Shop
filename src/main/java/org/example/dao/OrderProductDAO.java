package org.example.dao;

import org.example.connection.DatabaseConnection;
import org.example.handlers.MapResultSets;
import org.example.handlers.ResultSetHandler;
import org.example.handlers.UpdateHandler;
import org.example.models.CombinedOrderProducts;
import org.example.models.Order;
import org.example.models.OrderProduct;
import org.example.models.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderProductDAO {
    public final Connection conn = DatabaseConnection.connectToDB();

    public void addProductsToOrder(int orderId, int productId, int quantity) {
        Product product = getSpecificProduct(productId);
        int availableStock = product.getQuantity();
        if (availableStock < quantity) {
            System.out.println("Not enough stock available for product ID: " + productId);
            return;
        }
        double purchasePrice = product.getFinalPrice();
        double totalPrice = purchasePrice * quantity;

        String sql = "INSERT INTO public.order_products (order_id, product_id, purchase_price, quantity) VALUES (?, ?, ?, ?)";

        UpdateHandler.executeUpdate(sql, conn, orderId, productId, totalPrice, quantity);

        updateProductQuantity(productId, quantity);
        OrderDAO orderDAO = new OrderDAO();
        try {
            orderDAO.updateOrderValue(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product getSpecificProduct(int product_id){
        String sql = "SELECT * FROM public.products WHERE products.id = ?";
        return ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToProduct, product_id);
    }

    public List<CombinedOrderProducts> getCombinedOrderProductsByOrderId(int orderId) {
        String sql = "SELECT op.order_id, op.product_id, op.purchase_price, op.quantity, " +
                "p.name, p.brand, p.original_price, p.discount, p.final_price, p.quantity as stock_quantity " +
                "FROM public.order_products op " +
                "JOIN public.products p ON op.product_id = p.id " +
                "WHERE op.order_id = ?";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToCombinedOrderProduct, orderId);
    }

    public void updateProductQuantity(int productId, int quantity) {
        String sql = "UPDATE public.products SET quantity = quantity - ? WHERE id = ?";
        UpdateHandler.executeUpdate(sql, conn, quantity, productId);
    }



}
