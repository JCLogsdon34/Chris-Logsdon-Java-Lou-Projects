/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.SuperPower;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
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
public class SuperPowerTest {

    private SuperHerosDao testDao;
    private JdbcTemplate jdbcTemplate;

    public SuperPowerTest() {
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
    
//        jdbcTemplate.execute("UPDATE SuperHeros SET superHerosID = null WHERE 1=1");
  //      jdbcTemplate.execute("UPDATE SuperPowers SET super_power_id = null WHERE 1=1");
    //    jdbcTemplate.execute("UPDATE Organizations SET orgID = null WHERE 1=1");
      //  jdbcTemplate.execute("UPDATE Locations SET locationID = null WHERE 1=1");
      //  jdbcTemplate.execute("DELETE FROM Sightings WHERE 1=1");
        

        jdbcTemplate.execute("DELETE FROM SUPERHERO_SUPERPOWER WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM Superpowers WHERE 1=1");
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
    public void testAddSuperPower() {
         List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Augery");
        s.setDescription("Tells the future");
        SuperPower sP = new SuperPower();
        
        sP.setName("Decor Complements");
        sP.setDescription("Ties room together");
        p.add(s);
        p.add(sP);
        
        sP = testDao.addSuperPower(s);
        Assert.assertNotNull(sP); 
        Assert.assertEquals(sP.getName(), "Augery");
        Assert.assertEquals(sP.getDescription(), "Tells the future");
        Assert.assertEquals(s, sP);
    }
    
    @Test
    public void testDeleteSuperPower() {
        SuperPower newSuperPower = new SuperPower();
        SuperPower returnedSuperPower = new SuperPower();
        int id = 0;
        newSuperPower.setName("Boiotian Sorcery");
        newSuperPower.setDescription("Magic from Greece");
        returnedSuperPower = testDao.addSuperPower(newSuperPower);
        testDao.deleteSuperPower(returnedSuperPower.getSuperPowerID());
        id = returnedSuperPower.getSuperPowerID();
        Assert.assertNull(testDao.getSuperPowerByID(id));
    }
    

    @Test
    public void testUpdateSuperPower() {
        SuperPower s = new SuperPower();
        SuperPower fromDb = new SuperPower();
        s.setName("regicide");
        s.setDescription("ability to kill a tyrant");       
        testDao.addSuperPower(s);
        s.setName("tyrannicide");
        testDao.updateSuperPower(s);
        fromDb = testDao.getSuperPowerByID(s.getSuperPowerID());
        assertEquals(fromDb, s);
    }

    @Test
    public void testGetSuperPowerByID() {
        SuperPower sP = new SuperPower();
        SuperPower s = new SuperPower();
        SuperPower sPP = new SuperPower();
        sP.setName("Nilotic Magic");
        sP.setDescription("makes enemy a mummy");

        
        sPP = testDao.addSuperPower(sP);
        s = testDao.getSuperPowerByID(sPP.getSuperPowerID());
        Assert.assertNotNull(sPP);
        Assert.assertEquals(sPP.getSuperPowerID(), s.getSuperPowerID());
        Assert.assertEquals(sPP.getName(), "Nilotic Magic");
        Assert.assertEquals(sPP.getDescription(), "makes enemy a mummy");
        Assert.assertEquals(sP, sPP);
    }

    @Test
    public void testGetAllSuperPowers() {
        SuperPower s = new SuperPower();
        SuperPower sP = new SuperPower();
        SuperPower sPP = new SuperPower();
        sP.setName("Haruspicy");
        sP.setDescription("Reads entrails to predict future");

        s.setName("Marsian Snake Charming");
        s.setDescription("Makes snakes nearby blow up");
        sPP.setName("Invocatio");
        sPP.setDescription("convinces gods to abandon enemy");
        testDao.addSuperPower(sP);
        testDao.addSuperPower(s);
        testDao.addSuperPower(sPP);
        List<SuperPower> hList = new ArrayList<>();
        List<SuperPower> oList = new ArrayList<>();
        hList = testDao.getAllSuperPowers();
        oList = testDao.getAllSuperPowers();
        Assert.assertNotNull(hList);
        Assert.assertNotNull(oList);
        Assert.assertEquals(hList.size(), oList.size());   
    }
}