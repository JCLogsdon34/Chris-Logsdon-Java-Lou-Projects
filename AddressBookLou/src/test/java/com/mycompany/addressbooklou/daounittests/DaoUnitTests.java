package com.mycompany.addressbooklou.daounittests;

import com.mycompany.addressbooklou.dao.AddressBookDao;
import com.mycompany.addressbooklou.dao.AddressBookDaoImpl;
import com.mycompany.addressbooklou.dao.AddressBookLouPersistenceException;
import com.mycompany.addressbooklou.dto.Address;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JCLog
 */
public class DaoUnitTests {
    
    AddressBookDao dao = new AddressBookDaoImpl();
    
    public DaoUnitTests() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   @Test
    public void testAddGetAddress() throws AddressBookLouPersistenceException {
        Address address = new Address("Joe");
        address.setFirstName("Joe");
        address.setLastName("Smith");
        address.setStreetAddress("Java-May-2000");

        dao.addAddress(address.getStreetAddress(), address);
        Address fromDao = dao.getAddress(address.getStreetAddress());

        assertEquals(address.getFirstName(), fromDao.getStreetAddress());
    }

  
    @Test
    public void testGetAllAddresses() throws AddressBookLouPersistenceException{
        Address addressOne = new Address("Joe");
        addressOne.setFirstName("Joe");
        addressOne.setLastName("Smith");
        addressOne.setStreetAddress("Java-May-2000");

        dao.addAddress(addressOne.getFirstName(), addressOne);

        Address addressTwo = new Address("John");
        addressTwo.setFirstName("John");
        addressTwo.setLastName("Doe");
        addressTwo.setStreetAddress(".NET-May-2000");

        dao.addAddress(addressTwo.getFirstName(), addressTwo);

        assertEquals(2, dao.getAllAddresses().size());
    }


        @Test
        public void testRemoveAddress() throws Exception {
            Address addressOne = new Address("Joe");
            addressOne.setFirstName("Joe");
            addressOne.setLastName("Smith");
            addressOne.setStreetAddress("Java-May-2000");

            dao.addAddress(addressOne.getFirstName(), addressOne);

            Address addressTwo = new Address("John");
            addressTwo.setFirstName("John");
            addressTwo.setLastName("Doe");
            addressTwo.setStreetAddress(".NET-May-2000");

            dao.addAddress(addressTwo.getFirstName(), addressTwo);

            dao.removeAddress(addressOne.getFirstName());
            assertEquals(1, dao.getAllAddresses().size());
            assertNull(dao.getAddress(addressOne.getFirstName()));
            
            dao.removeAddress(addressTwo.getFirstName());
            assertEquals(0, dao.getAllAddresses().size());
            assertNull(dao.getAddress(addressTwo.getFirstName()));
        }

}
