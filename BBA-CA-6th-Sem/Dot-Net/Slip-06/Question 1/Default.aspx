<%-- Question: Write ASP.Net program that displays the names of some flowers in two columns. Bind a label to the RadioButtonList so that when the user selects an option from the list and clicks on a button, the label displays the flower selected by the user. [15 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Flower Selection</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Select a Flower</h3>
            <asp:RadioButtonList ID="rblFlowers" runat="server" RepeatColumns="2">
                <asp:ListItem>Rose</asp:ListItem>
                <asp:ListItem>Lily</asp:ListItem>
                <asp:ListItem>Lotus</asp:ListItem>
                <asp:ListItem>Jasmine</asp:ListItem>
                <asp:ListItem>Sunflower</asp:ListItem>
                <asp:ListItem>Tulip</asp:ListItem>
            </asp:RadioButtonList>
            <asp:Button ID="btnShow" runat="server" Text="Show Flower" OnClick="btnShow_Click" />
            <br /><br />
            <asp:Label ID="lblFlower" runat="server" Font-Bold="true" />
        </div>
    </form>
</body>
</html>
