/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Organization;
import com.sg.superherosightings.dto.SuperHero;
import com.sg.superherosightings.dto.SuperPower;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author JCLog
 */
public class OrganizationTest {

    private SuperHerosDao testDao;
    private JdbcTemplate jdbcTemplate;

    public OrganizationTest() {
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
        
        // jdbcTemplate.execute("DELETE FROM organizations WHERE 1=1");
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
    public void testAddOrganization() {
        List<SuperHero> p = new ArrayList<>();
        Organization o = new Organization();
        Organization orgs = new Organization();

        Location locale = new Location();
        Location location = new Location();

        SuperHero nc = new SuperHero();
        SuperHero hero = new SuperHero();

        SuperPower sample = new SuperPower();
        SuperPower sampleTwo = new SuperPower();

        List<SuperPower> l = new ArrayList<>();
        SuperPower power = new SuperPower();
        power.setName("Fratricide");
        power.setDescription("ability to kill brother");
        sample = testDao.addSuperPower(power);

        SuperPower sP = new SuperPower();
        sP.setName("Pomerium");
        sP.setDescription("boundry setting action");
        sampleTwo = testDao.addSuperPower(sP);

        l.add(power);
        l.add(sP);
        nc.setName("Romulus");
        nc.setDescription("Rome founder");
        nc.setSuperPowers(l);
        hero = testDao.addSuperHero(nc);

        locale.setLocationName("Aventine Hill");
        locale.setAddress("Julian House");
        locale.setLongitude(new BigDecimal("12.2200").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.9900").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);
        
        o.setOrgLocation(location);
        o.setOrgName("Guild of Heros");
        o.setOrgDescription("Monster slayers");
        o.setLocationID(location.getLocationID());

        o.setOrgMembers(p);
        orgs = testDao.addOrganization(o);

        Assert.assertNotNull(orgs);
        Assert.assertEquals(orgs.getOrgName(), "Guild of Heros");
        Assert.assertEquals(orgs.getOrgDescription(), "Monster slayers");
        Assert.assertEquals(orgs.getLocationID(), location.getLocationID());
        Assert.assertEquals(o.getOrgID(), orgs.getOrgID());

    }

    @Test
    public void testDeleteOrganization() {
        List<SuperHero> p = new ArrayList<>();
        Organization o = new Organization();
        Organization orgs = new Organization();
        Organization orgs1 = new Organization();
        o.setOrgName("Guild of Soldiers");
        o.setOrgDescription("Bridge holders");

        SuperHero nc = new SuperHero();
        SuperHero hero = new SuperHero();

        SuperPower sample = new SuperPower();
        SuperPower sampleTwo = new SuperPower();

        Location locale = new Location();
        Location location = new Location();

        locale.setLocationName("Aventine Hill");
        locale.setAddress("Collegia");
        locale.setLongitude(new BigDecimal("12.0110").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0110").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);
        o.setLocationID(location.getLocationID());
        o.setOrgLocation(location);

        List<SuperPower> l = new ArrayList<>();
        SuperPower power = new SuperPower();
        power.setName("Sword fighter");
        power.setDescription("good with blade");
        sample = testDao.addSuperPower(power);

        SuperPower sP = new SuperPower();
        sP.setName("No surrender");
        sP.setDescription("won't give in");
        sampleTwo = testDao.addSuperPower(sP);

        l.add(sample);
        l.add(sampleTwo);
        nc.setName("Lucius Vorrenus");
        nc.setDescription("1st Spear Centurion");
        nc.setSuperPowers(l);
        SuperHero heroTwo = new SuperHero();
        SuperHero heroThree = new SuperHero();
        heroTwo.setName("Titus Pullo");
        heroTwo.setDescription("2nd Spear Centurion");
        heroTwo.setSuperPowers(l);
        hero = testDao.addSuperHero(nc);
        heroThree = testDao.addSuperHero(heroTwo);
        p.add(0, hero);
        p.add(1, heroThree);
        o.setOrgMembers(p);
        /// for some reason it is getting 0 for the id
        /// maybe it is getting the list index
        orgs = testDao.addOrganization(o);
        testDao.addSuperhero_organization(orgs);
        testDao.deleteSuperhero_organization(orgs);
        testDao.deleteOrganization(orgs);
        int orgID = 0;
        orgID = orgs.getOrgID();
        orgs1 = testDao.getOrganizationById(orgID);
        Assert.assertNull(orgs1);
    }

    @Test
    public void testUpdateOrganization() {
        List<SuperHero> p = new ArrayList<>();
        Organization o = new Organization();
        Organization fromDb = new Organization();
        Organization orgs = new Organization();
        Organization org = new Organization();

        Location locale = new Location();
        Location location = new Location();

        SuperHero nc = new SuperHero();
        SuperHero hero = new SuperHero();

        SuperPower sample = new SuperPower();
        SuperPower sampleTwo = new SuperPower();

        List<SuperPower> l = new ArrayList<>();
        SuperPower power = new SuperPower();
        power.setName("Sword fighter");
        power.setDescription("good with blade");
        sample = testDao.addSuperPower(power);

        SuperPower sP = new SuperPower();
        sP.setName("No surrender");
        sP.setDescription("won't give in");
        sampleTwo = testDao.addSuperPower(sP);

        l.add(sample);
        l.add(sampleTwo);
        nc.setName("Cato");
        nc.setDescription("Roman Warrior");
        nc.setSuperPowers(l);
        hero = testDao.addSuperHero(nc);

        locale.setLocationName("Utica");
        locale.setAddress("His fort");
        locale.setLongitude(new BigDecimal("12.0110").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0110").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);
        o.setOrgLocation(location);
        o.setLocationID(location.getLocationID());

        o.setOrgName("Cato and friends");
        o.setOrgDescription("Punic slayers");

        o.setOrgMembers(p);

        org = testDao.addOrganization(o);
        orgs = testDao.getOrganizationById(org.getOrgID());
        org.setOrgName("Cato et amicorum");

        testDao.updateOrganization(org);
        fromDb = testDao.getOrganizationById(org.getOrgID());
        assertEquals(fromDb.getOrgID(), org.getOrgID());
        assertEquals(fromDb.getOrgID(), o.getOrgID());
    }

    @Test
    public void testGetAllOrganizationByHero() {
        

    }

    @Test
    public void testGetAllOrganizations() {

        List<SuperHero> p = new ArrayList<>();
        List<SuperHero> pls = new ArrayList<>();

        List<Organization> hList = new ArrayList<>();
        List<Organization> oList = new ArrayList<>();

        Location locale = new Location();
        Location location = new Location();

        SuperHero nc = new SuperHero();
        SuperHero hero = new SuperHero();

        SuperPower sample = new SuperPower();
        SuperPower sampleTwo = new SuperPower();

        Organization o = new Organization();
        Organization orgs = new Organization();

        List<SuperPower> l = new ArrayList<>();
        SuperPower power = new SuperPower();
        power.setName("Street fighter");
        power.setDescription("handy with the steel");
        sample = testDao.addSuperPower(power);

        l.add(power);
        nc.setName("Titus Annius Milo");
        nc.setDescription("Roman Thug");
        nc.setSuperPowers(l);
        hero = testDao.addSuperHero(nc);

        locale.setLocationName("Suburra");
        locale.setAddress("His Neighborhood");
        locale.setLongitude(new BigDecimal("11.0110").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("17.0110").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);
        o.setOrgLocation(location);
        o.setLocationID(location.getLocationID());
        o.setOrgName("Optimates");
        o.setOrgDescription("Elitist gangsters");

        o.setOrgMembers(p);

        orgs = testDao.addOrganization(o);

        hList = testDao.getAllOrganizations();
        oList = testDao.getAllOrganizations();
        Assert.assertNotNull(hList);
        Assert.assertNotNull(oList);
        Assert.assertEquals(hList.size(), oList.size());
    }

    @Test
    public void testGetMembersOfAnOrg() {
        SuperHero nc = new SuperHero();
        SuperHero hero = new SuperHero();
        SuperPower sample = new SuperPower();
        SuperPower sampleTwo = new SuperPower();
        List<SuperHero> p = new ArrayList<>();
        List<Organization> hList = new ArrayList<>();
        List<SuperHero> pls = new ArrayList<>();
        Organization o = new Organization();
        Organization orgs = new Organization();
        Location locale = new Location();
        Location location = new Location();

        List<SuperPower> l = new ArrayList<>();
        SuperPower power = new SuperPower();
        power.setName("Crafty Fighter");
        power.setDescription("Plays dirty");
        sample = testDao.addSuperPower(power);

        l.add(power);
        nc.setName("Publius Clodius Pulcher");
        nc.setDescription("Roman Thug");
        nc.setSuperPowers(l);
        hero = testDao.addSuperHero(nc);

        locale.setLocationName("Aventine Collegium");
        locale.setAddress("The people's Neighborhood");
        locale.setLongitude(new BigDecimal("11.0110").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("17.0110").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);
        o.setOrgLocation(location);
        o.setLocationID(location.getLocationID());

        o.setOrgName("Populares");
        o.setOrgDescription("non-elite party");

        o.setOrgMembers(p);
        orgs = testDao.addOrganization(o);
        pls = orgs.getOrgMembers();

        Assert.assertNotNull(orgs);
        Assert.assertEquals(orgs.getOrgName(), "Populares");
        Assert.assertEquals(orgs.getOrgDescription(), "non-elite party");
        Assert.assertEquals(o.getOrgID(), orgs.getOrgID());
    }

}
