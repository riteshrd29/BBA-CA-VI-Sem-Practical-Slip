Project Type:
- Advanced-Java

Slip Number:
- Slip-26

Question Number:
- Question 1

Slip Question (From PDF):
- Write a java program to display list of college names from college table. (Assume College table (CID, CName, addr) is already created. [15 M]

Execution Steps:
1. Open Q1_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE College (
  CID INT PRIMARY KEY,
  CName VARCHAR(100),
  addr VARCHAR(100)
);
INSERT INTO College VALUES (1, 'CName_demo', 'addr_demo');

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
