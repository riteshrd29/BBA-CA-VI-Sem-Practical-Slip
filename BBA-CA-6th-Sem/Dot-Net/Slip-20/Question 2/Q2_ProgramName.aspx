<%-- Question: Write a Web application in ASP.Net that generates the “IndexOutOfRange” exception when a button is clicked. Instead of displaying the above exception, it redirects the user to a custom error page. All the above should be done with the trace for the page being enabled. [25 M] --%>
<%-- Instruction: This page is exam-ready. Click the button to generate IndexOutOfRangeException and verify redirection to Error.aspx. --%>
<%@ Page Language="C#" AutoEventWireup="true" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Slip-20 Question 2</title>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>IndexOutOfRange Exception Demo</h3>
            <asp:Label ID="lblInfo" runat="server" Text="Click the button to generate IndexOutOfRangeException."></asp:Label>
            <br /><br />
            <asp:Button ID="btnGenerateError" runat="server" Text="Generate Exception" OnClick="btnGenerateError_Click" />
        </div>

        <script runat="server">
            protected void btnGenerateError_Click(object sender, EventArgs e)
            {
                // Deliberately accessing an invalid index to raise IndexOutOfRangeException.
                int[] numbers = { 10, 20, 30 };
                int value = numbers[5];
                lblInfo.Text = value.ToString();
            }
        </script>
    </form>
</body>
</html>
