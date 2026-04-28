using System;
using System.Data.SqlClient;
using System.Web.UI;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        const string Cs = "Data Source=(LocalDB)\\MSSQLLocalDB;AttachDbFilename=|DataDirectory|Emp.mdf;Integrated Security=True;";

        protected void btnInsert_Click(object sender, EventArgs e)
        {
            ExecuteNonQuery("INSERT INTO EMP(eno, ename, edesignation, salary, joindate) VALUES (@eno,@ename,@edesignation,@salary,@joindate)");
            lblMsg.Text = "Record inserted.";
        }

        protected void btnUpdate_Click(object sender, EventArgs e)
        {
            ExecuteNonQuery("UPDATE EMP SET ename=@ename, edesignation=@edesignation, salary=@salary, joindate=@joindate WHERE eno=@eno");
            lblMsg.Text = "Record updated.";
        }

        private void ExecuteNonQuery(string sql)
        {
            using (var conn = new SqlConnection(Cs))
            using (var cmd = new SqlCommand(sql, conn))
            {
                cmd.Parameters.AddWithValue("@eno", txtEno.Text);
                cmd.Parameters.AddWithValue("@ename", txtEname.Text);
                cmd.Parameters.AddWithValue("@edesignation", txtDesignation.Text);
                cmd.Parameters.AddWithValue("@salary", txtSalary.Text);
                cmd.Parameters.AddWithValue("@joindate", txtJoinDate.Text);
                conn.Open();
                cmd.ExecuteNonQuery();
            }
        }
    }
}