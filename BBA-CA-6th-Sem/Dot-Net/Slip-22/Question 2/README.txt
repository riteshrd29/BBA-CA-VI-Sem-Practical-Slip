Project Type:
- Dot-Net

Slip Number:
- Slip-22

Question Number:
- Question 2

Slip Question (From PDF):
- Write a Vb.net program to design the following form; it contains the three menus Color (Red, Blue, and Green), Window (Maximize, Minimize, and Restore) and Exit. On Selection of any menu or submenu result should affect the form control( for example if user selecte d Red color from Color menu back color of form should get changed to Red and if user selected Maximize from Window Menu then form should get maximized). [25 M]

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
- ASP.NET Web Forms with C#; controls used: Menu, Label, Button.

Database Setup:
Database Setup:
CREATE TABLE Color (
  Red VARCHAR(100) PRIMARY KEY,
  Blue VARCHAR(100),
  and VARCHAR(100)
);
INSERT INTO Color VALUES ('Red_demo', 'Blue_demo', 'and_demo');
CREATE TABLE Window (
  Maximize VARCHAR(100) PRIMARY KEY,
  Minimize VARCHAR(100),
  and VARCHAR(100)
);
INSERT INTO Window VALUES ('Maximize_demo', 'Minimize_demo', 'and_demo');
CREATE TABLE control (
  for VARCHAR(100) PRIMARY KEY
);
INSERT INTO control VALUES ('for_demo');

Design Tools (Toolbox) and Suggested Count:
- Menu: 1
- Label: 1
- Button: 1

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
