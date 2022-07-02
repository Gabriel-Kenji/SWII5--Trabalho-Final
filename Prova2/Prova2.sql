DROP database IF EXISTS Prova2;
CREATE DATABASE Prova2;
use Prova2;

CREATE TABLE salesman(
	SALESMAN_ID int NOT NULL AUTO_INCREMENT,
    NAME varchar(30),
    CITY varchar(15),
    COMMISSION decimal(5,2),
    PRIMARY KEY (SALESMAN_ID)
);

create table customer(
	CUSTOMER_ID int NOT NULL AUTO_INCREMENT,
    CUST_NAME varchar(30),
    CITY varchar(15),
    GRADE numeric(3),
    PRIMARY KEY (CUSTOMER_ID)
);

create table orders(
	ORD_NO int NOT NULL AUTO_INCREMENT,
    PURCH_AMT decimal(8,2),
    ORD_DATE date,
    SALESMAN_ID int,
    CUSTOMER_ID int,
    PRIMARY KEY (ORD_NO),
    FOREIGN KEY (SALESMAN_ID) REFERENCES salesman(SALESMAN_ID),
    FOREIGN KEY (CUSTOMER_ID) REFERENCES customer(CUSTOMER_ID)
);



