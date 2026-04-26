Project Type:
- Advanced-Java

Slip Number:
- Slip-26

Question Number:
- Question 2

Slip Question (From PDF):
- Write a SERVLET program to Design an HTML page containing 4 option buttons (Painting, Drawing, Singing and swimming) and 2 buttons reset and submit. When the user clicks submit, the server responds by adding cookie containing the selected hobby and sends the HTML page to the client. Program should not allow duplicate cookies to be written. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Web Note:
- Deploy the Java file inside a Dynamic Web Project with Tomcat.

Database Setup:
Database Setup:
CREATE TABLE buttons (
  Painting VARCHAR(100) PRIMARY KEY,
  Drawing VARCHAR(100),
  Singing VARCHAR(100)
);
INSERT INTO buttons VALUES ('Painting_demo', 'Drawing_demo', 'Singing_demo');

Dependencies:
- JDK 8+.
- Tomcat 9+ and Servlet API for servlet-based questions.
