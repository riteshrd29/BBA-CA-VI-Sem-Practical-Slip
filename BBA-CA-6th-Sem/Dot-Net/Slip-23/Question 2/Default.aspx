<%-- Question: Create the application in ASP.Net that accepts name, password ,age , email id, and user id. All the information entry is compulsory. Password should be reconfirmed. Age should be within 21 to 30. Email id should be valid. User id should have at least a capital letter and digit as well as length should be between 7 and 20 characters. [25 M] --%>
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
