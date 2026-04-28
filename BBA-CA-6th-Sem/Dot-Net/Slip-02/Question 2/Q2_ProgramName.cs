using System;
using System.Text;
using System.Windows.Forms;

// Question: Write a C#.Net program to create a base class Department and derived classes Sales and Human Resource. Accept the details of both departments and display them in proper format. [25 M]
namespace QuestionWin
{
    public class Department
    {
        public string DepartmentName { get; set; }

        public virtual string Display()
        {
            return $"Department Name: {DepartmentName}";
        }
    }

    public class Sales : Department
    {
        public decimal TargetAmount { get; set; }

        public override string Display()
        {
            return base.Display() + Environment.NewLine + $"Target Amount: {TargetAmount:F2}";
        }
    }

    public class HumanResource : Department
    {
        public int EmployeeCount { get; set; }

        public override string Display()
        {
            return base.Display() + Environment.NewLine + $"Employee Count: {EmployeeCount}";
        }
    }

    public partial class Q2_ProgramName : Form
    {
        public Q2_ProgramName()
        {
            InitializeComponent();
        }

        private void btnShow_Click(object sender, EventArgs e)
        {
            if (string.IsNullOrWhiteSpace(txtSalesName.Text) || string.IsNullOrWhiteSpace(txtSalesTarget.Text) || string.IsNullOrWhiteSpace(txtHRName.Text) || string.IsNullOrWhiteSpace(txtHREmployees.Text))
            {
                MessageBox.Show("Enter all department details.");
                return;
            }

            if (!decimal.TryParse(txtSalesTarget.Text, out decimal target) || !int.TryParse(txtHREmployees.Text, out int count))
            {
                MessageBox.Show("Enter valid numeric values.");
                return;
            }

            Sales sales = new Sales
            {
                DepartmentName = txtSalesName.Text.Trim(),
                TargetAmount = target
            };

            HumanResource hr = new HumanResource
            {
                DepartmentName = txtHRName.Text.Trim(),
                EmployeeCount = count
            };

            var builder = new StringBuilder();
            builder.AppendLine("Sales Department");
            builder.AppendLine(sales.Display());
            builder.AppendLine();
            builder.AppendLine("Human Resource Department");
            builder.AppendLine(hr.Display());
            txtOutput.Text = builder.ToString();
        }
    }
}
