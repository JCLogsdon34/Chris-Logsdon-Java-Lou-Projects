package com.mycompany.dvdlibrarylou.ui;

import com.mycompany.dvdlibrarylou.dto.Dvd;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author JCLog
 */
public class DvdLibraryLouView {

    private UserIO io;

    public DvdLibraryLouView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("Main Menu");
        io.print("1. List Dvds in Library");
        io.print("2. Create a New Dvd");
        io.print("3. View a Dvd");
        io.print("4. Remove a Dvd");
        io.print("5. Edit a Dvd");
        io.print("6. Search for a Dvd by Title");
        io.print("7. Exit");

        return io.readInt("Please select from the above choices.", 1, 7);
    }

    public String getDvdTitleChoice() {
        String dvdTitle = "";
        dvdTitle = io.readString("Please enter the Dvd Title to search for.");
        return dvdTitle;
    }

    public Dvd getNewDvdInfo() {
        String dvdTitle = "";
        String releaseDate = "";
        String mpaaRating = "";
        String directorsName = "";
        String studio = "";
        String userNotes = "";

        dvdTitle = io.readString("Please enter a Dvd Title");
        Dvd currentDvd = new Dvd(dvdTitle);
        releaseDate = io.readString("Please enter a Release Date of pattern "
                + "MM/dd/yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate ld = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String formatted = ld.format(formatter);
        mpaaRating = io.readString("Please enter the Mpaa Rating");
        directorsName = io.readString("Please enter the Director's name");
        studio = io.readString("Please enter the studio name");
        userNotes = io.readString("Please enter you notes on this dvd");
        currentDvd.setDvdTitle(dvdTitle);
        currentDvd.setReleaseDate(formatted);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorsName(directorsName);
        currentDvd.setStudio(studio);
        currentDvd.setUserNotes(userNotes);
        return currentDvd;
    }

    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            io.print(currentDvd.getDvdTitle() + ": "
                    + currentDvd.getReleaseDate() + " "
                    + currentDvd.getMpaaRating() + " "
                    + currentDvd.getDirectorsName() + " "
                    + currentDvd.getStudio() + " "
                    + currentDvd.getUserNotes());
        }
        io.readString("Please hit enter to continue.");
    }

    public void displaySearchedDvds(List<Dvd> dvdList, String dvdTitle) {

        for (Dvd currentDvd : dvdList) {
            if (currentDvd.getDvdTitle().contains(dvdTitle)) {
                io.print(currentDvd.getDvdTitle() + ": "
                        + currentDvd.getReleaseDate() + " "
                        + currentDvd.getMpaaRating() + " "
                        + currentDvd.getDirectorsName() + " "
                        + currentDvd.getStudio() + " "
                        + currentDvd.getUserNotes());
            } else if(currentDvd.getDvdTitle().isEmpty()){
                io.print("No such title in collection");
            }
        }
        io.readString("Please hit enter to continue.");
    }

    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getDvdTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorsName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserNotes());
            io.print("");
        } else {
            io.print("No such Dvd.");
        }
        io.readString("Please hit enter to continue.");
    }

    public Dvd getDvdForEdit(String dvdTitle, Dvd currentDvd) {
        boolean keepGoing = true;
        int userSelection = 0;
        String releaseDate;
        String mpaaRating;
        String directorsName;
        String studio;
        String userNotes;

        while (keepGoing) {
            userSelection = io.readInt("Please select a number from the following editing options: "
                    + "(1)Dvd Title"
                    + "(2)Release Date "
                    + "(3)MPAA Rating "
                    + "(4)Director's Name"
                    + "(5)Studio "
                    + "(6)User Notes"
                    + "(7)Leave Menu");
            boolean boolingAround = true;
            switch (userSelection) {

                case 1:
                    do {
                        dvdTitle = io.readString("Please enter your desired changes for the Dvd's title");
                        if (dvdTitle != null) {
                            currentDvd.setDvdTitle(dvdTitle);
                            io.print("Your change to the Dvd Title has been noted");
                            boolingAround = false;
                        } else {
                            boolingAround = true;
                        }
                    } while (boolingAround);
                    break;
                case 2:
                    do {
                        /*
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate ld = LocalDate.parse(releaseDate, formatter);
                        String formatted = ld.format(formatter);
                         */
                        releaseDate = io.readString("Please enter your desired changes for the Release Date");
                        if (releaseDate != null) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            LocalDate ld = LocalDate.parse(releaseDate, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
                            String formatted = ld.format(formatter);
                            currentDvd.setReleaseDate(formatted);
                            io.print("Your change to the Release Date has been noted");
                            boolingAround = false;
                        } else {
                            boolingAround = true;
                        }
                    } while (boolingAround);
                    break;
                case 3:
                    do {
                        mpaaRating = io.readString("Please enter your desired changes for the MPAA Rating");
                        if (!mpaaRating.isEmpty()) {
                            currentDvd.setMpaaRating(mpaaRating);
                            io.print("Your change to the MPAA Rating has been noted");
                            boolingAround = false;
                        } else {
                            boolingAround = true;
                        }
                    } while (boolingAround);
                    break;
                case 4:
                    do {
                        directorsName = io.readString("Please enter your desired changes for the Director's Name");
                        if (directorsName != null) {
                            currentDvd.setDirectorsName(directorsName);
                            io.print("Your change to the Director's Name has been saved");
                            boolingAround = false;
                        } else {
                            boolingAround = true;
                        }
                    } while (boolingAround);
                    break;
                case 5:
                    do {
                        studio = io.readString("Please enter your desired changes for Studio");
                        if (!studio.isEmpty()) {
                            currentDvd.setStudio(studio);
                            io.print("Your change to the Dvd's Studio have been saved");
                            boolingAround = false;
                        } else {
                            boolingAround = true;
                        }
                    } while (boolingAround == true);
                    break;
                case 6:
                    do {
                        userNotes = io.readString("Please enter your desired changes for User Notes");
                        if (userNotes != null) {
                            currentDvd.setUserNotes(userNotes);
                            io.print("Your change to the User's Notes have been saved");
                            boolingAround = false;
                        } else {
                            boolingAround = true;
                        }
                    } while (boolingAround);
                    break;
                case 7:
                    keepGoing = false;
                    break;
                default:
                    io.print("Invalid Input, please enter one of the numbered chocies");
                    break;
            }
        }
        return currentDvd;
    }

    public void displayDisplayAllBanner() {
        io.print("=== Display All Dvdss ===");
    }

    public void displayCreateDvdBanner() {
        io.print("=== Create Dvd ===");
    }

    public void displayCreateSuccessBanner() {
        io.readString(
                "Dvd successfully created.  Please hit enter to continue");
    }

    public void displaySearchByTitleBanner() {
        io.readString("=== Search For Dvd By Title ===");
    }

    public void displayDisplayDvdBanner() {
        io.print("=== Display Dvd ===");
    }

    public void displayRemoveDvdBanner() {
        io.print("=== Remove Dvd ===");
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit Dvd ===");
    }

    public void displayRemoveSuccessBanner() {
        io.readString("Dvd successfully removed. Please hit enter to continue.");
    }

    public void displayExitBanner() {
        io.print("Good Bye!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }
}
