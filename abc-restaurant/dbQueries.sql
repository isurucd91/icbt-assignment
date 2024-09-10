use abcr;

create table users(
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
PRIMARY KEY (id));

select * from users;

create table reservations(
    id INT NOT NULL AUTO_INCREMENT,
    curdate DATE NOT NULL,
    cutime TIME NOT NULL,
    type VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    custid INT NOT NULL,
 PRIMARY KEY (id),
 FOREIGN KEY (custid) REFERENCES users(id));
  
 select * from reservations;
 
 create table queries(
    id INT NOT NULL AUTO_INCREMENT,
    querytext VARCHAR(255) NOT NULL,
    replytext VARCHAR(255) NOT NULL,
    custid INT NOT NULL,
 PRIMARY KEY (id),
 FOREIGN KEY (custid) REFERENCES users(id));
 
 select * from queries;