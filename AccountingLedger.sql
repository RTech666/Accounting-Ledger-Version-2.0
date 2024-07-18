drop database if exists AccountingLedger;
create database AccountingLedger;
use AccountingLedger;

create table deposits(
	id int primary key not null auto_increment,
    dateTime datetime,
    description varchar(255),
    vendor varchar(255),
    amount double(10,2) not null
);

create table payments(
	id int primary key not null auto_increment,
    dateTime datetime,
    description varchar(255),
    vendor varchar(255),
    amount double(10,2) not null
);

create table ledger(
	id int primary key not null auto_increment,
    dateTime datetime,
    description varchar(255),
    vendor varchar(255),
    amount double(10,2) not null,
    type varchar(50)
);
INSERT INTO payments (id,dateTime,description, vendor, amount) VALUES ("Car ", "Honda", -350);
INSERT INTO deposits (id,dateTime,description, vendor, amount) VALUES ("Landscape", "Hoover Landscapers", 1000);
INSERT INTO payments (id,dateTime,description, vendor, amount) VALUES ("Rrent ", "GreyStar", -1150);
INSERT INTO deposits (id,dateTime,description, vendor, amount) VALUES ("Dog Sit", "Rover", 200);
    