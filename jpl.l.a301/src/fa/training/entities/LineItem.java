/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.entities;

/**
 *
 * @author user
 */
public class LineItem implements Comparable<LineItem> {
    private int orderId;
    private int productId;
    private int quantity;
    private double price;

    // Default constructor
    public LineItem() {
        // Default values
        this.orderId = 0;
        this.productId = 0;
        this.quantity = 0;
        this.price = 0.0;
    }

    // Constructor with parameters
    public LineItem(int orderId, int productId, int quantity, double price) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter and setter methods
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(LineItem o) {
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
