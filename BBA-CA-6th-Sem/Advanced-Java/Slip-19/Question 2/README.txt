Project Type:
- Advanced-Java

Slip Number:
- Slip-19

Question Number:
- Question 2

Slip Question (From PDF):
- Write a Java program to display first record from student table (rno, sname, per) onto the TextFields by clicking on button. (Assume Student table is already created). [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE student (
  rno INT PRIMARY KEY,
  sname VARCHAR(100),
  per INT
);
INSERT INTO student VALUES (1, 'sname_demo', 1);

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
