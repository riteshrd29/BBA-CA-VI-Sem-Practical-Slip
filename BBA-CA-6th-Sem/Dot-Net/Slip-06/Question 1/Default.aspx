<%-- Question: Write ASP.Net program that displays the names of some flowers in two columns. Bind a label to the RadioButtonList so that when the user selects an option from the list and clicks on a button, the label displays the flower selected by the user. [15 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>Flower Selection</h3>
    <asp:RadioButtonList ID="rblFlower" runat="server">
        <asp:ListItem>Rose</asp:ListItem>
        <asp:ListItem>Lily</asp:ListItem>
        <asp:ListItem>Lotus</asp:ListItem>
    </asp:RadioButtonList>
    <asp:Button ID="btnRun" runat="server" Text="Show" OnClick="btnRun_Click" />
    <asp:Label ID="lblOut" runat="server"></asp:Label>
</form>
<script runat="server">
    protected void btnRun_Click(object sender, EventArgs e)
    {
        lblOut.Text = "Selected: " + rblFlower.SelectedValue;
    }
</script>
</body>
</html>
