/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fa.training.dao;
import java.sql.SQLException;
import fa.training.entities.Product;
import java.util.List;

public interface ProductDAO {
    List<Product> getAllProducts() throws SQLException;
    Product getProductById(int productId) throws SQLException;
    boolean addProduct(Product product) throws SQLException;
    boolean updateProduct(Product product) throws SQLException;
    boolean deleteProduct(int productId) throws SQLException;
}

