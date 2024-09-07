package org.example.handlers;

import org.example.models.Order;
import org.example.models.OrderProduct;
import org.example.models.Product;
import org.example.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapResultSets {
    public static User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getString("name"),
                resultSet.getString("password")
        );
    }

    public static Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        return new Product(
                resultSet.getInt("id"),
                resultSet.getString("brand"),
                resultSet.getString("name"),
                resultSet.getDouble("original_price"),
                resultSet.getInt("discount"),
                resultSet.getDouble("final_price"),
                resultSet.getInt("quantity")
        );
    }

    public static Order mapResultSetToOrder(ResultSet resultSet) throws SQLException{
        return new Order(
                resultSet.getInt("id"),
                resultSet.getDouble("value"),
                resultSet.getString("status"),
                resultSet.getString("address"),
                resultSet.getTimestamp("order_date")
        );
    }

    public static OrderProduct mapResultSetToOrderProduct(ResultSet resultSet) throws SQLException{
        return new OrderProduct(
                resultSet.getInt("order_id"),
                resultSet.getInt("product_id"),
                resultSet.getDouble("purchase_price"),
                resultSet.getInt("quantity")
        );
    }
}
