Project Type:
- Dot-Net

Slip Number:
- Slip-05

Question Number:
- Question 2

Slip Question (From PDF):
- Design a web application form in ASP.Net having loan amount, inte rest rate and duration fields. C alculate the simple interest and perform necessary validation i.e. Ensures data has been entered for each field. Checking for non -numeric value. Assume suitable web-form controls and perform necessary validation. [25 M]

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
- ASP.NET Web Forms with C#; controls used: RequiredFieldValidator, RegularExpressionValidator, CompareValidator, TextBox, Button, Label, GridView, SqlDataSource.

Design Tools (Toolbox) and Suggested Count:
- RequiredFieldValidator: 1
- RegularExpressionValidator: 1
- CompareValidator: 1
- TextBox: 4
- Button: 1
- Label: 1
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
