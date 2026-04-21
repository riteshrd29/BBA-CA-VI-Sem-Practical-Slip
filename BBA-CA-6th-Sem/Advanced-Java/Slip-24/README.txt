Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
CREATE TABLE attributes (
  ENo INT PRIMARY KEY,
  EName VARCHAR(100),
  salary INT,
  Desg VARCHAR(100)
);
INSERT INTO attributes VALUES (1, 'EName_demo', 1, 'Desg_demo');

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
- MySQL Connector/J for JDBC questions.