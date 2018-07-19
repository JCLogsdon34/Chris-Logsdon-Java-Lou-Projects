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
public class Rectangle extends Shape{
    private double length;
    private double width;
    
    Rectangle(double myWidth, double myLength){
        this.length = myLength;
        this.width = myWidth;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
    
    @Override
        public double getArea(){
        double area = 0;
        area = length * width;
        return area;
    }
    
    @Override
    public double getPerimeter(){
        double perimeter = 0;
        perimeter = length + length + width + width;
        return perimeter;
    }
    
}
