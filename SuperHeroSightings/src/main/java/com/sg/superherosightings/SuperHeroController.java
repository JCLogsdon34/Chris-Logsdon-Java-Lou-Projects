package com.sg.superherosightings;

import com.sg.superherosightings.dao.SuperHerosDao;
import com.sg.superherosightings.dto.Location;
import com.sg.superherosightings.dto.Organization;
import com.sg.superherosightings.dto.Sighting;
import com.sg.superherosightings.dto.SuperHero;
import com.sg.superherosightings.dto.SuperPower;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;

/**
 *
 * @author JCLog
 */
@Controller
public class SuperHeroController {

    private SuperHerosDao dao;

    @Inject
    public SuperHeroController(SuperHerosDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String displayLandingPage() {
        return "index";
    }

    @RequestMapping(value = "/displayHomePage", method = RequestMethod.GET)
    public String displayHomePage(Model model) {
        List<Sighting> sightingList = new ArrayList<>();
        List<Sighting> sights = new ArrayList<>();
        
        sightingList = dao.getAllSightings();
        LocalDate date = LocalDate.now();
        long years = 15;

        for (Sighting sight : sightingList) {
            Location location = new Location();
            int locationID = sight.getLocationID();
            location = dao.getLocationByID(locationID);
            
            sight.setLocation(location);
            sights.add(sight);
            String dateString = "";
            /// Lets maybe use 1200 BCE as the start date
            int j = 0;
        }
            sights.sort(new Comparator<Sighting>() {
                /// Lets maybe use 1200 BCE as the start date
                @Override
                public int compare(Sighting m1, Sighting m2) {
                    int placement = 0;
                    String dateString = m1.getDate();
                    String dateStringTwo = m2.getDate();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  
                    LocalDate dateOne = LocalDate.parse(dateString, formatter);
                    LocalDate dateTwo = LocalDate.parse(dateStringTwo, formatter);
                    if (dateOne == dateTwo) {
                        placement = 0;
                    } else if (dateOne.isBefore(dateTwo)){
                        placement = -1;
                    } else if (dateOne.isAfter(dateTwo)){
                        placement = 1;
                    }
                    return placement;
                }
            });
            int u = 0;
            int r = 0;
            u = sights.size();
            r = u - 10;
            sights.subList(0, r).clear();

        model.addAttribute("sights", sights);
        return "homePage";
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Sightings ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displaySightingsPage", method = RequestMethod.GET)
    public String displayAllSightings(Model model) {
        List<Sighting> sightingList = new ArrayList<>();
        List<Sighting> sights = new ArrayList<>();
        sightingList = dao.getAllSightings();
        //  List<Location> locationList = new ArrayList<>();
        /// i being the position in the lists

        for (Sighting sight : sightingList) {
            Location location = new Location();
            int locationID = sight.getLocationID();
            location = dao.getLocationByID(locationID);
            sight.setLocation(location);

            sights.add(sight);
        }
        model.addAttribute("sights", sights);
        //   model.addAttribute("locationList", locationList);
        return "sightingsPage";
    }

    @RequestMapping(value = "/createSighting", method = RequestMethod.POST)
    public String createSighting(HttpServletRequest request) {
        Location location = new Location();
        SuperHero hero = new SuperHero();
        Organization org = new Organization();
        List<Organization> orgs = new ArrayList<>();
        List<SuperHero> heros = new ArrayList<>();
        Sighting sighting = new Sighting();
        sighting.setDate(request.getParameter("sightingDate"));
        String locationIdParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIdParameter);
        String superHeroIdParameter = request.getParameter("superHeroID");
        int superHeroID = Integer.parseInt(superHeroIdParameter);
        hero = dao.getSuperHeroById(superHeroID);
        heros.add(hero);
        orgs = dao.getOrgsByHero(hero);

        sighting.setHeroList(heros);
        sighting.setLocationID(locationID);
        location = dao.getLocationByID(locationID);
        sighting.setLocation(location);

        dao.addSighting(sighting);
        return "redirect:displaySightingsPage";
    }

    @RequestMapping(value = "/deleteSighting", method = RequestMethod.GET)
    public String deleteSighting(HttpServletRequest request) {
        String sightingIdParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIdParameter);
        Sighting sighting = new Sighting();
        sighting = dao.getSightingsByID(sightingID);
        dao.deleteSighting(sighting);
        return "redirect:displaySightingsPage";
    }

    @RequestMapping(value = "/displayUpdateSightingsForm", method = RequestMethod.GET)
    public String displayEditSightingForm(HttpServletRequest request, Model model) {
        List<Sighting> sightingList = new ArrayList<>();
        String sightingIdParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIdParameter);
        Sighting sighting = new Sighting();
        sighting = dao.getSightingsByID(sightingID);
        List<Location> locationList = new ArrayList<>();
        for (Sighting sight : sightingList) {
            Location location = new Location();
            int locationID = 0;
            locationID = sight.getLocationID();
            location = dao.getLocationByID(locationID);
            locationList.add(location);
        }

        model.addAttribute("locationList", locationList);
        sightingList.add(sighting);
        model.addAttribute("sightingList", sightingList);
        return "updateSightingsForm";
    }

    @RequestMapping(value = "/updateSightings", method = RequestMethod.POST)
    public String editSighting(@Valid @ModelAttribute("sighting") Sighting sighting, BindingResult result) {
        if (result.hasErrors()) {
            return "updateSightingForm";
        }
        dao.updateSighting(sighting);
        return "redirect:sightingsPage";
    }

    @RequestMapping(value = "/displaySightingDetails", method = RequestMethod.GET)
    public String displaySighting(HttpServletRequest request, Model model) {
        List<Sighting> sightingList = new ArrayList<>();
        String sightingIdParameter = request.getParameter("sightingID");
        int sightingID = Integer.parseInt(sightingIdParameter);
        Sighting sighting = new Sighting();

        sighting = dao.getSightingsByID(sightingID);
        List<SuperHero> heroList = new ArrayList<>();
        int superHeroID = 0;
        SuperHero hero = new SuperHero();
        hero = dao.getSuperHeroById(superHeroID);
        heroList = dao.getHerosForASighting(sightingID);
        model.addAttribute("heroList", heroList);

        List<Organization> organizationList = new ArrayList<>();
        int orgID = 0;
        int locationID = 0;
        Organization org = new Organization();
        Location location = new Location();
        //org = dao.getOrganizationById(orgID);
      //  organizationList.add(org);
    //    model.addAttribute("organizationList", organizationList);

        List<Location> locationList = new ArrayList<>();
        locationID = sighting.getLocationID();
        location = dao.getLocationByID(locationID);
        sighting.setLocation(location);
        sightingList.add(sighting);
        model.addAttribute("sightingList", sightingList);
        return "sightingDetails";
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // SuperPowers ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displaySuperPowersPage", method = RequestMethod.GET)
    public String displayAllSuperPowers(Model model) {
        List<SuperPower> superPowerList = new ArrayList<>();
        superPowerList = dao.getAllSuperPowers();
        model.addAttribute("superPowerList", superPowerList);
        return "superPowersPage";
    }

    @RequestMapping(value = "/createSuperPower", method = RequestMethod.POST)
    public String createSuperPower(HttpServletRequest request) {
        SuperPower superPower = new SuperPower();
        superPower.setName(request.getParameter("name"));
        superPower.setDescription(request.getParameter("description"));
        dao.addSuperPower(superPower);
        return "redirect:displaySuperPowersPage";
    }

    @RequestMapping(value = "/displayUpdateSuperPower", method = RequestMethod.GET)
    public String displayEditSuperPowerForm(HttpServletRequest request, Model model) {
        List<SuperPower> superPowerList = new ArrayList<>();
        String superPowerIdParameter = request.getParameter("superPowerID");
        int superPowerID = Integer.parseInt(superPowerIdParameter);
        SuperPower superPower = new SuperPower();
        superPower = dao.getSuperPowerByID(superPowerID);
        superPowerList.add(superPower);
        model.addAttribute("superPowerList", superPowerList);
        return "updateSuperPowerForm";
    }

    @RequestMapping(value = "/updateSuperPower", method = RequestMethod.POST)
    public String editSuperPower(@Valid @ModelAttribute("superPowerList") SuperPower superPower, BindingResult result) {
        if (result.hasErrors()) {
            return "updateSuperPowerForm";
        }
        dao.updateSuperPower(superPower);
        return "redirect:superPowersPage";
    }

    @RequestMapping(value = "/deleteSuperPower", method = RequestMethod.GET)
    public String deleteSuperPower(HttpServletRequest request) {
        String superPowerIdParameter = request.getParameter("superPowerID");
        int superPowerID = Integer.parseInt(superPowerIdParameter);
        dao.deleteSuperPower(superPowerID);
        return "redirect:displaySuperPowersPage";
    }

    @RequestMapping(value = "/displaySuperPower", method = RequestMethod.GET)
    public String displaySuperPower(HttpServletRequest request, Model model) {
        List<SuperPower> superPowerList = new ArrayList<>();
        String superPowerIdParameter = request.getParameter("superPowerID");
        int superPowerID = Integer.parseInt(superPowerIdParameter);
        SuperPower superPower = new SuperPower();
        superPower = dao.getSuperPowerByID(superPowerID);
        superPowerList.add(superPower);
        model.addAttribute("superPowerList", superPowerList);
        return "superPowerDetails";
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Locations ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayLocationsPage", method = RequestMethod.GET)
    public String displayAllLocations(Model model) {
        List<Location> locationList = new ArrayList<>();
        locationList = dao.getAllLocations();
        model.addAttribute("locationList", locationList);
        return "locationsPage";
    }

    @RequestMapping(value = "/createLocation", method = RequestMethod.POST)
    public String createLocation(HttpServletRequest request) {
        Location location = new Location();
        location.setLocationName(request.getParameter("locationName"));
        location.setAddress(request.getParameter("address"));
        location.setLongitude(new BigDecimal(request.getParameter("longitude")));
        location.setLatitude(new BigDecimal(request.getParameter("latitude")));
        dao.addLocation(location);
        return "locationsPage";
    }

    @RequestMapping(value = "/displayUpdateLocations", method = RequestMethod.GET)
    public String displayEditLocationsForm(HttpServletRequest request, Model model) {
        List locationList = new ArrayList<>();
        String locationIdParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIdParameter);
        Location location = new Location();
        location = dao.getLocationByID(locationID);
        locationList.add(location);
        model.addAttribute("locationList", locationList);
        return "updateLocationsForm";
    }

    @RequestMapping(value = "/updateLocation", method = RequestMethod.POST)
    public String editLocation(@Valid @ModelAttribute("locationList") Location location, BindingResult result) {
        if (result.hasErrors()) {
            return "updateLocationsForm";
        }
        dao.updateLocation(location);
        return "redirect:displayLocationsPage";
    }

    @RequestMapping(value = "/deleteLocation", method = RequestMethod.GET)
    public String deleteLocation(HttpServletRequest request) {
        String locationIdParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIdParameter);
        dao.deleteLocation(locationID);
        return "locationsPage";
    }

    @RequestMapping(value = "/displayLocation", method = RequestMethod.GET)
    public String displayLocation(HttpServletRequest request, Model model) {
        List<Location> locationList = new ArrayList<>();
        String locationIdParameter = request.getParameter("locationID");
        int locationID = Integer.parseInt(locationIdParameter);
        Location currentLocation = new Location();
        currentLocation = dao.getLocationByID(locationID);
        locationList.add(currentLocation);
        model.addAttribute("locationList", locationList);
        return "locationDetails";
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // SuperHeros ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayHerosPage", method = RequestMethod.GET)
    public String displayAllSuperHeros(Model model) {
        List<SuperHero> heroList = new ArrayList<>();
        heroList = dao.getAllSuperHeros();
        model.addAttribute("heroList", heroList);
        return "herosPage";
    }

    @RequestMapping(value = "/createSuperHero", method = RequestMethod.POST)
    public String createSuperHero(HttpServletRequest request, Model model) {

        List<SuperPower> getSP = new ArrayList<>();

        SuperPower superPower = new SuperPower();
        SuperHero hero = new SuperHero();
        hero.setName(request.getParameter("name"));
        hero.setDescription(request.getParameter("description"));

        //come up ith sql statements to do different things
        //
        superPower.setSuperPowerID(Integer.parseInt(request.getParameter("superPowerID")));
        getSP.add(superPower);
        hero.setSuperPowers(getSP);
        dao.addSuperHero(hero);
        return "redirect:displayHerosPage";
    }

    @RequestMapping(value = "/displayUpdateHero", method = RequestMethod.GET)
    public String displayEditSuperHeroForm(HttpServletRequest request, Model model) {
        List<SuperHero> heroList = new ArrayList<>();
        List<SuperPower> superPowerList = new ArrayList<>();
        String superHeroIdParameter = request.getParameter("superHeroID");
        int superHeroID = Integer.parseInt(superHeroIdParameter);
        SuperHero hero = new SuperHero();
        hero = dao.getSuperHeroById(superHeroID);
        superPowerList = hero.getSuperPowers();
        heroList.add(hero);
        model.addAttribute("superHeroList", heroList);
        model.addAttribute("superPowerList", superPowerList);
        return "updateHerosForm";
    }

    @RequestMapping(value = "/updateHerosForm", method = RequestMethod.POST)
    public String editSuperHero(@Valid @ModelAttribute("superHeroList") SuperHero superHero, BindingResult result) {
        if (result.hasErrors()) {
            return "updateHerosForm";
        }
        dao.updateSuperHero(superHero);
        return "redirect:displayHerosPage";
    }

    @RequestMapping(value = "/deleteSuperHero", method = RequestMethod.GET)
    public String deleteSuperHero(HttpServletRequest request) {
        String superHeroIdParameter = request.getParameter("superHeroID");
        int superHeroID = Integer.parseInt(superHeroIdParameter);
        dao.deleteSuperHero(superHeroID);
        return "redirect:displayHerosPage";
    }

    @RequestMapping(value = "/displayHeroDetails", method = RequestMethod.GET)
    public String displaySuperHero(HttpServletRequest request, Model model) {
        List<SuperHero> heroList = new ArrayList<>();
        String superHeroIdParameter = request.getParameter("superHeroID");
        List<SuperPower> superPowersList = new ArrayList<>();
        int superHeroID = 0;
        superHeroID = Integer.parseInt(superHeroIdParameter);
        SuperHero hero = new SuperHero();
        hero = dao.getSuperHeroById(superHeroID);
        List<Organization> orgs = new ArrayList<>();
        
        superPowersList = dao.findSuperPowersForSuperHero(superHeroID);
        // for(int id : superPowersList){
        orgs = dao.getOrgsByHero(superHeroID);
        // }
        //  superPowerList = dao.
        hero.setSuperPowers(superPowersList);
        heroList.add(hero);
        
        model.addAttribute("superHeroList", heroList);
        model.addAttribute("superPowersList", superPowersList);
        model.addAttribute("orgList", orgs);
        return "heroDetails";
    }

    //////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////
    // Organizations ///////////////////////////////////////////////////////////
    @RequestMapping(value = "/displayOrganizationsPage", method = RequestMethod.GET)
    public String displayAllOrganizations(Model model) {
        //      List<Location> locations = new ArrayList<>();
        List<Location> locationList = new ArrayList<>();
        List<SuperHero> members = new ArrayList<>();
        //     locations = dao.getAllLocations();
        //    Organization org = new Organization();
        List<Organization> organizationList = new ArrayList<>();
        List<Organization> orgs = new ArrayList<>();
        int locationID = 0;
        Location location = new Location();
        organizationList = dao.getAllOrganizations();

        for (Organization org : organizationList) {
            locationID = org.getLocationID();
            location = dao.getLocationByID(locationID);
            org.setOrgLocation(location);
            //for (Location l : locations) {
            //     if (l.getLocationID() == org.getLocationID()) {
            orgs.add(org);

        

           int orgID = 0;
             orgID = org.getOrgID();
               members = dao.getMembersOfAnOrg(orgID);
        }
                 model.addAttribute("members", members);
        model.addAttribute("organizationList", orgs);
//        model.addAttribute("locationList", locationList);

        return "organizationsPage";
    }

    @RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
    public String createOrganization(HttpServletRequest request) {
        Organization org = new Organization();
        Location location = new Location();
        org.setOrgName(request.getParameter("orgName"));
        org.setOrgDescription(request.getParameter("orgDescription"));
        String locationString = request.getParameter("locationID");
        int locationID = 0;
        locationID = Integer.parseInt(locationString);
        org.setLocationID(locationID);
        location = dao.getLocationByID(locationID);
        org.setOrgLocation(location);
        List<SuperHero> heroList = new ArrayList<>();
        SuperHero hero = new SuperHero();
        for (String x : request.getParameterValues("superHeroID")) {
            int y = Integer.parseInt(x);
            hero = dao.getSuperHeroById(y);
            heroList.add(hero);
        }
        org.setOrgMembers(heroList);
        dao.addOrganization(org);
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/displayUpdateOrganizations", method = RequestMethod.GET)
    public String displayEditOrganizationsForm(HttpServletRequest request, Model model) {
        List<Organization> orgList = new ArrayList<>();
        String orgIdParameter = request.getParameter("orgID");
        int orgID = Integer.parseInt(orgIdParameter);
        Organization org = new Organization();
        org = dao.getOrganizationById(orgID);
        orgList.add(org);
        model.addAttribute("organizationList", orgList);
        return "updateOrganizationsForm";
    }

    @RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
    public String editOrganization(@Valid @ModelAttribute("organizationList") Organization org, BindingResult result) {
        if (result.hasErrors()) {
            return "updateOrganization";
        }
        dao.updateOrganization(org);
        return "organizationsPage";
    }

    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.GET)
    public String deleteOrganization(HttpServletRequest request) {
        String orgIdParameter = request.getParameter("orgID");
        int orgID = Integer.parseInt(orgIdParameter);
        Organization org = new Organization();
        org = dao.getOrganizationById(orgID);
        dao.deleteOrganization(org);
        return "redirect:displayOrganizationsPage";
    }

    @RequestMapping(value = "/displayOrganization", method = RequestMethod.GET)
    public String displayOrganization(HttpServletRequest request, Model model) {
        List<Organization> orgList = new ArrayList<>();
        List<Location> locationList = new ArrayList<>();
        String orgIdParameter = request.getParameter("orgID");
        int orgID = Integer.parseInt(orgIdParameter);
        int locationID = 0;
        Organization org = new Organization();
        Location location = new Location();
        SuperHero hero = new SuperHero();
        List<SuperHero> heroList = new ArrayList<>();
        org = dao.getOrganizationById(orgID);
        /// maybe a for-loop here
        locationID = org.getLocationID();
        location = dao.getLocationByID(locationID);
        org.setOrgLocation(location);
        //org.setOrgLocation(location);
        orgList.add(org);
        heroList = dao.getMembersOfAnOrg(orgID);
        
        org.setOrgMembers(heroList);
        model.addAttribute("organizationList", orgList);
    //    model.addAttribute("locationList", locationList);
        model.addAttribute("heroList", heroList);
        return "organizationDetails";
    }
}
