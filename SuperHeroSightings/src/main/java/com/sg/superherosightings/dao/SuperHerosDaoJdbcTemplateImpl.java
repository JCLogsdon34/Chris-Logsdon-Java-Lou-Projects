package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Organization;
import com.sg.superherosightings.dto.Sighting;
import com.sg.superherosightings.dto.SuperHero;
import com.sg.superherosightings.dto.SuperPower;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author JCLog
 */
public class SuperHerosDaoJdbcTemplateImpl implements SuperHerosDao {

    private JdbcTemplate jdbcTemplate;

    @Inject
    public SuperHerosDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    /////////////////////////// Heros /////////////////////////////
    private static final String SQL_INSERT_HEROS
            = "insert into heros (name, description)"
            + "values (?, ?)";

    private static final String SQL_DELETE_HEROS
            = "DELETE from heros "
            + "WHERE superHeroID = ? ";

    private static final String SQL_UPDATE_HERO
            = "update heros set name = ?, description = ? "
            + "WHERE superHeroID = ? ";

    /// maybe two prepared statements to insert hero, then power,
    private static final String SQL_SELECT_HEROS
            = "SELECT * from heros where superHeroID = ?";

    private static final String SQL_SELECT_SUPERHERO_SUPERPOWER
            = "SELECT * "
            + "FROM SUPERHERO_SUPERPOWER sp "
            + "inner join heros h on sp.superHeroID = h.superHeroID "
            + "left join superpowers p on sp.superPowerID = p.superPowerID "
            //   + "order by superHeroID "
            + "WHERE h.superHeroID = ?";

    private static final String SQL_SELECT_ALL_HEROS
            = "SELECT * from heros";

    private static final String SQL_INSERT_SUPERHERO_SUPERPOWER
            = "insert into superhero_superpower (superHeroID, superPowerID)"
            + " values (?, ?)";

    private static final String SQL_UPDATE_SUPERHERO_SUPERPOWER
            = "update superhero_superpower set superPowerID = ? "
            + "WHERE superHeroID = ?";

    private static final String SQL_DELETE_SUPERHERO_SUPERPOWER
            = "DELETE from superhero_superpower "
            + "WHERE superHeroID = ?";

    private static final String SQL_DELETE_SUPERHERO_SIGHTING
            = "DELETE from superhero_has_sighting "
            + "WHERE superHeroID = ?";

    private static final String SQL_DELETE_SUPERHEROID_SUPERHERO_ORGANIZATION
            = "DELETE from superhero_organization "
            + "WHERE superHeroID = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SuperHero addSuperHero(SuperHero superhero) {
        List<SuperPower> powerList = new ArrayList<>();
        //    SuperPower power = new SuperPower();
        jdbcTemplate.update(SQL_INSERT_HEROS,
                superhero.getName(),
                superhero.getDescription());

        int superHeroID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        superhero.setSuperHeroID(superHeroID);

        powerList = superhero.getSuperPowers();
        //     int i = 0;
        // i = powerList.size();
        //   i = i - 1;
        for (SuperPower power : powerList) {
            //   power = powerList.get(i);
            // i--;
            jdbcTemplate.update(SQL_INSERT_SUPERHERO_SUPERPOWER,
                    superhero.getSuperHeroID(),
                    power.getSuperPowerID());
        }
        return superhero;
    }

    @Override
    public void deleteSuperHero(int superHeroID) {
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_SUPERPOWER, superHeroID);
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_ORGANIZATION, superHeroID);
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_HAS_SIGHTING, superHeroID);
        jdbcTemplate.update(SQL_DELETE_HEROS, superHeroID);
    }

    @Override
    public SuperHero getSuperHeroById(int superHeroID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_HEROS,
                    new SuperHeroMapper(),
                    superHeroID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperHero> getAllSuperHeros() {
        return jdbcTemplate.query(SQL_SELECT_ALL_HEROS,
                new SuperHeroMapper());
    }

    @Override
    public void updateSuperHero(SuperHero hero) {
        List<SuperPower> powerList = new ArrayList<>();
        SuperPower power = new SuperPower();
        jdbcTemplate.update(SQL_UPDATE_HERO,
                hero.getName(),
                hero.getDescription(),
                hero.getSuperHeroID());
        powerList = hero.getSuperPowers();
        int i = 0;
        i = powerList.size();
        i = i - 1;
        while (i > -1) {
            power = powerList.get(i);
            i--;
            jdbcTemplate.update(SQL_UPDATE_SUPERHERO_SUPERPOWER,
                    hero.getSuperHeroID(),
                    power.getSuperPowerID());
        }
    }

    @Override
    public List<SuperPower> findSuperPowersForSuperHero(int superHeroID) {
        List<SuperPower> superPowers = new ArrayList<>();
        List<Integer> ids = new ArrayList<>();
        SuperPower superPower = new SuperPower();
        try {
            return jdbcTemplate.query(SQL_SELECT_SUPERHERO_SUPERPOWER,
                    new SuperPowerMapper(),
                    superHeroID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    private static final class SuperHeroMapper implements RowMapper<SuperHero> {

        @Override
        public SuperHero mapRow(ResultSet rs, int i) throws SQLException {
            SuperHero sup = new SuperHero();
            sup.setSuperHeroID(rs.getInt("superHeroID"));
            sup.setName(rs.getString("name"));
            sup.setDescription(rs.getString("description"));

            return sup;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    //////// Super Powers ?//////////////////////////////////////////////////
    private static final String SQL_INSERT_SUPERPOWERS
            = "INSERT into superpowers (name, description) "
            + "values (?, ?)";
    private static final String SQL_DELETE_SUPERPOWERS
            = "DELETE FROM superpowers WHERE superPowerID = ? ";
    private static final String SQL_UPDATE_SUPERPOWERS
            = "UPDATE superpowers SET name = ?, description = ? "
            + "WHERE superPowerID  =  ?";
    private static final String SQL_SELECT_SUPERPOWER_BY_ID
            = "SELECT * FROM superpowers WHERE superPowerID = ? ";
    private static final String SQL_SELECT_ALL_SUPERPOWERS
            = "SELECT * FROM superpowers";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public SuperPower addSuperPower(SuperPower superpower) {

        jdbcTemplate.update(SQL_INSERT_SUPERPOWERS,
                superpower.getName(),
                superpower.getDescription());

        int superPowerID
                = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                        Integer.class);
        superpower.setSuperPowerID(superPowerID);
        return superpower;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteSuperPower(int superPowerID) {
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_SUPERPOWER, superPowerID);
        jdbcTemplate.update(SQL_DELETE_SUPERPOWERS, superPowerID);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateSuperPower(SuperPower superpower) {
        jdbcTemplate.update(SQL_UPDATE_SUPERPOWERS,
                superpower.getName(),
                superpower.getDescription(),
                superpower.getSuperPowerID());
    }

    @Override
    public SuperPower getSuperPowerByID(int superPowerID) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SUPERPOWER_BY_ID,
                    new SuperPowerMapper(),
                    superPowerID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperPower> getAllSuperPowers() {
        return jdbcTemplate.query(SQL_SELECT_ALL_SUPERPOWERS,
                new SuperPowerMapper());
    }

    private static final class SuperPowerMapper implements RowMapper<SuperPower> {

        @Override
        public SuperPower mapRow(ResultSet rs, int i) throws SQLException {
            SuperPower pow = new SuperPower();
            pow.setSuperPowerID(rs.getInt("superPowerID"));
            pow.setName(rs.getString("name"));
            pow.setDescription(rs.getString("description"));
            return pow;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    //////// Sightings //////////////////////////////////////////////////
    private static final String SQL_SELECT_SIGHTINGS_BY_DATE
            = "SELECT * from sightings"
            + " WHERE sightingDate = ? ";

    private static final String SQL_INSERT_SIGHTING
            = "INSERT into sightings (sightingDate, location) "
            + "values (?, ?)";
    private static final String SQL_DELETE_SIGHTING
            = "delete from sightings where sightingID = ?";
    private static final String SQL_UPDATE_SIGHTING
            = "update sightings set sightingDate = ?, location = ?"
            + " WHERE sightingID  =  ?";
    private static final String SQL_SELECT_SIGHTING
            = "SELECT * from sightings WHERE sightingID = ? ";

    private static final String SQL_SELECT_SUPERHERO_HAS_SIGHTING
            = "SELECT * "
            + "FROM superhero_has_sighting hS "
            + "inner join Sightings s on hS.sightingID = s.sightingID  "
            + "inner join Heros h on hS.superHeroID = h.superHeroID "
            + "WHERE s.sightingID = ? ";

    //  private static final String SQL_SELECT_SUPERHERO_HAS_SIGHTING
    //        = "SELECT * from superhero_has_sighting"
    //      + " WHERE sightingID = ? ";
    private static final String SQL_SELECT_SIGHTINGS_BY_LOCATION_ID
            = " SELECT * "
            + " FROM sightings_locations sl "
            + " inner join Sightings s on sl.sightingID = s.sightingID "
            + " left join Location l on sl.location = l.locationID "
            + " WHERE l.locationID = ?;";

    private static final String SQL_SELECT_ALL_SIGHTINGS
            = "SELECT * from sightings";

    private static final String SQL_INSERT_SUPERHERO_HAS_SIGHTING
            = "insert into superhero_has_sighting (superHeroID, sightingID) "
            + "values (?, ?)";

    private static final String SQL_DELETE_SUPERHERO_HAS_SIGHTING
            = "DELETE from superhero_has_sighting  "
            + "WHERE sightingID = ? ";

    private void addSuperhero_has_sighting(Sighting sighting) {
        final int sightingID = sighting.getSightingID();
        List<SuperHero> o = new ArrayList<>();

        int superHeroID = 0;
        SuperHero myHero = new SuperHero();
        List<SuperHero> h = new ArrayList<>();
        int i = 0;
        i = sighting.getHeroList().size();
        i = i - 1;
        while (i > -1) {
            myHero = sighting.getHeroList().get(i);
            h.add(myHero);
            superHeroID = myHero.getSuperHeroID();
            i--;
            for (SuperHero currentHero : o) {
                superHeroID = currentHero.getSuperHeroID();
                jdbcTemplate.update(SQL_INSERT_SUPERHERO_HAS_SIGHTING,
                        superHeroID, sightingID);
            }
        }
    }

    private void deleteSuperhero_has_sighting(Sighting sighting) {
        final int sightingID = sighting.getSightingID();
        List<SuperHero> o = new ArrayList<>();

        int superHeroID = 0;
        SuperHero myHero = new SuperHero();
        List<SuperHero> h = new ArrayList<>();
        int i = 0;
        i = sighting.getHeroList().size();
        i = i - 1;
        while (i > -1) {
            myHero = sighting.getHeroList().get(i);
            h.add(myHero);
            superHeroID = myHero.getSuperHeroID();
            i--;
            for (SuperHero currentHero : o) {
                superHeroID = currentHero.getSuperHeroID();
                jdbcTemplate.update(SQL_DELETE_SUPERHERO_HAS_SIGHTING,
                        sightingID);
            }
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Sighting addSighting(Sighting sighting) {
        ///// format the date string here, then pass that in instead of date obj
        jdbcTemplate.update(SQL_INSERT_SIGHTING,
                sighting.getDate(),
                sighting.getLocationID());
        int sightingID
                = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()",
                        Integer.class);
        sighting.setSightingID(sightingID);
        addSuperhero_has_sighting(sighting);
        return sighting;
    }

    @Override
    public void deleteSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_HAS_SIGHTING,
                sighting.getSightingID());
        jdbcTemplate.update(SQL_DELETE_SIGHTING, sighting.getSightingID());
    }

    @Override
    public void updateSighting(Sighting sighting) {
        jdbcTemplate.update(SQL_UPDATE_SIGHTING,
                sighting.getDate().toString(),
                sighting.getLocationID(),
                sighting.getSightingID());
    }

    @Override
    public Sighting getSightingsByID(int sightingID) {
        List<SuperHero> heros = new ArrayList<>();
        SuperHero hero = new SuperHero();
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_SIGHTING,
                    new SightingMapper(),
                    sightingID); //id           
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<SuperHero> getHerosForASighting(int sightingID) {
        return jdbcTemplate.query(SQL_SELECT_SUPERHERO_HAS_SIGHTING,
                new SuperHeroMapper(),
                sightingID);
    }

    @Override
    public List<Sighting> getSightingsBySuperHeroId(int SuperHeroID) {
        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS, new SightingMapper(), SuperHeroID);
    }

    @Override
    public List<Sighting> getSightingsByLocationID(int locationID) {
        return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_LOCATION_ID, new SightingMapper(), locationID);
    }

    @Override
    public List<Sighting> getSightingsByDate(String date) {
        return jdbcTemplate.query(SQL_SELECT_SIGHTINGS_BY_DATE, new SightingMapper(), date);
    }

    @Override
    public List<Sighting> getAllSightings() {

        return jdbcTemplate.query(SQL_SELECT_ALL_SIGHTINGS,
                new SightingMapper());
    }

    private static final class SightingMapper implements RowMapper<Sighting> {

        @Override
        public Sighting mapRow(ResultSet rs, int i) throws SQLException {
            Sighting si = new Sighting();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            Location location = new Location();
            si.setSightingID(rs.getInt("sightingID"));
            /// how do I get all of the superheros into a sighting in my mapRow
            //  si.setDate(LocalDate.parse(rs.getString("sightingDate"),formatter));
            si.setDate(rs.getString("sightingDate"));
            si.setLocationID(rs.getInt("location"));
            return si;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    //////// Locations ?//////////////////////////////////////////////////
    private static final String SQL_INSERT_LOCATION
            = "insert into locations "
            + "(locationName, address, longitude, latitude) "
            + "values (?, ?, ?, ?)";

    private static final String SQL_DELETE_LOCATION
            = "DELETE FROM locations WHERE locationID = ?";

    private static final String SQL_UPDATE_LOCATION
            = "UPDATE locations SET locationName = ?, "
            + "address = ?, "
            + "longitude = ?, "
            + "latitude = ? "
            + "WHERE locationID = ?";

    private static final String SQL_SELECT_ALL_LOCATIONS
            = "SELECT * FROM locations";

    private static final String SQL_GET_LOCATION_BY_ID
            = "SELECT * FROM locations WHERE locationID = ?";

    private static final String SQL_SELECT_SUPERHEROS_BY_LOCATION_ID
            = "SELECT * FROM locations WHERE superHerosID = ?";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Location addLocation(Location location) {
        jdbcTemplate.update(SQL_INSERT_LOCATION,
                location.getLocationName(),
                location.getAddress(),
                location.getLongitude().setScale(2, RoundingMode.HALF_UP),
                location.getLatitude().setScale(2, RoundingMode.HALF_UP));
        int assignedId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        location.setLocationID(assignedId);
        return location;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteLocation(int locationID) {
        jdbcTemplate.update(SQL_DELETE_LOCATION, locationID);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateLocation(Location location) {
        jdbcTemplate.update(SQL_UPDATE_LOCATION,
                location.getLocationName(),
                location.getAddress(),
                location.getLongitude().setScale(2, RoundingMode.HALF_UP),
                location.getLatitude().setScale(2, RoundingMode.HALF_UP),
                location.getLocationID());
    }

    @Override
    public Location getLocationByID(int locationID) {
        try {
            return jdbcTemplate.queryForObject(SQL_GET_LOCATION_BY_ID,
                    new LocationMapper(),
                    locationID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<
        Location> getAllLocations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_LOCATIONS,
                new LocationMapper());
    }

    @Override
    public List<SuperHero> getAllHerosByLocationID(int locationID) {
        return jdbcTemplate.query(SQL_SELECT_SUPERHEROS_BY_LOCATION_ID,
                new SuperHeroMapper());
    }

    private static final class LocationMapper implements RowMapper<Location> {

        @Override
        public Location mapRow(ResultSet rs, int i) throws SQLException {
            Location loc = new Location();
            loc.setLocationID(rs.getInt("locationID"));
            loc.setLocationName(rs.getString("locationName"));
            loc.setAddress(rs.getString("address"));
            loc.setLongitude(rs.getBigDecimal("longitude").setScale(2, RoundingMode.HALF_UP));
            loc.setLatitude(rs.getBigDecimal("latitude").setScale(2, RoundingMode.HALF_UP));
            return loc;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    //////// Organizations ?//////////////////////////////////////////////////
    private static final String SQL_SELECT_MEMBERS_BY_ORGANIZATION_ID
            = " SELECT * "
            + " FROM superhero_organization so "
            + " inner join Heros s on so.superHeroID = s.superHeroID "
            + " WHERE so.orgID = ? ";

    private static final String SQL_ORGS_BY_HERO_ID
            = " SELECT * "
            + " FROM superhero_organization so "
            + " inner join organizations o on so.orgID = o.orgID "
            + " WHERE so.superHeroID = ? ";

    private static final String SQL_INSERT_ORGANIZATIONS
            = "INSERT into organizations (orgName, orgDescription, locationID) "
            + "values (?, ?, ?)";
    private static final String SQL_DELETE_ORGANIZATIONS
            = "DELETE from organizations "
            + "WHERE orgID = ? ";

    private static final String SQL_UPDATE_ORGANIZATIONS
            = "UPDATE organizations set orgName = ?, orgDescription = ?, locationID = ? "
            + "WHERE orgID = ? ";
    private static final String SQL_SELECT_ALL_ORGANIZATIONS
            = "SELECT * FROM organizations ";
    private static final String SQL_SELECT_ORGANIZATIONS
            = "SELECT * FROM organizations WHERE orgID = ? ";

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public Organization addOrganization(Organization organization) {
        jdbcTemplate.update(SQL_INSERT_ORGANIZATIONS,
                organization.getOrgName(),
                organization.getOrgDescription(),
                organization.getLocationID());
        int orgID = 0;
        orgID = jdbcTemplate.queryForObject("select LAST_INSERT_ID()",
                Integer.class);
        organization.setOrgID(orgID);
        return organization;
    }

    private static final String SQL_INSERT_SUPERHERO_ORGANIZATION
            = "INSERT into superhero_organization (superHeroID, orgID) "
            + "values (?, ?)";

    @Override
    public void addSuperhero_organization(Organization org) {
        List<SuperHero> o = new ArrayList<>();
        SuperHero hero = new SuperHero();
        o = org.getOrgMembers();
        int i = 0;
        i = o.size();
        i = i - 1;
        for (SuperHero uberMensch : o) {
            //           hero = o.get(i);
            jdbcTemplate.update(SQL_INSERT_SUPERHERO_ORGANIZATION,
                    uberMensch.getSuperHeroID(), org.getOrgID());
        }
    }

    private static final String SQL_DELETE_SUPERHERO_ORGANIZATION
            = "delete from superhero_organization "
            + "WHERE orgID = ? ";

    @Override
    public void deleteSuperhero_organization(Organization org) {
        final int orgID = org.getOrgID();
        /*
         int superHeroID = 0;
         SuperHero myHero = new SuperHero();
         List<SuperHero> h = new ArrayList<>();
         int i = 0;
         i = org.getOrgMembers().size();
         i = i - 1;
         while(i > -1){  
             myHero = org.getOrgMembers().get(i);
             h.add(myHero);
             superHeroID = myHero.getSuperHeroID();
             i--;     
         */
        jdbcTemplate.update(SQL_DELETE_SUPERHERO_ORGANIZATION,
                orgID);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void deleteOrganization(Organization org) {
        final int orgID = org.getOrgID();
        /*
        int superHeroID = 0;
        SuperHero myHero = new SuperHero();
        List<SuperHero> h = new ArrayList<>();
        int i = 0;
        i = org.getOrgMembers().size();
        i = i - 1;
        while (i > -1) {
            myHero = org.getOrgMembers().get(i);
            h.add(myHero);
            superHeroID = myHero.getSuperHeroID();
            i--;
            this.deleteSuperhero_organization(org);
         */

        deleteSuperhero_organization(org);
        jdbcTemplate.update(SQL_DELETE_ORGANIZATIONS, orgID);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void updateOrganization(Organization organization
    ) {
        jdbcTemplate.update(SQL_UPDATE_ORGANIZATIONS,
                organization.getOrgName(),
                organization.getOrgDescription(),
                organization.getLocationID(),
                organization.getOrgID());
    }

    @Override
    public Organization getOrganizationById(int orgID
    ) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_ORGANIZATIONS,
                    new OrganizationMapper(),
                    orgID);
        } catch (EmptyResultDataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Organization> getAllOrganizations() {
        return jdbcTemplate.query(SQL_SELECT_ALL_ORGANIZATIONS, new OrganizationMapper());
    }

    @Override
    public List<Organization> getOrgsByHero(SuperHero hero) {
        int superHeroID = 0;
        int sHID = 0;
        int i = 0;
        int orgID = 0;
        Organization org = new Organization();
        superHeroID = hero.getSuperHeroID();
        List<Organization> myList = new ArrayList<>();
        List<Organization> returnList = new ArrayList<>();
        SuperHero hS = new SuperHero();
        List<SuperHero> newList = new ArrayList<>();
        List<SuperHero> theList = new ArrayList<>();
        myList = this.getAllOrganizations();
        theList = this.getAllSuperHeros();
        for (Organization o : myList) {
            newList = o.getOrgMembers();
            for (SuperHero h : theList) {
                sHID = h.getSuperHeroID();
                if (sHID == superHeroID) {
                    i = myList.indexOf(h);
                    org = myList.get(i);
                    orgID = o.getOrgID();
                    org = this.getOrganizationById(orgID);
                    returnList.add(o);
                    break;
                }
            }
        }
        return returnList;
    }

    @Override
    public List<SuperHero> getMembersOfAnOrg(int orgID) {
        return jdbcTemplate.query(SQL_SELECT_MEMBERS_BY_ORGANIZATION_ID, new SuperHeroMapper(), orgID);
    }

    @Override
    public List<Organization> getOrgsByHero(int superHeroID) {
        return jdbcTemplate.query(SQL_ORGS_BY_HERO_ID, new OrganizationMapper(), superHeroID);
    }

    private static final class OrganizationMapper implements RowMapper<Organization> {

        @Override
        public Organization mapRow(ResultSet rs, int i) throws SQLException {
            Organization b = new Organization();

            b.setOrgID(rs.getInt("orgID"));
            b.setOrgName(rs.getString("orgName"));
            b.setOrgDescription(rs.getString("orgDescription"));
            b.setLocationID(rs.getInt("locationID"));

            return b;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////
    //////// helper methods  ?//////////////////////////////////////////////////
    private List<SuperHero> findOrganizationsForSuperHero(SuperHero hero) {
        return jdbcTemplate.query(SQL_SELECT_MEMBERS_BY_ORGANIZATION_ID,
                new SuperHeroMapper(),
                hero.getSuperHeroID());
    }

}
