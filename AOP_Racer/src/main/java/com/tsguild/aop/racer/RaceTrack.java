/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.aop.racer;

import com.tsguild.aop.racer.interfaces.Driveable;
import com.tsguild.aop.racer.vehicles.*;
import com.tsguild.aop.racer.vehicles.exceptions.VehicleException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author ahill
 */
public class RaceTrack {

    private static final BigDecimal MILES_TO_THE_FINISH = new BigDecimal("100");
    
    public static void main(String[] args) {

        ApplicationContext carFactory = new ClassPathXmlApplicationContext("car-factory.xml");
        Driveable theBall = carFactory.getBean("driveHamster", HamsterBall.class);
        
        Vehicle theBeetle = carFactory.getBean("beatle", JWBeetle.class);
        
        Vehicle theTank = carFactory.getBean("tank", PixelTank.class);
        
        Vehicle thePorshe = carFactory.getBean("porsheGreen", DigitalPorshe.class);
        
        Vehicle theRacer = carFactory.getBean("dragRacer", DragRacer.class);
        
        Vehicle theJunker = carFactory.getBean("theJunker", Vehicle.class);
        

        List<Driveable> theRacers = new ArrayList<>();
        theRacers.add(theBeetle);
        theRacers.add(theTank);
        theRacers.add(thePorshe);
        theRacers.add(theRacer);
        theRacers.add(theJunker);
        theRacers.add(theBall);
        
        System.out.println("WELCOME TO THE RACES!");
        System.out.println("We've got a great selection here today...");
        for (Driveable aRacer : theRacers) {
            
        }
        
        int count = 0;
        while(!hasAWinner(theRacers)){
            System.out.println("ROUND "+ count++);
            reportRacers(theRacers);
            System.out.println("");
            driveRound(theRacers);
            sortInOrder(theRacers);
            System.out.println("");
            System.out.println("");
        }
        
        System.out.println("EGADS! WE HAVE A WINNER!");
        List<Driveable> winners = getAllWinners(theRacers);
        if(winners.size() > 1){
            System.out.println("Several in fact!");
            reportRacers(winners);
        }else{
            System.out.println(winners.get(0).getIdentifier());
        }
        System.out.println("LETS GO AGAIN....!!");

    }

    static void reportRacers(List<Driveable> theRacers) {
        for (int i = 0; i < theRacers.size(); i++) {
            System.out.println( i + ") " + theRacers.get(i).getClass().getSimpleName() + " @ " + theRacers.get(i).readOdometer() + " mi.");
        }
    }
    
    static void sortInOrder(List<Driveable> theRacers) {
        theRacers.sort((Driveable o1, Driveable o2) -> o2.readOdometer().compareTo(o1.readOdometer()));
    }
    
    static void driveRound(List<Driveable> theRacers) {
        List<Driveable> brokenDown = new ArrayList<>();
        for (Driveable aRacer : theRacers) {
            try {
                BigDecimal milesTraveled = aRacer.drive();
                System.out.println(aRacer.getClass().getSimpleName() + " has driven " + milesTraveled + " mi. for a total of " + aRacer.readOdometer());
            } catch (VehicleException ex) {
                System.out.println(aRacer.getClass().getSimpleName() + " is about to drive ...");
                System.out.println(ex.getMessage());
                System.out.println("OH KNOW! It seems like " + aRacer.getIdentifier() + " has had some trouble w/ a " + ex.getClass().getSimpleName() + ".");
                System.out.println("Guess we'll have to remove it from the field.");
                System.out.println("");
                brokenDown.add(aRacer);
            }
        }
        
        if(brokenDown.size() > 0){
            theRacers.removeAll(brokenDown);
        }
    }
    
    static boolean hasAWinner(List<Driveable> theRacers) {
        
        for (Driveable aRacer : theRacers) {
            if(aRacer.readOdometer().compareTo(MILES_TO_THE_FINISH) >= 0){
                return true;
            }
        }
        return false;
    }
    
    static List<Driveable> getAllWinners(List<Driveable> theRacers) {
        List<Driveable> winners = new ArrayList<>();
        for (Driveable aRacer : theRacers) {
            if(aRacer.readOdometer().compareTo(MILES_TO_THE_FINISH) >= 0){
                winners.add(aRacer);
            }
        }
        return winners;
    }

}
