package org.example.handlers;

import org.example.models.Product;
import org.example.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapResultSets {
    public static User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getString("password"),
                resultSet.getString("user_role")
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
}
