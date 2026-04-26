Project Type:
- Advanced-Java

Slip Number:
- Slip-16

Question Number:
- Question 2

Slip Question (From PDF):
- Write a Java program to accept the details of students (rno, sname, per) at least 5 Records, store it into database and display the details of student having highest percentage. (Use PreparedStatement Interface) [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE students (
  rno INT PRIMARY KEY,
  sname VARCHAR(100),
  per INT
);
INSERT INTO students VALUES (1, 'sname_demo', 1);

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
