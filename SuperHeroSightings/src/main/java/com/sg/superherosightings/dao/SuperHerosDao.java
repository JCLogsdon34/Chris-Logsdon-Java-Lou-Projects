/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dao;

import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Organization;
import com.sg.superherosightings.dto.Sighting;
import com.sg.superherosightings.dto.SuperHero;
import com.sg.superherosightings.dto.SuperPower;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface SuperHerosDao {
 
    
    public SuperHero addSuperHero(SuperHero Hero);

    public void deleteSuperHero(int superHeroId);

    public void updateSuperHero(SuperHero Hero);

    public SuperHero getSuperHeroById(int superHeroID);

    public List<SuperHero> getAllSuperHeros();
    
    public List<SuperPower> findSuperPowersForSuperHero(int superHeroID);
    
    public List<SuperHero> getAllHerosByLocationID(int locationID);
    
    ////////////////////////////////////////////////////////////////
    //////////////////////////// SuperPowers

     public SuperPower addSuperPower(SuperPower superPower);

    public void deleteSuperPower(int superPowerID);

    public void updateSuperPower(SuperPower superPower);

    public SuperPower getSuperPowerByID(int superPowerID);

    public List<SuperPower> getAllSuperPowers();
    
     ////////////////////////////////////////////////////////////////
    //////////////////////////// Sightings
    
    public Sighting addSighting(Sighting sighting);

    public void deleteSighting(Sighting sighting);

    public void updateSighting(Sighting sighting);

    public Sighting getSightingsByID(int sightingID);

    public List<Sighting> getSightingsBySuperHeroId(int SuperHeroID);

    public List<Sighting> getSightingsByLocationID(int locationID);
    
    public List<Sighting> getSightingsByDate(String date);

    public List<Sighting> getAllSightings();
    
    public List<SuperHero> getHerosForASighting(int sightingID);
    
    
    
     ////////////////////////////////////////////////////////////////
    //////////////////////////// Locations

    public Location addLocation(Location location);

    public void deleteLocation(int locationID);

    public void updateLocation(Location location);

    public Location getLocationByID(int locationID);

    public List<Location> getAllLocations();
    
    
     ////////////////////////////////////////////////////////////////
    //////////////////////////// Organizations
    
    public Organization addOrganization(Organization org);

    public void deleteOrganization(Organization org);

    public void updateOrganization(Organization org);

    public Organization getOrganizationById(int organizationID);

    public List<Organization> getAllOrganizations();
    
    public List<Organization> getOrgsByHero(SuperHero hero);
    
    public List<Organization> getOrgsByHero(int superHeroID);
    
    public List<SuperHero> getMembersOfAnOrg(int orgID);
    
    public void addSuperhero_organization(Organization org);
    
    public void deleteSuperhero_organization(Organization org);
    
}
