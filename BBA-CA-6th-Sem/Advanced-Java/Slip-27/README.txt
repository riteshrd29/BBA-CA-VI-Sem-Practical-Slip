Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

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
- MySQL Connector/J for JDBC questions.