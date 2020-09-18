CREATE TABLE Employee (
   id INT NOT NULL, 
   firstname VARCHAR(50) NOT NULL,
   lastname VARCHAR(30) NOT NULL,
   dateofbirth VARCHAR(30) NOT NULL
);

CREATE TABLE Address (
   id INT NOT NULL,
   employeeId INT NOT NULL,
   line1 VARCHAR(50) NOT NULL,
   line2 VARCHAR(20) NOT NULL,
   city VARCHAR(50) NOT NULL,
   state VARCHAR(20) NOT NULL,
   country VARCHAR(20) NOT NULL,
   zipcode VARCHAR(20) NOT NULL
);