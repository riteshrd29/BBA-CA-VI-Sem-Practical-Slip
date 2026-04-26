<%-- Question: Write a Web application in ASP.Net that generates the “IndexOutOfRange” exception when a button is clicked. Instead of displaying the above exception, it redirects the user to a custom error page. All the above should be done with the trace for the page being enabled. [25 M] --%>
<%-- Instruction: This page is exam-ready. Click the button to generate IndexOutOfRangeException and verify redirection to Error.aspx. --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Q2_ProgramName.aspx.cs" Inherits="Slip20Q2.Q2_ProgramName" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Slip-20 Question 2</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>IndexOutOfRange Exception Demo</h3>
            <asp:Label ID="lblInfo" runat="server" Text="Click the button to generate IndexOutOfRangeException."></asp:Label>
            <br /><br />
            <asp:Button ID="btnGenerateError" runat="server" Text="Generate Exception" OnClick="btnGenerateError_Click" />
        </div>
    </form>
</body>
</html>
