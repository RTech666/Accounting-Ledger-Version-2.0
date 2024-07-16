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
    