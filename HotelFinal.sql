DROP DATABASE IF EXISTS Hotel;

CREATE DATABASE Hotel;

USE Hotel;

CREATE TABLE Hotel.Reservation
(ReservationID INT NOT NULL AUTO_INCREMENT, 
CustomerID INT NOT NULL,
StayDateStart DATE NOT NULL,
StayDateEnd DATE NOT NULL,
StayLengthDays INT NOT NULL,
ReservationName VARCHAR(50) NOT NULL, 
Promotion INT NULL,
PRIMARY KEY(ReservationID),
KEY CustomerID(CustomerID),
INDEX ReservationName(ReservationName),
INDEX StayDateStart(StayDateStart),
INDEX StayDateEnd(StayDateEnd),
INDEX StayLengthDays(StayLengthDays),
KEY Promotion(Promotion));

CREATE TABLE Hotel.CustomerInformation
(CustomerID INT NOT NULL AUTO_INCREMENT, 
CustomerName VARCHAR(150) NOT NULL,
CustomerBirthYear DATE NOT NULL, 
CustomerPhone VARCHAR(50) NOT NULL,
CustomerEmail VARCHAR(45) NOT NULL,
PRIMARY KEY(CustomerID),
INDEX CustomerName(CustomerName),
INDEX CustomerPhone(CustomerPhone), 
INDEX CustomerEmail(CustomerEmail));

CREATE TABLE Hotel.Guests
(GuestID INT NOT NULL, 
GuestName VARCHAR(150) NOT NULL,
GuestBirthYear INT NOT NULL,
PRIMARY KEY(GuestID), 
INDEX GuestName(GuestName),
INDEX GuestBirthYear(GuestBirthYear));

CREATE TABLE Hotel.Amenity
(AmenityID INT NOT NULL, 
AmenityName VARCHAR(150) NOT NULL,
PRIMARY KEY(AmenityID), 
INDEX AmenityName(AmenityName));

CREATE TABLE Hotel.RoomType
(RoomTypeID INT NOT NULL,
RoomTypeName VARCHAR(50) NOT NULL, 
RateType VARCHAR(20) NOT NULL, 
RoomOccupancy INT NOT NULL,
PRIMARY KEY RoomTypeID(RoomTypeID),
INDEX RoomTypeName(RoomTypeName), 
INDEX RateType(RateType));

CREATE TABLE Hotel.RoomRate
(RoomRateID INT NOT NULL AUTO_INCREMENT, 
Season VARCHAR(50) NOT NULL, 
RateItself FIXED(6,2) UNSIGNED NULL,
Amenities INT NOT NULL,
PRIMARY KEY(RoomRateID),
INDEX Season (Season),
INDEX RateItself(RateItself),
KEY Amenities(Amenities));

CREATE TABLE Hotel.RoomInformation
(RoomID INT NOT NULL AUTO_INCREMENT, 
RoomRateID INT NOT NULL,
BedSize VARCHAR(10) NOT NULL,
RoomOccupancy INT NOT NULL,
PRIMARY KEY(RoomID), 
KEY RoomRateID(RoomRateID),
INDEX BedSize(BedSize), 
INDEX RoomOccupancy(RoomOccupancy));


CREATE TABLE Hotel.RoomInformation_Has_Reservation
(RoomReservationID INT NOT NULL,
RoomID INT NOT NULL , 
ReservationID INT NOT NULL,
PRIMARY KEY RoomReservationID(RoomReservationID),
KEY RoomID(RoomID),
KEY ReservationID(ReservationID));


CREATE TABLE Hotel.Promotions
(PromotionID INT NOT NULL, 
PromotionName VARCHAR(20) NOT NULL,
PromotionDateStart DATE NULL,
PromotionDateEnd DATE NULL,
FlatRate INT NULL, 
PercentageRate FIXED(4,2) UNSIGNED NULL,
PRIMARY KEY(PromotionID),
INDEX PromotionName(PromotionName),
INDEX PromotionDateStart(PromotionDateStart),
INDEX PromotionDateEnd(PromotionDateEnd),
INDEX FlatRate(FlatRate),
INDEX PercentageRate(PercentageRate));

CREATE TABLE Hotel.AddOns
(AddOnID INT NOT NULL, 
AddOnName VARCHAR(25) NULL, 
ID INT NOT NULL,
Price FIXED(4,2) UNSIGNED NULL,
PRIMARY KEY(AddOnID),
INDEX AddOnName(AddOnName),
KEY ID(ID),
INDEX Price(Price));

CREATE TABLE Hotel.Bill
(BillID INT NOT NULL AUTO_INCREMENT, 
ReservationID INT NOT NULL,
TaxInfo FIXED(6,2) UNSIGNED NULL,
Total INT NULL,
PRIMARY KEY(BillID),
KEY ReservationID(ReservationID), 
INDEX TaxInfo(TaxInfo),
INDEX Total(Total));

CREATE TABLE Hotel.Addons_to_Bill_Details
(ID INT NOT NULL, 
TheTabID INT NOT NULL,
AddOnID INT NOT NULL,
PRIMARY KEY (ID),
KEY TheTabID(TheTabID),
KEY AddonID(AddOnId));

CREATE TABLE Hotel.Guest_Reservation
(GuestResID INT NOT NULL AUTO_INCREMENT, 
Guest INT NOT NULL,
Reservation INT NOT NULL,
PRIMARY KEY (GuestResID),
KEY Guest(Guest),
KEY Reservation(Reservation));

CREATE TABLE Hotel.Rate_Type
(RateTypeID INT NOT NULL AUTO_INCREMENT, 
RoomTypeID INT NOT NULL,
RoomRateID INT NOT NULL,
PRIMARY KEY (RateTypeID),
KEY RoomTypeID(RoomTypeID),
KEY RoomRateID(RoomRateID));


CREATE TABLE Hotel.Bill_Details
(TheTabID INT NOT NULL AUTO_INCREMENT,
BillID INT NOT NULL,
ID INT NOT NULL,
Cleaning FIXED(4,2) UNSIGNED NULL,
LateCheckout FIXED(4,2) UNSIGNED NULL,
PRIMARY KEY(TheTabID), 
KEY BillID(BillID),
KEY ID(ID),
INDEX Cleaning(Cleaning),
INDEX LateCheckout(LateCheckout));

ALTER TABLE Hotel.RoomInformation
ADD CONSTRAINT fk_RoomInformation_RoomRate
FOREIGN KEY (RoomRateID) REFERENCES Hotel.RoomRate(RoomRateID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.RoomRate
ADD CONSTRAINT fk_RoomType_Amenities
FOREIGN KEY (Amenities) REFERENCES Hotel.Amenity(AmenityID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Rate_Type
ADD CONSTRAINT fk_Rate_Type_RoomType
FOREIGN KEY (RoomTypeID) REFERENCES Hotel.RoomType(RoomTypeID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Rate_Type
ADD CONSTRAINT fk_Rate_Type_RoomRate
FOREIGN KEY (RoomRateID) REFERENCES Hotel.RoomRate(RoomRateID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.RoomInformation_Has_Reservation
ADD CONSTRAINT fk_RoomInformation_Has_Reservation_Reservation
FOREIGN KEY (ReservationID) REFERENCES Hotel.Reservation(ReservationID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.RoomInformation_Has_Reservation
ADD CONSTRAINT fk_RoomInformation_Has_Reservation_RoomInformation
FOREIGN KEY (RoomID) REFERENCES Hotel.RoomInformation(RoomID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Addons
ADD CONSTRAINT fk_Addons_AddOns_to_Bill_Details
FOREIGN KEY (ID) REFERENCES Hotel.Addons_to_Bill_Details(ID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Reservation
ADD CONSTRAINT fk_Reservation_Promotions
FOREIGN KEY (Promotion) REFERENCES Hotel.Promotions(PromotionID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Bill_Details
ADD CONSTRAINT fk_Bill_Details_Addons_to_Bill_Details
FOREIGN KEY (ID) REFERENCES Hotel.Addons_to_Bill_Details(ID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Reservation
ADD CONSTRAINT fk_Reservation_CustomerInformation
FOREIGN KEY (CustomerID) REFERENCES Hotel.CustomerInformation(CustomerID) ON DELETE NO ACTION ON UPDATE NO ACTION ;

ALTER TABLE Hotel.Guest_Reservation
ADD CONSTRAINT fk_Guest_Reservation_Guests
FOREIGN KEY (Guest) REFERENCES Hotel.Guests(GuestID);

ALTER TABLE Hotel.Guest_Reservation
ADD CONSTRAINT fk_Guest_Reservation_Reservation
FOREIGN KEY (Reservation) REFERENCES Hotel.Reservation(ReservationID);

ALTER TABLE Hotel.Bill
ADD CONSTRAINT fk_Bill_Reservation
FOREIGN KEY (ReservationID) REFERENCES Hotel.Reservation(ReservationID) ON DELETE NO ACTION ON UPDATE NO ACTION;

ALTER TABLE Hotel.Bill_Details
ADD CONSTRAINT fk_Bill_Details_Bill
FOREIGN KEY (BillID) REFERENCES Hotel.Bill(BillID) ON DELETE NO ACTION ON UPDATE NO ACTION ;


INSERT INTO CustomerInformation (CustomerID, CustomerName , CustomerBirthYear, CustomerPhone, CustomerEmail)
VALUES (1,'Odysseus', '1990-04-01', 15026487428, 'IthacaBoy@aol.com'),
(2, 'Theseus', '1985-02-18', 15022227428, 'MinataurMangler@gmail.com'),
(3, 'Mopsus', '1970-03-02', 18123334533, 'IonianBro@gmail.com'),
(4, 'Ajax', '1990-03-02', 12124567844, 'TelemonianDude@gmail.com'),
(5, 'Clytemnestra', '1983-03-12', 12024527844, 'HusbandKillingLady@hotmail.com'),
(6, 'Ideomenos','1971-01-23', 15024567844, 'DaKingOfCrete@hotmail.com'),
(7, 'Cassandra', '1970-11-02', 17154567844, 'WhyDontNoOneListen@hotmail.com'),
(8, 'Andromache', '1985-03-17', 12121537844, 'HectorsWife@hotmail.com'),
(9, 'Atalanta', '1981-12-01', 15554567844,'HuntingHeroine@hotmail.com'),
(10, 'Penelope','1970-03-02', 14324567844, 'SuperLoyalWife@hotmail.com'),
(11, 'Hipponax','1971-06-07', 12124566766, 'TheOriginalEminem@aol.com'),
(12, 'Sappho', '1991-03-01', 10654567844, 'PoetLady@hotmail.com'),
(13, 'Nestor', '1993-03-25', 13144567844, 'WiseGuy@hotmail.com'),
(14, 'Polynikes', '1983-02-02', 1-222-459-7844, 'MessingWithThebes@hotmail.com'),
(15, 'Crito', '1983-01-19', 1-412-453-3844, 'SocratesFriend@hotmail.com'),
(16, 'Pentheus', '1986-03-19', 1-555-456-7844,'MessedWithBacchus@hotmail.com'),
(17, 'Horatius Cocles','1950-03-08', 1-502-456-7814, 'MilvianBridgeGuy@hotmail.com'),
(18, 'Remus','1963-05-02', 1-812-358-6766, 'MyBrotherSucks@aol.com'),
(19, 'Corinna', '1964-07-02', 1-065-456-7844, 'ThebanPoetess@hotmail.com'),
(20, 'Orpheus', '1979-03-02', 1-812-456-6329, 'HarpPlayinGuy@hotmail.com');

INSERT INTO Guests (GuestID, GuestName, GuestBirthYear)
VALUES (1, 'Eurybates', 1991),
(2, 'Tacitus', 1985),
(3, 'Ennius', 1987),
(4, 'Plinius', 1988),
(5, 'Lucius Julius Caesar', 1993),
(6, 'Gaius Julius Caesar', 1994),
(7, 'Publius Licinius Crassus', 1995),
(8, 'Croesus', 1992),
(9, 'Anaximander', 1983),
(10,  'Thales', 1992),
(11, 'Tou Hero Alexandrou', 1989),
(12, 'Anaxagoras', 1990),
(13, 'Epaminandas', 1992),
(14, 'Xenophones', 1994),
(15, 'Antonius Pius', 1990),
(16, 'Livia Drusillia', 1988),
(17,'Julia Agripinna', 1990),
(18,'Tireseas', 1991),
(19, 'Simonides', 1988),
(20, 'Aulus Antonius', 1990);


INSERT INTO Addons_to_Bill_Details(ID, TheTabID, AddOnID)
VALUES(1, 1, 18),
(2, 2, 18),
(3, 3, 17),
(4, 4, 2),
(5, 5, 4),
(6, 6, 5),
(7, 7, 18),
(8, 8, 18),
(9, 9, 18),
(10, 10, 18),
(11, 11, 18),
(12, 12, 18),
(13, 13, 4),
(14, 15, 4),
(15, 15, 1),
(16, 16, 2),
(17, 17, 8),
(18, 18, 9),
(19, 19, 10),
(20, 20, 11);

INSERT INTO AddOns (AddOnID, AddOnName, ID, Price)
VALUES(1, 'Lemon Bars', 1, 2.50),
(2, 'Tiramasu', 2, 3.50),
(3, 'Fresh Pugliese Loaf', 3, 4.00),
(4, 'Humus with Pita Bread', 4,  4.50),
(5, 'Athenian Chicken', 5, 7.50),
(6, 'Gyro', 6, 5.50),
(7, 'Girlouk', 7, 5.00),
(8, 'House Red Wine: Glass', 8, 3.50),
(9, 'House White Wine: Glass', 9, 3.50),
(10, 'House Red Wine: Bottle', 10, 8.50),
(11, 'House White Wine: Bottle', 11, 7.50),
(12, 'Bacon and Eggs', 12, 6.00),
(13, 'Veggie Omlet', 13, 6.50),
(14, 'Orange Juice', 14, 0.50),
(15, 'Black Coffee', 15, 1.00),
(16, 'Dates', 16, 1.00),
(17, 'Figs', 17, 1.00),
(18, 'Nothing', 18, 0),
(19, 'Houlmi Cheese', 19, 1.00),
(20, 'Houriatiki', 20, 4.00);




INSERT INTO RoomType(RoomTypeID, RoomTypeName, RateType, RoomOccupancy)
VALUES(1, 'Regina', 'Seasonal',  1),
(2, 'Duo Regina', 'Seasonal',  2),
(3, 'Rex', 'Seasonal', 2),
(4, 'Duo Reges', 'Seasonal', 4),
(5, 'Imperator', 'Seasonal', 6),
(6, 'Regina', 'Out Of Season',  1),
(7,'Duo Regina', 'Out of Season',  2),
(8, 'Rex', 'Out of Season', 2),
(9,'Duo Reges', 'Out of Season', 4),
(10,'Imperator', 'Out of Season',  6),
(11,'Regina', 'Seasonal', 1),
(12,'Duo Regina', 'Seasonal', 2),
(13,'Rex', 'Seasonal',  2),
(14,'Duo Reges', 'Seasonal',  4),
(15,'Imperator', 'Seasonal',  6),
(16,'Regina', 'Out Of Season',  1),
(17,'Duo Regina', 'Out of Season',  2),
(18,'Rex', 'Out of Season', 2),
(19,'Duo Reges', 'Out of Season',  4),
(20,'Imperator', 'Out of Season',  6);


INSERT INTO Amenity(AmenityID, AmenityName)
VALUES (1, 'none'),
(2, 'Freezer'),
(3, 'Minibar'),
(4, 'Oven'),
(5, 'Stove and Oven');

INSERT INTO RoomRate(RoomRateID, Season, RateItself, Amenities)
Values(1, 'Peak Rate',  1000.00, 1),
(2, 'Peak Rate',  1200.00, 2),
(3, 'Peak Rate',  1400.00 , 3),
(4, 'Peak Rate', 1600.00, 4),
(5, 'Peak Rate', 1900.00, 5),
(6, 'Slow Rate',  800.00, 1),
(7, 'Slow Rate',  1000.00, 2),
(8, 'Slow Rate',  1200.00, 3),
(9, 'Slow Rate',  1400.00, 4),
(10, 'Slow Rate',  1600.00, 5),
(11, 'Peak Rate',  1000.00, 1),
(12, 'Peak Rate',  1200.00, 2),
(13, 'Peak Rate',  1400.00, 3),
(14, 'Peak Rate',  1600.00, 4),
(15, 'Peak Rate',  1900.00, 5),
(16, 'Event Rate',  1200.00, 1),
(17, 'Event Rate', 1400.00, 2),
(18,'Event Rate',  1600.00, 3),
(19, 'Event Rate', 1800.00, 4),
(20, 'Event Rate',  2000.00, 5);

INSERT INTO Rate_Type (RateTypeID, RoomTypeID, RoomRateID)
VALUES(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 14),
(16, 16, 15),
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20);


INSERT INTO RoomInformation(RoomID, RoomRateID, BedSize, RoomOccupancy)
VALUES(1, 1, 'Queen', 1),
(2,  2, 'Queen', 2),
(3,  3, 'King', 2),
(4,   4, 'King', 4),
(5,   5, 'King Plus', 6),
(6,  6, 'Queen', 1),
(7,  7, 'Queen', 1),
(8,  8, 'Queen', 2),
(9,  9, 'King', 4),
(10,  10, 'Queen', 1),
(11,  11, 'King', 4),
(12,  12, 'King', 4),
(13,  13, 'Queen', 2),
(14, 14, 'Queen', 2),
(15,  15, 'Queen', 1),
(16,  16, 'Queen', 1),
(17,  17, 'Queen', 1),
(18,  18, 'Queen', 1),
(19,  19, 'Queen', 1),
(20,  20, 'Queen', 1);

INSERT INTO Promotions (PromotionID, PromotionName, PromotionDateStart, PromotionDateEnd, FlatRate, PercentageRate)
VALUES(1, 'Saturnalia', '2018-12-17', '2018-12-24', 40.00, NULL),
(2, 'Feast of Minerva', '2018-03-19', '2018-03-20', NULL, 00.15),
(3, 'Volturnalia','2018-08-27', '2018-08-28',  NULL, 00.25),
(4, 'Corporate Function', '2018-12-25', '2018-12-26', 40.00, NULL),
(5, 'none', NULL , NULL, 0, 0);

INSERT INTO Reservation (ReservationID, CustomerID,  ReservationName, StayDateStart, StayDateEnd, StayLengthDays, Promotion)
VALUES (1, 1, 1,  '2018-05-12', '2018-05-16', 4, 5),
(2, 2, 2,  '2018-03-12', '2018-03-13', 1, 2),
(3, 3, 3,  '2018-03-12', '2018-03-14', 2, 2),
(4, 4, 4,  '2018-04-08', '2018-04-12', 4, 4),
(5, 5, 5,  '2018-11-04', '2018-11-04', 6, 4),
(6, 6, 6, '2018-03-12', '2018-03-12', 2, 2),
(7, 7, 7, '2018-11-04', '2018-11-12', 8, 5),
(8, 8, 8,  '2018-11-04', '2018-11-08', 4, 5),
(9, 9, 9,  '2018-07-04', '2018-07-07', 3, 5),
(10, 10, 10 , '2018-04-01', '2018-04-01', 2, 5),
(11, 11, 11, '2018-04-10', '2018-04-20',10, 5),
(12, 12, 12,  '2018-04-12', '2018-04-12', 2, 5),
(13, 13, 13, '2018-05-06', '2018-05-07', 1, 5),
(14, 14, 14,  '2018-08-11', '2018-08-14', 3, 3),
(15, 15, 15, '2018-04-11', '2018-04-15', 4, 5),
(16, 16, 16, '2018-04-17', '2018-04-17', 3, 5),
(17, 17, 17, '2018-12-17', '2018-04-22', 5, 1),
(18, 18, 18, '2018-09-09', '2018-09-10', 1, 5),
(19, 19, 19, '2018-03-02', '2018-03-10', 8, 2),
(20, 20, 20, '2018-02-12', '2018-02-21', 9, 5);

INSERT INTO Guest_Reservation(GuestResID, Guest, Reservation)
VALUES (1, 1, 1), 
(2, 2, 2),
(3, 3, 3),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6), 
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11), 
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 15),
(16, 16, 16), 
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20);

INSERT INTO RoomInformation_Has_Reservation (RoomReservationID, RoomID, ReservationID)
VALUES(1, 1, 1),
(2, 2, 1),
(3, 3, 2),
(4, 4, 4),
(5, 5, 5),
(6, 6, 6),
(7, 7, 7),
(8, 8, 8),
(9, 9, 9),
(10, 10, 10),
(11, 11, 11),
(12, 12, 12),
(13, 13, 13),
(14, 14, 14),
(15, 15, 14),
(16, 16, 15),
(17, 17, 17),
(18, 18, 18),
(19, 19, 19),
(20, 20, 20);


INSERT INTO Bill(BillID, ReservationID, TaxInfo, Total)
VALUES(1, 1, 13.00, 1800),
(2, 2, 40.00, 1700),
(3, 3, 32.00, 5000),
(4, 4, 15.00, 7000),
(5, 5, 27.00, 9000),
(6, 6, 25.00, 6000),
(7, 7, 50.00, 7500),
(8, 8, 40.00, 1111),
(9, 9, 100.00, 4300),
(10, 10, 20.00, 3400),
(11, 11, 40.00, 20000),
(12, 12, 20.00, 2900),
(13, 13, 10.00, 18100),
(14, 14, 20.00, 5000),
(15, 15, 20.00, 3400),
(16, 16, 30.00, 13000),
(17, 17, 40.00, 11000),
(18, 18, 18.00, 5000),
(19, 19, 30.00, 920),
(20, 20, 18.00, 1000);


INSERT INTO Bill_Details(TheTabID, BillID, ID, Cleaning, LateCheckout)
VALUES (1, 1, 1, 20, 40), 
(2, 2, 2, 20, 0),
(3, 3, 3, 20, 0),
(4, 4, 4, 20, 40),
(5, 5, 5, 20, 0),
(6, 6, 6 , 20, 0),
(7, 7, 7, 20, 40),
(8, 8, 8, 20, 0),
(9, 9, 9, 20, 3),
(10, 10, 10, 20, 0),
(11, 11, 11, 20, 40),
(12, 12, 12, 20, 0),
(13, 13, 13, 20, 0),
(14, 14, 14, 20, 0),
(15, 15, 15, 20, 0),
(16, 16, 16, 20, 40),
(17, 17, 17, 20, 0),
(18, 18, 18, 20, 0),
(19, 19, 18, 20, 0),
(20, 20, 18, 20, 20);


SELECT *
FROM RoomInformation
INNER JOIN RoomRate ON RoomInformation.RoomRateID = RoomRate.RoomRateID
LEFT JOIN Amenity ON RoomRate.Amenities = Amenity.AmenityID
WHERE AmenityName = 'none';


SELECT *
FROM Reservation
INNER JOIN CustomerInformation ON Reservation.CustomerID = CustomerInformation.CustomerID
INNER JOIN RoomInformation_Has_Reservation ON Reservation.ReservationID = RoomInformation_Has_Reservation.ReservationID
INNER JOIN RoomInformation ON RoomInformation_Has_Reservation.RoomID = RoomInformation.RoomID
INNER JOIN Guest_Reservation ON Reservation.ReservationID = Guest_Reservation.Reservation
LEFT JOIN Guests ON Guest_Reservation.Guest = Guests.GuestID
GROUP BY CustomerName
HAVING CustomerName = 'Odysseus';

SELECT *
FROM Reservation
INNER JOIN CustomerInformation ON Reservation.CustomerID = CustomerInformation.CustomerID
INNER JOIN RoomInformation_Has_Reservation ON Reservation.ReservationID = RoomInformation_Has_Reservation.ReservationID
INNER JOIN RoomInformation ON RoomInformation_Has_Reservation.RoomID = RoomInformation.RoomID
GROUP BY CustomerName
HAVING CustomerName = 'Odysseus';



SELECT *
FROM Bill
LEFT JOIN Bill_Details ON Bill.BillID =  Bill_Details.BillID
ORDER BY Total DESC
LIMIT 0, 3;

SELECT *
FROM Bill
INNER JOIN Bill_Details ON Bill.BillID =  Bill_Details.BillID
LEFT JOIN Reservation ON Bill.ReservationID = Reservation.ReservationID
ORDER BY Total DESC
LIMIT 0, 3;


SELECT *
FROM Promotions
INNER JOIN Reservation ON Promotions.PromotionID = Reservation.Promotion
INNER JOIN Bill ON Reservation.ReservationID = Bill.ReservationID
INNER JOIN Bill_Details ON Bill.BillID =  Bill_Details.BillID;
