package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Product;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public interface DaoProduct {
    
    Set<String> getAllTypes();
    
    Product createProduct(String productType);
    
    Product editProduct(String productType, Product product);
    
    Product removeProduct(String productType, Product product);
    
    Product getProduct(String productType);
    
    List<Product> getAllProduct();
    
    void loadProduct()throws
            FlooringPersistenceException;
}
