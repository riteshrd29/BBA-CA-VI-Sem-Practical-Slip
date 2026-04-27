<%-- Question: Create a Web Application in ASP.Net to display all the Empname and Deptid of the employee from the database using SQL source control and bind it to GridView. Database fields are(DeptId, DeptName, EmpName, Salary). [25 M] --%>
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
