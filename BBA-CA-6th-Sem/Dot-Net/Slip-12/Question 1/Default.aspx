<%-- Question: Write ASP.Net program that displays a button in green color and it should change into yellow when the mouse moves over it. [15 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Button Color Change</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Button Color Demo</h3>
            <asp:Button ID="btnColor" runat="server" Text="Hover Me" BackColor="Green" ForeColor="White" onmouseover="this.style.backgroundColor='Yellow'; this.style.color='Black';" onmouseout="this.style.backgroundColor='Green'; this.style.color='White';" />
        </div>
    </form>
</body>
</html>
