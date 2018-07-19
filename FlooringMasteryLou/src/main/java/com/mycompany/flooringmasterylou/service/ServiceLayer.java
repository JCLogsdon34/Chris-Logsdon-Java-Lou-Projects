package com.mycompany.flooringmasterylou.service;

import com.mycompany.flooringmasterylou.dao.FlooringBadDateException;
import com.mycompany.flooringmasterylou.dao.FlooringPersistenceException;
import com.mycompany.flooringmasterylou.dto.Order;
import com.mycompany.flooringmasterylou.dto.Product;
import com.mycompany.flooringmasterylou.dto.Tax;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface ServiceLayer {

    List<Tax> getAllTax();

    List<Product> getAllProduct();

    Order createOrder(String orderDate, Order order) 
            throws FlooringDataValidationException, FlooringBadDateException;

    List<Order> getAllOrdersByDate(String orderDate) throws FlooringBadDateException;
    
    Order computeProductCosts(Order order)
                throws FlooringDataValidationException, 
            FlooringTaxException, FlooringProductException;

    Order getOrder(String orderDate, String orderNumber)
            throws FlooringDataValidationException,
            FlooringPersistenceException, FlooringBadDateException;

    void editOrder(String orderDate, String orderNumber, Order order)
            throws FlooringDataValidationException, FlooringBadDateException;

    Order removeOrder(String orderDate, String orderNumber)
            throws FlooringDataValidationException, FlooringBadDateException;

    Tax getTax(String state);

    Product getProduct(String productType);
    
    void loadAllOrders()
            throws FlooringPersistenceException;

    void writeOrder()
            throws FlooringPersistenceException, FlooringBadDateException;

    void loadTax()
            throws FlooringPersistenceException;
    
    void loadProduct()
            throws FlooringPersistenceException;
}
