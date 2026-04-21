<%-- Question: Create the application in ASP.Net that accepts name, password ,age , email id, and user id. All the information entry is compulsory. Password should be reconfirmed. Age should be within 21 to 30. Email id should be valid. User id should have at least a capital letter and digit as well as length should be between 7 and 20 characters. [25 M] --%>
<%-- Instruction: Use ASP.NET Web Forms with C# and the controls listed in README.txt. --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Q2_ProgramName.aspx.cs" Inherits="Slip23.Q2_ProgramName" %>
<!DOCTYPE html>
<html>
<head>
    <title>Q2_ProgramName</title>
</head>
<body>
<form id="form1" runat="server">
    <asp:TextBox ID="txt1" runat="server"></asp:TextBox>
    <asp:TextBox ID="txt2" runat="server"></asp:TextBox>
    <asp:TextBox ID="txt3" runat="server"></asp:TextBox>
    <asp:TextBox ID="txt4" runat="server"></asp:TextBox>
    <asp:Button ID="btn1" runat="server" Text="Run" OnClick="btn1_Click" />
    <asp:Label ID="lbl1" runat="server"></asp:Label>
    <asp:GridView ID="grid1" runat="server"></asp:GridView>
    <asp:ListBox ID="list1" runat="server" SelectionMode="Multiple"></asp:ListBox>
    <asp:RadioButtonList ID="rbl1" runat="server"></asp:RadioButtonList>
    <asp:DropDownList ID="ddl1" runat="server"></asp:DropDownList>
    <asp:Menu ID="menu1" runat="server"></asp:Menu>
    <asp:TreeView ID="tree1" runat="server"></asp:TreeView>
    <asp:Panel ID="pnl1" runat="server"></asp:Panel>
</form>
</body>
</html>
