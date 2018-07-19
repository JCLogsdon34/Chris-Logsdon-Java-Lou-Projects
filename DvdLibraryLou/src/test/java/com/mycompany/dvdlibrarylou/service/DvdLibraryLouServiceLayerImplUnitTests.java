package com.mycompany.dvdlibrarylou.service;

import com.mycompany.dvdlibrarylou.dto.Dvd;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author JCLog
 */
public class DvdLibraryLouServiceLayerImplUnitTests {

    private DvdLibraryLouServiceLayer service;

    public DvdLibraryLouServiceLayerImplUnitTests() {
        ApplicationContext ctx = 
        new ClassPathXmlApplicationContext("test-applicationContext.xml");
    service = 
        ctx.getBean("service", DvdLibraryLouServiceLayerImpl.class);
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
    public void testCreateDvdInvalidData()
            throws Exception {
        Dvd testDvd = new Dvd("Carrot Top: The Movie");
        testDvd.setDvdTitle("Carrot: The Movie");
        testDvd.setReleaseDate("12-15-88");
        testDvd.setMpaaRating("R");
        testDvd.setDirectorsName("Hamish Blake");
        testDvd.setStudio("Outback");
        testDvd.setUserNotes("Just no");
        try {
            service.addDvd(testDvd.getDvdTitle(), testDvd);
            fail("Expected DvdLibraryLouDataValidationException was not thrown.");
        } catch (DvdLibraryLouDataValidationException e) {
            return;
        }
    }
    
    @Test
    public void testEditDvd() throws Exception {
        String dvdTitle = "Zorba The Greek";
        Dvd currentDvd = service.getDvd("Zorba The Greek");
        assertNotNull(currentDvd);
        currentDvd.setStudio("Crete, in Greece");
        service.editDvd(dvdTitle, currentDvd);
        service.getDvd(dvdTitle);
        assertEquals(service.getDvd(dvdTitle).getUserNotes(), currentDvd.getUserNotes());
    }

    @Test
    public void testGetDvd() throws Exception {
        Dvd currentDvd = service.getDvd("Zorba The Greek");
        assertNotNull(currentDvd);
        Dvd mine = service.getDvd("9999");
        assertNull(mine);
    }

    @Test
    public void testGetAllDvds() throws Exception {
        assertEquals(1, service.getAllDvds().size());
    }

    @Test
    public void testRemoveDvd() throws Exception {
        Dvd dvd = service.removeDvd("Zorba The Greek");
        assertNotNull(dvd);
        dvd = service.removeDvd("9999");
        assertNull(dvd);
    }
    
    
}
