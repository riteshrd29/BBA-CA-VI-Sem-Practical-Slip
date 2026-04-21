Project Type:
- Advanced-Java

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
CREATE TABLE College (
  CollegeID INT PRIMARY KEY,
  Coll_Name VARCHAR(100),
  Address VARCHAR(100)
);
INSERT INTO College VALUES (1, 'Coll_Name_demo', 'Address_demo');

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
- MySQL Connector/J for JDBC questions.