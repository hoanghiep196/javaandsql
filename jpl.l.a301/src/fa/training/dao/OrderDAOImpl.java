/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDAOImpl implements OrderDAO {
    private Connection connection;
    

    // Constructor to inject database connection
    public OrderDAOImpl(Connection connection) {
        this.connection = connection;
    }

    /**
     *
     * @param orderId
     * @return
     * @throws SQLException
     */
    @Override
    public double computeOrderTotal(int orderId) throws SQLException {
        double total = 0.0;
        String query = "SELECT SUM(quantity * price) AS total_price FROM LineItem WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, orderId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    total = resultSet.getDouble("total_price");
                }
            }
        }
        return total;
    }

    // Implement other methods (addOrder, updateOrderTotal) similarly...

    @Override
    public List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException {
        List<Order> orders = new ArrayList<>();
        String query = "SELECT * FROM Orders WHERE customer_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, customerId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    int orderId = resultSet.getInt("order_id");
                    Date orderDate = resultSet.getDate("order_date");
                    int employeeId = resultSet.getInt("employee_id");
                    double total = resultSet.getDouble("total");

                    // Create Order object and add to list
                    Order order = new Order(orderId, orderDate, customerId, employeeId, total);
                    orders.add(order);
                }
            }
        }
        return orders;
    }
    @Override
    public boolean addOrder(Order order) throws SQLException {
        String query = "INSERT INTO Orders (order_id, order_date, customer_id, employee_id, total) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, order.getOrderId());
            statement.setDate(2, new java.sql.Date(order.getOrderDate().getTime())); // Assuming orderDate is a java.util.Date
            statement.setInt(3, order.getCustomerId());
            statement.setInt(4, order.getEmployeeId());
            statement.setDouble(5, order.getTotal());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        }
    }

    @Override
    public boolean updateOrderTotal(int orderId) throws SQLException {
        Order order = null;
        String query = "UPDATE Orders SET total = ? WHERE order_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDouble(1, order.getTotal());
            statement.setInt(2, orderId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }
}
