package com.sg.superherosightings.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author JCLog
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Sighting {

    private int sightingID;
    /// do I also need to delcare SuperHero as a property?
    private String date;
    private int locationID; /// maybe just use location
    private Location location = new Location();
    private List<SuperHero> heroList = new ArrayList<>(); // could I just use an  arraylist for this

/// not a constructor, no return type for contructors and it
    // shares the class name
}
