package com.mycompany.dvdlibrarylou.dao;

import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouPersistenceException;
import com.mycompany.dvdlibrarylou.dto.Dvd;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class DvdLibraryLouDaoStubImpl implements DvdLibraryLouDao {

    private Dvd onlyDvd;
    private List<Dvd> dvdList = new ArrayList<>();

    public DvdLibraryLouDaoStubImpl() {
        onlyDvd = new Dvd("Zorba The Greek");
        onlyDvd.setDvdTitle("Zorba The Greek");
        onlyDvd.setReleaseDate("12-15-53");
        onlyDvd.setMpaaRating("R");
        onlyDvd.setDirectorsName("Nikos Kazanzakis");
        onlyDvd.setStudio("Crete");
        onlyDvd.setUserNotes("Kala");

        dvdList.add(onlyDvd);
    }

    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd) throws DvdLibraryLouPersistenceException {
        if (dvdTitle.equals(onlyDvd.getDvdTitle())) {
            return onlyDvd;
        } else {
            return null;
        }
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryLouPersistenceException {
        return dvdList;
    }

    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryLouPersistenceException {
        if (dvdTitle.equals(onlyDvd.getDvdTitle())) {
            return onlyDvd;
        } else {
            return null;
        }
    }

    @Override
    public Dvd removeDvd(String dvdTitle) throws DvdLibraryLouPersistenceException {
        if (dvdTitle.equals(onlyDvd.getDvdTitle())) {
            return onlyDvd;
        } else {
            return null;
        }
    }

    @Override
    public void editDvd(String dvdTitle, Dvd dvd) throws DvdLibraryLouPersistenceException {

        onlyDvd.setStudio(dvd.getUserNotes());
        dvdList.remove(0);
        dvdList.add(onlyDvd);
    }
}
