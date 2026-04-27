<%-- Question: List of employees is available in listbox. Write ASP.Net application to add selected or all records from listbox to Textbox (assume multi-line property of textbox is true). [15 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>ListBox to TextBox</h3>
    <asp:ListBox ID="lstEmp" runat="server" SelectionMode="Multiple">
        <asp:ListItem>Amit</asp:ListItem>
        <asp:ListItem>Seeta</asp:ListItem>
        <asp:ListItem>Ravi</asp:ListItem>
    </asp:ListBox><br />
    <asp:Button ID="btnRun" runat="server" Text="Copy" OnClick="btnRun_Click" />
    <asp:TextBox ID="txtOut" runat="server" TextMode="MultiLine" Rows="4" Columns="30"></asp:TextBox>
</form>
<script runat="server">
    protected void btnRun_Click(object sender, EventArgs e)
    {
        System.Text.StringBuilder sb = new System.Text.StringBuilder();
        foreach (System.Web.UI.WebControls.ListItem it in lstEmp.Items) if (it.Selected) sb.AppendLine(it.Text);
        txtOut.Text = sb.ToString();
    }
</script>
</body>
</html>
