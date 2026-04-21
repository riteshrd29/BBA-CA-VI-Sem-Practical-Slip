Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE lifecycle (
  creation VARCHAR(100) PRIMARY KEY,
  sleep VARCHAR(100),
  and VARCHAR(100)
);
INSERT INTO lifecycle VALUES ('creation_demo', 'sleep_demo', 'and_demo');

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
- MySQL Connector/J for JDBC questions.