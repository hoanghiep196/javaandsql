/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    private Connection connection;

    // Constructor to inject database connection
    public EmployeeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Employee> getAllEmployees() throws SQLException {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT employee_id, employee_name, salary, supervisor_id FROM Employee";
        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("employee_id");
                String employeeName = resultSet.getString("employee_name");
                double salary = resultSet.getDouble("salary");
                int supervisorId = resultSet.getInt("supervisor_id");
                Employee employee = new Employee(employeeId, employeeName, salary, supervisorId);
                employees.add(employee);
            }
        }
        return employees;
    }

    // Implement other methods (getEmployeeById, addEmployee, updateEmployee, deleteEmployee) similarly...

    @Override
    public Employee getEmployeeById(int employeeId) throws SQLException{
        Employee employee = null;
        String query = "SELECT employee_name, salary, supervisor_id FROM Employee WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String employeeName = resultSet.getString("employee_name");
                    double salary = resultSet.getDouble("salary");
                    int supervisorId = resultSet.getInt("supervisor_id");
                    employee = new Employee(employeeId, employeeName, salary, supervisorId);
                }
            }
        }
        return employee;
    }

    @Override
    public boolean addEmployee(Employee employee) throws SQLException {
        String query = "INSERT INTO Employee (employee_id, employee_name, salary, supervisor_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employee.getEmployeeId());
            statement.setString(2, employee.getEmployeeName());
            statement.setDouble(3, employee.getSalary());
            statement.setInt(4, employee.getSupervisorId());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
    }
    }
   @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        String query = "UPDATE Employee SET employee_name = ? WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, employee.getEmployeeName());
            statement.setInt(2, employee.getEmployeeId());
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        }
    }

    @Override
    public boolean deleteEmployee(int employeeId) throws SQLException {
        String query = "DELETE FROM Employee WHERE employee_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, employeeId);
            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}

