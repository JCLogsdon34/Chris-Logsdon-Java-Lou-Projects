package com.mycompany.takingcalcsgetresults;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author JCLog
 */


public class Calculator {
    enum MathOperator {
    PLUS, MINUS, MULTIPLY, DIVIDE
}

    public BigDecimal useStuff(String mathOp, String opOne, String opTwo) {

        BigDecimal operand1 = new BigDecimal(opOne);
        BigDecimal operand2 = new BigDecimal(opTwo);
        int operator = 0;

        if(mathOp.equals("Add")){
            operator = 1;
        } else if (mathOp.equals("Subtract")){
            operator = 2;
        } else if (mathOp.equals("Multiply")){
            operator = 3;
        } else if (mathOp.equals("Divide")){
            operator = 4;
        } else {
            throw new UnsupportedOperationException();
        }
      
        switch (operator){
            case 1:
                return operand1.add(operand2);
            case 2:
                return operand1.subtract(operand2);
            case 3:
                return operand1.multiply(operand2);
            case 4:
                return operand1.divide(operand2, RoundingMode.HALF_UP);
            default:
                throw new UnsupportedOperationException();
        }
    }
}
