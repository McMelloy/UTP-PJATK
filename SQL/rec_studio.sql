CREATE TABLE Band (
    IdBand integer  NOT NULL,
    Name varchar2(30)
) ;

CREATE TABLE Branch (
    IdBranch integer  NOT NULL,
    City varchar2(20)  ,
    Street varchar2(20) ,
    "Number" integer  ,
    "Size" integer ,
    Rent integer
) ;

CREATE TABLE Member (
    Band integer  NOT NULL,
    Musician integer  ,
    Role integer
) ;

CREATE TABLE Musician (
    IdMusician integer  NOT NULL,
    Name varchar2(20)  ,
    Surname varchar2(20)
) ;

CREATE TABLE Project (
    IdProject int  NOT NULL,
    IdBand integer  NOT NULL,
    Name varchar2(20)  ,
    Label varchar2(20)
) ;

CREATE TABLE Recording (
    IdRecording integer  NOT NULL,
    "Date" date  ,
    Room integer  ,
    RecName varchar2(20)  ,
    IdProject int  NOT NULL
) ;

CREATE TABLE Role (
    IdRole integer  NOT NULL,
    Name varchar2(20)
) ;

CREATE TABLE Room (
    IdRoom integer  NOT NULL,
    Branch integer  ,
    "Size" integer
) ;

INSERT INTO