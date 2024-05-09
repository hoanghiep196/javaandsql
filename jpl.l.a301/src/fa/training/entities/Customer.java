/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.entities;

public class Customer implements Comparable<Customer> {
    private int customerId;
    private String customerName;

    // Default constructor
    public Customer() {
        // Default values
        this.customerId = 0;
        this.customerName = "";
    }

    // Constructor with parameters
    public Customer(int customerId, String customerName) {
        this.customerId = customerId;
        this.customerName = customerName;
    }

    // Getter and setter methods for customerId
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    // Getter and setter methods for customerName
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        // Compare 'this' Order object with 'other' Order object based on 'customerId' attribute in descending order
        if (this.customerId > o.customerId) {
            return -1; // 'this' is greater (sorting in descending order)
        } else if (this.customerId < o.customerId) {
            return 1; // 'other' is greater (sorting in descending order)
        } else {
            return 0; // Same total value
        }
    }

    
}
