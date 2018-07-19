package com.mycompany.dvdlibrarylou.controller;

import com.mycompany.dvdlibrarylou.dao.DvdLibraryLouPersistenceException;
import com.mycompany.dvdlibrarylou.dto.Dvd;
import com.mycompany.dvdlibrarylou.service.DvdLibraryLouDataValidationException;
import com.mycompany.dvdlibrarylou.service.DvdLibraryLouDuplicateDvdTitleException;
import com.mycompany.dvdlibrarylou.service.DvdLibraryLouServiceLayer;
import com.mycompany.dvdlibrarylou.ui.DvdLibraryLouView;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class Controller {

    private DvdLibraryLouView view;
    private DvdLibraryLouServiceLayer service;

    public Controller(DvdLibraryLouServiceLayer service, DvdLibraryLouView view) {
        this.service = service;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        viewDvd();
                        break;
                    case 4:
                        removeDvd();
                        break;
                    case 5:
                        editDvd();
                        break;
                    case 6:
                        getDvdByDvdTitle();
                        break;
                    case 7:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }
            }
            exitMessage();
        } catch (DvdLibraryLouPersistenceException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void editDvd() throws DvdLibraryLouPersistenceException {
        String dvdTitle = "";
        view.displayEditDvdBanner();
        dvdTitle = view.getDvdTitleChoice();
        Dvd currentDvd = service.getDvd(dvdTitle);
        //maybe use remove here

        Dvd editedDvd = view.getDvdForEdit(dvdTitle, currentDvd);
        service.removeDvd(dvdTitle);
        try{
        service.editDvd(editedDvd.getDvdTitle(), editedDvd);
        }catch(DvdLibraryLouDataValidationException e){
            view.displayErrorMessage(e.getMessage());
        }
    }

    private void createDvd() throws DvdLibraryLouPersistenceException {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        try{
        service.addDvd(newDvd.getDvdTitle(), newDvd);
        }catch(DvdLibraryLouDataValidationException e){
            view.displayErrorMessage(e.getMessage());
        } catch(DvdLibraryLouDuplicateDvdTitleException e){
            view.displayErrorMessage(e.getMessage());
        }
        view.displayCreateSuccessBanner();
    }

    private void listDvds() throws DvdLibraryLouPersistenceException {
        view.displayDisplayAllBanner();
        List<Dvd> dvdList = service.getAllDvds();
        view.displayDvdList(dvdList);
    }

    private void getDvdByDvdTitle() throws DvdLibraryLouPersistenceException {
        String dvdTitle = "";
        view.displayDisplayDvdBanner();
        dvdTitle = view.getDvdTitleChoice();
        List<Dvd> dvdList = service.getAllDvds();
        view.displaySearchedDvds(dvdList, dvdTitle);
    }

    private void viewDvd() throws DvdLibraryLouPersistenceException {
        String dvdTitle = "";
        view.displayDisplayDvdBanner();
        dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = service.getDvd(dvdTitle);
        view.displayDvd(dvd);
    }

    private void removeDvd() throws DvdLibraryLouPersistenceException {
        view.displayRemoveDvdBanner();
        String dvdTitle = view.getDvdTitleChoice();
        Dvd dvd = service.getDvd(dvdTitle);
        view.displayDvd(dvd);
        service.removeDvd(dvdTitle);
        view.displayRemoveSuccessBanner();
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
}
