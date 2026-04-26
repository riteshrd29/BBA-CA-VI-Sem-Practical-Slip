Project Type:
- Advanced-Java

Slip Number:
- Slip-11

Question Number:
- Question 2

Slip Question (From PDF):
- Write a Java program to display sales details of Product (PID, PName, Qty, Rate, Amount) between two selected dates. (Assume Sales table is already created). [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE Product (
  PID INT PRIMARY KEY,
  PName VARCHAR(100),
  Qty INT,
  Rate INT,
  Amount INT
);
INSERT INTO Product VALUES (1, 'PName_demo', 1, 1, 1);

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
