package org.example.dao;

import org.example.connection.DatabaseConnection;
import org.example.handlers.MapResultSets;
import org.example.handlers.ResultSetHandler;
import org.example.handlers.UpdateHandler;
import org.example.models.Product;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public final Connection conn = DatabaseConnection.connectToDB();

    public void addProduct(String brand, String name, double original_price, int discount, int quantity) {
        String sql = "INSERT INTO public.products(brand, name, original_price, discount, quantity) VALUES (?, ?, ?, ?, ?)";
        UpdateHandler.executeUpdate(sql, conn, brand, name, original_price, discount, quantity);
    }

    public Product getProductByID(int id){
        String sql = "SELECT * FROM public.products WHERE products.id = ?";
        return ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToProduct, id);
    }

    public List<Product> getAllProducts(){
        String sql = "SELECT * FROM public.products";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToProduct);
    }

    public List<Product> getProductByPriceRange(int low, int high){
        String sql = "SELECT * FROM public.products WHERE products.final_price BETWEEN ? AND ?";
        return ResultSetHandler.handleMultipleReturnSet(sql, conn, MapResultSets::mapResultSetToProduct, low, high);
    }

    public Product getProductByName(String name){
        String sql = "SELECT * FROM public.products WHERE products.name = ?";
        return ResultSetHandler.handleSingleReturnSet(sql, conn, MapResultSets::mapResultSetToProduct, name);
    }

    public void deleteProduct(int id){
        String sql = "DELETE FROM public.products WHERE id = ?";
        UpdateHandler.executeUpdate(sql, conn, id);
    }
}
