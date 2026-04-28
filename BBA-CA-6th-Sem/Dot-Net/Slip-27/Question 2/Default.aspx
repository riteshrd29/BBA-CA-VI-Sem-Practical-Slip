<%-- Question: Create a web application in ASP.Net which may have a textbox. Now user must type some data into it, the data he can enter is only 255 characters. After he crosses the limit then the last word should not be typed and at the same time color of textbox should be red. [25 M] --%>
<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="Default.aspx.cs" Inherits="QuestionWeb._Default" Trace="true" %>
<!DOCTYPE html>
<html>
<head runat="server">
    <title>Textbox Limit</title>
    <script type="text/javascript">
        function limitText(tb) {
            if (tb.value.length > 255) {
                tb.value = tb.value.substring(0, 255);
                tb.style.backgroundColor = 'red';
            } else {
                tb.style.backgroundColor = 'white';
            }
        }
    </script>
</head>
<body>
    <form id="form1" runat="server">
        <div>
            <h3>Limited Textbox</h3>
            <asp:TextBox ID="txtData" runat="server" TextMode="MultiLine" Rows="8" Columns="60" onkeyup="limitText(this);" />
        </div>
    </form>
</body>
</html>
