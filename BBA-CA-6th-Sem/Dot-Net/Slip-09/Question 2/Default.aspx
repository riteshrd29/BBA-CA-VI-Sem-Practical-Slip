<%-- Question: Create an application in ASP.Net that allows the user to enter a number in the textbox named "getnum". Check whether the number in the textbox "getnum" is palindrome or not. Print the message accordingly in the label control named lbldisplay when the user clicks on the button "check". [25 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>Palindrome Check</h3>
    <asp:TextBox ID="getnum" runat="server"></asp:TextBox>
    <asp:Button ID="check" runat="server" Text="Check" OnClick="check_Click" />
    <asp:Label ID="lbldisplay" runat="server"></asp:Label>
</form>
<script runat="server">
    protected void check_Click(object sender, EventArgs e)
    {
        string s = getnum.Text;
        char[] c = s.ToCharArray();
        System.Array.Reverse(c);
        lbldisplay.Text = s == new string(c) ? "Palindrome" : "Not Palindrome";
    }
</script>
</body>
</html>
