/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {
    private Connection connection;

    // Constructor to inject database connection
    public ProductDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String query = "SELECT product_id, product_name, list_price FROM Product";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                double listPrice = resultSet.getDouble("list_price");
                Product product = new Product(productId, productName, listPrice);
                products.add(product);
            }
        }
        return products;
    }

    @Override
    public Product getProductById(int productId) throws SQLException {
        String query = "SELECT product_name, list_price FROM Product WHERE product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String productName = resultSet.getString("product_name");
                    double listPrice = resultSet.getDouble("list_price");
                    return new Product(productId, productName, listPrice);
                }
            }
        }
        return null;
    }

    // Implement other methods (addProduct, updateProduct, deleteProduct) similarly...

    @Override
    public boolean addProduct(Product product) throws SQLException {
        String query = "INSERT INTO Product (product_id, product_name, list_price) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, product.getProductId());
            statement.setString(2, product.getProductName());
            statement.setDouble(3, product.getListPrice());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    @Override
    public boolean updateProduct(Product product) throws SQLException {
        String query = "UPDATE Product SET product_name = ? WHERE product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, product.getProductName());
            statement.setInt(2, product.getProductId());
            statement.setDouble(3, product.getListPrice());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    @Override
    public boolean deleteProduct(int productId) throws SQLException {
        String query = "DELETE FROM Product WHERE product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, productId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}
