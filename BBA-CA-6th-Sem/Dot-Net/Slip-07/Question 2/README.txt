Project Type:
- Dot-Net

Slip Number:
- Slip-07

Question Number:
- Question 2

Slip Question (From PDF):
- Write a VB.NET program to create a table student (Roll No, SName, Class,City). Insert the records (Max: 5). Update city of students to ‘Pune’ whose city is ‘Mumbai’ and display updated records in GridView.

Ready-to-Run Files in this folder:
- Q2_ProgramName.aspx
- Web.config
- Default.aspx
- Error.aspx
- App_Data/README.txt

Visual Studio Options to Select:
1. File -> Open -> Web Site...
2. In left panel choose: File System.
3. Select this Question 2 folder and click Open.
4. In toolbar choose IIS Express.
5. Right-click Q2_ProgramName.aspx -> Set as Start Page.
6. Press Ctrl+F5 to run.

Language and Form Components:
- ASP.NET Web Forms with C#; controls used: GridView, TextBox, Button, Label, SqlDataSource.

Database Setup:
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

Design Tools (Toolbox) and Suggested Count:
- GridView: 1
- TextBox: 4
- Button: 1
- Label: 1
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
