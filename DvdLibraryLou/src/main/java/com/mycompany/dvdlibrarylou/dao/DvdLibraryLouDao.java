package com.mycompany.dvdlibrarylou.dao;

import com.mycompany.dvdlibrarylou.dto.Dvd;
import java.util.List;
/**
 *
 * @author JCLog
 */
public interface DvdLibraryLouDao {
    
    Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException;

    List<Dvd> getAllDvds()
            throws DvdLibraryLouPersistenceException;

    Dvd getDvd(String dvdTitle)
            throws DvdLibraryLouPersistenceException;
    
    void editDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException;

    Dvd removeDvd(String dvdTitle)
            throws DvdLibraryLouPersistenceException;
    
}