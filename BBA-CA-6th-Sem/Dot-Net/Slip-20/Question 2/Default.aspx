<%-- Question: Write a Web application in ASP.Net that generates the “IndexOutOfRange” exception when a button is clicked. Instead of displaying the above exception, it redirects the user to a custom error page. All the above should be done with the trace for the page being enabled. [25 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>IndexOutOfRange Exception Demo</h3>
    <asp:Label ID="lblInfo" runat="server" Text="Click button to generate exception."></asp:Label><br /><br />
    <asp:Button ID="btnRun" runat="server" Text="Generate Exception" OnClick="btnRun_Click" />
</form>
<script runat="server">
    protected void btnRun_Click(object sender, EventArgs e)
    {
        int[] a = {10, 20, 30};
        int x = a[5];
        lblInfo.Text = x.ToString();
    }
</script>
</body>
</html>
