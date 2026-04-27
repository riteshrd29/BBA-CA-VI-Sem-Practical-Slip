<%-- Question: Design a web application form in ASP.Net having loan amount, inte rest rate and duration fields. C alculate the simple interest and perform necessary validation i.e. Ensures data has been entered for each field. Checking for non -numeric value. Assume suitable web-form controls and perform necessary validation. [25 M] --%>
<%@ Page Language="C#" Trace="true" %>
<!DOCTYPE html>
<html>
<head><title>Default</title></head>
<body>

<form id="form1" runat="server">
    <h3>Simple Interest</h3>
    <asp:TextBox ID="txtP" runat="server" placeholder="Principal"></asp:TextBox><br />
    <asp:TextBox ID="txtR" runat="server" placeholder="Rate"></asp:TextBox><br />
    <asp:TextBox ID="txtT" runat="server" placeholder="Time"></asp:TextBox><br />
    <asp:Button ID="btnRun" runat="server" Text="Calculate" OnClick="btnRun_Click" />
    <asp:Label ID="lblOut" runat="server"></asp:Label>
</form>
<script runat="server">
    protected void btnRun_Click(object sender, EventArgs e)
    {
        double p = double.Parse(txtP.Text), r = double.Parse(txtR.Text), t = double.Parse(txtT.Text);
        lblOut.Text = "Simple Interest = " + (p * r * t / 100.0).ToString("0.00");
    }
</script>
</body>
</html>
