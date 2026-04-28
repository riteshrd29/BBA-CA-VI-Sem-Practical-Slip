<%-- Question: Write ASP.Net application for the following: 1. Create a table EMP(eno, ename, edesignation, salary, joindate) 2. Insert a Record. 3. Update a record [25 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>EMP Table</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>EMP Table Maintenance</h3>
            <asp:TextBox ID="txtEno" runat="server" /><br /><br />
            <asp:TextBox ID="txtEname" runat="server" /><br /><br />
            <asp:TextBox ID="txtDesignation" runat="server" /><br /><br />
            <asp:TextBox ID="txtSalary" runat="server" /><br /><br />
            <asp:TextBox ID="txtJoinDate" runat="server" /><br /><br />
            <asp:Button ID="btnInsert" runat="server" Text="Insert" OnClick="btnInsert_Click" />
            <asp:Button ID="btnUpdate" runat="server" Text="Update" OnClick="btnUpdate_Click" />
            <br /><br />
            <asp:Label ID="lblMsg" runat="server" />
        </div>
    </form>
</body>
</html>
