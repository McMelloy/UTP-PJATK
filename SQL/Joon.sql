
DROP TABLE Basket;
DROP TABLE Purchase;
DROP TABLE Shop;
DROP TABLE Branch;
DROP TABLE Product;
DROP TABLE Employee;
DROP TABLE Customer;

CREATE TABLE Basket (
    Product_Id_Product integer  NOT NULL,
    Purchase_Id_Purchase integer  NOT NULL,
    Amount integer  NOT NULL,
    CONSTRAINT Basket_pk PRIMARY KEY (Product_Id_Product, Purchase_Id_Purchase)
) ;

CREATE TABLE Branch (
    Id_Branch integer  PRIMARY KEY,
    NameOfBranch varchar2(30)  NOT NULL,
    Location varchar2(30)  NOT NULL,
    Address varchar2(30)  NOT NULL
) ;

CREATE TABLE Customer (
    Id_Customer integer  PRIMARY KEY,
    FirstName varchar2(30)  NOT NULL,
    LastName varchar2(30)  NOT NULL,
    Address varchar2(30)  NOT NULL,
    PESEL integer  NOT NULL
) ;

CREATE TABLE Employee (
    Id_Employee integer  PRIMARY KEY,
    FirstName varchar2(30)  NOT NULL,
    LastName varchar2(30)  NOT NULL,
    Salary integer  NOT NULL,
    PESEL integer  NOT NULL,
    Address varchar2(30)  NOT NULL
) ;

CREATE TABLE Product (
    Id_Product integer  PRIMARY KEY,
    Type varchar2(30)  NOT NULL,
    Name varchar2(30)  NOT NULL,
    Exp_Date date,
    Price integer  NOT NULL,
    Barcode integer  NOT NULL
) ;

CREATE TABLE Purchase (
    Id_Purchase integer  PRIMARY KEY,
    TotalPayment integer  NOT NULL,
    PTime TIMESTAMP(2),
    Id_Customer integer  NOT NULL,
    Employee_Id_Employee integer  NOT NULL,
    Shop_IdShop varchar2(30)  NOT NULL
) ;

CREATE TABLE Shop (
    IdShop varchar2(30)  PRIMARY KEY,
    NameOfShop varchar2(30)  NOT NULL,
    Location integer  NOT NULL,
    Id_Branch integer  NOT NULL
) ;

-- foreign keys
ALTER TABLE Basket ADD CONSTRAINT Basket_Product
    FOREIGN KEY (Product_Id_Product)
    REFERENCES Product (Id_Product);

ALTER TABLE Basket ADD CONSTRAINT Basket_Purchase
    FOREIGN KEY (Purchase_Id_Purchase)
    REFERENCES Purchase (Id_Purchase);

ALTER TABLE Purchase ADD CONSTRAINT Purchase_Customer
    FOREIGN KEY (Id_Customer)
    REFERENCES Customer (Id_Customer);

ALTER TABLE Purchase ADD CONSTRAINT Purchase_Employee
    FOREIGN KEY (Employee_Id_Employee)
    REFERENCES Employee (Id_Employee);

ALTER TABLE Purchase ADD CONSTRAINT Purchase_Shop
    FOREIGN KEY (Shop_IdShop)
    REFERENCES Shop (IdShop);

ALTER TABLE Shop ADD CONSTRAINT Store_Branch
    FOREIGN KEY (Id_Branch)
    REFERENCES Branch (Id_Branch);


-- inserting everything
INSERT INTO Branch VALUES(1,'Zlote tarasy','Warsaw','Jana Pawla II');
INSERT INTO Branch VALUES(2,'Blue City','Warsaw','Jerozolimskie');
INSERT INTO Branch VALUES(3,'Alfa','Bialystok','Swietojanska');

INSERT INTO Shop VALUES('zara','Zara',15,1);
INSERT INTO Shop VALUES('empik','Empik',31,1);
INSERT INTO Shop VALUES('notino','Notino',21,2);
INSERT INTO Shop VALUES('ikea','Ikea',4,2);
INSERT INTO Shop VALUES('pp','Piotr i Pawel',1,2);
INSERT INTO Shop VALUES('ziaja','Ziaja',11,3);

INSERT INTO Employee VALUES(2345,'Tom','Ford',60000,982739,'NY');
INSERT INTO Employee VALUES(1253,'Henry','Ford',120000,625467,'Past');
INSERT INTO Employee VALUES(4836,'Alpha','Beta',2000,369285,'Delta');
INSERT INTO Employee VALUES(3623,'Big','Lebowski',444,123321,'Big House');
INSERT INTO Employee VALUES(9999,'Mr','Devil',666000,666666,'Down Below');
INSERT INTO Employee VALUES(10000,'Lazy','Worker',0,121245,'Homeless');

INSERT INTO Customer VALUES(1,'First','Pancake','Pancake country',776512);
INSERT INTO Customer VALUES(669,'Eugen','Von Geuer','Shanghai',151098);
INSERT INTO Customer VALUES(39778,'Giorno','Giovanna','Italy',870866);
INSERT INTO Customer VALUES(95234,'Ronny','Dio','Metalgrad',124245);
INSERT INTO Customer VALUES(156,'Alberto','Morillas','Perfumery',897665);

INSERT INTO Product VALUES(1234,'Shirt','Cool stylish',NULL,120,687980);
INSERT INTO Product VALUES(1245,'Shirt','Minimalistic',NULL,23,768579);
INSERT INTO Product VALUES(9098,'Book','4-hour workweek',NULL,50,298790);
INSERT INTO Product VALUES(6435,'Book','Cooking with Gordon Ramsay',NULL,50,124123);
INSERT INTO Product VALUES(3456,'Kitchen Knife','Sfjoden',NULL,20,329879);
INSERT INTO Product VALUES(8739,'Fork','Forksdottir',NULL,15,198742);
INSERT INTO Product VALUES(2142,'Perfume','Dior Fahrenheit',NULL,350,325236);
INSERT INTO Product VALUES(8643,'Milk','Ordinary',TO_DATE('25-APR-2019', 'DD-MON-YYYY'),5,124435);
INSERT INTO Product VALUES(867,'Cottage Cheese','With Berries',TO_DATE('15-JUN-2019', 'DD-MON-YYYY'),2,214157);


INSERT INTO Purchase VALUES(90, 622, to_timestamp('25-DEC-2018 12:34:56.78','DD-MON-YYYY HH24:MI:SS.FF'),1,2345,'pp');
INSERT INTO Purchase VALUES(91, 3200, to_timestamp('25-DEC-2018 22:00:14.78','DD-MON-YYYY HH24:MI:SS.FF'),669,1253,'zara');
INSERT INTO Purchase VALUES(12, 622, to_timestamp('21-JAN-2019 12:34:56.78','DD-MON-YYYY HH24:MI:SS.FF'),1,9999,'empik');
INSERT INTO Purchase VALUES(25, 3200, to_timestamp('22-JAN-2019 22:00:14.78','DD-MON-YYYY HH24:MI:SS.FF'),669,3623,'zara');
INSERT INTO Purchase VALUES(46, 25, to_timestamp('23-JAN-2019 15:41:33.78','DD-MON-YYYY HH24:MI:SS.FF'),39778,1253,'ikea');
INSERT INTO Purchase VALUES(89, 60, to_timestamp('24-JAN-2019 20:12:10.78','DD-MON-YYYY HH24:MI:SS.FF'),669,2345,'pp');

INSERT INTO Basket VALUES(9098,12,1);
INSERT INTO Basket VALUES(6435,12,666);
INSERT INTO Basket VALUES(1234,25,1);
INSERT INTO Basket VALUES(1245,25,1);
INSERT INTO Basket VALUES(3456,46,2);
INSERT INTO Basket VALUES(8739,46,11);
INSERT INTO Basket VALUES(8643,89,3);
INSERT INTO Basket VALUES(867,89,3);


--Query I - Print what was bought in every purchase and amount
SELECT Id_Purchase,Type,Name,Amount
FROM Basket, purchase, product
WHERE Product_Id_Product=Id_Product AND Purchase_Id_Purchase=Id_Purchase
ORDER BY Id_Purchase, Amount;

--Query II - Print those products that were bought in more that one amount
SELECT Type,Name,Amount
FROM Product, basket
WHERE Product_Id_Product=Id_Product
AND amount>1;

--Query III - Print those branches that have more than 2 shops
SELECT NameOfBranch
FROM Branch, Shop
WHERE Branch.Id_Branch=Shop.Id_Branch
GROUP BY NameOfBranch
HAVING Count(IdShop)>2;

--Query IV - Find out what is the average yearly salary we must pay to employees
SELECT AVG(12*NVL(Salary,0)) AS Average
From employee;

--Query V - Print an employees with highest and lowest salaries
SELECT FirstName, LastName, Salary, Address
FROM Employee
WHERE Salary = (SELECT Min(Salary) FROM EMPLOYEE);

--Query VI - Find out who was shopping on Christmas 
SELECT *
FROM customer
Where id_customer in (
SELECT Id_Customer
FROM Purchase
WHERE (PTime)<'25-DEC-2018 11:59:59.00 PM' AND (PTime)>'24-DEC-2018 11:59:59.00 PM' );

--Query VII - Find out who works in empik
SELECT E.FirstName, E.LastName
FROM employee E
WHERE exists(
SELECT Id_Purchase
FROM purchase, shop
WHERE E.Id_Employee=Employee_Id_Employee AND Shop_IdShop=IdShop AND NameOfShop='Empik');

--Query VIII - Print those employees that didn't participate in any purchase
SELECT E.FirstName, E.LastName
FROM employee E
WHERE NOT EXISTS(
SELECT Id_Purchase
FROM purchase
WHERE E.Id_Employee=Employee_Id_Employee);

--Triggers
Set ServerOutput ON
--Before insert - check if we insert price with non-negatite price
CREATE OR REPLACE trigger BeforeInsert
BEFORE INSERT ON Product
FOR EACH ROW
BEGIN
if (:New.Price < 0)
then 
    raise_application_error(-20050,'price cannot be negative!');
end if;
END;

--After insert - count how much customers we have now
create or replace trigger AfterInsert
after insert on Customer
Declare c integer;
Begin
select count(Id_Customer) into c
from Customer;
DBMS_output.put_line(c);
End;

--Before delete - delete basket before deleting purchase
CREATE OR REPLACE TRIGGER BeforeDelete
Before delete on Purchase
For each row
Begin
Delete from Basket
Where Purchase_Id_Purchase=:old.Id_Purchase;
End;

--After delete - show how much salary we have to pay monthly
create or replace trigger AfterDelete
after delete on Employee
Declare c integer;
Begin
select sum(Salary) into c
from Employee;
DBMS_output.put_line(c);
End;

--Before update - check if the salary is negative after update
create or replace trigger beforeUpdate
Before update on Employee
FOR EACH ROW
BEGIN
if (:New.Salary < 0)
then 
    raise_application_error(-20050,'salary cannot be negative!');
end if;
END;

--After update - show how the salary was changed
create or replace trigger AfterUpdate
After update on Employee
FOR EACH ROW
BEGIN
DBMS_output.put_line('Old:'||:old.Salary);
DBMS_output.put_line('New:'||:new.Salary);
DBMS_output.put_line('Diff:'||:new.Salary - :old.Salary);
END;