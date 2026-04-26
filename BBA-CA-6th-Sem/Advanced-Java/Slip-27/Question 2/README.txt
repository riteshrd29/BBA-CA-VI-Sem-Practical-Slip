Project Type:
- Advanced-Java

Slip Number:
- Slip-27

Question Number:
- Question 2

Slip Question (From PDF):
- Write a Java Program for the implementation of scrollable ResultSet. Assume Teacher table with attributes (TID, TName, Salary, Subject) is already created. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE attributes (
  TID INT PRIMARY KEY,
  TName VARCHAR(100),
  Salary INT,
  Subject VARCHAR(100)
);
INSERT INTO attributes VALUES (1, 'TName_demo', 1, 'Subject_demo');

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
