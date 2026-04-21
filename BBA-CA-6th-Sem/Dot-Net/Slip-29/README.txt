Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Language and Form Components:
- Q1_ProgramName.cs: C# Console Application; no form controls are needed.
- Q2_ProgramName.aspx: ASP.NET Web Forms with C#; components needed: TextBox, Label, RequiredFieldValidator, RegularExpressionValidator, CompareValidator, GridView, SqlDataSource.

Database Setup:
CREATE TABLE customer (
  CName VARCHAR(100) PRIMARY KEY,
  Contact INT,
  Email_id INT
);
INSERT INTO customer VALUES ('CName_demo', 1, 1);

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.