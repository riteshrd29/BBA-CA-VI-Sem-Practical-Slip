using System;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void lstItems_SelectedIndexChanged(object sender, EventArgs e)
        {
            imgItem.ImageUrl = string.Empty;
            switch (lstItems.SelectedValue)
            {
                case "Laptop": imgItem.ImageUrl = "laptop.jpg"; break;
                case "Phone": imgItem.ImageUrl = "phone.jpg"; break;
                case "Tablet": imgItem.ImageUrl = "tablet.jpg"; break;
            }
        }

        protected void btnCost_Click(object sender, EventArgs e)
        {
            switch (lstItems.SelectedValue)
            {
                case "Laptop": lblCost.Text = "Cost: 65000"; break;
                case "Phone": lblCost.Text = "Cost: 25000"; break;
                case "Tablet": lblCost.Text = "Cost: 18000"; break;
                default: lblCost.Text = "Select an item."; break;
            }
        }
    }
}