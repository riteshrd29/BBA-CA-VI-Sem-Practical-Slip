<%-- Question: Write a ASP.Net pr ogram that gets user input such as the user name, mode of payment, appropriate credit card. After the user enters the appropriate values the Validation button validates the values entered. [15 M] --%>
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
