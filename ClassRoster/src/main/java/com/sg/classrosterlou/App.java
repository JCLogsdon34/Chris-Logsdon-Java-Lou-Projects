package com.sg.classrosterlou;

import com.sg.classrosterlou.controller.ClassRosterController;
import com.sg.classrosterlou.dao.ClassRosterAuditDao;
import com.sg.classrosterlou.dao.ClassRosterAuditDaoImpl;
import com.sg.classrosterlou.dao.ClassRosterDao;
import com.sg.classrosterlou.dao.ClassRosterDaoFileImpl;
import com.sg.classrosterlou.service.ServiceLayer;
import com.sg.classrosterlou.service.ServiceLayerImpl;
import com.sg.classrosterlou.ui.ClassRosterView;
import com.sg.classrosterlou.ui.UserIO;
import com.sg.classrosterlou.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JCLog
 */
public class App {

    public static void main(String[] args) {
        /*
        UserIO myIo = new UserIOConsoleImpl();
        ClassRosterView myView = new ClassRosterView(myIo);
        ClassRosterDao myDao = new ClassRosterDaoFileImpl();
        ClassRosterAuditDao myAuditDao = new ClassRosterAuditDaoImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        ServiceLayer myService = new ServiceLayerImpl(myDao, myAuditDao);
        ClassRosterController controller = new ClassRosterController(myService, myView);
        controller.run();
         */
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        ClassRosterController controller = 
           ctx.getBean("controller", ClassRosterController.class);
        controller.run();
    }
}
