/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fa.training.dao;
import java.sql.SQLException;
import fa.training.entities.Customer;
import java.util.List;

public interface CustomerDAO {
    List<Customer> getAllCustomers() throws SQLException;
    boolean addCustomer(Customer customer) throws SQLException;
    boolean updateCustomer(Customer customer) throws SQLException;
    boolean deleteCustomer(int customerId) throws SQLException;
}

