package org.example.handlers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateHandler {
    public static void executeUpdate(String sql, Connection conn, Object... obj){
        try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
            for(int i = 0; i < obj.length; i++){
                preparedStatement.setObject(i+1, obj[i]);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
