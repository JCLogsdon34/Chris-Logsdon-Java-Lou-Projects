package com.mycompany.shapesandperimeters;
/**
 *
 * @author JCLog
 */
public abstract class Shape {
    
    private String color;
    
    Shape(String color){
        this.color = color;
    }
    
    public abstract double getArea();
    
    public abstract double getPerimeter();
}
