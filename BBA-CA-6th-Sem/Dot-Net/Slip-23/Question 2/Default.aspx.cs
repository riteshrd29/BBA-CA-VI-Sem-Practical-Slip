using System;
using System.Linq;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected TextBox txtName;
        protected TextBox txtPassword;
        protected TextBox txtConfirm;
        protected TextBox txtAge;
        protected TextBox txtEmail;
        protected TextBox txtUserId;
        protected Button btnValidate;
        protected Label lblMsg;

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
    }
}