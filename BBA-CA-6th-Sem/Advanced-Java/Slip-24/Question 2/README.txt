Project Type:
- Advanced-Java

Slip Number:
- Slip-24

Question Number:
- Question 2

Slip Question (From PDF):
- Write a menu driven program in Java for the following: Assume Emp table with attributes ( ENo, EName, salary, Desg ) is already created. 1. Insert 2. Update 3. Delete 4. Search 5. Display 6. Exit. [25 M]

Execution Steps:
1. Open Q2_ProgramName.java in the IDE and run it.

Database Setup:
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
- JDBC driver and a local database server such as MySQL.
