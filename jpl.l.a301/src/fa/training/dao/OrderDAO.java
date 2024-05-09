/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.Order;
import java.sql.SQLException;
import java.util.List;

public interface OrderDAO  {
    // Method to retrieve all orders for a given customer ID
    List<Order> getAllOrdersByCustomerId(int customerId) throws SQLException;

    // Method to compute the total price of an order
    double computeOrderTotal(int orderId) throws SQLException;

    // Other method declarations...
    boolean addOrder(Order order) throws SQLException;

    public boolean updateOrderTotal(int orderId) throws SQLException;
}

