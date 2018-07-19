/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dto;

import java.math.BigDecimal;
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
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Organization {

    private int orgID;
    @NotEmpty(message = "You must supply a value for Org Name.")
    @Length(max = 50, message = "Org Name must be no more than 50 characters in length.")
    private String orgName;
    @NotEmpty(message = "You must supply a value for Org Description.")
    @Length(max = 50, message = "Org Description must be no more than 50 characters in length.")
    private String orgDescription;
    @NotEmpty(message = "You must supply a value for Org Address.")
    @Length(max = 50, message = "Org Address must be no more than 50 characters in length.")
    private int locationID;
    
    private Location orgLocation = new Location();
    private List<SuperHero> orgMembers = new ArrayList<>();
    
    

}
