<%@ Page Language="C#" Trace="true" %>
<%-- Question: Write ASP.Net application to create a user control that contains a list of colors. Add a button to the Web Form which when clicked changes the color of the form to the color selected from the list. [15 M] --%>
<!DOCTYPE html>
<html>
<head>
    <title>Color Selector</title>
</head>
<body>
<form id="form1" runat="server">
    <div id="pageBody" runat="server">
        <h3>Select a Color</h3>
        <asp:DropDownList ID="ddlColors" runat="server">
            <asp:ListItem>LightBlue</asp:ListItem>
            <asp:ListItem>LightGreen</asp:ListItem>
            <asp:ListItem>LightYellow</asp:ListItem>
            <asp:ListItem>LightPink</asp:ListItem>
        </asp:DropDownList>
        <asp:Button ID="btnChange" runat="server" Text="Change Color" OnClick="btnChange_Click" />
    </div>
</form>
<script runat="server">
    protected void btnChange_Click(object sender, EventArgs e)
    {
        pageBody.Style["background-color"] = ddlColors.SelectedValue;
    }
</script>
</body>
</html>
