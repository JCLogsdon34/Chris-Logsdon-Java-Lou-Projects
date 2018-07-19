SELECT *
FROM RoomInformation
INNER JOIN RoomRate ON RoomInformation.RoomRateID = RoomRate.RoomRateID;

SELECT * 
FROM Reservation
INNER JOIN CustomerInformation ON CustomerInformation.CustomerID = Reservation.CustomerID;


SELECT *
FROM Bill_Details
LEFT JOIN Bill ON Bill_Details.BillID =  Bill.BillID;

SELECT *
FROM Bill
LEFT JOIN Bill_Details ON Bill.BillID =  Bill_Details.BillID
ORDER BY Total DESC
LIMIT 0, 3;

SELECT *
FROM RoomInformation
INNER JOIN RoomRate ON RoomInformation.RoomRateID = RoomRate.RoomRateID
INNER JOIN RoomType ON RoomInformation.RoomTypeID = RoomType.RoomTypeID
HAVING Amenities = 'none';

SELECT *
FROM Reservation
INNER JOIN CustomerInformation ON Reservation.CustomerID =  CustomerInformation.CustomerID
LEFT JOIN RoomInformation_Has_Reservation ON Reservation.ReservationID = RoomInformation_Has_Reservation.ReservationID
HAVING CustomerName = 'Odysseus';

SELECT *
FROM Bill
INNER JOIN Bill_Details ON Bill.BillID =  Bill_Details.BillID
INNER JOIN Bill on Reservation.BillID = Bill.BillID
INNER JOIN CustomerInformation on Reservation.CustomerID = CustomerInformation.CustomerID
ORDER BY Total DESC
LIMIT 0, 3;

SELECT *
FROM CustomerInformation
LEFT JOIN Bill ON Bill.CustomerID = CustomerInformation.CustomerID;

SELECT *
FROM Promotions
INNER JOIN Bill ON Promotions.PromotionID = Bill.PromotionID;
