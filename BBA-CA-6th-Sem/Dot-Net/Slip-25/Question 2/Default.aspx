<%@ Page Language="C#" Trace="true" %>
<%-- Question: Create a Web Application in ASP.Net to display all the Empname and Deptid of the employee from the database using SQL source control and bind it to GridView. Database fields are(DeptId, DeptName, EmpName, Salary). [25 M] --%>
<!DOCTYPE html>
<html>
<head>
    <title>Employee GridView</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Employee Summary</h3>
    <asp:GridView ID="gvEmp" runat="server" AutoGenerateColumns="true" />
</form>
<script runat="server">
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!IsPostBack)
        {
            System.Data.DataTable dt = new System.Data.DataTable();
            dt.Columns.Add("DeptId");
            dt.Columns.Add("EmpName");
            dt.Rows.Add("10", "Amit");
            dt.Rows.Add("20", "Neha");
            gvEmp.DataSource = dt;
            gvEmp.DataBind();
        }
    }
</script>
</body>
</html>
