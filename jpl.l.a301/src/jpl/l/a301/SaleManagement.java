/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jpl.l.a301;
import fa.training.dao.*;
import fa.training.entities.*;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SaleManagement {
    public static void main(String[] args) {
        try {
            // Establish database connection
            Connection connection = DatabaseConnection.getConnection();
            // Create DAO instances
            CustomerDAO customerDAO = new CustomerDAOImpl(connection);
            OrderDAO orderDAO = new OrderDAOImpl(connection);
            LineItemDAO lineItemDAO = new LineItemDAOImpl(connection);

            // List all customers
            System.out.println("Listing all customers:");
            List<Customer> allCustomers = customerDAO.getAllCustomers();
            for (Customer customer : allCustomers) {
                System.out.println(customer.getCustomerId() + ": " + customer.getCustomerName());
            }
            System.out.println();

            // List all orders for a customer
            int customerIdToQuery = 1; // Example: Customer ID to query orders for
            System.out.println("Listing all orders for customer with ID " + customerIdToQuery + ":");
            List<Order> ordersByCustomer = orderDAO.getAllOrdersByCustomerId(customerIdToQuery);
            for (Order order : ordersByCustomer) {
                System.out.println(order.getOrderId() + ", " + order.getOrderDate() + ", Customer: " + order.getCustomerId() +
                        ", Employee: " + order.getEmployeeId() + ", Total: " + order.getTotal());
            }
            System.out.println();

            // List all line items for an order
            int orderIdToQuery = 1; // Example: Order ID to query line items for
            System.out.println("Listing all line items for order with ID " + orderIdToQuery + ":");
            List<LineItem> lineItemsForOrder = lineItemDAO.getAllLineItemsByOrderId(orderIdToQuery);
            for (LineItem item : lineItemsForOrder) {
                System.out.println("Product ID: " + item.getProductId() + ", Quantity: " + item.getQuantity() +
                        ", Price: " + item.getPrice());
            }
            System.out.println();

            // Compute order total for an order using UDF
            int orderIdForTotal = 1; // Example: Order ID to compute total for
            System.out.println("Computing order total for order with ID " + orderIdForTotal + ":");
            double orderTotal = orderDAO.computeOrderTotal(orderIdForTotal);
            System.out.println("Total Price: " + orderTotal);
            System.out.println();
            // Add a new customer using stored procedure
            Customer newCustomer = new Customer(10, "John Doe"); // Example: New customer details
            System.out.println("Adding new customer:");
            boolean customerAdded = customerDAO.addCustomer(newCustomer);
            if (customerAdded) {
                System.out.println("Customer added successfully: " + customerAdded);
            } else {
                System.out.println("Customer added failed");
            }
            System.out.println();
            // Delete a customer and associated orders using stored procedure
            int customerIdToDelete = 10; // Example: Customer ID to delete
            System.out.println("Deleting customer with ID " + customerIdToDelete + " and associated orders:");
            boolean customerDeleted = customerDAO.deleteCustomer(customerIdToDelete);
            if (customerDeleted) {
                System.out.println("Customer deleted successfully: " + customerDeleted);
            } else {
                System.out.println("Customer updated failed");
            }           
            System.out.println();
            // Update an existing customer using stored procedure
            Customer updatedCustomer = new Customer(1, "Updated Name"); // Example: Updated customer details
            System.out.println("Updating existing customer:");
            boolean customerUpdated = customerDAO.updateCustomer(updatedCustomer);
            if (customerUpdated) {
                System.out.println("Customer updated successfully: " + customerUpdated);
            } else {
                System.out.println("Customer updated failed");
            }            
            System.out.println();
            // Create a new order
            Order newOrder = new Order(1001, new java.util.Date(), 1, 101, 250.0); // Example: New order details
            System.out.println("Creating new order:");
            boolean orderCreated = orderDAO.addOrder(newOrder);
            if (orderCreated) {
                System.out.println("Order created successfully: " + orderCreated);
            } else {
                System.out.println("Order created failed");
            }
            System.out.println();
            // Create a new line item
            LineItem newLineItem = new LineItem(1001, 1, 3, 50.0); // Example: New line item details
            System.out.println("Creating new line item:");
            boolean lineItemCreated = lineItemDAO.addLineItem(newLineItem);
            if (lineItemCreated) {
                System.out.println("Line item created successfully:" + lineItemCreated);
            } else {
                System.out.println("Line item created failed");
            }
            System.out.println();
            // Update order total
            int orderIdToUpdateTotal = 10; // Example: Order ID to update total for
            System.out.println("Updating order total for order with ID " + orderIdToUpdateTotal + ":");
            boolean totalUpdated = orderDAO.updateOrderTotal(orderIdToUpdateTotal);
            if (totalUpdated) {
                System.out.println("Order total updated successfully" + totalUpdated);
            } else {
                System.out.println("Failed to update order total order.");
            }
            System.out.println();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }  
    }
}

