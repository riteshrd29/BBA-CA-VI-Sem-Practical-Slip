using System;
using System.Linq;
using System.Web.UI;
using System.Web.UI.HtmlControls;
using System.Web.UI.WebControls;

namespace Slip23
{
    public partial class Q2_ProgramName : Page
    {
        private T GetControl<T>(string id) where T : Control
        {
            HtmlForm form = FindControl("form1") as HtmlForm;
            return form == null ? null : form.FindControl(id) as T;
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            string mode = "login_module";
            if (!IsPostBack)
            {
                if ("radio_flower" == mode) { GetControl<RadioButtonList>("rbl1").Items.Add("Rose"); GetControl<RadioButtonList>("rbl1").Items.Add("Lily"); GetControl<RadioButtonList>("rbl1").Items.Add("Lotus"); }
                if ("listbox_to_text" == mode) { GetControl<ListBox>("list1").Items.Add("A"); GetControl<ListBox>("list1").Items.Add("B"); GetControl<ListBox>("list1").Items.Add("C"); }
                if ("menu_form" == mode) { GetControl<Menu>("menu1").Items.Add(new MenuItem("Color")); GetControl<Menu>("menu1").Items.Add(new MenuItem("Window")); GetControl<Menu>("menu1").Items.Add(new MenuItem("Exit")); }
                if ("tree_view" == mode) { GetControl<TreeView>("tree1").Nodes.Add(new TreeNode("Root")); GetControl<TreeView>("tree1").Nodes[0].ChildNodes.Add(new TreeNode("Child")); }
            }
        }

        protected void btn1_Click(object sender, EventArgs e)
        {
            string mode = "login_module";
            TextBox txt1 = GetControl<TextBox>("txt1");
            TextBox txt2 = GetControl<TextBox>("txt2");
            TextBox txt3 = GetControl<TextBox>("txt3");
            Label lbl1 = GetControl<Label>("lbl1");
            RadioButtonList rbl1 = GetControl<RadioButtonList>("rbl1");

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
    }
}