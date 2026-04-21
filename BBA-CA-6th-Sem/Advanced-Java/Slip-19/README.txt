Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
CREATE TABLE student (
  rno INT PRIMARY KEY,
  sname VARCHAR(100),
  per INT
);
INSERT INTO student VALUES (1, 'sname_demo', 1);

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
- MySQL Connector/J for JDBC questions.