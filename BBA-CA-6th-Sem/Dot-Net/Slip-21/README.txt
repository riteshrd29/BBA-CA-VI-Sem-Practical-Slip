Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Language and Form Components:
- Q1_ProgramName.cs: C# Console Application; no form controls are needed.
- Q2_ProgramName.aspx: ASP.NET Web Forms with C#; components needed: GridView, SqlDataSource.

Database Setup:
CREATE TABLE EMP (
  eno INT PRIMARY KEY,
  ename VARCHAR(100),
  edesignation VARCHAR(100),
  salary INT,
  joindate DATE
);
INSERT INTO EMP VALUES (1, 'ename_demo', 'edesignation_demo', 1, '2026-04-21');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.