drop table brnch;
drop table band;
drop table member;
drop table musician;
drop table project;
drop table Recording;
drop table Room;

CREATE TABLE Band (
    IdBand varchar2(30) NOT NULL PRIMARY KEY,
    Name varchar2(30)
);

CREATE TABLE Brnch (
    IdBranch integer  NOT NULL PRIMARY KEY,
    City varchar2(20)  ,
    Street varchar2(20) ,
    HNumber integer  ,
    BSize integer ,
    Rent integer
);

CREATE TABLE Member (
    Band varchar2(30)  NOT NULL ,
    Musician varchar2(20) NOT NULL,
    CONSTRAINT PK_Member PRIMARY KEY (Band,Musician)
) ;

CREATE TABLE Musician (
    IdMusician varchar2(20)  NOT NULL PRIMARY KEY,
    Name varchar2(20)  ,
    Surname varchar2(20)
) ;

CREATE TABLE Project (
    IdProject varchar2(20)  NOT NULL PRIMARY KEY,
    IdBand varchar2(30)  NOT NULL,
    Name varchar2(20)  ,
    Label varchar2(20)
) ;


CREATE TABLE Recording (
    IdRecording integer  NOT NULL PRIMARY KEY,
    RecDate date  ,
    Room integer  ,
    RecName varchar2(20)  ,
    IdProject integer NOT NULL
) ;

ALTER TABLE Recording
MODIFY IdProject varchar2(20);

desc Recording;

CREATE TABLE Room (
    IdRoom integer  NOT NULL PRIMARY KEY,
    Branch integer  ,
    RoomSize integer
) ;

-- foreign keys
-- Reference: Band_Member_Client_Band (table: Member)
ALTER TABLE Member ADD CONSTRAINT Band_Member_Client_Band
    FOREIGN KEY (Band)
    REFERENCES Band (IdBand);

-- Reference: Member_Musician (table: Member)
ALTER TABLE Member ADD CONSTRAINT Member_Musician
    FOREIGN KEY (Musician)
    REFERENCES Musician (IdMusician);

-- Reference: Project_Band (table: Project)
ALTER TABLE Project ADD CONSTRAINT Project_Band
    FOREIGN KEY (IdBand)
    REFERENCES Band (IdBand);

-- Reference: Recording_Project (table: Recording)
ALTER TABLE Recording ADD CONSTRAINT Recording_Project
    FOREIGN KEY (IdProject)
    REFERENCES Project (IdProject);

-- Reference: Recording_Room (table: Recording)
ALTER TABLE Recording ADD CONSTRAINT Recording_Room
    FOREIGN KEY (Room)
    REFERENCES Room (IdRoom);

-- Reference: Room_Branch (table: Room)
ALTER TABLE Room ADD CONSTRAINT Room_Brnch
    FOREIGN KEY (Branch)
    REFERENCES Brnch (IdBranch);


INSERT INTO brnch VALUES(1,'WARSAW','KOROTYNSKIEGO',3,2000,13000);
INSERT INTO brnch VALUES(2,'WROCLAW','BANACHA',21,3000,15000);
INSERT INTO brnch VALUES(3,'GDANSK','DICKENSA',10,1100,6000);

INSERT INTO room VALUES(11,1,23);
INSERT INTO room VALUES(12,1,32);
INSERT INTO room VALUES(13,1,50);
INSERT INTO room VALUES(21,2,17);
INSERT INTO room VALUES(22,2,43);
INSERT INTO room VALUES(23,2,33);
INSERT INTO room VALUES(24,2,50);
INSERT INTO room VALUES(25,2,20);
INSERT INTO room VALUES(31,3,25);
INSERT INTO room VALUES(32,3,20);
INSERT INTO room VALUES(33,3,7);

INSERT INTO Musician VALUES('mknopfler','Mark','Knopfler');
INSERT INTO Musician VALUES('mbellamy','Matt','Bellamy');
INSERT INTO Musician VALUES('cwolstenholme','Chris','Wolstenholme');
INSERT INTO Musician VALUES('dhoward','Dominic','Howard');
INSERT INTO Musician VALUES('jhetfield','Mark','Knopfler');
INSERT INTO Musician VALUES('khammet','Kirk','Hammet');
INSERT INTO Musician VALUES('lulrich','Lars','Ulrich');
INSERT INTO Musician VALUES('fmercury','Freddie','Mercury');
INSERT INTO Musician VALUES('bmay','Brian','May');
INSERT INTO Musician VALUES('rtaylor','Roger','Taylor');
INSERT INTO Musician VALUES('jdeacon','John','Deacon');
INSERT INTO Musician VALUES('ck','Calvin','Klein');

UPDATE Musician
SET name='James', surname='Hetfield'
WHERE idmusician='jhetfield';

DELETE FROM Musician
WHERE idmusician='ck';

INSERT INTO BAND VALUES('mknopflersolo','Mark Knopfler');
INSERT INTO BAND VALUES('muse','Muse');
INSERT INTO BAND VALUES('metallica','Metallica');
INSERT INTO BAND VALUES('queen','Queen');

INSERT INTO MEMBER VALUES('mknopflersolo','mknopfler');
INSERT INTO MEMBER VALUES('muse','mbellamy');
INSERT INTO MEMBER VALUES('muse','cwolstenholme');
INSERT INTO MEMBER VALUES('muse','dhoward');
INSERT INTO MEMBER VALUES('metallica','jhetfield');
INSERT INTO MEMBER VALUES('metallica','khammet');
INSERT INTO MEMBER VALUES('metallica','lulrich');
INSERT INTO MEMBER VALUES('queen','mknopfler');
INSERT INTO MEMBER VALUES('queen','fmercury');
INSERT INTO MEMBER VALUES('queen','bmay');
INSERT INTO MEMBER VALUES('queen','rtaylor');
INSERT INTO MEMBER VALUES('queen','jdeacon');

INSERT INTO PROJECT VALUES('killcrimson', 'mknopflersolo', 'Kill to get crimson', 'Mercury');
INSERT INTO PROJECT VALUES('simtheory', 'muse', 'Simulation Theory', 'Helium-3');
INSERT INTO PROJECT VALUES('drones', 'muse', 'Drones', 'Warner Bros.');
INSERT INTO PROJECT VALUES('oos', 'muse', 'Origin of symmetry', 'Mushroom');
INSERT INTO PROJECT VALUES('dmagnetic', 'metallica', 'Death Magnetic', 'Warner Bros.');
INSERT INTO PROJECT VALUES('mop', 'metallica', 'Master of puppets', 'Elektra');
INSERT INTO PROJECT VALUES('ajfa', 'metallica', 'And justice for all', 'Elektra');
INSERT INTO PROJECT VALUES('notw', 'queen', 'News of the world', 'Elektra');
INSERT INTO PROJECT VALUES('jazz', 'queen', 'Jazz', 'Elektra');

INSERT INTO Recording VALUES(1323,TO_DATE('25-APR-1977', 'DD-MON-YYYY'),22,'Its Late','notw');
INSERT INTO Recording VALUES(2527,TO_DATE('10-FEB-1978', 'DD-MON-YYYY'),24,'Spread Your Wings','notw');
INSERT INTO Recording VALUES(3807,TO_DATE('14-MAR-1979', 'DD-MON-YYYY'),11,'Jealousy','jazz');
INSERT INTO Recording VALUES(4345,TO_DATE('10-JAN-1988', 'DD-MON-YYYY'),21,'One','ajfa');
INSERT INTO Recording VALUES(5353,TO_DATE('21-OCT-1989', 'DD-MON-YYYY'),22,'Eye of the Beholder','ajfa');
INSERT INTO Recording VALUES(4001,TO_DATE('2-JUL-1986', 'DD-MON-YYYY'),31,'Battery','mop');
INSERT INTO Recording VALUES(11602,TO_DATE('21-AUG-2008', 'DD-MON-YYYY'),32,'Day That Never Comes','dmagnetic');
INSERT INTO Recording VALUES(11678,TO_DATE('3-APR-2008', 'DD-MON-YYYY'),12,'All Nightmare Long','dmagnetic');
INSERT INTO Recording VALUES(9989,TO_DATE('20-AUG-2001', 'DD-MON-YYYY'),32,'Bliss','oos');
INSERT INTO Recording VALUES(16038,TO_DATE('23-MAR-2015', 'DD-MON-YYYY'),13,'Dead Inside','drones');
INSERT INTO Recording VALUES(17309,TO_DATE('27-SEP-2018', 'DD-MON-YYYY'),23,'The Dark Side','simtheory');
INSERT INTO Recording VALUES(17310,TO_DATE('27-SEP-2018', 'DD-MON-YYYY'),23,'Pressure','simtheory');
INSERT INTO Recording VALUES(11276,TO_DATE('17-SEP-2007', 'DD-MON-YYYY'),11,'Love Will Never Fade','killcrimson');

--Print name and surname of musicians and bands they are in
SELECT Mu.Name, Surname, B.Name AS Band
FROM Musician Mu, Band B, Member Me
WHERE IdBand=Band AND IdMusician=Musician;

--Print all rooms of recording studios from largest to smallest with cities they are located in 
SELECT IdRoom, City, RoomSize
FROM Room, Brnch
WHERE IdBranch=Branch
ORDER BY 3 desc;

--Print the branch with more than 3 rooms
SELECT City
FROM Brnch
WHERE IdBranch in (
SELECT Branch
FROM Room
GROUP BY Branch
HAVING count(IdRoom)>3);

--Print branches and their summary room size
SELECT Branch, SUM(RoomSize)
FROM Room
GROUP BY Branch;

--Print city with the smallest room
SELECT City
FROM Brnch,Room 
WHERE IdBranch=Branch
AND (RoomSize) = (
SELECT min(RoomSize)
FROM Room );

--Print bands which were recorded in 2000s
SELECT DISTINCT B.Name 
FROM Band B,Project Q
WHERE B.IdBand = Q.IdBand
AND (Q.IdBand) in (
SELECT IdBand
FROM Project P,Recording R
WHERE P.IdProject=R.IdProject
AND (RecName, RecDate) in(
SELECT RecName, RecDate
FROM Recording
WHERE RecDate>'01-JAN-2000' AND RecDate<'01-JAN-2010'));

--Print songs that have another song recorded during the same project
SELECT First.RecName
FROM Recording First
WHERE EXISTS(
SELECT Second.RecName
FROM Recording Second
WHERE Second.IdProject = First.IdProject AND second.recname!=first.recname);

--Print rooms that were never used for recordings
SELECT IdRoom
FROM Room
WHERE NOT EXISTS(
SELECT IdRecording
FROM Recording
WHERE IdRoom=Room);


--Trigger 1 - before insert - check if you can add recording before studio foundation
Create or replace trigger createRec
Before insert on Recording
For each row
Begin
if (:New.RecDate < '01-JAN-1970')
then 
    raise_application_error(-20050,'cannot be recorded before studio foundaton date');
end if;
End;

INSERT INTO Recording VALUES(1234,TO_DATE('25-APR-1967', 'DD-MON-YYYY'),22,'Inside','notw');

--Trigger 2 - after insert - after adding room to branch, the size of branch increases
Create or replace trigger addRoom
After insert on Room
For each row
Declare x integer;
Begin
Select BSize into x
from brnch
where idBranch = :new.Branch;
UPDATE brnch
SET BSize=x+:new.RoomSize
WHERE idBranch = :new.Branch;
End;

Select * from brnch;
Select * from Room;
INSERT INTO room VALUES(14,1,50);

--Trigger 3 - before delete - after adding room to branch, the size of branch shrinks
Create or replace trigger delRoom
Before delete on Room
For each row
Declare x integer;
Begin
Select BSize into x
from brnch
where idBranch = :old.Branch;
UPDATE brnch
SET BSize=x-:old.RoomSize
WHERE idBranch = :old.Branch;
End;

delete from Room
where idroom=14;
Select * from brnch;

--Trigger 3.5 - before delete - delete member if deleting musician


--Trigger 4 - after delete - count and print amount of remaining musicians after deleting one
create or replace trigger countMusicians
after delete on Musician
Declare c integer;
Begin
select count(IdMusician) into c
from Musician;
DBMS_output.put_line(c);
End;

--Trigger 5 - before update - ckeck if the room is of negative size
create or replace trigger negativeSize
before update on Room
for each row
Begin
if(:new.RoomSize<0)
then
    raise_application_error(-20050,'room cannot be of negative size');
end if;
end;

update Room
set RoomSize=-30
where IdRoom=11;

--Trigger 6 - after update - show the difference
create or replace trigger diffSize
before update on Room
for each row
Declare diff integer;
Begin
DBMS_output.put_line(:new.RoomSize - :old.RoomSize);
end;

update Room
set RoomSize=26
where IdRoom=11;
ida@pjwstk.edu.pl