package com.mycompany.flooringmasterylou.dto;

import java.math.BigDecimal;

/**
 *
 * @author JCLog
 */
public class Order {

    private String orderDate;
    private String orderNumber;
    private String orderName;
    private Tax tax = new Tax();
    private Product product = new Product();
    private BigDecimal area;
 //   private String state;
   // private String productType;
    private BigDecimal materialCost;
    private BigDecimal laborCost;
    private BigDecimal taxAmount;
    private BigDecimal total;

    public Order(String orderNumber) {
        this.orderNumber = orderNumber;
        this.tax = new Tax();
        this.product = new Product();
    }
    
    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product){
        this.product = product;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }

    /*
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
*/
    
    public BigDecimal getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(BigDecimal materialCost) {
        this.materialCost = materialCost;
    }

    public BigDecimal getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(BigDecimal laborCost) {
        this.laborCost = laborCost;
    }

    public BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(BigDecimal taxAmount) {
        this.taxAmount = taxAmount;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Order Date: " + orderDate + " |Order Name: " + orderName
                + " |Order Number: " + orderNumber + "|Area: " + area +  "|Material Cost: "
                + materialCost + "|Labor Cost: " + laborCost + "|Tax Amount: "
                + taxAmount + " |Total: " + total;
        //"|State: "
             //   + /state + "|Product Type: " + productType +
    }
}
