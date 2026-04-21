Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Language and Form Components:
- Q1_ProgramName.cs: C# Console Application; no form controls are needed.
- Q2_ProgramName.aspx: ASP.NET Web Forms with C#; components needed: GridView, TextBox, Button, Label, SqlDataSource.

Database Setup:
CREATE TABLE Employee (
  ENO INT PRIMARY KEY,
  EName VARCHAR(100)
);
INSERT INTO Employee VALUES (1, 'EName_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.