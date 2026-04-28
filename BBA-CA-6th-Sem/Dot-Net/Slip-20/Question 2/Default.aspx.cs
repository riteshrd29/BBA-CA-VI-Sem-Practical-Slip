using System;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void btnRun_Click(object sender, EventArgs e)
        {
            try
            {
                int[] a = { 10, 20, 30 };
                int x = a[5];
                lblInfo.Text = x.ToString();
            }
            catch
            {
                Response.Redirect("Error.aspx");
            }
        }
    }
}