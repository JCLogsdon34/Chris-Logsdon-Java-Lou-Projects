/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.Location;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author JCLog
 */
public class LocationTest {

    private SuperHerosDao testDao;
    private JdbcTemplate jdbcTemplate;

    public LocationTest() {
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");

        jdbcTemplate = factory.getBean(JdbcTemplate.class);
        testDao = new SuperHerosDaoJdbcTemplateImpl(jdbcTemplate);

        // We have to empty the database for our tests.
        // Since we have a couple of nullable, foreign keys
        // it's easier to just set them to null and THEN delete
        // the other records. Otherwise, you would have to delete them in reverse order
        // of their entry.
        // Also, you could just use your dao delete methods, but that
        // will require that they work! This way, you bypass the dao
        // and manipulate the database directly.     
        
        
        /// delete the locationID from other tables first
        jdbcTemplate.execute("DELETE FROM superhero_organization WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM organizations WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM sightings WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM locations WHERE 1=1");
   
    }

    @Test // if you don't annotate, it will not test
    public void testDaoConnectionDoesntExplode() {
        // Really stupid simple test.
        // It's just checking if it can connect to the dao at all, and if it explodes.
        ApplicationContext factory
                = new ClassPathXmlApplicationContext("test-applicationContext.xml");
        Assert.assertNotNull(jdbcTemplate);
        testDao = new SuperHerosDaoJdbcTemplateImpl(jdbcTemplate);
    }

    @Test
    public void testaddLocation() {
        Location locale = new Location();
        Location addedLocation = new Location();

        locale.setLocationName("Tarentum");
        locale.setAddress("Street of the Butchers");
        locale.setLongitude(new BigDecimal("12.00").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.00").setScale(2, RoundingMode.HALF_UP));

        addedLocation = testDao.addLocation(locale);

        Assert.assertNotNull(addedLocation);
        Assert.assertTrue(addedLocation.getLocationID() > 0);
        Assert.assertEquals(addedLocation.getLocationName(), "Tarentum");
        Assert.assertEquals(addedLocation.getAddress(), "Street of the Butchers");
        Assert.assertEquals(locale, addedLocation);
    }

    @Test
    public void testDeleteLocation() {
        Location locale = new Location();
        Location addedLocation = new Location();
        Location deletedLocation = new Location();

        locale.setLocationName("Pompeii");
        locale.setAddress("House of Sulla");
        locale.setLongitude(new BigDecimal("12.0011").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0022").setScale(2, RoundingMode.HALF_UP));
   
        addedLocation = testDao.addLocation(locale);

        testDao.deleteLocation(addedLocation.getLocationID());
        deletedLocation = testDao.getLocationByID(addedLocation.getLocationID());
        Assert.assertNull(deletedLocation);
    }

    @Test
    public void testUpdateLocation() {

        Location locale = new Location();
        Location addedLocation = new Location();
        Location fromDb = new Location();
        Location fromDatab = new Location();
        
        locale.setLocationName("Aventine Hill");
        locale.setAddress("Julian House");
        locale.setLongitude(new BigDecimal("12.0033").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0033").setScale(2, RoundingMode.HALF_UP));

        addedLocation = testDao.addLocation(locale);
        fromDb = testDao.getLocationByID(locale.getLocationID());
        
        fromDb.setLocationName("Subura");
        testDao.updateLocation(fromDb);
        fromDatab = testDao.getLocationByID(fromDb.getLocationID());
        Assert.assertNotNull(fromDatab);
        assertEquals(fromDb.getLocationID(), addedLocation.getLocationID());
    }

    @Test
    public void testGetLocationByID() {
        Location locale = new Location();
        Location fromDb = new Location();
        Location addedLocation = new Location();

         locale.setLocationName("Caelian Hill");
        locale.setAddress("Street of the millers");
        locale.setLongitude(new BigDecimal("12.0022").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0033").setScale(2, RoundingMode.HALF_UP));

        addedLocation = testDao.addLocation(locale);
        fromDb = testDao.getLocationByID(addedLocation.getLocationID());
        assertEquals(fromDb, addedLocation);
        
    }

    @Test
    public void testGetAllLocations() {
        Location locale = new Location();
        List<Location> myL = new ArrayList<>();
        List<Location> localeList = new ArrayList<>();
        List<Location> locationList = new ArrayList<>();
        List<Location> locationL = new ArrayList<>();

       
        
        locale.setAddress("Street of the bakers");
        locale.setLocationName("Mutina");
        locale.setLongitude(new BigDecimal("12.0011").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0089").setScale(2, RoundingMode.HALF_UP));
        testDao.addLocation(locale);
        
        locationList = testDao.getAllLocations();
        localeList = testDao.getAllLocations();
        Assert.assertEquals(localeList.size(), locationList.size());
        
        Location locale2 = new Location();
        locale2.setAddress("Street of the millers");
        locale2.setLocationName("Caelian Hill");
        locale2.setLongitude(new BigDecimal("14.2200").setScale(2, RoundingMode.HALF_UP));
        locale2.setLatitude(new BigDecimal("17.1100").setScale(2, RoundingMode.HALF_UP));
        testDao.addLocation(locale2);
        
        myL = testDao.getAllLocations();
        locationL = testDao.getAllLocations();
        assertEquals(myL.size(), locationL.size());

    }

    @Test
    public void testGetAllLocationsByHero() {
        
    }
}