using System;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void btnValidate_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtUser.Text) || ddlPayment.SelectedIndex == 0 || string.IsNullOrWhiteSpace(txtCard.Text) || string.IsNullOrWhiteSpace(txtPass.Text) || string.IsNullOrWhiteSpace(txtConfirm.Text))
            {
                lblMessage.Text = "All fields are required.";
                return;
            }

            if (txtPass.Text != txtConfirm.Text)
            {
                lblMessage.Text = "Password and confirmation must match.";
                return;
            }

            if (ddlPayment.SelectedValue == "Credit Card" && txtCard.Text.Length < 6)
            {
                lblMessage.Text = "Enter a valid credit card number.";
                return;
            }

            lblMessage.ForeColor = System.Drawing.Color.Green;
            lblMessage.Text = "Validation successful.";
        }
    }
}