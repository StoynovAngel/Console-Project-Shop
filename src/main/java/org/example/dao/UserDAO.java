package org.example.dao;

import org.example.connection.DatabaseConnection;
import org.example.handlers.MapResultSets;
import org.example.handlers.ResultSetHandler;
import org.example.handlers.UpdateHandler;
import org.example.models.User;
import org.example.security.Security;

import java.sql.*;
import java.util.List;

public class UserDAO {
    public final Connection conn = DatabaseConnection.connectToDB();

    public void addUser(String name, String password){
        String sql = "INSERT INTO public.users(name, password) VALUES (?, ?)";
        UpdateHandler.executeUpdate(sql, conn, name, password);
    }

    public List<User> getAllUsers(){
        String sql = "SELECT * FROM public.users";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToUser);
    }

    public User getSpecificUser(int id){
        String sql = "SELECT * FROM public.users WHERE users.id = ?";
        return ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToUser, id);
    }

    public List<User> getAllUserBySpecificRole(String userRole){
        String sql = "SELECT * FROM public.users WHERE users.user_role = ?";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToUser, userRole);
    }

    public User getLoggedUser(String name, String password){
        String sql = "SELECT * FROM public.users WHERE users.name = ? AND users.password = ?";
        return ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToUser, name, Security.encryption(password));
    }

    public String getMyUserRole(String name, String password){
        String sql = "SELECT users.user_role FROM public.users WHERE users.name = ? AND users.password = ?";
        User user = ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToUser, name, Security.encryption(password));
        return user != null ? user.getUserRole() : null;
    }

}
