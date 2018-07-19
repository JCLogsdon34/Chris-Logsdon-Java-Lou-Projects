package com.mycompany.shapesandperimeters;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */
public class Sandbox {

    public static void main(String[] args) {
        double ex = 10;
        Shape myShape = new Shape();
        Square mySquare = new Square(ex);
        Triangle myTriangle = new Triangle(ex, ex, ex);
        Rectangle myRectangle = new Rectangle(ex, ex);
        Circle myCircle = new Circle(ex);
        
        double areaSquare = 0;
        double perimeterSquare = 0;
        areaSquare = mySquare.getArea();
        perimeterSquare = mySquare.getPerimeter();
        double areaRectangle = 0;
        double perimeterRectangle = 0;
        areaRectangle = myRectangle.getArea();
        perimeterRectangle = myRectangle.getPerimeter();
        double areaCircle = 0;
        double perimeterCircle = 0;
        areaCircle = myCircle.getArea();
        perimeterCircle = myCircle.getPerimeter();
        double areaTriangle = 0;
        double perimeterTriangle = 0;
        areaTriangle = myTriangle.getArea();
        perimeterTriangle = myTriangle.getPerimeter();
        
        
        Scanner inputReader = new Scanner(System.in);
        System.out.println("Square area is : " + areaSquare);
        System.out.println("Square perimeter is : " + perimeterSquare);
        System.out.println(mySquare.color);
        
        System.out.println("Rectangle area is : " + areaRectangle);
        System.out.println("Rectangle perimeter is :" + perimeterRectangle);
        System.out.println(myRectangle.color);
        
        System.out.println("Circle area is : " + areaCircle);
        System.out.println("Circle perimeter is :" + perimeterCircle);
        System.out.println(myCircle.color);
        
        System.out.println("Triangle area is : " + areaTriangle);
        System.out.println("Triangle perimeter is :" + perimeterTriangle);
        System.out.println(myTriangle.color);
        
    }
    
}
