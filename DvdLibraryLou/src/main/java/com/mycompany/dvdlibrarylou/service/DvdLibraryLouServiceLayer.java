package com.mycompany.dvdlibrarylou.service;

import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouPersistenceException;
import com.mycompany.dvdlibrarylou.dto.Dvd;
import java.util.List;

/**
 *
 * @author JCLog
 */
public interface DvdLibraryLouServiceLayer {

    void addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException,
            DvdLibraryLouDuplicateDvdTitleException,
            DvdLibraryLouDataValidationException;

    List<Dvd> getAllDvds()
            throws DvdLibraryLouPersistenceException;

    Dvd getDvd(String dvdTitle)
            throws DvdLibraryLouPersistenceException;

    void editDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException,
            DvdLibraryLouDataValidationException;

    Dvd removeDvd(String dvdTitle)
            throws DvdLibraryLouPersistenceException;

}
