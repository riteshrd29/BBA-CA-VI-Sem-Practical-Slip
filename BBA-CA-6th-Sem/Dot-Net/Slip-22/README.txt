Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE Color (
  Red VARCHAR(100) PRIMARY KEY,
  Blue VARCHAR(100),
  and VARCHAR(100)
);
INSERT INTO Color VALUES ('Red_demo', 'Blue_demo', 'and_demo');
CREATE TABLE Window (
  Maximize VARCHAR(100) PRIMARY KEY,
  Minimize VARCHAR(100),
  and VARCHAR(100)
);
INSERT INTO Window VALUES ('Maximize_demo', 'Minimize_demo', 'and_demo');
CREATE TABLE control (
  for VARCHAR(100) PRIMARY KEY
);
INSERT INTO control VALUES ('for_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.