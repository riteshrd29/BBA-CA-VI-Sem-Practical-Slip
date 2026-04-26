Project Type:
- Advanced-Java

Slip Number:
- Slip-09

Question Number:
- Question 1

Slip Question (From PDF):
- Write a Java Program to create a Emp (ENo, EName, Sal) table and insert record into it. (Use PreparedStatement Interface) [15 M]

Execution Steps:
1. Open Q1_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE Emp (
  ENo INT PRIMARY KEY,
  EName VARCHAR(100),
  Sal INT
);
INSERT INTO Emp VALUES (1, 'EName_demo', 1);

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
