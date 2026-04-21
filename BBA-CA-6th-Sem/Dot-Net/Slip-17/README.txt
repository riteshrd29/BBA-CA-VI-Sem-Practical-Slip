Project Type:
- Dot-Net

Execution Steps:
1. Open Q1_ProgramName in the IDE and run it.
2. Open Q2_ProgramName in the IDE and run it.

Database Setup:
CREATE TABLE product (
  PID INT PRIMARY KEY,
  PName VARCHAR(100),
  expiry_date DATE,
  price VARCHAR(100)
);
INSERT INTO product VALUES (1, 'PName_demo', '2026-04-21', 'price_demo');

Dependencies:
- Visual Studio / .NET Framework for the .cs and .aspx files.
- SQL Server / LocalDB for database questions.