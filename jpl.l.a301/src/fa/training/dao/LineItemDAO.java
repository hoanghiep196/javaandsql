/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package fa.training.dao;

import fa.training.entities.LineItem;
import java.sql.SQLException;
import java.util.List;

public interface LineItemDAO {
    List<LineItem> getAllLineItemsByOrderId(int orderId) throws SQLException;
    boolean addLineItem(LineItem lineItem) throws SQLException;
    boolean updateLineItem(LineItem lineItem) throws SQLException;
    boolean deleteLineItem(int orderId, int productId) throws SQLException;
}

