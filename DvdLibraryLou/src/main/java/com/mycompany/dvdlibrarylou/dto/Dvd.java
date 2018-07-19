package com.mycompany.dvdlibrarylou.dto;

/**
 *
 * @author JCLog
 */
public class Dvd {

    private String dvdTitle;
    private String releaseDate;
    private String mpaaRating;
    private String directorsName;
    private String studio;
    private String userNotes;

    public Dvd(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getDvdTitle() {
        return dvdTitle;
    }

    public void setDvdTitle(String dvdTitle) {
        this.dvdTitle = dvdTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserNotes() {
        return userNotes;
    }

    public void setUserNotes(String userNotes) {
        this.userNotes = userNotes;
    }

    @Override
    public String toString() {
        return "Dvd Title: " + dvdTitle + " |Release Date: " + releaseDate
                + " |MPAA Rating: " + mpaaRating + " |Director's Name: "
                + directorsName + " |Studio " + studio + " |User Notes: " + userNotes;
    }
}