using System;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected TextBox txtUser;
        protected TextBox txtPass;
        protected Label lblResult;

        protected void btnValidate_Click(object sender, EventArgs e)
        {
            lblResult.Text = (txtUser.Text == "DYP" && txtPass.Text == "Pimpri") ? "User is authorized." : "User is not authorized.";
        }
    }
}