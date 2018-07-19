package com.mycompany.addressbooklou;

import com.mycompany.addressbooklou.controller.Controller;
import com.mycompany.addressbooklou.dao.AddressBookDao;
import com.mycompany.addressbooklou.dao.AddressBookDaoImpl;
import com.mycompany.addressbooklou.ui.AddressBookView;
import com.mycompany.addressbooklou.ui.UserIO;
import com.mycompany.addressbooklou.ui.UserIOConsoleImpl;

/**
 *
 * @author JCLog
 */
public class App {

    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoImpl();
        Controller controller
                = new Controller(myDao, myView);
        controller.run();
    }
}
