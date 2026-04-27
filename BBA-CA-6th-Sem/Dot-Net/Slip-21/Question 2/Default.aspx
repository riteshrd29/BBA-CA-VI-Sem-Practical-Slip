<%-- Question: Write ASP.Net application for the following: 1. Create a table EMP(eno, ename, edesignation, salary, joindate) 2. Insert a Record. 3. Update a record [25 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>Database/GridView Demo</h3>
    <asp:Label ID="lblOut" runat="server" Text="Configure DB connection string as per exam machine."></asp:Label><br />
    <asp:GridView ID="grid1" runat="server"></asp:GridView>
</form>
<script runat="server">
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack) lblOut.Text = "GridView page is ready.";
    }
</script>
</body>
</html>
