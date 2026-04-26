Slip-20 | Dot-Net | Question 2

Question:
Generate IndexOutOfRangeException on button click and redirect to custom error page with trace enabled.

Direct Run (Visual Studio):
1. Open Question2.sln.
2. Select IIS Express for web project or project profile for console.
3. Press F5 (Debug) or Ctrl+F5 (Run).

Expected Output:
1. `Q2_ProgramName.aspx` opens.
2. Click `Generate Exception`.
3. `IndexOutOfRangeException` occurs.
4. App redirects to `Error.aspx`.

Controls Used:
- Button: `btnGenerateError`
- Label: `lblInfo`

Important Files:
- `Slip20Q2.sln`
- `Slip20Q2.csproj`
- `Q2_ProgramName.aspx`
- `Q2_ProgramName.aspx.cs`
- `Q2_ProgramName.aspx.designer.cs`
- `Web.config`
- `Error.aspx`

Requirements:
- Visual Studio 2022 with ASP.NET and web development workload
- .NET Framework 4.8 Developer Pack
