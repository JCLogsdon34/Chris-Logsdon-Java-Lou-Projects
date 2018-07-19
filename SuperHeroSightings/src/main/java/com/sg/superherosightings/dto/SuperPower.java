package com.sg.superherosightings.dto;

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
public class SuperPower {

    private int superPowerID;
    @NotEmpty(message = "You must supply a value for Name.")
    @Length(max = 50, message = "Name must be no more than 50 characters in length.")
    private String name;
    @NotEmpty(message = "You must supply a value for Descrption.")
    @Length(max = 150, message = "Description must be no more than 150 characters in length.")    
    private String description;

}
