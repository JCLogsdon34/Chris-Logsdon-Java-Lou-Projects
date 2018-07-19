
package com.mycompany.javaclasses;

/**
 *
 * @author JCLog
 */
public class GPSHouse {
    
    private String streetAddress;
    private float cordinates;
    private String subdivision;
    
    
    public GPSHouse(String streetAddress, float cordinates, String subdivision){
        this.streetAddress = streetAddress;
        this.cordinates = cordinates;
        this.subdivision = subdivision;
    }
    
    public String getStreetAddress(){
        return streetAddress;
    }
    
    public void setStreetAddress(String streetAddress){
        this.streetAddress = streetAddress;
    }
    
    public float getCordinates(){
        return cordinates;
    }
    
    public void setCordinates(float cordinates){
        this.cordinates = cordinates;
    }
    
      public String getSubdivision(){
        return subdivision;
    }
    
    public void setSubdivision(String subdivision){
        this.subdivision = subdivision;
    }
    
}
