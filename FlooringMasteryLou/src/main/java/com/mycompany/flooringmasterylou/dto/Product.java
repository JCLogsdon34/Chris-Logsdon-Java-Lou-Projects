package com.mycompany.flooringmasterylou.dto;

import java.math.BigDecimal;

/**
 *
 * @author JCLog
 */
public class Product {

    private String productType;
    private BigDecimal costPerSqFt;
    private BigDecimal laborCostPerSqFt;
    
    public String getProductType(){
        return productType;
    }
    
    public void setProductType(String productType){
        this.productType = productType;
    }

    public BigDecimal getCostPerSqFt() {
        return costPerSqFt;
    }

    public void setCostPerSqFt(BigDecimal costPerSqFt) {
        this.costPerSqFt = costPerSqFt;
    }

    public BigDecimal getLaborCostPerSqFt() {
        return laborCostPerSqFt;
    }

    public void setLaborCostPerSqFt(BigDecimal laborCostPerSqFt) {
        this.laborCostPerSqFt = laborCostPerSqFt;
    }

    @Override
    public String toString() {
        return "|Cost Per Sq Ft: " + costPerSqFt + " |LaborCostPerSqFt: " + laborCostPerSqFt;
    }
}
