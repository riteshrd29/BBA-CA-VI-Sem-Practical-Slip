<%@ Page Language="C#" Trace="true" %>
<%-- Question: Create the application in ASP.Net that accepts name, password, age, email id, and user id. All the information entry is compulsory. Password should be reconfirmed. Age should be within 21 to 30. Email id should be valid. User id should have at least a capital letter and digit as well as length should be between 7 and 20 characters. [25 M] --%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration Validation</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 24px; }
        .row { margin-bottom: 8px; }
        label { display: inline-block; width: 150px; }
    </style>
</head>
<body>
<form id="form1" runat="server">
    <h3>User Registration</h3>
    <div class="row"><label>Name:</label><asp:TextBox ID="txtName" runat="server" /></div>
    <div class="row"><label>Password:</label><asp:TextBox ID="txtPassword" runat="server" TextMode="Password" /></div>
    <div class="row"><label>Confirm Password:</label><asp:TextBox ID="txtConfirm" runat="server" TextMode="Password" /></div>
    <div class="row"><label>Age:</label><asp:TextBox ID="txtAge" runat="server" /></div>
    <div class="row"><label>Email ID:</label><asp:TextBox ID="txtEmail" runat="server" /></div>
    <div class="row"><label>User ID:</label><asp:TextBox ID="txtUserId" runat="server" /></div>
    <asp:Button ID="btnValidate" runat="server" Text="Validate" OnClick="btnValidate_Click" />
    <br /><br />
    <asp:Label ID="lblMsg" runat="server" ForeColor="Red" />
</form>
<script runat="server">
    protected void btnValidate_Click(object sender, EventArgs e)
    {
        if (string.IsNullOrWhiteSpace(txtName.Text) || string.IsNullOrWhiteSpace(txtPassword.Text) || string.IsNullOrWhiteSpace(txtConfirm.Text) || string.IsNullOrWhiteSpace(txtAge.Text) || string.IsNullOrWhiteSpace(txtEmail.Text) || string.IsNullOrWhiteSpace(txtUserId.Text))
        {
            lblMsg.Text = "All fields are compulsory.";
            return;
        }
        if (txtPassword.Text != txtConfirm.Text)
        {
            lblMsg.Text = "Password reconfirmation failed.";
            return;
        }
        int age;
        if (!int.TryParse(txtAge.Text, out age) || age < 21 || age > 30)
        {
            lblMsg.Text = "Age must be between 21 and 30.";
            return;
        }
        if (txtEmail.Text.IndexOf("@") < 0 || txtEmail.Text.IndexOf(".") < 0)
        {
            lblMsg.Text = "Enter a valid email id.";
            return;
        }
        string userId = txtUserId.Text;
        bool hasUpper = false;
        bool hasDigit = false;
        foreach (char c in userId)
        {
            if (char.IsUpper(c)) hasUpper = true;
            if (char.IsDigit(c)) hasDigit = true;
        }
        if (userId.Length < 7 || userId.Length > 20 || !hasUpper || !hasDigit)
        {
            lblMsg.Text = "User ID must be 7 to 20 characters and include at least one capital letter and one digit.";
            return;
        }
        lblMsg.ForeColor = System.Drawing.Color.Green;
        lblMsg.Text = "Validation successful.";
    }
</script>
</body>
</html>
