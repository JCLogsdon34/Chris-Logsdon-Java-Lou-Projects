/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.dao;

/**
 *
 * @author JCLog
 */

import com.sg.dvdlibraryspringmvc.model.dvd.Dvd;
import java.util.List;
import java.util.Map;

public interface DvdListDao {

    // add the given Contact to the data store
    public Dvd addDvd(Dvd dvd);

   
    public void removeDvd(String dvdTitle);


    public void updateDvd(Dvd dvd);

    public List<Dvd> getAllDvds();

   
    public Dvd getDvdByTitle(String dvdTitle);


    public List<Dvd> searchDvds(Map<SearchTerm, String> criteria);
}
