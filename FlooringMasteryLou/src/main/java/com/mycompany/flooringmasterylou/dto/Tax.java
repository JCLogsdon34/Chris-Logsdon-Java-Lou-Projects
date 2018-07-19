package com.mycompany.flooringmasterylou.dto;

import java.math.BigDecimal;

/**
 *
 * @author JCLog
 */
public class Tax {
    
    private String state;
    private BigDecimal taxRate;
    
    public String getState(){
        return state;
    }
    
    public void setState(String state){
        this.state = state;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }
   
    @Override
    public String toString() {
        return "|State: " + state + "|Tax Rate: " + taxRate;
    }
    
}
