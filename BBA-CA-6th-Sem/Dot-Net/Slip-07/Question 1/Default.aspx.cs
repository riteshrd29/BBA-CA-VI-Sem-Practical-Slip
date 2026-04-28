using System;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected TextBox txtNumber;
        protected Button btnCheck;
        protected Label lblResult;

        protected void btnCheck_Click(object sender, EventArgs e)
        {
            try
            {
                int number;
                if (!int.TryParse(txtNumber.Text, out number))
                {
                    throw new Exception("Enter a valid integer.");
                }

                int sum = 0;
                for (int i = 1; i <= number / 2; i++)
                {
                    if (number % i == 0)
                    {
                        sum += i;
                    }
                }

                if (sum != number)
                {
                    throw new Exception(number + " is not a perfect number.");
                }

                lblResult.Text = number + " is a perfect number.";
            }
            catch (Exception ex)
            {
                lblResult.Text = ex.Message;
            }
        }
    }
}