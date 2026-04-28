using System;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void btnCalc_Click(object sender, EventArgs e)
        {
            lblMsg.Text = string.Empty;
            lblResult.Text = string.Empty;

            if (string.IsNullOrWhiteSpace(txtLoan.Text) || string.IsNullOrWhiteSpace(txtRate.Text) || string.IsNullOrWhiteSpace(txtDuration.Text))
            {
                lblMsg.Text = "All fields are required.";
                return;
            }

            if (!decimal.TryParse(txtLoan.Text, out decimal principal) || !decimal.TryParse(txtRate.Text, out decimal rate) || !decimal.TryParse(txtDuration.Text, out decimal years))
            {
                lblMsg.Text = "Enter numeric values only.";
                return;
            }

            decimal si = (principal * rate * years) / 100m;
            decimal total = principal + si;
            lblResult.Text = "Simple Interest: " + si.ToString("F2") + "<br />Total Amount: " + total.ToString("F2");
        }
    }
}