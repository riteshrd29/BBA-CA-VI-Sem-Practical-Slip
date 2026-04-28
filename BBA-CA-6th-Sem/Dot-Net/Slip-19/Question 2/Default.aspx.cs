using System;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected RadioButtonList rblVote;
        protected Button btnVote;
        protected Label lblResult;
        static int good, satisfactory, bad;

        protected void btnVote_Click(object sender, EventArgs e)
        {
            if (rblVote.SelectedValue == "Good") good++;
            else if (rblVote.SelectedValue == "Satisfactory") satisfactory++;
            else if (rblVote.SelectedValue == "Bad") bad++;

            int total = good + satisfactory + bad;
            if (total == 0) total = 1;
            lblResult.Text = "Good: " + (good * 100 / total) + "%<br/>Satisfactory: " + (satisfactory * 100 / total) + "%<br/>Bad: " + (bad * 100 / total) + "%";
        }
    }
}