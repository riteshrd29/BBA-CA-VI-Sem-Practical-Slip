Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Language and Form Components:
- Q1_ProgramName.cs: C# Console Application; no form controls are needed.
- Q2_ProgramName.aspx: ASP.NET Web Forms with C#; components needed: GridView, TextBox, Button, Label, SqlDataSource.

Database Setup:
CREATE TABLE student (
  Roll VARCHAR(100) PRIMARY KEY,
  SName VARCHAR(100),
  Class VARCHAR(100),
  City VARCHAR(100)
);
INSERT INTO student VALUES ('Roll_demo', 'SName_demo', 'Class_demo', 'City_demo');
CREATE TABLE records (
  Max: VARCHAR(100) PRIMARY KEY
);
INSERT INTO records VALUES ('Max:_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.