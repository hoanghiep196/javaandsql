/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.entities;

import java.util.Date;

public class Order implements Comparable<Order> {
    private int orderId;
    private Date orderDate;
    private int customerId;
    private int employeeId;
    private double total;

    // Default constructor
    public Order() {
        // Default values
        this.orderId = 0;
        this.orderDate = new Date(); // Default current date
        this.customerId = 0;
        this.employeeId = 0;
        this.total = 0.0;
    }

    // Constructor with parameters
    public Order(int orderId, Date orderDate, int customerId, int employeeId, double total) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.total = total;
    }

    // Getter and setter methods for orderId
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    // Getter and setter methods for orderDate
    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    // Getter and setter methods for customerId
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter and setter methods for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Getter and setter methods for total
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", customerId=" + customerId +
                ", employeeId=" + employeeId +
                ", total=" + total +
                '}';
    }

    @Override
    public int compareTo(Order o) {
        // Compare 'this' Order object with 'other' Order object based on 'total' attribute in descending order
        if (this.orderId > o.orderId) {
            return -1; // 'this' is greater (sorting in descending order)
        } else if (this.orderId < o.orderId) {
            return 1; // 'other' is greater (sorting in descending order)
        } else {
            return 0; // Same total value
        }
    }
}

