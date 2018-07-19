DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel;

USE Hotel;

CREATE TABLE Reservation
(ReservationID INT NOT NULL AUTO_INCREMENT, 
CustomerID INT NOT NULL, 
RoomID INT NOT NULL,
StayLengthDays INT NOT NULL,
StayDate DATE Not NULL,
ReservationName VARCHAR(50) NOT NULL, 
PRIMARY KEY(ReservationID),
INDEX CustomerID(CustomerID),
INDEX ReservationName(ReservationName),
INDEX StayDate(StayDate),
INDEX StayLengthDays(StayLengthDays));

CREATE TABLE CustomerInformation
(CustomerID INT NOT NULL AUTO_INCREMENT, 
CustomerName VARCHAR(150) NOT NULL,
CustomerBirthYear DATE NOT NULL, 
CustomerPhone VARCHAR(50) NOT NULL,
CustomerEmail VARCHAR(45) NOT NULL,
PRIMARY KEY(CustomerID), 
INDEX CustomerName(CustomerName),
INDEX CustomerPhone(CustomerPhone), 
INDEX CustomerEmail(CustomerEmail));

CREATE TABLE RoomType
(RoomTypeID VARCHAR(20) NOT NULL, 
RateType VARCHAR(20) NOT NULL, 
Amenities VARCHAR(50) NULL,
RoomOccupancy INT NOT NULL,
KEY RoomTypeID(RoomTypeID), 
INDEX RateType(RateType),
INDEX Amenities(Amenities), 
INDEX RoomOccupancy(RoomOccupancy));

CREATE TABLE RoomRate
(RoomRateID INT NOT NULL AUTO_INCREMENT, 
RoomTypeID VARCHAR(20) NOT NULL, 
Season VARCHAR(50) NOT NULL, 
RateItself BIGINT NOT NULL,
PRIMARY KEY(RoomRateID),
KEY RoomTypeID(RoomTypeID),
INDEX Season (Season),
INDEX RateItself(RateItself));

CREATE TABLE RoomInformation
(RoomID INT NOT NULL AUTO_INCREMENT, 
RoomTypeID VARCHAR(20) NOT NULL,
RoomRateID INT NOT NULL,
BedSize VARCHAR(10) NOT NULL,
RoomOccupancy INT NOT NULL,
PRIMARY KEY(RoomID), 
KEY RoomTypeID(RoomTypeID), 
KEY RoomRateID(RoomRateID),
INDEX BedSize(BedSize), 
INDEX RoomOccupancy(RoomOccupancy));


CREATE TABLE RoomInformation_Has_Reservation
(RoomID INT NOT NULL , 
ReservationID INT NOT NULL,
KEY(RoomID),
KEY ReservationID(ReservationID));


CREATE TABLE Hotel
(HotelID VARCHAR(15) NOT NULL, 
Rooms INT NOT NULL, 
Floors INT NOT NULL,
Location VARCHAR(25) NOT NULL,
Primary KEY(HotelID));


CREATE TABLE Promotions
(PromotionID INT NOT NULL, 
PromotionName VARCHAR(20) NOT NULL,
PromotionDateStart DATE NULL,
PromotionDateEnd DATE NULL,
FlatRate INT NULL, 
PercentageRate INT NULL,
PRIMARY KEY(PromotionID),
INDEX PromotionName(PromotionName),
INDEX FlatRate(FlatRate),
INDEX PercentageRate(PercentageRate));

CREATE TABLE AddOns
(AddOnID INT NOT NULL, 
AddOnName VARCHAR(25) NULL, 
ID INT NOT NULL,
Price BIGINT NULL,
PRIMARY KEY(AddOnID),
INDEX AddOnName(AddOnName),
INDEX ID(ID),
INDEX RoomServicePrice(Price));

CREATE TABLE Bill
(BillID INT NOT NULL AUTO_INCREMENT, 
ReservationID INT NOT NULL,
PromotionID INT NOT NULL,
TaxInfo BIGINT NOT NULL,
Total BIGINT NOT NULL,
PRIMARY KEY(BillID),
INDEX ReservationID(ReservationID), 
INDEX PromotionID(PromotionID),
INDEX TaxInfo(TaxInfo),
INDEX Total(Total));

CREATE TABLE Addons_to_Bill_Details
(ID INT NULL, 
TheTabID INT NOT NULL,
AddOnID INT NOT NULL,
UNIQUE (ID),
KEY TheTabID(TheTabID),
KEY AddonID(AddOnId));


CREATE TABLE Bill_Details
(TheTabID INT NOT NULL AUTO_INCREMENT,
BillID INT NOT NULL,
ID INT NOT NULL,
Cleaning INT NOT NULL,
LateCheckout INT NULL,
PRIMARY KEY(TheTabID), 
INDEX BillID(BillID),
INDEX ID(ID));

ALTER TABLE RoomInformation
ADD CONSTRAINT fk_RoomInformation_RoomRate
FOREIGN KEY (RoomRateID) REFERENCES RoomRate(RoomRateID);

ALTER TABLE RoomRate
ADD CONSTRAINT fk_RoomRate_RoomType
FOREIGN KEY (RoomTypeID) REFERENCES RoomType(RoomTypeID);

ALTER TABLE RoomInformation_Has_Reservation
ADD CONSTRAINT fk_Room_Has_Reservation_Reservation
FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID);

ALTER TABLE Addons_to_Bill_Details
ADD CONSTRAINT fk_Addons_to_Bill_Details_Bill_Details
FOREIGN KEY (TheTabID) REFERENCES Bill_Details(TheTabID);

ALTER TABLE Reservation
ADD CONSTRAINT fk_Reservation_RoomInformation
FOREIGN KEY (RoomID) REFERENCES RoomInformation(RoomID);

ALTER TABLE Reservation 
ADD CONSTRAINT fk_Reservation_CustomerInformation
FOREIGN KEY (CustomerID) REFERENCES CustomerInformation(CustomerID);

ALTER TABLE Bill
ADD CONSTRAINT fk_Bill_Reservation
FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID);

ALTER TABLE Promotions
ADD COLUMN PromotionDate DATE,
ADD COLUMN PromotionEndDate DATE;

ALTER TABLE Bill_Details
ADD CONSTRAINT fk_Bill_Details_Bill
FOREIGN KEY (BillID) REFERENCES Bill(BillID);

ALTER TABLE Bill
ADD CONSTRAINT fk_Bill_Promotions
FOREIGN KEY (PromotionID) REFERENCES Promotions(PromotionID);