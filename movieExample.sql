SET SQL_SAFE_UPDATES = 0;

DROP DATABASE IF EXISTS SWCCorp;

CREATE DATABASE IF NOT EXISTS MovieCatalogue;

USE MovieCatalogue;
 



create table MovieCatalogue.CastMembers(
   CastMemberID INT(20) NOT NULL auto_increment,
   ActorID VARCHAR(50) NOT NULL,
   MovieID VARCHAR(50) NOT NULL,
   Role VARCHAR(50) NOT NULL,
    PRIMARY KEY (CastMemberID)
);