using System.Drawing;
using System.Windows.Forms;

namespace QuestionWin
{
    partial class Q2_ProgramName
    {
        private Label lblSales;
        private Label lblHR;
        private TextBox txtSalesName;
        private TextBox txtSalesTarget;
        private TextBox txtHRName;
        private TextBox txtHREmployees;
        private Button btnShow;
        private TextBox txtOutput;

        private void InitializeComponent()
        {
            this.lblSales = new Label();
            this.lblHR = new Label();
            this.txtSalesName = new TextBox();
            this.txtSalesTarget = new TextBox();
            this.txtHRName = new TextBox();
            this.txtHREmployees = new TextBox();
            this.btnShow = new Button();
            this.txtOutput = new TextBox();
            this.SuspendLayout();
            // 
            // lblSales
            // 
            this.lblSales.AutoSize = true;
            this.lblSales.Location = new Point(18, 20);
            this.lblSales.Text = "Sales Department Name";
            // 
            // txtSalesName
            // 
            this.txtSalesName.Location = new Point(190, 17);
            this.txtSalesName.Width = 180;
            // 
            // txtSalesTarget
            // 
            this.txtSalesTarget.Location = new Point(190, 53);
            this.txtSalesTarget.Width = 180;
            // 
            // lblHR
            // 
            this.lblHR.AutoSize = true;
            this.lblHR.Location = new Point(18, 90);
            this.lblHR.Text = "HR Department Name";
            // 
            // txtHRName
            // 
            this.txtHRName.Location = new Point(190, 87);
            this.txtHRName.Width = 180;
            // 
            // txtHREmployees
            // 
            this.txtHREmployees.Location = new Point(190, 123);
            this.txtHREmployees.Width = 180;
            // 
            // btnShow
            // 
            this.btnShow.Location = new Point(18, 160);
            this.btnShow.Size = new Size(160, 32);
            this.btnShow.Text = "Display Details";
            this.btnShow.Click += new System.EventHandler(this.btnShow_Click);
            // 
            // txtOutput
            // 
            this.txtOutput.Location = new Point(18, 208);
            this.txtOutput.Multiline = true;
            this.txtOutput.ScrollBars = ScrollBars.Vertical;
            this.txtOutput.Size = new Size(410, 140);
            // 
            // Q2_ProgramName
            // 
            this.ClientSize = new Size(450, 375);
            this.Controls.Add(this.lblSales);
            this.Controls.Add(this.txtSalesName);
            this.Controls.Add(this.txtSalesTarget);
            this.Controls.Add(this.lblHR);
            this.Controls.Add(this.txtHRName);
            this.Controls.Add(this.txtHREmployees);
            this.Controls.Add(this.btnShow);
            this.Controls.Add(this.txtOutput);
            this.StartPosition = FormStartPosition.CenterScreen;
            this.Text = "Department Inheritance";
            this.ResumeLayout(false);
            this.PerformLayout();
        }
    }
}
