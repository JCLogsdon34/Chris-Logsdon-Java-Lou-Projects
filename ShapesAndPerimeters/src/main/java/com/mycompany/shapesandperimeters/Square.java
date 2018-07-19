/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.shapesandperimeters;

/**
 *
 * @author JCLog
 */
public class Square extends Shape{
 //   Shape myShape = new Shape();
    private double side;
    
    Square(double side){
        this.side = side;
    }

    public double getSide() {
        return side;
    }
    
    @Override
       public double getArea(){
        double area = 0;
        area = side * side;
        return area;
    }
    
    @Override
    public double getPerimeter(){
        double perimeter = 0;
        perimeter = side + side + side + side;
        return perimeter;
    }
    
}
