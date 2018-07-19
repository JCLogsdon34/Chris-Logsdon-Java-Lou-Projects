package com.mycompany.dvdlibrarylou.dao;

import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouPersistenceException;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouDaoImpl;
import com.mycompany.dvdlibrarylou.dto.Dvd;
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
public class DvdLibraryLouDaoFileImplTest {
                        
    DvdLibraryLouDao dao = new DvdLibraryLouDaoImpl();

    public DvdLibraryLouDaoFileImplTest() {

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
    public void testAddDvd() throws DvdLibraryLouPersistenceException {
        String dvdTitle = "";
        dvdTitle = "Croc Dundee";
        Dvd testDvd = new Dvd(dvdTitle);
        testDvd.setDvdTitle(dvdTitle);
        testDvd.setReleaseDate("12-15-88");
        testDvd.setMpaaRating("R");
        testDvd.setDirectorsName("Hamish Blake");
        testDvd.setStudio("Outback");
        testDvd.setUserNotes("Bonza mate");

        dao.addDvd(testDvd.getDvdTitle(), testDvd);
        assertEquals(dao.getDvd(testDvd.getDvdTitle()).getDvdTitle(), testDvd.getDvdTitle());
    }

    @Test
    public void testGetAllDvds() throws DvdLibraryLouPersistenceException {
        Dvd testDvd = new Dvd("A Time To Kill");
        testDvd.setDvdTitle("A Time To Kill");
        testDvd.setReleaseDate("12-15-88");
        testDvd.setMpaaRating("R");
        testDvd.setDirectorsName("Martin Scorcesse");
        testDvd.setStudio("Paramount");
        testDvd.setUserNotes("Intense, great book too");

        dao.addDvd(testDvd.getDvdTitle(), testDvd);

        Dvd testTwo = new Dvd("Strawberry Fields");
        testTwo.setDvdTitle("Strawberry Fields");
        testTwo.setReleaseDate("04-24-2009");
        testTwo.setMpaaRating("R");
        testTwo.setDirectorsName("Hamish Blake");
        testTwo.setStudio("Outback");
        testTwo.setUserNotes("Bonza mate");

        dao.addDvd(testTwo.getDvdTitle(), testTwo);

        assertEquals(dao.getAllDvds().size(), dao.getAllDvds().size());
    }

    @Test
    public void testRemoveStudent() throws DvdLibraryLouPersistenceException {
        Dvd testDvd = new Dvd("A Time To Kill");
        testDvd.setDvdTitle("A Time To Kill");
        testDvd.setReleaseDate("12-15-88");
        testDvd.setMpaaRating("R");
        testDvd.setDirectorsName("Martin Scorcesse");
        testDvd.setStudio("Paramount");
        testDvd.setUserNotes("Intense, great book too");

        dao.addDvd(testDvd.getDvdTitle(), testDvd);

        Dvd testTwo = new Dvd("Strawberry Fields");
        testTwo.setDvdTitle("Strawberry Fields");
        testTwo.setReleaseDate("04-24-2009");
        testTwo.setMpaaRating("R");
        testTwo.setDirectorsName("Hamish Blake");
        testTwo.setStudio("Outback");
        testTwo.setUserNotes("Bonza mate");

        dao.addDvd(testTwo.getDvdTitle(), testTwo);

        dao.removeDvd(testDvd.getDvdTitle());
        assertNull(dao.getDvd(testDvd.getDvdTitle()));

        dao.removeDvd(testTwo.getDvdTitle());
        assertNull(dao.getDvd(testTwo.getDvdTitle()));

    }
}
