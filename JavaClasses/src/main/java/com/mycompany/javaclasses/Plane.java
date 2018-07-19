package com.mycompany.javaclasses;

/**
 *
 * @author JCLog
 */
public class Plane {

    private String name;
    private float cordinates;
    private float speed;
    private float altitude;
    private String flightPlan;
    private String planeClass;

    public Plane(String name, float cordinates, float speed, float altitude, String flightPlan, String planeClass) {
    this.name = name;
    this.cordinates = cordinates;
    this.speed = speed;
    this.altitude = altitude;
    this.flightPlan = flightPlan;
    this.planeClass = planeClass;
}

public String getName(){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public float getCordinates(){
        return cordinates;
    }
    
    public void setCordinates(float cordinates){
        this.cordinates = cordinates;
    }
    
    public float getSpeed(){
        return speed;
    }
    
    public void setSpeed(float speed){
        this.speed = speed;
    }
    
    public float getAltitude(){
        return altitude;
    }
    
    public void setAltitude(float altitude){
        this.altitude = altitude;
    }
    
      public String getFlightPlan(){
        return flightPlan;
    }
    
    public void setFlightPlan(String flightPlan){
        this.flightPlan = flightPlan;
    }
    
    public String getPlaneClass(){
        return planeClass;
    }
    
    public void setPlaneClass(String planeClass){
        this.planeClass = planeClass;
    }
    
}
