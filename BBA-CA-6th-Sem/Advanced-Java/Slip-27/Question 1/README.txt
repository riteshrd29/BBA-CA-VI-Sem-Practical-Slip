Project Type:
- Advanced-Java

Slip Number:
- Slip-27

Question Number:
- Question 1

Slip Question (From PDF):
- Write a JSP script to accept the details of Teacher (TID, TName, Desg, Subject , Qualification) and display it on the browser. Use appropriate controls for accepting data. [15 M]

Execution Steps:
1. Open Q1_ProgramName.java in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
Database Setup:
CREATE TABLE Teacher (
  TID INT PRIMARY KEY,
  TName VARCHAR(100),
  Desg VARCHAR(100),
  Subject VARCHAR(100),
  Qualification VARCHAR(100)
);
INSERT INTO Teacher VALUES (1, 'TName_demo', 'Desg_demo', 'Subject_demo', 'Qualification_demo');

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
