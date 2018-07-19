package com.mycompany.shapesandperimeters;
/**
 *
 * @author JCLog
 */
public class Circle extends Shape{
    private double radius;
    
    Circle(double radius){
        this.radius = radius;
    }
    
    @Override
        public double getArea(){
        double area = 0;
        area = 3.14 * (radius * radius);
        return area;
    }
    
    @Override
    public double getPerimeter(){
        double perimeter = 0;
        perimeter = 2 * 3.14 * radius;
        return perimeter;
    }
    
    
}
