package com.sg.superherosightings.dao;

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
public class SightingTest {

    private SuperHerosDao testDao;
    private JdbcTemplate jdbcTemplate;

    public SightingTest() {

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
        // jdbcTemplate.execute("DELETE FROM Sightings WHERE 1=1");
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
    public void testaddSighting() {
        Sighting sighting = new Sighting();

        Location locale = new Location();
        Location location = new Location();
        locale.setAddress("Street of the bakers");
        locale.setLocationName("Oplontis");
        locale.setLongitude(new BigDecimal("12.0011").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0089").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Lyre Playing");
        s.setDescription("Hypnotzes with music");
        s = testDao.addSuperPower(s);
        SuperPower sP = new SuperPower();
        sP.setName("Singing");
        sP.setDescription("Sings about new things");
        sP = testDao.addSuperPower(sP);
        p.add(s);
        p.add(sP);
        SuperHero hero = new SuperHero();
        hero.setName("Orpheus");
        hero.setDescription("Lrue playing hero");
        hero.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);

        Organization org = new Organization();
        Organization orgs = new Organization();

        org.setOrgLocation(location);
        org.setOrgName("Guild of Heros");
        org.setOrgDescription("Monster slayers");
        org.setLocationID(location.getLocationID());

        List<SuperHero> heros = new ArrayList<>();
        List<SuperHero> heroSighting = new ArrayList<>();
        heroSighting.add(addedHero);
        heros.add(addedHero);
        org.setOrgMembers(heros);
        orgs = testDao.addOrganization(org);

        Sighting sightingB = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String stringDate = "01-02-2017";
    //    LocalDate parsedDate = LocalDate.parse(stringDate, formatters);
        sighting.setDate(stringDate);

        sightingB = testDao.addSighting(sighting);

// We wanted to make sure tha
        Assert.assertNotNull(sighting);
        Assert.assertNotNull(sightingB);
        Assert.assertEquals(sighting.getLocationID(), sightingB.getLocationID());
        Assert.assertEquals(sighting.getSightingID(), sightingB.getSightingID());
    }

    @Test
    public void testDeleteSighting() {
        Sighting sighting = new Sighting();

        Location locale = new Location();
        Location location = new Location();
        locale.setAddress("Street of the butchers");
        locale.setLocationName("Baiae");
        locale.setLongitude(new BigDecimal("12.0021").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0111").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Touch");
        s.setDescription("Turns thigns to gold");
        s = testDao.addSuperPower(s);

        p.add(s);
        SuperHero hero = new SuperHero();
        hero.setName("Midas");
        hero.setDescription("Gold having guy");
        hero.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);

        Organization org = new Organization();
        Organization orgs = new Organization();

        org.setOrgLocation(location);
        org.setOrgName("Golden Girls");
        org.setOrgDescription("Monster slayers");
        org.setLocationID(location.getLocationID());

        List<SuperHero> heros = new ArrayList<>();
        List<SuperHero> heroSighting = new ArrayList<>();
        heroSighting.add(addedHero);
        heros.add(addedHero);
        org.setOrgMembers(heros);
        orgs = testDao.addOrganization(org);

        Sighting sightingB = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String stringDate = "01-02-2017";
  //      LocalDate parsedDate = LocalDate.parse(stringDate, formatters);
        sighting.setDate(stringDate);

        sightingB = testDao.addSighting(sighting);
        testDao.deleteSighting(sightingB);

        Sighting deletedSightingTwo = new Sighting();
        deletedSightingTwo = testDao.getSightingsByID(sightingB.getSightingID());
        Assert.assertNull(deletedSightingTwo);
    }

    @Test
    public void testUpdateSighting() {
        Sighting sighting = new Sighting();

        Location locale = new Location();
        Location location = new Location();
        locale.setAddress("Street of the butchers");
        locale.setLocationName("Baiae");
        locale.setLongitude(new BigDecimal("12.0021").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0111").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Touch");
        s.setDescription("Turns thigns to gold");
        s = testDao.addSuperPower(s);

        p.add(s);
        SuperHero hero = new SuperHero();
        hero.setName("Midas");
        hero.setDescription("Gold having guy");
        hero.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);

        Organization org = new Organization();
        Organization orgs = new Organization();

        org.setOrgLocation(location);
        org.setOrgName("Golden Girls");
        org.setOrgDescription("Monster slayers");
        org.setLocationID(location.getLocationID());

        List<SuperHero> heros = new ArrayList<>();
        List<SuperHero> heroSighting = new ArrayList<>();
        heroSighting.add(addedHero);
        heros.add(addedHero);
        org.setOrgMembers(heros);
        orgs = testDao.addOrganization(org);

        Sighting sightingB = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String stringDate = "01-02-2017";
        String stringDateTwo = "01-03-2017";
      //  LocalDate parsedDate = LocalDate.parse(stringDate, formatters);
        sighting.setDate(stringDate);

        sightingB = testDao.addSighting(sighting);
        sightingB.setDate(stringDateTwo);
        testDao.updateSighting(sightingB);
        Sighting fromDb = new Sighting();
        fromDb = testDao.getSightingsByID(sightingB.getSightingID());

        Assert.assertNotNull(sighting);
        Assert.assertNotNull(sightingB);
        Assert.assertNotNull(fromDb);
        assertEquals(fromDb.getSightingID(), sightingB.getSightingID());
        assertEquals(fromDb.getLocationID(), sightingB.getLocationID());
    }

    @Test
    public void testGetSightingByID() {
        Sighting sighting = new Sighting();

        Location locale = new Location();
        Location location = new Location();
        locale.setAddress("The Palace");
        locale.setLocationName("Ithaca");
        locale.setLongitude(new BigDecimal("12.0021").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0111").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Wisdom");
        s.setDescription("Wise about stuff");
        s = testDao.addSuperPower(s);

        p.add(s);
        SuperHero hero = new SuperHero();
        hero.setName("Cautious");
        hero.setDescription("Does not rush in");
        hero.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);

        Organization org = new Organization();
        Organization orgs = new Organization();

        org.setOrgLocation(location);
        org.setOrgName("Ithaca Crew");
        org.setOrgDescription("Travellers");
        org.setLocationID(location.getLocationID());

        List<SuperHero> heros = new ArrayList<>();
        List<SuperHero> heroSighting = new ArrayList<>();
        heroSighting.add(addedHero);
        heros.add(addedHero);
        org.setOrgMembers(heros);
        orgs = testDao.addOrganization(org);

        Sighting sightingB = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String stringDate = "01-02-2017";
        String stringDateTwo = "01-03-2017";
   //     LocalDate parsedDate = LocalDate.parse(stringDate, formatters);
        sighting.setDate(stringDate);
        sighting.setHeroList(heros);
        sightingB = testDao.addSighting(sighting);
        sightingB.setHeroList(heros);
        sightingB.setDate(stringDateTwo);
        
        testDao.updateSighting(sightingB);
        Sighting fromDb = new Sighting();


        fromDb = testDao.getSightingsByID(sightingB.getSightingID());
        List<SuperHero> h = new ArrayList();
        SuperHero heroL = new SuperHero();
        int q = 0;
        q = sightingB.getSightingID();
        h = testDao.getHerosForASighting(q);
       // h.add(heroL);
        
        Assert.assertNotNull(sighting);
        Assert.assertNotNull(sightingB);
        Assert.assertNotNull(fromDb);
        assertEquals(fromDb.getSightingID(), sightingB.getSightingID());
        assertEquals(fromDb.getLocationID(), sightingB.getLocationID());
        assertEquals(fromDb.getDate().hashCode(), sightingB.getDate().hashCode());
    }

    @Test
    public void testGetSightingsBySuperHeroId() {

    }

    @Test
    public void testGetSightingsByLocationId() {

    }

    @Test
    public void testGetAllSightings() {
        Sighting sighting = new Sighting();

        Location locale = new Location();
        Location location = new Location();
        locale.setAddress("The Palace");
        locale.setLocationName("Ithaca");
        locale.setLongitude(new BigDecimal("12.0021").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.0111").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Wisdom");
        s.setDescription("Wise about stuff");
        s = testDao.addSuperPower(s);

        p.add(s);
        SuperHero hero = new SuperHero();
        hero.setName("Odysseus");
        hero.setDescription("Wise hero");
        hero.setSuperPowers(p);
        
        SuperHero heroTwo = new SuperHero();
        heroTwo.setName("Eurybates");
        heroTwo.setDescription("Side-kick Wise hero");
        heroTwo.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);
        
        SuperHero addedHeroTwo = new SuperHero();
        addedHeroTwo = testDao.addSuperHero(heroTwo);

        Organization org = new Organization();
        Organization orgs = new Organization();

        org.setOrgLocation(location);
        org.setOrgName("Ithaca Crew");
        org.setOrgDescription("Travellers");
        org.setLocationID(location.getLocationID());

        List<SuperHero> heros = new ArrayList<>();
        List<SuperHero> heroSighting = new ArrayList<>();
        heroSighting.add(addedHero);
        heros.add(addedHero);
        heroSighting.add(addedHeroTwo);
        heros.add(addedHeroTwo);
        org.setOrgMembers(heros);
        orgs = testDao.addOrganization(org);

        Sighting sightingB = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String stringDate = "01-02-2017";
//        LocalDate parsedDate = LocalDate.parse(stringDate, formatters);
        sighting.setDate(stringDate);

        sightingB = testDao.addSighting(sighting);
        Sighting fromDb = new Sighting();


        fromDb = testDao.getSightingsByID(sightingB.getSightingID());
        
        List<Sighting> sightingList = new ArrayList<>();
        List<Sighting> allSightings = new ArrayList<>();

        sightingList = testDao.getAllSightings();
        allSightings = testDao.getAllSightings();
        
        Assert.assertNotNull(sighting);
        Assert.assertNotNull(sightingList);
        Assert.assertNotNull(allSightings);
        Assert.assertEquals(sightingList.get(0).getDate().hashCode(), allSightings.get(0).getDate().hashCode());
        Assert.assertEquals(sightingList.get(0).getSightingID(), allSightings.get(0).getSightingID());
        Assert.assertEquals(sightingList.get(0).getLocationID(), allSightings.get(0).getLocationID());
        Assert.assertEquals(sightingList.size(), allSightings.size());
    }

    @Test
    public void testGetSightingsByDate() {
        Sighting sighting = new Sighting();

        Location locale = new Location();
        Location location = new Location();
        locale.setAddress("Top of the hill");
        locale.setLocationName("Mt. Pelion");
        locale.setLongitude(new BigDecimal("12.1421").setScale(2, RoundingMode.HALF_UP));
        locale.setLatitude(new BigDecimal("19.4111").setScale(2, RoundingMode.HALF_UP));
        location = testDao.addLocation(locale);

        List<SuperPower> p = new ArrayList<>();
        SuperPower s = new SuperPower();
        s.setName("Witty");
        s.setDescription("They got jokes lol");
        s = testDao.addSuperPower(s);

        p.add(s);
        SuperHero hero = new SuperHero();
        hero.setName("Charon");
        hero.setDescription("Smart horse guy");
        hero.setSuperPowers(p);
        
        SuperHero heroTwo = new SuperHero();
        heroTwo.setName("Bojack Horseman");
        heroTwo.setDescription("90s actor");
        heroTwo.setSuperPowers(p);

        SuperHero addedHero = new SuperHero();
        addedHero = testDao.addSuperHero(hero);
        
        SuperHero addedHeroTwo = new SuperHero();
        addedHeroTwo = testDao.addSuperHero(heroTwo);

        Organization org = new Organization();
        Organization orgs = new Organization();

        org.setOrgLocation(location);
        org.setOrgName("Centaurs");
        org.setOrgDescription("Horse people");
        org.setLocationID(location.getLocationID());

        List<SuperHero> heros = new ArrayList<>();
        List<SuperHero> heroSighting = new ArrayList<>();
        heroSighting.add(addedHero);
        heros.add(addedHeroTwo);
        heros.add(heroTwo);
        org.setOrgMembers(heros);
        orgs = testDao.addOrganization(org);

        Sighting sightingB = new Sighting();
        sighting.setLocationID(location.getLocationID());
        sighting.setLocation(location);

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("YYYY-MM-dd");
        String stringDate = "2018-03-12";
    //    LocalDate parsedDate = LocalDate.parse(stringDate, formatters);
        sighting.setDate(stringDate);

        sightingB = testDao.addSighting(sighting);
        Sighting fromDb = new Sighting();
        List<Sighting> sightings = new ArrayList<>();
        List<Sighting> moreSightings = new ArrayList<>();
        
        sightings = testDao.getSightingsByDate(stringDate);
        moreSightings = testDao.getSightingsByDate(stringDate);
        
        Assert.assertNotNull(sighting);
        Assert.assertNotNull(sightingB);
        Assert.assertNotNull(sightings);
        Assert.assertNotNull(moreSightings);
        Assert.assertEquals(sightings.get(0).getDate().hashCode(), moreSightings.get(0).getDate().hashCode());
        Assert.assertEquals(sightings.get(0).getSightingID(), moreSightings.get(0).getSightingID());
        Assert.assertEquals(sightings.get(0).getLocationID(), moreSightings.get(0).getLocationID());
        Assert.assertEquals(sightings.size(), moreSightings.size());
    }

}
