/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tsguild.olympians.aspects;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 *
 * @author ahill
 */
public class PersistentLogger {

    private static final String FILE_NAME = "logfile.txt";

    public PersistentLogger() throws IOException {
        PrintWriter logFile = new PrintWriter(new FileWriter(FILE_NAME, true));
        logFile.println("******* NEW LOGGING SESSION *******");
        logFile.flush();
        logFile.close();

    }

    public void logHowLongMethodTakes(ProceedingJoinPoint jp) {
        try {
            String nameOfMethodThatExecuted = jp.getSignature().getName();

            // Start the stop watch
            long startTime = System.currentTimeMillis();
            // Do the method execution
            try {
                jp.proceed(); // tells the target method you are executing 'around' to do it's thing
            } catch (Throwable t) {
                this.writeToFile(nameOfMethodThatExecuted + " just exploded when we were logging the time.");
                return;
            }

            // stop the stop watch
            long stopTime = System.currentTimeMillis();
            this.writeToFile(nameOfMethodThatExecuted + " took this long : " + (stopTime - startTime) + "ms");
            

        } catch (IOException e) {
            System.out.println("Dude. Something went wrong trying to log that method's time.");
        }

    }

    public void logExceptions(JoinPoint methodInfo, Throwable ex) {
        try {
            
            String nameOfMethodThatExecuted = methodInfo.getSignature().getName();
            this.writeToFile(nameOfMethodThatExecuted + " just threw an exception (" + ex.getClass().getSimpleName() + ")");
            this.writeToFile("And these were it's arguments: ");

            Object[] params = methodInfo.getArgs();
            int count = 1;
            for (Object param : params) {
                this.writeToFile(count + ") " + param.getClass().getSimpleName() + ": " + param.toString());
                count++;
            }

        } catch (IOException e) {
            System.out.println("Dude. Tried to log information on an exception but something when wrong writing to file.");
        } catch (Throwable t) {
            System.out.println("Yeah, we tried to log the exception, but uh ... it exploded.");
        }
    }

    private void writeToFile(String logString) throws IOException {
        PrintWriter logFile = new PrintWriter(new FileWriter(FILE_NAME, true));
        logFile.println(logString);
        
        // IF YOU DONT DO THIS SOMETIMES IT DOESNT WRITE ANYTHING
        logFile.flush();
        logFile.close();
    }
}
