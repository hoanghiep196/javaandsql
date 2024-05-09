/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.entities;

public class Employee implements Comparable<Employee> {
    private int employeeId;
    private String employeeName;
    private double salary;
    private int supervisorId;

    // Default constructor
    public Employee() {
        // Default values
        this.employeeId = 0;
        this.employeeName = "";
        this.salary = 0.0;
        this.supervisorId = 0;
    }

    // Constructor with parameters
    public Employee(int employeeId, String employeeName, double salary, int supervisorId) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.salary = salary;
        this.supervisorId = supervisorId;
    }

    // Getter and setter methods for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Getter and setter methods for employeeName
    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    // Getter and setter methods for salary
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter and setter methods for supervisorId
    public int getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeName='" + employeeName + '\'' +
                ", salary=" + salary +
                ", supervisorId=" + supervisorId +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        // Compare 'this' Order object with 'other' Order object based on 'total' attribute in descending order
        if (this.employeeId > o.employeeId) {
            return -1; // 'this' is greater (sorting in descending order)
        } else if (this.employeeId < o.employeeId) {
            return 1; // 'other' is greater (sorting in descending order)
        } else {
            return 0; // Same total value
        }
    }
}

