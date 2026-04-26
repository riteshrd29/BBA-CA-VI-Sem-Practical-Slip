Project Type:
- Advanced-Java

Slip Number:
- Slip-10

Question Number:
- Question 2

Slip Question (From PDF):
- Write a SERVLET program to display the details of Product (ProdCode, PName, Price) on the browser in tabular format. (Use database) [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
Database Setup:
CREATE TABLE Product (
  ProdCode VARCHAR(100) PRIMARY KEY,
  PName VARCHAR(100),
  Price VARCHAR(100)
);
INSERT INTO Product VALUES ('ProdCode_demo', 'PName_demo', 'Price_demo');

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
