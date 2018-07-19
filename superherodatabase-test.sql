
DROP DATABASE IF EXISTS SuperHerostest;

CREATE DATABASE SuperHerostest;

USE Superherostest;

CREATE TABLE IF NOT EXISTS `heros` (
 `superHeroID` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(50) NOT NULL,
 `description` varchar(150) NOT NULL,
 PRIMARY KEY (`superHeroID`),
 INDEX `name` (`name`),
  INDEX `description`(`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `superpowers` (
 `superPowerID` int(11) NOT NULL AUTO_INCREMENT,
 `name` varchar(50) NOT NULL,
 `description` varchar(150) NOT NULL,
 PRIMARY KEY (`superPowerID`),
 INDEX `name`(`name`),
 INDEX `description`(`description`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `locations` (
 `locationID` int(11) NOT NULL AUTO_INCREMENT,
 `locationName` varchar(100) NOT NULL,
 `address` varchar(150) NOT NULL,
 `longitude` FIXED(6,4) UNSIGNED NOT NULL,
 `latitude` FIXED(6,4) UNSIGNED NOT NULL,
 PRIMARY KEY (`locationID`),
 INDEX `locationName`(`locationName`),
 INDEX `address`(`address`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1;

CREATE TABLE IF NOT EXISTS `sightings` (
 `sightingID` int(11) NOT NULL AUTO_INCREMENT,
 `sightingDate` varchar(50) NULL,
 `location` int(11) NOT NULL,
 PRIMARY KEY (`sightingID`),
 INDEX `sightingDate` (`sightingDate`),
 KEY `location_idx` (`location`),
 CONSTRAINT `fk_sightings_locations` FOREIGN KEY (`location`) REFERENCES `locations`(`locationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE IF NOT EXISTS `organizations` (
 `orgID` int(11) NOT NULL AUTO_INCREMENT,
 `orgName` varchar(50) NOT NULL,
 `orgDescription` varchar(150) NOT NULL,
 `locationID` int(11) NOT NULL,
 PRIMARY KEY (`orgID`),
 INDEX  `orgName` (`orgName`),
  KEY `locationID_idx` (`locationID`),
 CONSTRAINT `fk_organizations_locations` FOREIGN KEY (`locationID`) REFERENCES `locations`(`locationID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;


CREATE TABLE IF NOT EXISTS `superhero_organization` (
 `heroOrgID` int(11) NOT NULL AUTO_INCREMENT,
 `superHeroID` int(11) NOT NULL,
 `orgID` int(11) NOT NULL,
 PRIMARY KEY(`heroOrgID`),
 KEY `fk_superhero_organization_heros_idx` (`superHeroID`),
 KEY `fk_superhero_organization_organizations_idx` (`orgID`),
 CONSTRAINT `fk_superhero_organization_heros` FOREIGN KEY (`superHeroID`) REFERENCES `heros`(`superHeroID`) ,
 CONSTRAINT `fk_superhero_organization_organizations` FOREIGN KEY (`orgID`) REFERENCES `organizations`(`orgID`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE IF NOT EXISTS `superhero_superpower` (
 `heroPowerID` int(11) NOT NULL AUTO_INCREMENT,
 `superHeroID` int(11) NOT NULL,
 `superPowerID` int(11) NOT NULL,
 PRIMARY KEY  `heroPowerID`(`heroPowerID`),
 KEY `fk_superhero_superpower_heros_idx` (`superHeroID`),
 KEY `fk_superhero_superpower_superpowers_idx` (`superPowerID`),
 CONSTRAINT `fk_superhero_superpower_heros` FOREIGN KEY (`superHeroID`) REFERENCES `heros`(`superHeroID`) ,
 CONSTRAINT `fk_superhero_superpower_superpowers` FOREIGN KEY (`superPowerID`) REFERENCES `superpowers`(`superPowerID`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


CREATE TABLE IF NOT EXISTS `superhero_has_sighting` (
 `heroSightingID` int(11) NOT NULL AUTO_INCREMENT,
 `superHeroID` int(11) NOT NULL,
 `sightingID` int(11) NOT NULL,
 PRIMARY KEY (`heroSightingID`),
 KEY `fk_superhero_has_sighting_heros_idx` (`superHeroID`),
 KEY `fk_superhero_has_sighting_sightings_idx` (`sightingID`),
 CONSTRAINT `fk_superhero_has_sighting_heros` FOREIGN KEY (`superHeroID`) REFERENCES `heros`(`superHeroID`) ,
 CONSTRAINT `fk_superhero_has_sighting_sightings` FOREIGN KEY (`sightingID`) REFERENCES `sightings`(`sightingID`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;