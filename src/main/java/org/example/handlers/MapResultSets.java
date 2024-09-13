package org.example.handlers;

import org.example.Roles.Admin;
import org.example.Roles.Client;
import org.example.models.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapResultSets {
    public static User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("name");
        String password = resultSet.getString("password");
        String user_role = resultSet.getString("user_role");

        if(user_role.equalsIgnoreCase("admin")){
            return new Admin(id, username, password, user_role);
        }
        else{
            return new Client(id, username, password, user_role);
        }
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

    public static CombinedOrderProducts mapResultSetToCombinedOrderProduct(ResultSet resultSet) throws SQLException{
        OrderProduct orderProduct = new OrderProduct(
                resultSet.getInt("order_id"),
                resultSet.getInt("product_id"),
                resultSet.getDouble("purchase_price"),
                resultSet.getInt("quantity")
        );

        Product product = new Product(
                resultSet.getInt("product_id"),
                resultSet.getString("brand"),
                resultSet.getString("name"),
                resultSet.getDouble("original_price"),
                resultSet.getInt("discount"),
                resultSet.getDouble("final_price"),
                resultSet.getInt("quantity")
        );

        return new CombinedOrderProducts(orderProduct, product);
    }
}
