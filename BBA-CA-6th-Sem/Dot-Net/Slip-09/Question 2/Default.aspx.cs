using System;
using System.Linq;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void check_Click(object sender, EventArgs e)
        {
            string value = getnum.Text.Trim();
            string reversed = new string(value.Reverse().ToArray());
            lbldisplay.Text = value == reversed ? "Palindrome number." : "Not a palindrome number.";
        }
    }
}