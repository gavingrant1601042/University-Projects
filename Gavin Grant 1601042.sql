create database DDSTEST_1601042grant0
use  DDSTEST_1601042grant0

/* Exercise 1*/
create table student
(
	student_id	INTEGER PRIMARY KEY,
	first_name	VARCHAR(20) NOT NULL,
	last_name	VARCHAR(75) NOT NULL,
	dateofbirth	DATE		NOT NULL,
	email		VARCHAR(50) NULL,
	telephone	VARCHAR(11)	,
	address		VARCHAR(50)	,
	parish		VARCHAR(50)	
);
INSERT INTO student
(student_id,first_name,last_name,dateofbirth,email,telephone,address,parish)
VALUES
(1001, 'Gavin','Grant', '1997/06/23','gavingrant691@gmail.com','18763481860','39 Barbados Avenue', 'Kingston')


CREATE TABLE book
(
book_id INTEGER		PRIMARY KEY,
title  VARCHAR(75)	NULL,
author VARCHAR(75)	NOT NULL,
dateofpublication DATE NULL,
owner_id INTEGER	NOT NULL,
CONSTRAINT fk_book FOREIGN KEY (owner_id) References student(student_id)
);	
INSERT into book
(book_id,title,author,dateofpublication,owner_id)
VALUES
(1001,' odyssey and cyclops', 'Homer','1997/06/23','1001')

Create table rent(
book_id INTEGER NOT NULL,
student_id INTEGER NOT NULL,
date_rented DATE NOT NULL,
date_returned DATE NULL,
Constraint pk_book Primary key(book_id,student_id,date_rented),
Constraint fk_rent_student Foreign key(student_id) References student(student_id),
CONSTRAINT fk_rent_book FOREIGN KEY (book_id) REFERENCES student(student_id)
)
INSERT into rent
(book_id,student_id,date_rented,date_returned)
VALUES
(1001,1001,'2001/06/13','2003/06/23')
select *from rent
select *from book
select *from student 

Delete from book where book_id = 9001

/* Exercise 2

Varchar is for variable length which means
that the amount of characters can be allocated why char is fixed length

Integer reprsents whole numbers and contains 32 bit integer while numeric represents decimal values

Date is used for values with no time but have a date while DATETIME is used for a value with both date and time

Both numeric and money data type can perform calculations however numeric has a scale of numbers and require 5-17 bytes while money takes a standard storage of 8 bytes
*/


/*	Exercise 3 Test table		*/

Create table test_your_id(

student_id	INTEGER PRIMARY KEY,
	first_name	VARCHAR(20) NOT NULL,
	last_name	VARCHAR(75) NOT NULL,
);


drop table test_your_id

Alter table student
Add Emergency_Contacts_Name 	Varchar(20)  NULL
Alter table student
Add Emergency_Contacts_Number Varchar(20) NULL;
Alter table student
Add Emergency_contacts_email	Varchar(20) NULL;

Alter table student
drop column  Emergency_contacts_email
select *from book

INSERT INTO book
(book_id, title, author, dateofpublication,owner_id )
VALUES											--------------------------------
(1002, 'Harry Potter', 'JK Rowling', '2005','1001');


INSERT INTO student
(student_id
,first_name,last_name,dateofbirth,email,telephone,address,parish,Emergency_Contacts_Name,Emergency_Contacts_Number)
VALUES
(100110001, 'John ' , 'Doe', '12/31/1982', 'test@test.com' , '324-
4567', '23 King Ave', 'Kingston','James Doe','5353988');

delete from student where student_id = 100110001;

select*from student
SELECT * FROM Book

SELECT * FROM Student



/*	Exercise 4 Test table		*/

CREATE TABLE Meet 
(
Meetingcode	  int		PRIMARY KEY,
name		varchar(20)  Not NULL,
type		varchar(20) NOT NULL,
date		DATE	NOT NULL

);	

INSERT into Meet
(Meetingcode,name,type,date)
VALUES
(9112,'Office_Meeting','Status_update','2003/06/23')
SELECT * FROM Event


INSERT INTO Event
(Event_ID, lastname,description, time,gender,category,WR)
VALUES
(1001, 'James', 'Student',500 ,'Male','Hurdle','10');




drop table Event
Create Table Event(
Event_ID	int Primary Key,
lastname	varchar(20)	NOT NULL,
description	varchar(20) NOT NULL,
time		INT	 NOT NULL,
gender		varchar(7) NOT NULL,
category	varchar(100) NOT NULL,
WR			int			NOT NULL
);
drop table Event
SELECT * FROM Event


Create Table Event_Hurdles( 
Event_ID		int Primary Key,
Hurdle_distance int NOT NULL,

Constraint fk_hurdle FOREIGN KEY (Event_ID) References Event(Event_ID)  
);
drop table Event_Hurdles

INSERT INTO Event_Hurdles
(Event_ID, Hurdle_distance)
VALUES
(1001, 8.5)
drop table Event_Hurdles


Create table Athlete(
Athlete_id	int		Primary Key,
firstname		varchar(20) NOT NULL,
lastname		varchar(20) NOT NULL,
DOB			DATE		NOT NULL,
gender		varchar(20)	NOT NULL,
country		varchar(75)	NOT NULL,
coach_id	int			NULL,
Constraint fk_Athlete Foreign key (coach_id) References Athlete (Athlete_id)
);
drop table Athlete
select *from Athlete
INSERT INTO Athlete
(Athlete_id,firstname, lastname,DOB,gender,country,coach_id,height)
VALUES
(1001, 'Gavin','Grant','1997/06/23','Male','Jamaica','1001','5ft 9')
drop table Athlete

create Table Athelete_Email(

Email	varchar(100)	PRIMARY KEY,
Athlete_id	int	NOT NULL,

Constraint fk_athelete_email Foreign key(Athlete_id)References Athlete(Athlete_id) 
);
drop table Athelete_Email

INSERT INTO Athelete_Email
(Email, Athlete_id)
VALUES
('grant691@gmail.com',1001)

create table Schedule(
Event_ID	int		NOT NULL,
Meetingcode	int		NOT NULL,
event_time	int	NOT NULL,

Constraint pk_key	primary key(Event_ID,Meetingcode),
Constraint fk_Schedule Foreign key(Event_ID)References Event(Event_ID), 
Constraint fk_Schedule1 Foreign key(Meetingcode)References Meet(Meetingcode)
)
INSERT INTO Schedule
(Event_ID, Meetingcode,event_time)
VALUES
('1001','9112',1300)
SELECT * FROM Event
SELECT * FROM Meet

create table Participate(
Athlete_id	int  NOT NULL,
Event_ID	int NOT NULL,
Meetingcode int NOT NULL,
position	varchar(20) NOT NULL,
status		varchar(20) NOT NULL,
time_ran	int	NOT NULL,
Constraint pk_part Primary key (Athlete_id,Event_ID),
Constraint fk_1 Foreign key(Meetingcode)References Meet(Meetingcode),
Constraint fk_2 Foreign key(Athlete_id) References Athlete(Athlete_id),
Constraint fk_3 Foreign key(Event_ID) References Event(Event_ID)  
);
INSERT INTO Participate
(Athlete_id, Event_ID,Meetingcode,position,status,time_ran)
VALUES
(1001,1001,9112,'Hurdle','First',30 	);


SELECT * FROM Athlete
SELECT * FROM Event
SELECT * FROM Meet
SELECT * FROM Participate
--drop table Participate

select *from Participate


/*-----------------------------------------------Lab 2-------------------------------------------------*/


alter table Athlete 
add height varchar(25)

alter table Event 
add category varchar(25)

insert into Meet  values
(1001,'Office_Meeting', 'Status_Update', '2004-05-24'),
(1002,'Office_Meeting', 'Information_Sharing', '2006-05-22'),
(1003,'Office_Meeting', 'Decision_Making', '2007-03-18'),
(1004,'Office_Meeting', 'Decision_Making', '2008-02-15')

SELECT * FROM Event
SELECT * FROM Meet
INSERT INTO Event VALUES
(1002, 'Morgan', 'Student','500' ,'Male','Hurdle',8),
(1003, 'Grant', 'Coach','20' ,'Male','Hurdle',7),
(1004, 'Barret', 'Teacher','30' ,'Male','Hurdle',20),
(1005, 'James', 'Student','40' ,'Male','Hurdle',50)

select *from Event

INSERT INTO Event_Hurdles VALUES
(1002, 8.5),
(1003, 6.5),
(1004, 7.5),
(1005, 6.0)
select * from Athlete
INSERT INTO Athlete	VALUES
(1002, 'Morgan','Jordan','1995/03/2','Male','Jamaica','1001','5ft 8'),
(1003, 'Grant','Winston','1994/04/5','Male','Jamaica','1001','5ft 8' ),
(1004, 'Barret','Christopher','1996/07/6','Male','Jamaica','1001','5ft 8'),
(1005, 'James','James','1992/09/18','Male','Jamaica','1001','5ft 8')
drop table Athlete

select *from Athelete_Email

INSERT INTO Athelete_Email VALUES
('morgan@gmail.com',1002),
('jace691@gmail.com',1003),
('grant@gmail.com',1004),
('barret@gmail.com',1005)

Select *from Event
Select *from Meet
Select *from Schedule
------------------------------
INSERT INTO Schedule VALUES
('1002','9112',1300),
('1003','9112',1300),
('1004','9112',1300),
('1005','9112',1300)

INSERT INTO Participate	VALUES

(1002,1002,9112,'Hurdle','Second',35 ),
(1003,1003,9112,'Hurdle','Third',40 ),
(1004,1004,9112,'Hurdle','Fourth',45 ),
(1005,1005,9112,'Hurdle','Fifth',50 )

---EXERCISE 2-------------
select * from Athlete
INSERT INTO Athlete
(Athlete_id, firstname,lastname,DOB,gender,country,coach_id,height)
VALUES
(1006, 'James','Jason','1997/06/23','Male','Jamaica','1001','6ft 5'),
(1007, 'Jordan','Anthony','1997/06/23','Male','Jamaica','1001','6ft 1');

select*from Event

INSERT INTO Event
(Event_ID, lastname,description, time,gender,category,WR)
VALUES
(1006, 'James', 'Student','30' ,'Male','Hurdle',10),
(1007, 'James', 'Student','50' ,'Male','Hurdle',2);

---EXERCISE 3-----------------

create table person(
person_id	int identity(1,1) primary key,
firstname	varchar(100)	NOT NULL,
last_name	varchar(100)	NOT NULL
);
drop table person 
Insert into person(firstname,last_name)
Select firstname,lastname from Athlete
select *from person
select *from dummy_athelete
select *from Event	-- -category missing
---------PART 2------------------------
create table dummy_athelete(	-- height missing

Athlete_id	int		Primary Key,
firstname		varchar(20) NOT NULL,
lastname		varchar(20) NOT NULL,
DOB			DATE		NOT NULL,
gender		varchar(20)	NOT NULL,
country		varchar(75)	NOT NULL,
coach_id	int			NOT NULL,
height		varchar(32) NOT NULL,

Constraint fk_dummy Foreign key (coach_id) References Athlete (Athlete_id)
);
drop table dummy_athelete
select *from dummy_athelete
Insert into dummy_athelete(Athlete_id,firstname,lastname,DOB,gender,country,coach_id,height)
Select Athlete_id,firstname,lastname,DOB,gender,country,coach_id,height from Athlete
---------------------------EXERCISE 4----------------------

Update dummy_athelete set height ='6ft'
where  Athlete_id=1001
Update dummy_athelete set height ='6ft'
where  Athlete_id=1002
Update dummy_athelete set height ='6ft'
where  Athlete_id=1003
Update dummy_athelete set height ='6ft'
where  Athlete_id=1004
Update dummy_athelete set height ='6ft'
where  Athlete_id=1005
Update dummy_athelete set lastname ='Wise'
where Athlete_id =1001

Select *from Event

Update Event set category ='Long Distance'
where  Event_ID=1002

Update Event set category ='Long Distance'
where  Event_ID=1004

Update Event set category ='Long Distance'
where  Event_ID=1005


Select *from Meet

Update Meet set name ='Hurdle Meeting'
where  MeetingCode=1002

Update Meet set name ='Hurdle Meeting'
where  MeetingCode=1003

select *from Athlete





Update Athlete set gender ='Female'
where Athlete_id = 1004

Update Event set WR =WR - 0.1
where WR < 10


Update Event set lastname ='Brown'
where Event_ID = 1001
Update Event set lastname ='Jordan'
where Event_ID = 1002
Update Event set lastname ='Winston'
where Event_ID = 1003
Update Event set lastname ='Christopher'
where Event_ID = 1004
Update Event set lastname ='James'
where Event_ID = 1005
Update Event set lastname ='Jason'
where Event_ID = 1006
Update Event set lastname ='Anthony'
where Event_ID = 1007

select *from Athlete

--------------DELETE-------------------------


select *from dummy_athelete

DELETE FROM dummy_athelete WHERE Athlete_id=1003

DELETE FROM dummy_athelete WHERE Country='Cuba'



DELETE FROM dummy_athelete
 WHERE country ='Jamaica'AND lastname ='Brown'





 Update dummy_athelete set lastname ='Brown'
where Athlete_id = 1002



Update dummy_athelete set Country ='Cuba'
where Athlete_id = 1006
Update dummy_athelete set Country ='Cuba'
where Athlete_id = 1004

--------------------------------LAB 3----------------------------------------------------------------------------------


Select *from Event
Select *from Schedule
Select *from Athlete
Select *from Meet
Select *from Participate


Select  lastname,description, gender From Event
Select Event_ID, Meetingcode From Schedule
Select DOB, Athlete_id,firstname,lastname from Athlete
Select date,Meetingcode from Meet
Select time_ran, Athlete_id,Event_ID from Participate

-----------------------EXERCISE 3---------------------------------

Select*from Event
where WR>15

select*from Event_Hurdles
where Hurdle_distance >100


select*from Athlete
where gender ='Female'



Update Event_Hurdles set Hurdle_distance =100
where Event_ID = 1001
Update Event_Hurdles set Hurdle_distance =200
where Event_ID = 1002
Update Event_Hurdles set Hurdle_distance =300
where Event_ID = 1003
Update Event_Hurdles set Hurdle_distance =88
where Event_ID = 1004
Update Event_Hurdles set Hurdle_distance =45
where Event_ID = 1005

select*from Event_Hurdles
where Hurdle_distance >200 AND Hurdle_distance<400



select firstname,lastname from Athlete
where gender ='Female'


select*from Athlete
where NOT gender ='Male' AND country ='Jamaica'


------------------------------EXERCISE 4--------------------------------------------

--PART A 
Select *from Athlete
ORDER BY DOB ASC, lastname ASC
--PARTB 
Select *from Event_Hurdles
ORDER BY Hurdle_distance ASC 

Select *from Event
Order BY WR ASC


/--PARt C
Select firstname,lastname,country, gender from Athlete
 Order by country, firstname,lastname ASC


--PART D
 Select name,date from Meet
 ORDER BY date,type ASC
 Select*from Meet

Update Athlete set Country ='Cuba'
where Athlete_id = 1004


--------------------------------------GROUP BY----------------------------------------------------------
select Hurdle_distance from Event_Hurdles

select*from Event_Hurdles
--A 
Select gender,count(*)as Gender_counts from Athlete
Group by gender
--B 
Select category,count(*)as Event_Type from Event
Group by category
--C 
Select Hurdle_distance,count(*)as Event_Type from Event_Hurdles
where Hurdle_distance >=100 AND Hurdle_distance <= 200
Group by Hurdle_distance
------

Select COUNT(gender) as Male
FROM Athlete
GROUP BY gender
HAVING COUNT (gender) > 1
 
select COUNT (Hurdle_distance) as amount_distance
from Event_Hurdles
GROUP BY Hurdle_distance

select*from Event
select*from Athlete
--------------Lab 4-------------------------
--1)
Select firstname,DOB, country FROM Athlete
INNER JOIN Event
ON Athlete.Athlete_id = Event.Event_ID

--2) 

Select firstname,coach_id FROM Athlete
INNER JOIN Event
ON Athlete.Athlete_id = Event.Event_ID
--3)
Select firstname,category FROM Athlete
INNER JOIN Event
ON Athlete.Athlete_id = Event.Event_ID

--4
Select firstname,category FROM Athlete
INNER JOIN Event
ON Athlete.Athlete_id = Event.Event_ID
where Event.gender = 'Female'

Update Event set gender ='Female'
where Event_ID = 1004

Select* FROM Athlete

Select* FROM Event
--5


select*from Event
select*from Meet

Select Name,type FROM Meet
INNER JOIN Event
ON Meet.Meetingcode = Event.Event_ID



Select Name,type,date FROM Meet
INNER JOIN Event
ON Meet.Meetingcode = Event.Event_ID
Select  *From Meet where DATEDIFF(year,date,GETDATE()) >2
---SUBTRACT DATE (DATE DIFF)

-----------LEFT TABLE-------------------

Select *FROM Athlete
INNER JOIN Participate
ON Athlete.Athlete_id = Participate.Event_ID


Select *FROM Athlete
LEFT JOIN Participate
ON Athlete.Athlete_id = Participate.Event_ID



Select *FROM Athlete
LEFT JOIN Participate
ON Athlete.Athlete_id = Participate.Event_ID
where  Event_ID IS NULL;

-----RIGHT TABLE ---------------
Select *FROM Athlete
RIGHT JOIN Participate
ON Athlete.Athlete_id = Participate.Event_ID


Select *FROM Athlete
RIGHT JOIN Participate
ON Athlete.Athlete_id = Participate.Event_ID



Select *FROM Athlete
RIGHT JOIN Participate
ON Athlete.Athlete_id = Participate.Event_ID
where  Event_ID IS NULL;

--------FULL JOIN-----------------------
Select *FROM Meet
Select *FROM Event
Select *FROM Participate



Select name , type from  Meet
Full join Schedule
on Meetingcode = Event_ID

Select Meetingcode, name , type from  Meet
Full join Event
on Meetingcode = Event_ID
-----------------Lab 5---------------------------------------------

select * from Athlete
where firstname LIKE '%B%'

select * from Event
where description LIKE '%W'

Update Event  set description ='W'
where Event_ID = 1001

Update Athlete  set firstname ='entran'
where Athlete_id = 1001

select *from Athlete
where firstname LIKE '%en%'

select *from Meet
where type NOT LIKE '%oy%'



-----------Exercise 2---------Change participation------

Select AVG(event_time) as Avg_ran from  Schedule
Select MAX (WR) as Longest_time  From Event
Select MIN (WR) as Min_time  From Event
Select Count(*) Amount_Athletes from Event
Select AVG(time_ran) as time_ran from  Participate
		
Select SUM (time) as Total_TIme from Event	



-------------EXERCISE 3-----------------
select *from Event
select *from Participate
select *from Athlete

Update Event  set gender ='Male'
where Event_ID = 1005


select *from Meet
select *from Athlete

Select  *
FROM Event s INNER JOIN Participate p 
ON s.Event_ID = p.Event_ID 


Select  *
FROM Event s INNER JOIN Meet p 
ON s.Event_ID = p.Meetingcode 

select 
s.firstname, s.lastname, s.country from Athlete s
where country = 'Jamaica'

Select  *
FROM Athlete s INNER JOIN Event p 
ON s.Athlete_id = p.Event_ID 
where s.gender LIKE '%Female%'

Select  s.firstname, s.lastname, p.category,p.WR
FROM Athlete s INNER JOIN Event p 
ON s.Athlete_id = p.Event_ID 
where WR >20












-------------EXERCISE 4-----------------
/*Exist operator is used to test for existence of a record and is a subquery returning on or multiple records found*/
/*NOT Exist operator to deliver the opposite of EXIST however it looks for row and columns if not found it will return false else true */
/*Union is used to compare two or more records by comparing the records into one"*/
/*Used to return2 ormore select statements only returning rows and checking if a record exist between dataset 1 and 2"*/
/* Difference compares two values and return a value" 
/*Cartesian Product  or CROSS JOIN returns */
the Cartesian product of the sets of records from two or more joined tables. Thus, it equates to an inner join where the join-condition always evaluates to either True or 
where the join-condition is absent from the statement*/ 
/*EXCEPT returns distinct rows from the left input query that aren’t output by the right input query*/
/*ANY used where the subquery values condition are met using where and having clause*/
/*Some compare value  between the outer and inner tables and evaluate wheter the statement is true or false and atleast one must be matched  */

/*------------LAB 6-------------------------------------*/

Select  firstname,lastname, DateDiff(year, DOB, GETDATE())AS AGE from Athlete  
Select firstname,lastname from Athlete where DateDiff(year, DOB, GETDATE())  >25
Select  firstname,lastname from Athlete where DateDiff(year, DOB, GETDATE())>25 AND  DateDiff(year, DOB, GETDATE())<30  
Select  DATEPART (Quarter,DOB) AS Quarter  from Athlete
Select *from Athlete 
/*EXercise 2*/
Select firstname,lastname from Athlete where DateDiff(year, DOB, '1/11/2023')  >=30
Select*from Event

/*Exercise 3 */
CREATE TABLE Trainee
(
Id int NOT NULL,
LastName varchar(255) NOT NULL,
FirstName varchar(255) NOT NULL,
Marital_Status char(1) DEFAULT 'S',
Address varchar(255),
Email varchar(255),
Parish varchar(50),
CONSTRAINT chk_Trainee CHECK (Id>0 AND Parish in ('Kingston','St. Cathrine','Portland','St.Andrew')),
Constraint chk_Person_Marital CHECK (Marital_status ='S' or Marital_Status='M'),
Constraint uk_email Unique (Email),Primary Key(ID)
)
/*The error message given was that there was a missing bracket from the check constraint and a primary key was being added again where it was already there*/

INSERT  INTO Trainee
VALUES
(115,'Tamara','Barret','S','29 BBR Road','g21@gmail.com','Kingston');
INSERT  INTO Trainee
VALUES
(115,'Grant','Gavin',NULL,'19 BBRS Road','g21@gmail.com','Westmoreland');

/*Will not allow duplicate emails*/
INSERT  INTO Trainee
VALUES
(115,'Tamara','Barret','S','29 BBR Road','g214@.com','Kingston');
/*Forcing user to enter a data*/



Select DISTINCT (country) from athlete 
Select DISTINCT (Firstname) from athlete 
Select DISTINCT (Lastname) from athlete 


----------EXERCISE 5 ----------------------------
INSERT  INTO Trainee
VALUES
(116,'Gavin','Barret','S','19 BBR Road','ak214@.com','Kingston'),
(117,'Grant','James','S','2 BBR Road','g14@.com','Kingston'),
(118,'Kemar','Kevon','S','59 BBR Road','sd214@.com','Kingston');


Select *from Trainee
Select *from Athlete

Select firstname, lastname from Athlete where country ='Jamaica'
Union
Select firstname, lastname from Trainee where Marital_Status ='S';

-------Records were not Duplicated---------------
--------ALL THe records added previously are there-------------


Select firstname, lastname from Athlete where gender ='Male'
Union
Select firstname, lastname from Trainee where Marital_Status ='S';


Select firstname, lastname from Athlete where gender ='Female'
Union
Select firstname, lastname from Trainee where Marital_Status ='S';




------------SQL HOMEWORK-------------------------


--1--
/*In SQL, a view is a virtual table based on the result-set of an SQL statement.

A view contains rows and columns, just like a real table. 
The fields in a view are fields from one or more real tables in the database.*/
--2--
/*table stores data in a databse while view only is an virtual table 
containing only columns and no rows where contents are defined by query hence saving 
dataspace*/

--3--
Create table Driver(
TRN		int     Primary Key ,
Firstname varchar(255) NOT NULL,
Lastname varchar(255) NOT NULL
)

INSERT INTO DRIVER
VALUES
(100,'Gavin','Grant'),
(101,'James','Jackson'),
(102,'Kevin','Jake');
drop table driver

select *from DRiver
 
Create view Driver_name AS
select TRN,Firstname,Lastname 
from Driver
Where Trn  IS NOT NULL;
