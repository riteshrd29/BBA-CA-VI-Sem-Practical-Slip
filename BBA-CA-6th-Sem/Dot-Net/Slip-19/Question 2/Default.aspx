<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<%-- Question: "How is the book ASP.NET with C# by Wrox publication?" Give the user three choices: Good, Satisfactory, Bad. Provide a VOTE button. After user votes, present the result in percentage using labels next to the choices. [25 M] --%>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Book Vote</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Book Feedback</h3>
            <asp:RadioButtonList ID="rblVote" runat="server">
                <asp:ListItem>Good</asp:ListItem>
                <asp:ListItem>Satisfactory</asp:ListItem>
                <asp:ListItem>Bad</asp:ListItem>
            </asp:RadioButtonList>
            <asp:Button ID="btnVote" runat="server" Text="VOTE" OnClick="btnVote_Click" />
            <br /><br />
            <asp:Label ID="lblResult" runat="server" />
        </div>
    </form>
</body>
</html>
