/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class DaoProductStubImpl implements DaoProduct {

    private Product onlyProduct;
    private List<Product> productList = new ArrayList<>();

    public DaoProductStubImpl() {
        onlyProduct.setProductType("Wood");
        onlyProduct.setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        onlyProduct.setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        productList.add(onlyProduct);
    }

    @Override
    public Product createProduct(String productType) {
        if (productType.equalsIgnoreCase(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product editProduct(String productType, Product product) {
        // does nothing
        return product;
    }

    @Override
    public Product removeProduct(String productType, Product product) {
        if (productType.equalsIgnoreCase(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public Product getProduct(String productType) {
        if (productType.equalsIgnoreCase(onlyProduct.getProductType())) {
            return onlyProduct;
        } else {
            return null;
        }
    }

    @Override
    public List<Product> getAllProduct() {
        return productList;
    }

    @Override
    public void loadProduct() throws FlooringPersistenceException {
        // do nothing
    }

    @Override
    public Set<String> getAllTypes() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
