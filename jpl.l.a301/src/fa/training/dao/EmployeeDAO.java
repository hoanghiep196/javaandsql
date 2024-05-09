/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fa.training.dao;
import java.sql.SQLException;
import fa.training.entities.Employee;
import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployees() throws SQLException;
    Employee getEmployeeById(int employeeId) throws SQLException;
    boolean addEmployee(Employee employee) throws SQLException;
    boolean updateEmployee(Employee employee) throws SQLException;
    boolean deleteEmployee(int employeeId) throws SQLException;
}

