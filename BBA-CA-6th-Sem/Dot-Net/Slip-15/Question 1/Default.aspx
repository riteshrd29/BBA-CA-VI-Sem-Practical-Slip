<%-- Question: Write ASP.Net application to create a user control that contains a list of colors. Add a button to the Web Form which when clicked changes the color of the form to the color selected from the list. [15 M] --%>
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
