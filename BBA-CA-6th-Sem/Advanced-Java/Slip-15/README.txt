Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

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
- Tomcat 9+ and Servlet API for servlet-based questions.
- MySQL Connector/J for JDBC questions.