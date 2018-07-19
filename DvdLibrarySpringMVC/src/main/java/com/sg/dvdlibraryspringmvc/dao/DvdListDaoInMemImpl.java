/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

import com.sg.dvdlibraryspringmvc.model.dvd.Dvd;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *
 * @author JCLog
 */
public class DvdListDaoInMemImpl implements DvdListDao {

    private Map<String, Dvd> dvdMap = new HashMap<>();
    // used to assign ids to Contacts - simulates the auto increment
    // primary key for Contacts in a database
    private static long dvdTitleCounter = 0;

    @Override
    public Dvd addDvd(Dvd dvd) {
        // assign the current counter values as the contactid
        dvd.setDvdTitle(dvd.getDvdTitle());
        // increment the counter so it is ready for use for the 
        // next contact
        dvdTitleCounter++;
        dvdMap.put(dvd.getDvdTitle(), dvd);
        return dvd;
    }

    @Override
    public void removeDvd(String dvdTitle) {
        dvdMap.remove(dvdTitle);
    }

    @Override
    public void updateDvd(Dvd dvd) {
        dvdMap.put(dvd.getDvdTitle(), dvd);
    }

    @Override
    public List<Dvd> getAllDvds() {
        Collection<Dvd> d = dvdMap.values();
        return new ArrayList(d);
    }

    @Override
    public Dvd getDvdByTitle(String dvdTitle) {
        return dvdMap.get(dvdTitle);
    }

    @Override
    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria) {
        String dvdTitleSearchCriteria
                = criteria.get(SearchTerm.DVD_TITLE);
        String releaseDateSearchCriteria
                = criteria.get(SearchTerm.RELEASE_DATE);
        String directorsNameSearchCriteria
                = criteria.get(SearchTerm.DIRECTORS_NAME);
        String ratingSearchCriteria
                = criteria.get(SearchTerm.RATING);

        // Declare all the predicate conditions - remember that
        // Predicate is a functional interface with one method
        // called test(T t) that returns a boolean.  Since
        // Predicate is generic, we get to specify the type of
        // object we want T to be - in our case, we want T to be
        // of type Contact.  That means the Predicates declared 
        // here will have one method: boolean test(Contact c)
        Predicate<Dvd> dvdTitleMatchPredicate;
        Predicate<Dvd> releaseDateMatchPredicate;
        Predicate<Dvd> directorsNameMatchPredicate;
        Predicate<Dvd> ratingMatchPredicate;

        // Placeholder predicate - always returns true. Used for 
        // search terms that are empty - if the user didn't specify 
        // a value for one of the search terms, we must return true
        // because we are ANDing all the search terms together and 
        // our spec says that we return everything in the DAO when
        // the user leaves all the search terms blank.
        Predicate<Dvd> truePredicate = (c) -> {
            return true;
        };

        // Assign values to predicates. If a given search term is empty, 
        // just assign the default truePredicate, otherwise assign the 
        // predicate that only returns true when it finds a match for the 
        // given term.
        if (dvdTitleSearchCriteria == null
                || dvdTitleSearchCriteria.isEmpty()) {
            dvdTitleMatchPredicate = truePredicate;
        } else {
            dvdTitleMatchPredicate
                    = (c) -> c.getDvdTitle().equals(dvdTitleSearchCriteria);
        }

        if (releaseDateSearchCriteria == null
                || dvdTitleSearchCriteria.isEmpty()) {
            releaseDateMatchPredicate = truePredicate;
        } else {
            releaseDateMatchPredicate
                    = (d) -> d.getReleaseDate().equals(releaseDateSearchCriteria);
        }

        if (directorsNameSearchCriteria == null
                || directorsNameSearchCriteria.isEmpty()) {
            directorsNameMatchPredicate = truePredicate;
        } else {
            directorsNameMatchPredicate
                    = (d) -> d.getDirectorsName().equals(directorsNameSearchCriteria);
        }

        if (ratingSearchCriteria == null
                || ratingSearchCriteria.isEmpty()) {
            ratingMatchPredicate = truePredicate;
        } else {
            ratingMatchPredicate
                    = (d) -> d.getRating().equals(ratingSearchCriteria);
        }

        // Return the list of Contacts that match the given criteria. 
        // To do this we just AND all the predicates together in a 
        // filter operation.
        return dvdMap.values().stream()
                .filter(dvdTitleMatchPredicate
                        .and(releaseDateMatchPredicate)
                        .and(directorsNameMatchPredicate)
                        .and(ratingMatchPredicate))
                .collect(Collectors.toList());
    }

}
