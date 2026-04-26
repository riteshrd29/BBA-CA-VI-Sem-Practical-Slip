Project Type:
- Dot-Net

Slip Number:
- Slip-04

Question Number:
- Question 2

Slip Question (From PDF):
- Create a web application to insert 3 records inside the SQL database table having following fields ( DeptId, DeptName, EmpName, Salary). Update the salary for any one employee and increment it to 15% of the present salar y. Perform delete operation on one row of the database table. [25 M]

Ready-to-Run Files in this folder:
- Q2_ProgramName.aspx
- Web.config
- Default.aspx
- Error.aspx
- App_Data/README.txt

Direct Run (Visual Studio):
1. Open Question2.sln.
2. Select IIS Express for web project or project profile for console.
3. Press F5 (Debug) or Ctrl+F5 (Run).

Visual Studio Options to Select:
1. File -> Open -> Web Site...
2. In left panel choose: File System.
3. Select this Question 2 folder and click Open.
4. In toolbar choose IIS Express.
5. Right-click Q2_ProgramName.aspx -> Set as Start Page.
6. Press Ctrl+F5 to run.

Language and Form Components:
- ASP.NET Web Forms with C#; controls used: GridView, SqlDataSource.

Database Setup:
Database Setup:
CREATE TABLE fields (
  DeptId INT PRIMARY KEY,
  DeptName VARCHAR(100),
  EmpName VARCHAR(100),
  Salary INT
);
INSERT INTO fields VALUES (1, 'DeptName_demo', 'EmpName_demo', 1);

Design Tools (Toolbox) and Suggested Count:
- GridView: 1
- SqlDataSource: 1

Design Steps:
1. Open Q2_ProgramName.aspx in Design view.
2. From Toolbox, drag the controls listed above.
3. Set control IDs exactly as used in code (txt1, txt2, txt3, txt4, btn1, lbl1, etc.).
4. Double-click the Button to create or connect btn1_Click event.
5. Run with IIS Express (Ctrl+F5).

Dependencies:
- Visual Studio with ASP.NET and web development workload.
- .NET Framework 4.8 Developer Pack.
- SQL Server Express / LocalDB for database questions.
