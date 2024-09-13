package org.example.dao;

import org.example.connection.DatabaseConnection;
import org.example.handlers.MapResultSets;
import org.example.handlers.ResultSetHandler;
import org.example.handlers.UpdateHandler;
import org.example.models.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO {
    public final Connection conn = DatabaseConnection.connectToDB();

    public void createOrder(int user_id, String address){
        String sql = "INSERT INTO public.orders(user_id, address)VALUES (?,?)";
        UpdateHandler.executeUpdate(sql, conn, user_id, address);
    }

    public List<Order> getOrdersByUserID(int userId) {
        String sql = "SELECT * FROM public.orders WHERE user_id = ?";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToOrder, userId);
    }

    public Order getOrderByID(int id){
        String sql = "SELECT * FROM public.orders WHERE orders.id = ?";
        return ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToOrder, id);
    }

    public void updateOrderValue(int orderId) throws SQLException {
        String sql = "UPDATE public.orders SET value = (SELECT SUM(op.purchase_price * op.quantity) " +
                "FROM public.order_products op WHERE op.order_id = ?) WHERE id = ?";
        UpdateHandler.executeUpdate(sql, conn, orderId, orderId);
    }

    public List<Order> getAllOrders(){
        String sql = "SELECT * FROM public.orders";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToOrder);
    }

}
