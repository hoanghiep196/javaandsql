/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.entities;

public class Product implements Comparable<Product> {
    private int productId;
    private String productName;
    private double listPrice;

    // Default constructor
    public Product() {
        // Default values
        this.productId = 0;
        this.productName = "";
        this.listPrice = 0.0;
    }

    // Constructor with parameters
    public Product(int productId, String productName, double listPrice) {
        this.productId = productId;
        this.productName = productName;
        this.listPrice = listPrice;
    }

    // Getter and setter methods for productId
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    // Getter and setter methods for productName
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    // Getter and setter methods for listPrice
    public double getListPrice() {
        return listPrice;
    }

    public void setListPrice(double listPrice) {
        this.listPrice = listPrice;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", listPrice=" + listPrice +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        // Compare 'this' Order object with 'other' Order object based on 'total' attribute in descending order
        if (this.productId > o.productId) {
            return -1; // 'this' is greater (sorting in descending order)
        } else if (this.productId < o.productId) {
            return 1; // 'other' is greater (sorting in descending order)
        } else {
            return 0; // Same total value
        }
    }
}
