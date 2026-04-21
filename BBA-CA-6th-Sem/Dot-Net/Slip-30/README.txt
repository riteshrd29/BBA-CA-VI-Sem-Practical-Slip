Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE Supplier (
  SupId INT PRIMARY KEY,
  SupName VARCHAR(100),
  Phone INT,
  Address VARCHAR(100)
);
INSERT INTO Supplier VALUES (1, 'SupName_demo', 1, 'Address_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.