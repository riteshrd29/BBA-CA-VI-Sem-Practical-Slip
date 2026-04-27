using System.Windows.Forms;

namespace QuestionWin
{
    partial class Q2_ProgramName
    {
        private TreeView treeView1;

        private void InitializeComponent()
        {
            this.treeView1 = new TreeView();
            this.SuspendLayout();
            this.treeView1.Dock = DockStyle.Fill;
            TreeNode root = new TreeNode("Sample Root");
            root.Nodes.Add("Child 1");
            root.Nodes.Add("Child 2");
            this.treeView1.Nodes.Add(root);
            this.treeView1.ExpandAll();
            this.Controls.Add(this.treeView1);
            this.Text = "Sample Tree View";
            this.StartPosition = FormStartPosition.CenterScreen;
            this.ClientSize = new System.Drawing.Size(500, 350);
            this.ResumeLayout(false);
        }
    }
}
