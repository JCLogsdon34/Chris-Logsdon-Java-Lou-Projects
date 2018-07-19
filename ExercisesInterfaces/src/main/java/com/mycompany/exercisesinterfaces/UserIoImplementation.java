package com.mycompany.exercisesinterfaces;

import java.util.Scanner;

/**
 *
 * @author JCLog
 */

public class UserIoImplementation implements UserIO {
    
     Scanner userInput = new Scanner(System.in);

    @Override
    public void print(String message) {
        System.out.println(message);
    }

    @Override
    public double readDouble(String prompt) {
        String userDoubleString = "";
        double myDouble  = 0;
        userDoubleString = readString(prompt); 
        myDouble = Double.parseDouble(userDoubleString);
        return myDouble;
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        String userDoubleString = "";
        double myDouble  = 0;
        System.out.println(prompt + " " + min + " " + max);
        myDouble = userInput.nextDouble();
        return myDouble;
    }
    
    @Override
    public float readFloat(String prompt) {
       String userFloatString = "";
        float myFloat  = 0;
        userFloatString = readString(prompt); 
        myFloat = Float.parseFloat(userFloatString);
        return myFloat;
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        String userFloatString = "";
        float myFloat  = 0;
        userFloatString = readString(prompt); 
        System.out.println(prompt + " " + min + " " + max);
        myFloat = userInput.nextFloat();
        return myFloat;}

    @Override
    public int readInt(String prompt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public long readLong(String prompt) {
        String userLongString = "";
        float myLong  = 0;
        userLongString = readString(prompt); 
        myLong = Float.parseFloat(userLongString);
        return myFloat;
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String readString(String prompt) {
        String userWritten = "";
       
        do{
        System.out.println(prompt);
        userWritten  = userInput.nextLine();
        }while(userWritten.isEmpty());
        return userWritten;
    }
    
}
