package com.mycompany.dvdlibrarylou;

import com.mycompany.dvdlibrarylou.controller.Controller;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouAuditDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouAuditDaoImpl;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouDaoImpl;
import com.mycompany.dvdlibrarylou.service.DvdLibraryLouServiceLayer;
import com.mycompany.dvdlibrarylou.service.DvdLibraryLouServiceLayerImpl;
import com.mycompany.dvdlibrarylou.ui.DvdLibraryLouView;
import com.mycompany.dvdlibrarylou.ui.UserIO;
import com.mycompany.dvdlibrarylou.ui.UserIOImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 *
 * @author JCLog
 */
public class App {
    
    public static void main(String[] args){
        /*
     UserIO myIo = new UserIOImpl();
        DvdLibraryLouView myView = new DvdLibraryLouView(myIo);
        DvdLibraryLouDao myDao = new DvdLibraryLouDaoImpl();
        DvdLibraryLouAuditDao myAuditDao = new DvdLibraryLouAuditDaoImpl();
        // Instantiate the Service Layer and wire the DAO and Audit DAO into it
        DvdLibraryLouServiceLayer service = new DvdLibraryLouServiceLayerImpl(myDao, myAuditDao);
        Controller controller
                = new Controller(service, myView);
        controller.run();   
        */
    
        ApplicationContext ctx = 
           new ClassPathXmlApplicationContext("applicationContext.xml");
        Controller controller = 
           ctx.getBean("controller", Controller.class);
        controller.run();
    }
}