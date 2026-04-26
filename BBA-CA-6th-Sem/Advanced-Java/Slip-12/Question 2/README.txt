Project Type:
- Advanced-Java

Slip Number:
- Slip-12

Question Number:
- Question 2

Slip Question (From PDF):
- Write a program in java which will show lifecycle (creation, sleep, and dead) of a thread. Program should print randomly the name of thread and value of sleep time. The name of the thread should be hard coded through constructor. The sleep time of a thread will be a random integer in the range 0 to 4999. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
Database Setup:
CREATE TABLE lifecycle (
  creation VARCHAR(100) PRIMARY KEY,
  sleep VARCHAR(100),
  and VARCHAR(100)
);
INSERT INTO lifecycle VALUES ('creation_demo', 'sleep_demo', 'and_demo');

Dependencies:
- JDK 8+.
- JDBC driver and a local database server such as MySQL.
