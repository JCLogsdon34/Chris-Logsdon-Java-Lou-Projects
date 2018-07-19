package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Order;
import java.util.List;
/**
 *
 * @author JCLog
 */
public interface DaoOrder {
    
    Order createOrder(String orderDate, Order order)throws FlooringBadDateException;

    Order getOrder(String orderDate, String orderNumber) throws FlooringPersistenceException, FlooringBadDateException;

    Order removeOrder(String orderDate, String orderNumber)throws FlooringBadDateException;

    List<Order> getAllOrdersByDate(String orderDate)throws FlooringBadDateException;

    void editOrder(String orderDate, String orderNumber, Order order)throws FlooringBadDateException;

    void loadAllOrders() throws FlooringPersistenceException;

    void writeOrder() throws FlooringPersistenceException, FlooringBadDateException;
}
