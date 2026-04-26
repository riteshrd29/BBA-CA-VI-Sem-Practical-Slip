Slip-20 | Dot-Net | Question 2

Question:
Write an ASP.NET page that throws IndexOutOfRangeException on button click,
then redirects to a custom error page, with trace enabled.

Run Steps (Visual Studio):
1. File -> Open -> Web Site -> File System.
2. Open this folder and select IIS Express.
3. Set Q2_ProgramName.aspx as Start Page.
4. Press Ctrl+F5.

Toolbox Items Needed:
- Button: 1 (ID: btnGenerateError)
- Label: 1 (ID: lblInfo)

What Should Happen:
1. Open Q2_ProgramName.aspx.
2. Click "Generate Exception".
3. App throws IndexOutOfRangeException.
4. App redirects to Error.aspx.

Files Used:
- Q2_ProgramName.aspx
- Web.config
- Error.aspx

Requirements:
- Visual Studio (ASP.NET and web development workload)
- .NET Framework 4.8 Developer Pack
