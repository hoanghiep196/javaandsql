/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.LineItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LineItemDAOImpl implements LineItemDAO {
    private Connection connection;

    // Constructor to inject database connection
    public LineItemDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<LineItem> getAllLineItemsByOrderId(int orderId) throws SQLException {
        List<LineItem> lineItems = new ArrayList<>();
        String query = "SELECT product_id, quantity, price FROM LineItem WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int productId = resultSet.getInt("product_id");
                    int quantity = resultSet.getInt("quantity");
                    double price = resultSet.getDouble("price");
                    LineItem lineItem = new LineItem(orderId, productId, quantity, price);
                    lineItems.add(lineItem);
                }
            }
        }
        return lineItems;
    }

    // Implement other methods (addLineItem, updateLineItem, deleteLineItem) similarly...

    @Override
    public boolean addLineItem(LineItem lineItem) throws SQLException {
        String query = "INSERT INTO LineItem (order_id, product_id, quantity, price) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lineItem.getOrderId());
            statement.setInt(2, lineItem.getProductId());
            statement.setInt(3, lineItem.getQuantity());
            statement.setDouble(4, lineItem.getPrice());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    @Override
    public boolean updateLineItem(LineItem lineItem) throws SQLException {
        String query = "UPDATE LineItem SET quantity = ?, price = ? WHERE order_id = ? AND product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, lineItem.getQuantity());
            statement.setDouble(2, lineItem.getPrice());
            statement.setInt(3, lineItem.getOrderId());
            statement.setInt(4, lineItem.getProductId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    @Override
    public boolean deleteLineItem(int orderId, int productId) throws SQLException {
        String query = "DELETE FROM LineItem WHERE order_id = ? AND product_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            statement.setInt(2, productId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}

