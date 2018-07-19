/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.superherosightings.dto;

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
public class SuperHero {

    private int superHeroID;
    @NotEmpty(message = "You must supply a value for Name.")
    @Length(max = 50, message = "Name must be no more than 150 characters in length.")
    private String name;
    @NotEmpty(message = "You must supply a value for Description.")
    @Length(max = 50, message = "Description must be no more than 150 characters in length.")
    private String description;
 //   private int superPowerID;

    
    private List<SuperPower> superPowers = new ArrayList<>();
    //// could I use int superPowerID as a unique identifier and chage this list
    ///// and orgMemberships to a List<Integer> ?
  //  private List<Organization> orgMemberships = new ArrayList<>(); 
    /// could this be an int

}