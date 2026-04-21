Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE Patient (
  PID INT PRIMARY KEY,
  PName VARCHAR(100),
  Contact INT,
  Disease VARCHAR(100)
);
INSERT INTO Patient VALUES (1, 'PName_demo', 1, 'Disease_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.