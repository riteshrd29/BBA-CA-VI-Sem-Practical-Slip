using System;
using System.Data;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace QuestionWeb
{
    public partial class _Default : Page
    {
        protected GridView gvEmp;

        protected void Page_Load(object sender, EventArgs e)
        {
            if (!IsPostBack)
            {
                DataTable dt = new DataTable();
                dt.Columns.Add("DeptId");
                dt.Columns.Add("EmpName");
                dt.Rows.Add("10", "Amit");
                dt.Rows.Add("20", "Neha");
                gvEmp.DataSource = dt;
                gvEmp.DataBind();
            }
        }
    }
}