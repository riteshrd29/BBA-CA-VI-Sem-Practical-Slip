<%-- Question: Write ASP.Net program to c reate a user control that receives the user name and password from the user and validates them. If the user name is "DYP" and the password is "Pimpri", then the user is authorized, otherwise not. [15 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>Web Form</h3>
    <asp:TextBox ID="txt1" runat="server"></asp:TextBox>
    <asp:Button ID="btnRun" runat="server" Text="Run" OnClick="btnRun_Click" />
    <asp:Label ID="lblOut" runat="server"></asp:Label>
</form>
<script runat="server">
    protected void btnRun_Click(object sender, EventArgs e)
    {
        lblOut.Text = "Web form executed successfully.";
    }
</script>
</body>
</html>
