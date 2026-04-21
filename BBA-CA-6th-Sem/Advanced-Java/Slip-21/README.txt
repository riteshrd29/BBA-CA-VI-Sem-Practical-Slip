Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

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
- MySQL Connector/J for JDBC questions.