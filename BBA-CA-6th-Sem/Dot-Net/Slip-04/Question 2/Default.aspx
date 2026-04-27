<%-- Question: Create a web application to insert 3 records inside the SQL database table having following fields ( DeptId, DeptName, EmpName, Salary). Update the salary for any one employee and increment it to 15% of the present salar y. Perform delete operation on one row of the database table. [25 M] --%>
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
