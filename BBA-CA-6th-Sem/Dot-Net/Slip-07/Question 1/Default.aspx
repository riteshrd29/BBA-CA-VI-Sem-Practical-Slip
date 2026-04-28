<%@ Page Language="C#" Trace="true" %>
<%-- Question: Write a ASP.Net program to accept a number from the user in a textbox control and throw an exception if the number is not a perfect number. Assume suitable controls on the web form. --%>
<!DOCTYPE html>
<html>
<head>
    <title>Perfect Number Check</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Perfect Number Checker</h3>
    <asp:TextBox ID="txtNumber" runat="server" />
    <asp:Button ID="btnCheck" runat="server" Text="Check" OnClick="btnCheck_Click" />
    <br /><br />
    <asp:Label ID="lblResult" runat="server" />
</form>
<script runat="server">
    protected void btnCheck_Click(object sender, EventArgs e)
    {
        try
        {
            int number;
            if (!int.TryParse(txtNumber.Text, out number))
            {
                throw new Exception("Enter a valid integer.");
            }

            int sum = 0;
            for (int i = 1; i <= number / 2; i++)
            {
                if (number % i == 0)
                {
                    sum += i;
                }
            }

            if (sum != number)
            {
                throw new Exception(number + " is not a perfect number.");
            }

            lblResult.Text = number + " is a perfect number.";
        }
        catch (Exception ex)
        {
            lblResult.Text = ex.Message;
        }
    }
</script>
</body>
</html>
