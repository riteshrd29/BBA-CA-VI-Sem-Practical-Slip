<%@ Page Language="C#" Trace="true" %>
<%-- Question: Write ASP.Net program to create a user control that receives the user name and password from the user and validates them. If the user name is "DYP" and the password is "Pimpri", then the user is authorized, otherwise not. [15 M] --%>
<!DOCTYPE html>
<html>
<head>
    <title>Login Validation</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Login</h3>
    <asp:Label ID="lblUser" runat="server" Text="User Name:" />
    <asp:TextBox ID="txtUser" runat="server" /><br /><br />
    <asp:Label ID="lblPass" runat="server" Text="Password:" />
    <asp:TextBox ID="txtPass" runat="server" TextMode="Password" /><br /><br />
    <asp:Button ID="btnValidate" runat="server" Text="Validate" OnClick="btnValidate_Click" />
    <br /><br />
    <asp:Label ID="lblResult" runat="server" />
</form>
<script runat="server">
    protected void btnValidate_Click(object sender, EventArgs e)
    {
        lblResult.Text = (txtUser.Text == "DYP" && txtPass.Text == "Pimpri") ? "User is authorized." : "User is not authorized.";
    }
</script>
</body>
</html>
