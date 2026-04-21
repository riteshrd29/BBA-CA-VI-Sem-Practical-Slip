Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE fields (
  DeptId INT PRIMARY KEY,
  DeptName VARCHAR(100),
  EmpName VARCHAR(100),
  Salary INT
);
INSERT INTO fields VALUES (1, 'DeptName_demo', 'EmpName_demo', 1);

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.