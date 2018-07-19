package com.mycompany.dvdlibrarylou.service;

import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouAuditDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouDao;
import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouPersistenceException;
import com.mycompany.dvdlibrarylou.dto.Dvd;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class DvdLibraryLouServiceLayerImpl implements DvdLibraryLouServiceLayer {

    private DvdLibraryLouDao dao;
    private DvdLibraryLouAuditDao auditDao;

    public DvdLibraryLouServiceLayerImpl(DvdLibraryLouDao dao, DvdLibraryLouAuditDao auditDao) {
        this.dao = dao;
        this.auditDao = auditDao;
    }

    @Override
    public void addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException,
            DvdLibraryLouDuplicateDvdTitleException,
            DvdLibraryLouDataValidationException {
        if (dao.getDvd(dvd.getDvdTitle()) != null) {
            throw new DvdLibraryLouDuplicateDvdTitleException(
                    "ERROR: Could not create Dvd.  Dvd Title"
                    + dvd.getDvdTitle()
                    + " already exists");
        }
        validateDvdData(dvd);
        dao.addDvd(dvd.getDvdTitle(), dvd);
        //      auditDao.writeAuditEntry("Dvd " + dvdTitle + " added.");
    }

    @Override
    public List<Dvd> getAllDvds() throws DvdLibraryLouPersistenceException {
        return dao.getAllDvds();
    }

    @Override
    public Dvd getDvd(String dvdTitle) throws DvdLibraryLouPersistenceException {
        return dao.getDvd(dvdTitle);
    }

    @Override
    public void editDvd(String dvdTitle, Dvd dvd) throws DvdLibraryLouPersistenceException, DvdLibraryLouDataValidationException {
        validateDvdData(dvd);
        //  auditDao.writeAuditEntry("Dvd " + dvdTitle + " added.");
        dao.editDvd(dvdTitle, dvd);
    }

    @Override
    public Dvd removeDvd(String dvdTitle) throws DvdLibraryLouPersistenceException {
        Dvd removedDvd = dao.removeDvd(dvdTitle);
        //     auditDao.writeAuditEntry("Dvd " + dvdTitle + " REMOVED.");
        return removedDvd;
    }

    private void validateDvdData(Dvd dvd) throws
            DvdLibraryLouDataValidationException {
        if (dvd.getDvdTitle() == null
                || dvd.getDvdTitle().trim().length() == 0
                || dvd.getReleaseDate() == null
                || dvd.getReleaseDate().trim().length() == 0
                || dvd.getMpaaRating() == null
                || dvd.getMpaaRating().trim().length() == 0
                || dvd.getDirectorsName() == null
                || dvd.getDirectorsName().trim().length() == 0
                || dvd.getStudio() == null
                || dvd.getStudio().trim().length() == 0
                || dvd.getUserNotes() == null
                || dvd.getUserNotes().trim().length() == 0) {

            throw new DvdLibraryLouDataValidationException(
                    "ERROR: All fields [Dvd Title, Release Date, MPAA Rating, Director's Name, Studio, and User Notes] are required.");
        }
    }

}
