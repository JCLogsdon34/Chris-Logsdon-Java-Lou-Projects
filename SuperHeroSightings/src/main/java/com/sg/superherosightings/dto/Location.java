/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
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
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Location {
    
    
    private int locationID;
    @NotEmpty(message = "You must supply a value for Location Name.")
    @Length(max = 50, message = "Location Name must be no more than 50 characters in length.")
    private String locationName;
    @NotEmpty(message = "You must supply a value for Address.")
    @Length(max = 50, message = "Address must be no more than 50 characters in length.")
    private String address;
    @NotEmpty(message = "You must supply a value for Longitude.")
    @Length(max = 50, message = "Longitude must be no more than 50 characters in length.")
    private BigDecimal longitude;
    @NotEmpty(message = "You must supply a value for Latitude.")
    @Length(max = 50, message = "Latitude must be no more than 50 characters in length.")
    private BigDecimal latitude; // add long and lat
    
}