Project Type:
- Advanced-Java

Slip Number:
- Slip-23

Question Number:
- Question 1

Slip Question (From PDF):
- Write a Java Program to display the details of College(CID, CName, address, Year) on JTable. [15 M]

Execution Steps:
1. Open Q1_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE College (
  CID INT PRIMARY KEY,
  CName VARCHAR(100),
  address VARCHAR(100),
  Year INT
);
INSERT INTO College VALUES (1, 'CName_demo', 'address_demo', 1);

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
