/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibraryspringmvc.model.dvd;



/**
 *
 * @author JCLog
 */

    import java.util.Objects;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

public class Dvd {

    private String dvdTitle;
    @NotEmpty(message = "You must supply a value for Dvd Title.")
    @Length(max = 50, message = "First Name must be no more than 50 characters in length.")
    private String releaseDate;
    @NotEmpty(message = "You must supply a value for Release Date.")
    @Length(max = 50, message = "Last Name must be no more than 50 characters in length.")
    private String directorsName;
    @NotEmpty(message = "You must supply a value for a Director's Name.")
    @Length(max = 50, message = "Company must be no more than 50 characters in length.")
    private String rating;
    @NotEmpty(message = "You must supply a value for Rating.")
    @Length(max = 10, message = "Phone must be no more than 10 characters in length.")

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

    public String getDirectorsName() {
        return directorsName;
    }

    public void setDirectorsName(String directorsName) {
        this.directorsName = directorsName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public int hashCode() {
        int hash = 3;

        hash = 97 * hash + Objects.hashCode(this.dvdTitle);
        hash = 97 * hash + Objects.hashCode(this.releaseDate);
        hash = 97 * hash + Objects.hashCode(this.directorsName);
        hash = 97 * hash + Objects.hashCode(this.rating);
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Dvd other = (Dvd) obj;
        if (this.dvdTitle != other.dvdTitle) {
            return false;
        }
        if (!Objects.equals(this.dvdTitle, other.dvdTitle)) {
            return false;
        }
        if (!Objects.equals(this.releaseDate, other.releaseDate)) {
            return false;
        }
        if (!Objects.equals(this.directorsName, other.directorsName)) {
            return false;
        }
        if (!Objects.equals(this.rating, other.rating)) {
            return false;
        }
        return true;
    }
}