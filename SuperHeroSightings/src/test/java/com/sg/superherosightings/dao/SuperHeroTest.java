package com.sg.superherosightings.dao;

import com.sg.superherosightings.dao.SuperHerosDao;
import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Organization;
import com.sg.superherosightings.dto.Sighting;
import com.sg.superherosightings.dto.SuperHero;
import com.sg.superherosightings.dto.SuperPower;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class SuperHeroTest {

    private SuperHerosDao testDao;
    private JdbcTemplate jdbcTemplate;

    public SuperHeroTest() {
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
        /*
        jdbcTemplate.execute("UPDATE SuperHeros SET superHerosID = null WHERE 1=1");
        jdbcTemplate.execute("UPDATE SuperPowers SET superPowersID = null WHERE 1=1");
        jdbcTemplate.execute("UPDATE Organizations SET orgID = null WHERE 1=1");
        jdbcTemplate.execute("UPDATE Locations SET locationID = null WHERE 1=1");
        jdbcTemplate.execute("DELETE FROM Sightings WHERE 1=1");
         */
        // jdbcTemplate.execute("DELETE FROM SuperHeros WHERE 1=1");
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
    public void testaddSuperHero() {

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Hassock Powers");
        s.setDescription("Relaxes People");
        s = testDao.addSuperPower(s);
        SuperPower sP = new SuperPower();
        sP.setName("Decor Complements");
        sP.setDescription("Ties room together");
        sP = testDao.addSuperPower(sP);
        p.add(s);
        p.add(sP);
        SuperHero hero = new SuperHero();
        hero.setName("Fred");
        hero.setDescription("Super Hassock");
        hero.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);

        Assert.assertNotNull(addedHero);
        Assert.assertEquals(addedHero.getName(), hero.getName());
        Assert.assertEquals(addedHero.getDescription(), hero.getDescription());
        Assert.assertEquals(addedHero.getSuperPowers(), hero.getSuperPowers());
        Assert.assertEquals(hero.getSuperHeroID(), addedHero.getSuperHeroID());
    }

    @Test
    public void testDeleteSuperHero() {
        SuperHero hero = new SuperHero();
        SuperHero addedHero = new SuperHero();
        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        SuperPower sP = new SuperPower();
        s.setName("Bowie Powers");
        s.setDescription("Strung out in heavens high");
        sP = testDao.addSuperPower(s);
        p.add(sP);

        hero.setName("David Bowie");
        hero.setDescription("Star Man");
        hero.setSuperPowers(p);

        addedHero = testDao.addSuperHero(hero);

        testDao.deleteSuperHero(addedHero.getSuperHeroID());
        SuperHero deletedHero = new SuperHero();
        deletedHero = testDao.getSuperHeroById(addedHero.getSuperHeroID());
        Assert.assertNull(deletedHero);
    }

    @Test
    public void testUpdateSuperHero() {
        SuperHero nc = new SuperHero();
        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Fratricide");
        s.setDescription("ability to kill brother");
        SuperPower sP = new SuperPower();
        sP.setName("Pomerium");
        sP.setDescription("boundry setting action");
        p.add(s);
        p.add(sP);
        nc.setName("Romulus");
        nc.setDescription("Rome founder");
        SuperHero fromDb = new SuperHero();
        fromDb = testDao.addSuperHero(nc);
        fromDb.setName("Quirinus");
        testDao.updateSuperHero(fromDb);
        
        int superHeroID = 0;
        superHeroID = fromDb.getSuperHeroID();
        String expectedResult = "Quirinus";

        assertEquals(testDao.getSuperHeroById(superHeroID).getName(), expectedResult);
    }

    @Test
    public void testGetSuperHeroByID() {
        SuperHero hero = new SuperHero();
        SuperHero nc = new SuperHero();
        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        SuperPower sOne = new SuperPower();
        SuperPower sTwo = new SuperPower();
        s.setName("Fratricide");
        s.setDescription("ability to kill brother");
        sOne = testDao.addSuperPower(s);
        SuperPower sP = new SuperPower();
        sP.setName("Pomerium");
        sP.setDescription("boundry setting action");
        sTwo = testDao.addSuperPower(sP);
        p.add(sOne);
        p.add(sTwo);

        nc.setName("Romulus");
        nc.setDescription("Rome founder");
        nc.setSuperPowers(p);
        hero = testDao.addSuperHero(nc);

        Assert.assertNotNull(hero);
        Assert.assertEquals(hero.getName(), nc.getName());
        Assert.assertEquals(hero.getDescription(), nc.getDescription());
        Assert.assertEquals(hero.getSuperPowers().lastIndexOf(s.getDescription()), nc.getSuperPowers().lastIndexOf(s.getDescription()));
        Assert.assertEquals(hero.getSuperPowers().lastIndexOf(sP.getDescription()), nc.getSuperPowers().lastIndexOf(sP.getDescription()));
        Assert.assertEquals(hero.getSuperHeroID(), nc.getSuperHeroID());

    }

    @Test
    public void testGetAllSuperHeros() {
        SuperHero nc = new SuperHero();
        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        SuperPower sOne = new SuperPower();

        s.setName("Horatian tactics");
        s.setDescription("runs and fights");
        sOne = testDao.addSuperPower(s);
        p.add(s);
        
        nc.setName("Horatius");
        nc.setDescription("Horatii Hero");
        nc.setSuperPowers(p);
        testDao.addSuperHero(nc);

        SuperHero sH2 = new SuperHero();
        List<SuperPower> j = new ArrayList<>();
        SuperPower f = new SuperPower();
        f.setName("augury");
        f.setDescription("ability to read bird signs");
        SuperPower sP1 = new SuperPower();
        j.add(f);
        sP1 = testDao.addSuperPower(f);
        sH2.setName("Remus");
        sH2.setDescription("Rome co-founder");
        sH2.setSuperPowers(j);
        testDao.addSuperHero(sH2);
        List<SuperHero> hList = new ArrayList<>();
        List<SuperHero> sList = new ArrayList<>();
        hList = testDao.getAllSuperHeros();
        sList = testDao.getAllSuperHeros();
        Assert.assertNotNull(sList);
        Assert.assertNotNull(hList);
        Assert.assertEquals(hList.size(), sList.size());      
    }

}
