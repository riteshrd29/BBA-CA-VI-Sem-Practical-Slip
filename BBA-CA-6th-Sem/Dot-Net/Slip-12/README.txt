Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE player (
  PID INT PRIMARY KEY,
  PName VARCHAR(100),
  Game VARCHAR(100),
  no_of_matches INT
);
INSERT INTO player VALUES (1, 'PName_demo', 'Game_demo', 1);

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.