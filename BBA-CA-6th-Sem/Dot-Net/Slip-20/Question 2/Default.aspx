<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>IndexOutOfRange Demo</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Exception Demo</h3>
            <asp:Label ID="lblInfo" runat="server" Text="Click to generate exception." />
            <br /><br />
            <asp:Button ID="btnRun" runat="server" Text="Generate Exception" OnClick="btnRun_Click" />
        </div>
    </form>
</body>
</html>
