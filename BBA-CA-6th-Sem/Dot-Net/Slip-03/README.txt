Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Language and Form Components:
- Q1_ProgramName.cs: C# Console Application; no form controls are needed.
- Q2_ProgramName.aspx: ASP.NET Web Forms with C#; components needed: Label, GridView, SqlDataSource.

Database Setup:
CREATE TABLE teacher (
  Tid INT PRIMARY KEY,
  TName VARCHAR(100),
  subject VARCHAR(100)
);
INSERT INTO teacher VALUES (1, 'TName_demo', 'subject_demo');
CREATE TABLE records (
  Max: VARCHAR(100) PRIMARY KEY
);
INSERT INTO records VALUES ('Max:_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.