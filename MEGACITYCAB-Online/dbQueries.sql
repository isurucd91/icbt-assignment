use mccdb;

create table users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
	regno INT NOT NULL,
	nic VARCHAR(255) NOT NULL,
	telephone VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
PRIMARY KEY (id));

select * from users;

create table bookings(
    id INT NOT NULL AUTO_INCREMENT,
    custid INT NOT NULL ,
    pickpt VARCHAR(255) NOT NULL,
    droppt VARCHAR(255) NOT NULL,
	ridetype VARCHAR(255) NOT NULL,
    drvid INT NOT NULL,
 PRIMARY KEY (id),
 FOREIGN KEY (custid) REFERENCES users(id), 
 FOREIGN KEY (drvid) REFERENCES users(id));
  
 select * from bookings;
 
 create table rides(
    id INT NOT NULL AUTO_INCREMENT,
    ridetype VARCHAR(255) NOT NULL,
    ridedetails VARCHAR(255) NOT NULL,
    drvid INT NOT NULL,
 PRIMARY KEY (id), 
 FOREIGN KEY (drvid) REFERENCES users(id));
  
 select * from rides;