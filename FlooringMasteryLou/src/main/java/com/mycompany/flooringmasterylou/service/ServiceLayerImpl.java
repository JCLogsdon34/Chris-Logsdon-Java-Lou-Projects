package com.mycompany.flooringmasterylou.service;

import com.mycompany.flooringmasterylou.dao.DaoOrder;
import com.mycompany.flooringmasterylou.dao.DaoProduct;
import com.mycompany.flooringmasterylou.dao.DaoTax;
import com.mycompany.flooringmasterylou.dao.FlooringBadDateException;
import com.mycompany.flooringmasterylou.dao.FlooringPersistenceException;
import com.mycompany.flooringmasterylou.dto.Order;
import com.mycompany.flooringmasterylou.dto.Product;
import com.mycompany.flooringmasterylou.dto.Tax;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 *
 * @author JCLog
 */
public class ServiceLayerImpl implements ServiceLayer {

    private DaoTax tax;
    private DaoProduct product;
    private DaoOrder dao;

    public ServiceLayerImpl(DaoOrder dao, DaoTax tax, DaoProduct product) {
        this.tax = tax;
        this.product = product;
        this.dao = dao;
    }

    @Override
    public Order createOrder(String orderDate, Order order) throws FlooringDataValidationException, FlooringBadDateException {
        validateOrderData(order);
        return dao.createOrder(orderDate, order);
    }

    @Override
    public List<Order> getAllOrdersByDate(String orderDate) throws FlooringBadDateException {
        return dao.getAllOrdersByDate(orderDate);
    }

    @Override
    public Order getOrder(String orderDate, String orderNumber) throws FlooringDataValidationException, FlooringPersistenceException, FlooringBadDateException {
        return dao.getOrder(orderDate, orderNumber);
    }

    @Override
    public void editOrder(String orderName, String orderNumber, Order order) throws FlooringDataValidationException, FlooringBadDateException {
        validateOrderData(order);
        dao.editOrder(orderName, orderNumber, order);
    }

    @Override
    public Order removeOrder(String orderDate, String orderNumber) throws FlooringBadDateException {
        return dao.removeOrder(orderDate, orderNumber);
    }

    @Override
    public Order computeProductCosts(Order order) throws FlooringDataValidationException, FlooringTaxException, FlooringProductException {
        validateOrderData(order);
        validateTax(order);
        validateProduct(order);
        Tax currentTax = new Tax();
        Product currentProduct = new Product();
        String state = order.getTax().getState();
        currentTax = tax.getTax(state);
        order.getTax().setTaxRate(currentTax.getTaxRate());
        String productType = order.getProduct().getProductType();
        currentProduct = product.getProduct(productType);
        order.getProduct().setCostPerSqFt(currentProduct.getCostPerSqFt());
        order.getProduct().setLaborCostPerSqFt(currentProduct.getLaborCostPerSqFt());

        BigDecimal costPerSqFt = order.getProduct().getCostPerSqFt();
        BigDecimal laborPerSqFt = order.getProduct().getLaborCostPerSqFt();
        BigDecimal taxRate = order.getTax().getTaxRate();
        BigDecimal area = order.getArea();

        BigDecimal material = costPerSqFt.multiply(area).setScale(2, RoundingMode.HALF_UP);
        BigDecimal labor = laborPerSqFt.multiply(area).setScale(2, RoundingMode.HALF_UP);
        BigDecimal mL = labor.add(material).setScale(2, RoundingMode.HALF_UP);
        BigDecimal realTax = taxRate.multiply(mL).setScale(2, RoundingMode.HALF_UP);
        BigDecimal total = mL.add(realTax).setScale(2, RoundingMode.HALF_UP);

        order.setLaborCost(labor);
        order.setMaterialCost(material);
        order.setTaxAmount(realTax);
        order.setTotal(total);
        return order;
    }

    @Override
    public List<Tax> getAllTax() {

        return tax.getAllTax();
    }

    @Override
    public List<Product> getAllProduct() {
        return product.getAllProduct();
    }

    @Override
    public Tax getTax(String state) {
        return tax.getTax(state);
    }

    @Override
    public Product getProduct(String productType) {
        return product.getProduct(productType);
    }

    @Override
    public void loadAllOrders() throws FlooringPersistenceException {
        dao.loadAllOrders();
    }

    @Override
    public void writeOrder() throws FlooringPersistenceException, FlooringBadDateException {
        dao.writeOrder();
    }

    @Override
    public void loadTax() throws FlooringPersistenceException {
        tax.loadTax();
    }

    @Override
    public void loadProduct() throws FlooringPersistenceException {
        product.loadProduct();
    }

    private void validateTax(Order order) throws FlooringTaxException {
        Set<String> taxInfo;
        boolean taxMan = true;
        Tax taxes = new Tax();
        String state = "";
        int i = 0;
        String otherState = "";
        taxInfo = tax.getStates();
        state = order.getTax().getState();
        Iterator iter = taxInfo.iterator();
        while (iter.hasNext()) {
            if (taxInfo.contains(state)) {
                break;
            } else {
                throw new FlooringTaxException(
                        "ERROR: You must enter a valid state postal abbrieviation.");
            }
        }
    }

    private void validateProduct(Order order) throws FlooringProductException {
        Set<String> productInfo = product.getAllTypes();
        String p = "";
        p = order.getProduct().getProductType();
        Iterator iter = productInfo.iterator();
        while (iter.hasNext()) {
            if (productInfo.contains(p)) {
                break;
            } else {
                throw new FlooringProductException(
                        "ERROR: You must enter a valid product type.");
            }
        }
    }

    private void validateOrderData(Order order) throws FlooringDataValidationException {
        if (order == null
                || order.getOrderDate() == null
                || order.getOrderDate().trim().length() == 0
                || order.getOrderDate().trim().length() > 8
                || order.getOrderName() == null
                || order.getOrderName().trim().length() == 0) {
            throw new FlooringDataValidationException(
                    "ERROR: Valid Order Date, Order Name, Product Type, State, and area amount required to place an order.");
        }

    }
}