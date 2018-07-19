USE sgroster;
 
CREATE TABLE Cohort
(
   CohortID INT NOT NULL auto_increment,
   StartDate DATE NOT NULL,
   Subject VARCHAR(30) NOT NULL,
   Location VARCHAR(30) NOT NULL,
   PRIMARY KEY (CohortID)
);

CREATE TABLE Apprentice 
(
   ApprenticeID INT NOT NULL auto_increment,
   FirstName VARCHAR(30) NOT NULL,
   LastName VARCHAR(30) NOT NULL,
   CohortID INT NOT NULL,
   PRIMARY KEY(ApprenticeID),
   FOREIGN KEY(CohortID) REFERENCES Cohort(CohortID)
);

INSERT INTO Apprentice (FirstName, LastName)
VALUES ('Bill', 'Smith');

ALTER TABLE Apprentice 
DROP FOREIGN KEY apprentice_ibfk_1;

ALTER TABLE Apprentice 
DROP COLUMN CohortID;

DROP TABLE Apprentice;

CREATE TABLE ApprenticeCohort 
(
    ApprenticeID INT NOT NULL,
    CohortID INT NOT NULL,        
    PRIMARY KEY (ApprenticeID, CohortID)
);

ALTER TABLE ApprenticeCohort
ADD CONSTRAINT fk_ApprenticeCohort_Apprentice 
FOREIGN KEY (ApprenticeID) REFERENCES Apprentice(ApprenticeID);

ALTER TABLE ApprenticeCohort 
ADD CONSTRAINT fk_ApprenticeCohort_Cohort 
FOREIGN KEY (CohortID) REFERENCES Cohort(CohortID);

ALTER TABLE Apprentice 
ADD DateOfBirth DATE not null;

ALTER TABLE Apprentice 
MODIFY COLUMN DateOfBirth DATETIME NULL;

DROP DATABASE SGRoster;
