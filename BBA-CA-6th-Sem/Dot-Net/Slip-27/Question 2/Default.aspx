<%-- Question: Create a web application in ASP.Net which may have a textbox. Now user must type some data into it, the data he can enter is only 255 characters. After he crosses the limit then the last word should not by typed and at the same time color of textbox should be red. [25 M] --%>
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
