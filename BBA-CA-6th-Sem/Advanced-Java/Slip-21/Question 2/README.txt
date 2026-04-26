Project Type:
- Advanced-Java

Slip Number:
- Slip-21

Question Number:
- Question 2

Slip Question (From PDF):
- Write a SERVLET program in java to accept details of student (SeatNo, Stud_Name, Class, Total_Marks). Calculate percentage and grade obtained and display details on page. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
Database Setup:
CREATE TABLE student (
  SeatNo INT PRIMARY KEY,
  Stud_Name VARCHAR(100),
  Class VARCHAR(100),
  Total_Marks INT
);
INSERT INTO student VALUES (1, 'Stud_Name_demo', 'Class_demo', 1);

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
