SELECT LastName, FirstName, TerritoryID
FROM Employees
RIGHT JOIN EmployeeTerritories ON EmployeeTerritories.EmployeeID = Employees.EmployeeID;

SELECT *
FROM Orders
RIGHT JOIN Order_Details ON Orders.OrderID = Order_Details.OrderID;

Select *
From products
LEFT JOIN order_details ON products.ProductID = order_details.ProductID
LEFT JOIN orders ON orders.OrderID = order_details.OrderID
 WHERE ProductName = 'Chai';
 
 