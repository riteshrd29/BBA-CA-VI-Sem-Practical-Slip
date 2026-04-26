Project Type:
- Advanced-Java

Slip Number:
- Slip-22

Question Number:
- Question 2

Slip Question (From PDF):
- Write a JSP program to accept the details of Account (ANo, Type, Bal) and store it into database and display it in tabular form. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
Database Setup:
CREATE TABLE Account (
  ANo INT PRIMARY KEY,
  Type VARCHAR(100),
  Bal INT
);
INSERT INTO Account VALUES (1, 'Type_demo', 1);

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
