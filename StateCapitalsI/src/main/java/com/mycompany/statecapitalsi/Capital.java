/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitalsi;

/**
 *
 * @author JCLog
 */
public class Capital {
    private String name;
    private int pop;
    private int area;
    
    Capital(String name, int pop, int area){
    this.name = name;
    this.pop = pop;
    this.area = area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
    
    
    
}
