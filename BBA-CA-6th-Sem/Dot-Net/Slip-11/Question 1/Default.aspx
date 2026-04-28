<%-- Question: Write a ASP.Net program that gets user input such as the user name, mode of payment, appropriate credit card. After the user enters the appropriate values the Validation button validates the values entered. [15 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>User Validation</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>User Validation Form</h3>
            <asp:TextBox ID="txtUser" runat="server" /><br /><br />
            <asp:DropDownList ID="ddlPayment" runat="server"><asp:ListItem>Select</asp:ListItem><asp:ListItem>Cash</asp:ListItem><asp:ListItem>Credit Card</asp:ListItem><asp:ListItem>Debit Card</asp:ListItem></asp:DropDownList><br /><br />
            <asp:TextBox ID="txtCard" runat="server" /><br /><br />
            <asp:TextBox ID="txtPass" runat="server" TextMode="Password" /><br /><br />
            <asp:TextBox ID="txtConfirm" runat="server" TextMode="Password" /><br /><br />
            <asp:Button ID="btnValidate" runat="server" Text="Validation" OnClick="btnValidate_Click" />
            <br /><br />
            <asp:Label ID="lblMessage" runat="server" ForeColor="Red" />
        </div>
    </form>
</body>
</html>
