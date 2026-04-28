using System;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void btnShow_Click(object sender, EventArgs e)
        {
            lblFlower.Text = string.IsNullOrWhiteSpace(rblFlowers.SelectedValue)
                ? "Select a flower first."
                : "Selected Flower: " + rblFlowers.SelectedValue;
        }
    }
}