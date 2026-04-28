<%-- Question: Write a ASP.Net program to create a Login Module which adds Username and Password in the database. Username in the database should be a primary key. [25 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Module</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Login Module</h3>
    <asp:Label ID="Label1" runat="server" Text="Username:" />
    <asp:TextBox ID="txtUser" runat="server" /><br /><br />
    <asp:Label ID="Label2" runat="server" Text="Password:" />
    <asp:TextBox ID="txtPass" runat="server" TextMode="Password" /><br /><br />
    <asp:Button ID="btnSave" runat="server" Text="Save" OnClick="btnSave_Click" />
    <br /><br />
    <asp:Label ID="lblMsg" runat="server" />
</form>
<script runat="server">
    protected void btnSave_Click(object sender, EventArgs e)
    {
        const string cs = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|Login.mdf;Integrated Security=True;";
        using (var conn = new System.Data.SqlClient.SqlConnection(cs))
        using (var cmd = new System.Data.SqlClient.SqlCommand("INSERT INTO LoginTable(Username, Password) VALUES(@u,@p)", conn))
        {
            cmd.Parameters.AddWithValue("@u", txtUser.Text);
            cmd.Parameters.AddWithValue("@p", txtPass.Text);
            conn.Open();
            cmd.ExecuteNonQuery();
            lblMsg.Text = "Record saved.";
        }
    }
</script>
</body>
</html>
