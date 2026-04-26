Project Type:
- Advanced-Java

Slip Number:
- Slip-13

Question Number:
- Question 2

Slip Question (From PDF):
- Write a JSP program to display the details of College (CollegeID, Coll_Name, Address) in tabular form on browser. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
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
