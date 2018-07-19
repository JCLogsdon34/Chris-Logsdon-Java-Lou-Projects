package com.mycompany.dvdlibrarylou.dao;

import com.mycompany.dvdlibrarylou.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author JCLog
 */
public class DvdLibraryLouDaoImpl implements DvdLibraryLouDao {
    
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd addDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException {
        loadLibrary();
        dvds.put(dvdTitle, dvd);
        writeLibrary();
        return dvd;
    }

    @Override
    public List<Dvd> getAllDvds()
            throws DvdLibraryLouPersistenceException {
        loadLibrary();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public void editDvd(String dvdTitle, Dvd dvd)
            throws DvdLibraryLouPersistenceException {
        getAllDvds(); //or loadLibrary();
        //maybe add a remove here
        dvds.put(dvdTitle, dvd);
        writeLibrary();
    }
    
    @Override
    public Dvd getDvd(String dvdTitle)
            throws DvdLibraryLouPersistenceException {
        loadLibrary();
              //  Dvd returnedDvd = new Dvd(dvdTitle);
        //returnedDvd = dvds.get(dvdTitle);
        //return returnedDvd;
        return dvds.get(dvdTitle);
    }

    @Override
    public Dvd removeDvd(String dvdTitle)
            throws DvdLibraryLouPersistenceException {
        Dvd removedDvd = dvds.remove(dvdTitle);
        writeLibrary();
        return removedDvd;
    }
    
    public static final String BOOK_FILE = "library.txt";
    public static final String DELIMITER = "::";

      private void loadLibrary() throws DvdLibraryLouPersistenceException {
        Scanner scanner;
        try {
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(BOOK_FILE)));
        } catch (FileNotFoundException e) {
            throw new DvdLibraryLouPersistenceException(
                    "-_- Could not load library data into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMITER);
            Dvd currentDvd = new Dvd(currentTokens[0]);
            currentDvd.setReleaseDate(currentTokens[1]);
            currentDvd.setMpaaRating(currentTokens[2]);
            currentDvd.setDirectorsName(currentTokens[3]);
            currentDvd.setStudio(currentTokens[4]);
            currentDvd.setUserNotes(currentTokens[5]);
            dvds.put(currentDvd.getDvdTitle(), currentDvd);
        }
        scanner.close();
    }

    private void writeLibrary() throws DvdLibraryLouPersistenceException{

        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(BOOK_FILE));
        } catch (IOException e) {
            throw new DvdLibraryLouPersistenceException(
                    "Could not save Dvd data.", e);
        }
//maybe get rid of the get all method
        List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
            out.println(currentDvd.getDvdTitle() + DELIMITER
                    + currentDvd.getReleaseDate() + DELIMITER
                    + currentDvd.getMpaaRating() + DELIMITER
                    + currentDvd.getDirectorsName() + DELIMITER
                    + currentDvd.getStudio() + DELIMITER
                    + currentDvd.getUserNotes());
            out.flush();
        }
        out.close();
    }
}