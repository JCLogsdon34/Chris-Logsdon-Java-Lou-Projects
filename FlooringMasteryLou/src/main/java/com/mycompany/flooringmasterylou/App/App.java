package com.mycompany.flooringmasterylou.App;

import com.mycompany.flooringmasterylou.controller.Controller;
import com.mycompany.flooringmasterylou.dao.FlooringPersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author JCLog
 */
public class App {

    public static void main(String[] args) throws FlooringPersistenceException {
        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller;
               

        Scanner scanner;
        String mode = "";
        String m = "";
        String modeChoice = "";
        String MODES_FILE = "Config//configMode.txt";
        try {

            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(MODES_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringPersistenceException("-_- Could not load modes.", e);
        }
        while (scanner.hasNext()) {
            mode = scanner.nextLine();
        }

        modeChoice = mode.replace("mode = ", "");

        if (modeChoice.equalsIgnoreCase("production")) {
            controller = ctx.getBean("controller", Controller.class);
        } else if (modeChoice.equalsIgnoreCase("training")) {
            controller = ctx.getBean("controllerTraining", Controller.class);
        } else {
            System.out.println("Could not read mode");
            return;
        }
        scanner.close();
        controller.run();
    }
}
