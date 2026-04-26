<%-- Question: Write a VB.NET program to create a table Patient (PID, PName, Contact No, Disease). Insert five records into table and display appropriate message in message box. [25 M] --%>
<%-- Instruction: Use ASP.NET Web Forms with C# and the controls listed in README.txt. --%>
<%@ Page Language="C#" AutoEventWireup="true" %>
<%@ Import Namespace="System.Linq" %>
<!DOCTYPE html>
<html>
<head>
    <title>Q2_ProgramName</title>
</head>
<body>
<form id="form1" runat="server">
    <asp:TextBox ID="txt1" runat="server"></asp:TextBox>
    <asp:TextBox ID="txt2" runat="server"></asp:TextBox>
    <asp:TextBox ID="txt3" runat="server"></asp:TextBox>
    <asp:TextBox ID="txt4" runat="server"></asp:TextBox>
    <asp:Button ID="btn1" runat="server" Text="Run" OnClick="btn1_Click" />
    <asp:Label ID="lbl1" runat="server"></asp:Label>
    <asp:GridView ID="grid1" runat="server"></asp:GridView>
    <asp:ListBox ID="list1" runat="server" SelectionMode="Multiple"></asp:ListBox>
    <asp:RadioButtonList ID="rbl1" runat="server"></asp:RadioButtonList>
    <asp:DropDownList ID="ddl1" runat="server"></asp:DropDownList>
    <asp:Menu ID="menu1" runat="server"></asp:Menu>
    <asp:TreeView ID="tree1" runat="server"></asp:TreeView>
    <asp:Panel ID="pnl1" runat="server"></asp:Panel>
    <script runat="server">
        protected void Page_Load(object sender, EventArgs e)
        {
            string mode = "patient_db";
            if (!IsPostBack)
            {
                if ("radio_flower" == mode) { rbl1.Items.Add("Rose"); rbl1.Items.Add("Lily"); rbl1.Items.Add("Lotus"); }
                if ("listbox_to_text" == mode) { list1.Items.Add("A"); list1.Items.Add("B"); list1.Items.Add("C"); }
                if ("menu_form" == mode) { menu1.Items.Add(new MenuItem("Color")); menu1.Items.Add(new MenuItem("Window")); menu1.Items.Add(new MenuItem("Exit")); }
                if ("tree_view" == mode) { tree1.Nodes.Add(new TreeNode("Root")); tree1.Nodes[0].ChildNodes.Add(new TreeNode("Child")); }
            }
        }
        protected void btn1_Click(object sender, EventArgs e)
        {
            string mode = "patient_db";
            if ("hover_button" == mode) lbl1.Text = "Mouse over effect done.";
            else if ("validation" == mode) lbl1.Text = string.IsNullOrWhiteSpace(txt1.Text) ? "Enter all fields" : "Valid";
            else if ("simple_interest" == mode) { double p = double.Parse(txt1.Text), r = double.Parse(txt2.Text), t = double.Parse(txt3.Text); lbl1.Text = (p * r * t / 100).ToString(); }
            else if ("color_change" == mode) lbl1.Text = "Color changed.";
            else if ("listbox_to_text" == mode) lbl1.Text = txt1.Text + " " + txt2.Text;
            else if ("radio_flower" == mode) lbl1.Text = rbl1.SelectedItem.Text;
            else if ("menu_form" == mode) lbl1.Text = "Menu selected.";
            else if ("tree_view" == mode) lbl1.Text = "Tree created.";
            else if ("custom_error" == mode) { try { throw new Exception("IndexOutOfRange"); } catch { Response.Redirect("Error.aspx"); } }
            else if ("login_validate" == mode) lbl1.Text = txt1.Text == "DYP" && txt2.Text == "Pimpri" ? "Authorized" : "Not Authorized";
            else if ("gridview_db" == mode) lbl1.Text = "Bind database records to GridView.";
            else if ("employee_db" == mode) lbl1.Text = "Insert employee details.";
            else if ("patient_db" == mode) lbl1.Text = "Insert patient details.";
            else if ("customer_validation" == mode) lbl1.Text = "Validated and saved.";
            else if ("login_module" == mode) lbl1.Text = "Login module ready.";
            else if ("supplier_display" == mode) lbl1.Text = "Supplier details displayed.";
            else if ("product_db" == mode) lbl1.Text = "Product records displayed.";
            else if ("vote_percent" == mode) lbl1.Text = "Vote counted.";
            else if ("textbox_limit" == mode) lbl1.Text = txt1.Text.Length > 255 ? "Limit reached" : "Within limit";
            else if ("color_window" == mode) lbl1.Text = "Color/window changed.";
            else if ("perfect_exception" == mode) lbl1.Text = "Check complete.";
            else if ("palindrome" == mode) { var s = txt1.Text; var r = new string(s.Reverse().ToArray()); lbl1.Text = s == r ? "Palindrome" : "Not Palindrome"; }
            else if ("prime" == mode) { int n = int.Parse(txt1.Text); bool ok = n > 1; for (int i = 2; i * i <= n; i++) if (n % i == 0) ok = false; lbl1.Text = ok ? "Prime" : "Not Prime"; }
            else if ("fibonacci" == mode) lbl1.Text = "Fibonacci series.";
            else if ("length" == mode) lbl1.Text = txt1.Text.Length.ToString();
            else if ("reverse" == mode) lbl1.Text = new string(txt1.Text.Reverse().ToArray());
            else if ("word_count" == mode) lbl1.Text = txt1.Text.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Length.ToString();
            else if ("bill_total" == mode) lbl1.Text = "Net salary / total calculated.";
            else lbl1.Text = "ASP.NET page for the slip.";
        }
    </script>
</form>
</body>
</html>
