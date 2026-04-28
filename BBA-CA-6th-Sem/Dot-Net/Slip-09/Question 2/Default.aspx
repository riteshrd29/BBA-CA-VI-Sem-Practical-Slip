<%@ Page Language="C#" Trace="true" %>
<%-- Question: Create an application in ASP.Net that allows the user to enter a number in the textbox named "getnum". Check whether the number in the textbox "getnum" is palindrome or not. Print the message accordingly in the label control named lbldisplay when the user clicks on the button "check". [25 M] --%>
<!DOCTYPE html>
<html>
<head>
    <title>Palindrome Checker</title>
</head>
<body>
<form id="form1" runat="server">
    <h3>Palindrome Number Check</h3>
    <asp:TextBox ID="getnum" runat="server" />
    <asp:Button ID="check" runat="server" Text="Check" OnClick="check_Click" />
    <br /><br />
    <asp:Label ID="lbldisplay" runat="server" />
</form>
<script runat="server">
    protected void check_Click(object sender, EventArgs e)
    {
        string value = getnum.Text.Trim();
        char[] chars = value.ToCharArray();
        Array.Reverse(chars);
        string reversed = new string(chars);
        lbldisplay.Text = value == reversed ? "Palindrome number." : "Not a palindrome number.";
    }
</script>
</body>
</html>
