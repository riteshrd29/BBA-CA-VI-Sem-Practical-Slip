<%-- Question: Write a ASP.Net program to accept a number from the user in a textbox control and throw an exception if the number is not a perfect number. Assume suitable controls on the web form. --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>Perfect Number Exception Check</h3>
    <asp:TextBox ID="txtNum" runat="server"></asp:TextBox>
    <asp:Button ID="btnRun" runat="server" Text="Check" OnClick="btnRun_Click" />
    <asp:Label ID="lblOut" runat="server"></asp:Label>
</form>
<script runat="server">
    bool IsPerfect(int n){ if(n<=1) return false; int s=1; for(int i=2;i<=n/2;i++) if(n%i==0) s+=i; return s==n; }
    protected void btnRun_Click(object sender, EventArgs e)
    {
        int n = int.Parse(txtNum.Text);
        if (!IsPerfect(n)) throw new Exception("Not a perfect number");
        lblOut.Text = "Perfect Number";
    }
</script>
</body>
</html>
