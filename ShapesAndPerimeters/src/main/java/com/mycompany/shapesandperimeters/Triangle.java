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
public class Triangle extends Shape{
    private double sideOne;
    private double sideTwo;
    private double sideThree;
    private String color = "sky blue";
    Shape myShape = new Shape(color);
    
    
    Triangle(double sideOne, double sideTwo, double sideThree){
        this.sideOne = sideOne;
        this.sideTwo = sideTwo;
        this.sideThree = sideThree;
        this.color = color;
    }

    public double getSideOne() {
        return sideOne;
    }

    public double getSideTwo() {
        return sideTwo;
    }

    public double getSideThree() {
        return sideThree;
    }
    
    @Override
    public double getArea(){
        double area = 0;
        
        return area;
    }
    
    @Override
    public double getPerimeter(){
        double perimeter = 0;
        perimeter = sideOne + sideTwo + sideThree;
        return perimeter;
    }
}
