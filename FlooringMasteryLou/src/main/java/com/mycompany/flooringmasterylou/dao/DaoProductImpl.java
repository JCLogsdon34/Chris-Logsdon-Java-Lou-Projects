package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Product;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class DaoProductImpl implements DaoProduct {

    private final Map<String, Product> products = new HashMap<>();

    @Override
    public Product createProduct(String productType) {
        Product currentProduct =  new Product();

        products.put(productType, currentProduct);
        return currentProduct;
    }

    @Override
    public Product editProduct(String productType, Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product removeProduct(String productType, Product product) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getProduct(String productType) {
        return products.get(productType);
    }
    
    @Override
    public Set<String> getAllTypes(){
        Set<String> p = products.keySet();
        return p;
    }

    @Override
    public List<Product> getAllProduct() {
        return new ArrayList<Product>(products.values());
    }

    public static final String PRODUCT_FILE = "Data\\Products.txt";
    public static final String DELIMITER = ",";

    @Override
    public void loadProduct() throws FlooringPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(PRODUCT_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException(
                    "-_- Could not load Product data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Product currentProduct = new Product();
            currentProduct.setProductType(currentTokens[0]);
            currentProduct.setCostPerSqFt(new BigDecimal(currentTokens[1]).setScale(2, RoundingMode.HALF_UP));
            currentProduct.setLaborCostPerSqFt(new BigDecimal(currentTokens[2]).setScale(2, RoundingMode.HALF_UP));
            products.put(currentProduct.getProductType(), currentProduct);
        }
        scanner.close();
    }
}