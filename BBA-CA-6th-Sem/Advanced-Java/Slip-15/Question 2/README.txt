Project Type:
- Advanced-Java

Slip Number:
- Slip-15

Question Number:
- Question 2

Slip Question (From PDF):
- Write a Java program to accept the details of Student (RNo, SName, Per, Gender, Class) and store into the database. (Use appropriate Swing Components and PreparedStatement Interface). [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE Student (
  RNo INT PRIMARY KEY,
  SName VARCHAR(100),
  Per INT,
  Gender VARCHAR(100),
  Class VARCHAR(100)
);
INSERT INTO Student VALUES (1, 'SName_demo', 1, 'Gender_demo', 'Class_demo');

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
