package com.mycompany.flooringmasterylou.service;

import com.mycompany.flooringmasterylou.dao.FlooringPersistenceException;
import com.mycompany.flooringmasterylou.dto.Order;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JCLog
 */
public class ServiceLayerTest {


    private ServiceLayer service;

    public ServiceLayerTest() {

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        service
                = ctx.getBean("service", ServiceLayerImpl.class);

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
    public void testGetOrder() throws Exception {
        service.loadAllOrders();
        String orderDate = "02182018";
        String orderNumber = "2";
        Order currentOrder = service.getOrder(orderDate, orderNumber);
        assertNotNull(service.getOrder(orderDate, orderNumber));
        assertEquals(Integer.parseInt(orderNumber), Integer.parseInt(currentOrder.getOrderNumber()));
    }

    @Test
    public void testGetAllOrdersByDate() throws Exception {
        service.loadAllOrders();
        String orderDate = "02182018";
        assertEquals(1, service.getAllOrdersByDate(orderDate).size());
    }

    @Test
    public void testGetOrderInvalidData() throws Exception {
        service.loadAllOrders();
        String orderNumber = "2";
        String orderDate = "06/012013";
        Order onlyOrder = new Order(orderNumber);
        onlyOrder.setOrderDate(orderDate);
        onlyOrder.setOrderName("Logsdon");
        onlyOrder.getTax().setState("KY");
        onlyOrder.getTax().setTaxRate(new BigDecimal("6.25").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.getProduct().setProductType("Wood");
        onlyOrder.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.getProduct().setCostPerSqFt(new BigDecimal("5.15").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.getProduct().setLaborCostPerSqFt(new BigDecimal("4.75").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setMaterialCost(new BigDecimal("515.00").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setLaborCost(new BigDecimal("475.00").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setTaxAmount(new BigDecimal("61.88").setScale(2, RoundingMode.HALF_UP));
        onlyOrder.setTotal(new BigDecimal("1051.00").setScale(2, RoundingMode.HALF_UP));

        try {
            service.createOrder(orderDate, onlyOrder);
            fail("Expected FlooringDataValidationException was not thrown.");
        } catch (FlooringDataValidationException e) {
            Assert.assertTrue("Correct exception occurred", true);
        } catch (NumberFormatException e) {
            Assert.assertFalse("Wrong exception occurred", false);
        }
    }

    @Test
    public void testRemoveOrder()
            throws Exception {
            service.loadAllOrders();
        String orderDate = "02182018";
        String orderNumber = "2";
        Order currentOrder = service.removeOrder(orderDate, orderNumber);
        assertEquals(currentOrder.getOrderNumber(), orderNumber);
    }

    @Test
    public void testEditOrder()
            throws Exception {
        service.loadAllOrders();
        String orderDate = "02182018";
        String expectedResult = "Logsdon";
        String orderNumber = "2";
        Order currentOrder = new Order(orderNumber);
        currentOrder = service.getOrder(orderDate, orderNumber);
        assertNotNull(currentOrder);
        currentOrder.setOrderName("Logsdon");
        service.editOrder(orderDate, orderNumber, currentOrder);
        assertEquals(service.getOrder(orderDate, orderNumber).getOrderName(), expectedResult);
    }

    @Test
    public void testBadTax() throws FlooringPersistenceException, FlooringTaxException, FlooringProductException, FlooringDataValidationException {
        service.loadTax();
        Order order = new Order("");
        order.setOrderDate("02252018");
        order.setOrderName("Tiro");
        order.getTax().setState("ME");
        order.getProduct().setProductType("Wood");
        order.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));

        try {
            service.computeProductCosts(order);
            fail("Expected FlooringBadDateException was not thrown.");
        } catch (FlooringTaxException e) {
            Assert.assertTrue("Correct exception occurred", true);
        } catch (NumberFormatException e) {
            Assert.assertFalse("Wrong exception occurred", false);
        }
    }

    @Test
    public void testBadProduct() throws FlooringPersistenceException, FlooringTaxException, FlooringProductException, FlooringDataValidationException {
        service.loadProduct();
        Order order = new Order("");
        order.setOrderDate("02252018");
        order.setOrderName("Tiro");
        order.getTax().setState("KY");
        order.getProduct().setProductType("Marble");
        order.setArea(new BigDecimal("100.00").setScale(2, RoundingMode.HALF_UP));

        try {
            service.computeProductCosts(order);
            fail("Expected FlooringProductException was not thrown.");
        } catch (FlooringProductException e) {
            Assert.assertTrue("Correct exception occurred", true);
        } catch (NumberFormatException e) {
            Assert.assertFalse("Wrong exception occurred", false);
        }
    }
}
