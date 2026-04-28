<%-- Question: Write ASP.Net program containing the following controls: ListBox, Button, Image, Label. The listbox is used to list items available in a store. When the user clicks on an item in the listbox, its image is displayed in the image control. When the user clicks the button, the cost of the selected item is displayed in the control. [25 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Store Items</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Store Item Viewer</h3>
            <asp:ListBox ID="lstItems" runat="server" AutoPostBack="true" OnSelectedIndexChanged="lstItems_SelectedIndexChanged">
                <asp:ListItem Text="Laptop" />
                <asp:ListItem Text="Phone" />
                <asp:ListItem Text="Tablet" />
            </asp:ListBox>
            <br /><br />
            <asp:Image ID="imgItem" runat="server" Width="180" Height="120" />
            <br /><br />
            <asp:Button ID="btnCost" runat="server" Text="Show Cost" OnClick="btnCost_Click" />
            <br /><br />
            <asp:Label ID="lblCost" runat="server" />
        </div>
    </form>
</body>
</html>
