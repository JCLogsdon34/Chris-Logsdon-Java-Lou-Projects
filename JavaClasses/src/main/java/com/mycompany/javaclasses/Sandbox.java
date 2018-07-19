
package com.mycompany.javaclasses;

/**
 *
 * @author JCLog
 */
public class Sandbox {
    public static void main(String[] args){
    String streetAddress = "1060 West Addison";
    float cordinates = 12f;
    String subdivision = "Oxford, Mississippi";
    
        GPSHouse burningDownDaHouse = new GPSHouse(streetAddress, cordinates, subdivision);
        System.out.println(burningDownDaHouse.getStreetAddress() + " ," + burningDownDaHouse.getCordinates() + " ," + burningDownDaHouse.getSubdivision());
        
    
    
    String name = "Soul Plane";
    float cordinatess = 54f;
    float speed = 500f;
    float altitude = 1000f;
    String flightPlan = "Always fresh and clean";
    String planeClass = "Stankovia";
    
    Plane daPlane = new Plane(name, cordinatess, speed, altitude, flightPlan,  planeClass);
    System.out.println(daPlane.getName() + " ," + daPlane.getCordinates() + " ," + daPlane.getSpeed()
          +  " ," + daPlane.getAltitude() + " ," + daPlane.getFlightPlan() + " ," + daPlane.getPlaneClass());
    }
}
