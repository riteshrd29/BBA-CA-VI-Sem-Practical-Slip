using System;
using System.Data.SqlClient;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            try
            {
                using (var connection = new SqlConnection("Data Source=(localdb)\\MSSQLLocalDB;Initial Catalog=master;Integrated Security=True;"))
                {
                    connection.Open();
                    lblStatus.Text = "Connection has been established";
                }
            }
            catch
            {
                lblStatus.Text = "Connection could not be established";
            }
        }
    }
}