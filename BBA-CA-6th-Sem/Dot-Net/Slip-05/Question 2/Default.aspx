<%-- Question: Design a web application form in ASP.Net having loan amount, interest rate and duration fields. Calculate the simple interest and perform necessary validation i.e. ensures data has been entered for each field. Checking for non-numeric value. Assume suitable web-form controls and perform necessary validation. [25 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Loan Calculator</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Simple Interest Calculator</h3>
            <asp:TextBox ID="txtLoan" runat="server" /><br /><br />
            <asp:TextBox ID="txtRate" runat="server" /><br /><br />
            <asp:TextBox ID="txtDuration" runat="server" /><br /><br />
            <asp:Button ID="btnCalc" runat="server" Text="Calculate" OnClick="btnCalc_Click" />
            <br /><br />
            <asp:Label ID="lblMsg" runat="server" />
            <br /><br />
            <asp:Label ID="lblResult" runat="server" />
        </div>
    </form>
</body>
</html>
