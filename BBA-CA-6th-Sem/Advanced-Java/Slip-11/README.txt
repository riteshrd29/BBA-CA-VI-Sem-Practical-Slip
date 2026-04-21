Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE Product (
  PID INT PRIMARY KEY,
  PName VARCHAR(100),
  Qty INT,
  Rate INT,
  Amount INT
);
INSERT INTO Product VALUES (1, 'PName_demo', 1, 1, 1);

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
- MySQL Connector/J for JDBC questions.