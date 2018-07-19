package com.mycompany.flooringmasterylou.dao;

import com.mycompany.flooringmasterylou.dto.Order;
import com.mycompany.flooringmasterylou.dto.Product;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JCLog
 */
public class DaoProductImplTest {

    private DaoProduct products;

    public DaoProductImplTest() {
        products = new DaoProductImpl();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetAllProducts() throws FlooringPersistenceException {
         products.loadProduct();
        assertEquals(4, products.getAllProduct().size());
    }

    @Test
    public void testGetProductCost() throws FlooringPersistenceException {
        products.loadProduct();
        String material = "Wood";
        Order currentOrder = new Order("");
        currentOrder.getProduct().setProductType(material);
        Product product = new Product();
        product.setProductType(material);
        BigDecimal costPer = products.getProduct(material).getCostPerSqFt().setScale(2, RoundingMode.HALF_UP);
        product.setCostPerSqFt(costPer);
        currentOrder.getProduct().setCostPerSqFt(costPer);
        BigDecimal costPerS = new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP);
        assertEquals(costPerS, currentOrder.getProduct().getCostPerSqFt());
        assertEquals(product.getCostPerSqFt(), currentOrder.getProduct().getCostPerSqFt());
    }

    @Test
    public void testGetProductLaborCost() throws FlooringPersistenceException {
        products.loadProduct();
        String productType = "Wood";
        BigDecimal laborCostPer = products.getProduct(productType).getLaborCostPerSqFt();
        Order currentOrder = new Order("");
        currentOrder.getProduct().setLaborCostPerSqFt(laborCostPer);
        BigDecimal costPerS = new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP);
        assertEquals(costPerS, currentOrder.getProduct().getLaborCostPerSqFt());
    }

    @Test
    public void testTypes() throws FlooringPersistenceException {
        products.loadProduct();
        String expectedResults = "Wood";
        String productType = "";
        List<Product> product = products.getAllProduct();
        for (Product p : product) {
            if (p.getProductType().equalsIgnoreCase(expectedResults)) {
                productType = p.getProductType();
                assertEquals(expectedResults, productType);
            }
        }
    }
}
