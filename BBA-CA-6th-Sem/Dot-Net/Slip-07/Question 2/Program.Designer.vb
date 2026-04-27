Imports System.Windows.Forms
Imports System.Drawing

Partial Class Program
    Inherits Form

    Private treeView1 As TreeView

    Private Sub InitializeComponent()
        Me.treeView1 = New TreeView()
        Me.SuspendLayout()
        Me.treeView1.Dock = DockStyle.Fill
        Dim root As TreeNode = New TreeNode("Sample Root")
        root.Nodes.Add("Child 1")
        root.Nodes.Add("Child 2")
        Me.treeView1.Nodes.Add(root)
        Me.treeView1.ExpandAll()
        Me.Controls.Add(Me.treeView1)
        Me.StartPosition = FormStartPosition.CenterScreen
        Me.Text = "Sample Tree View"
        Me.ClientSize = New Size(500, 350)
        Me.ResumeLayout(False)
    End Sub
End Class
