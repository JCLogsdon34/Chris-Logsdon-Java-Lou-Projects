package com.sg.dvdlibraryspringmvc.dvdcontroller;

import com.sg.dvdlibraryspringmvc.dao.DvdListDao;
import com.sg.dvdlibraryspringmvc.dao.SearchTerm;
import com.sg.dvdlibraryspringmvc.model.dvd.Dvd;
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

    private DvdListDao dao;

    @Inject
    public SearchController(DvdListDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/search/dvds", method = RequestMethod.POST)
    @ResponseBody
    public List<Dvd> searchDvdContacts(@RequestBody Map<String, String> searchMap) {
        // Create the map of search criteria to send to the DAO
        Map<SearchTerm, String> criteriaMap = new HashMap<>();

        // Determine which search terms have values, translate the String
        // keys into SearchTerm enums, and set the corresponding values
        // appropriately.
        String currentTerm = searchMap.get("dvdTitle");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DVD_TITLE, currentTerm);
        }
        currentTerm = searchMap.get("releaseDate");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RELEASE_DATE, currentTerm);
        }
        currentTerm = searchMap.get("directorsName");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.DIRECTORS_NAME, currentTerm);
        }
        currentTerm = searchMap.get("rating");
        if (currentTerm != null && !currentTerm.isEmpty()) {
            criteriaMap.put(SearchTerm.RATING, currentTerm);
        }

        return dao.searchDvds(criteriaMap);
    }

    @RequestMapping(value = "/displaySearchPage", method = RequestMethod.GET)
    public String displaySearchPage() {
        return "search";
    }
}
