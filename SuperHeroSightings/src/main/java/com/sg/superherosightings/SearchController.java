package com.sg.superherosightings;

import com.sg.superherosightings.dao.SuperHerosDao;
import com.sg.superherosightings.dto.SuperHero;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author JCLog
 */    
@Controller
public class SearchController {

        private SuperHerosDao dao;

    @Inject
    public SearchController(SuperHerosDao dao) {
        this.dao = dao;
    }
/*
    @RequestMapping(value = "/search/heros", method = RequestMethod.POST)
    @ResponseBody
    public List<SuperHero> searchHeros(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        
        Map<SearchTerm, String> criteriaMap = new HashMap<>();

        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        String currentTerm = searchMap.get("firstName");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.FIRST_NAME, currentTerm);
        }
        currentTerm = searchMap.get("lastName");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.LAST_NAME, currentTerm);
        }
        currentTerm = searchMap.get("company");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.COMPANY, currentTerm);
        }
        currentTerm = searchMap.get("email");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.EMAIL, currentTerm);
        }
        currentTerm = searchMap.get("phone");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.PHONE, currentTerm);
        }

        return dao.searchContacts(criteriaMap);
    }

*/
    @RequestMapping(value = "/displaySearchPage", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }
}
