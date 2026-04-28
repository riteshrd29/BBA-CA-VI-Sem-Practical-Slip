<%-- Question: List of employees is available in listbox. Write ASP.Net application to add selected or all records from listbox to Textbox (assume multi-line property of textbox is true). [15 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Employees</h3>
    <asp:ListBox ID="lstEmployees" runat="server" SelectionMode="Multiple">
        <asp:ListItem>Amit</asp:ListItem>
        <asp:ListItem>Bhavna</asp:ListItem>
        <asp:ListItem>Chirag</asp:ListItem>
        <asp:ListItem>Divya</asp:ListItem>
        <asp:ListItem>Ekta</asp:ListItem>
    </asp:ListBox>
    <br /><br />
    <asp:Button ID="btnSelected" runat="server" Text="Add Selected" OnClick="btnSelected_Click" />
    <asp:Button ID="btnAll" runat="server" Text="Add All" OnClick="btnAll_Click" />
    <br /><br />
    <asp:TextBox ID="txtOutput" runat="server" TextMode="MultiLine" Rows="10" Columns="40" />
</form>
<script runat="server">
    protected void btnSelected_Click(object sender, EventArgs e)
    {
        txtOutput.Text = string.Empty;
        foreach (ListItem item in lstEmployees.Items)
        {
            if (item.Selected)
            {
                txtOutput.Text += item.Text + Environment.NewLine;
            }
        }
    }

    protected void btnAll_Click(object sender, EventArgs e)
    {
        txtOutput.Text = string.Empty;
        foreach (ListItem item in lstEmployees.Items)
        {
            txtOutput.Text += item.Text + Environment.NewLine;
        }
    }
</script>
</body>
</html>
