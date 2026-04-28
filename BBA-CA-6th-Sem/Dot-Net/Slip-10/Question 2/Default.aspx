<%@ Page Language="C#" Trace="true" %>
<%-- Question: Write ASP.Net program to connect to the master database in SQL Server in the Page_Load event. When the connection is established, the message “Connection has been established” should be displayed in a label in the form . [25 M] --%>
<!DOCTYPE html>
<html>
<head>
    <title>SQL Connection</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Database Connection Test</h3>
    <asp:Label ID="lblStatus" runat="server" />
</form>
<script runat="server">
    protected void Page_Load(object sender, EventArgs e)
    {
        try
        {
            using (var connection = new System.Data.SqlClient.SqlConnection("Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=master;Integrated Security=True;"))
            {
                connection.Open();
                lblStatus.Text = "Connection has been established";
            }
        }
        catch
        {
            lblStatus.Text = "Connection could not be established";
        }
    }
</script>
</body>
</html>
