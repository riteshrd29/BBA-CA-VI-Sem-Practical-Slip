using System;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected DropDownList ddlColors;
        protected Button btnChange;
        protected HtmlGenericControl pageBody;

        protected void btnChange_Click(object sender, EventArgs e)
        {
            pageBody.Style["background-color"] = ddlColors.SelectedValue;
        }
    }
}