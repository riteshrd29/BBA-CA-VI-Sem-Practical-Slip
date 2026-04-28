Imports System.Windows.Forms
Imports System.Drawing

Partial Class Program
    Inherits Form

    Private lblEno As Label
    Private lblEname As Label
    Private lblSalary As Label
    Private txtEno As TextBox
    Private txtEname As TextBox
    Private txtSalary As TextBox
    Private btnAdd As Button
    Private btnRefresh As Button
    Private dgvEmployees As DataGridView

    Private Sub InitializeComponent()
        Me.lblEno = New Label()
        Me.lblEname = New Label()
        Me.lblSalary = New Label()
        Me.txtEno = New TextBox()
        Me.txtEname = New TextBox()
        Me.txtSalary = New TextBox()
        Me.btnAdd = New Button()
        Me.btnRefresh = New Button()
        Me.dgvEmployees = New DataGridView()
        CType(Me.dgvEmployees, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()

        Me.lblEno.AutoSize = True
        Me.lblEno.Location = New Point(18, 18)
        Me.lblEno.Text = "ENO"
        Me.lblEname.AutoSize = True
        Me.lblEname.Location = New Point(18, 54)
        Me.lblEname.Text = "EName"
        Me.lblSalary.AutoSize = True
        Me.lblSalary.Location = New Point(18, 90)
        Me.lblSalary.Text = "Salary"

        Me.txtEno.Location = New Point(110, 15)
        Me.txtEno.Width = 180
        Me.txtEname.Location = New Point(110, 51)
        '
        Me.txtSalary.Location = New Point(110, 87)
        Me.txtSalary.Width = 180

        Me.btnAdd.Location = New Point(18, 126)
        Me.btnAdd.Size = New Size(120, 32)
        Me.btnAdd.Text = "Add Employee"
        AddHandler Me.btnAdd.Click, AddressOf Me.btnAdd_Click

        Me.btnRefresh.Location = New Point(170, 126)
        Me.btnRefresh.Size = New Size(120, 32)
        Me.btnRefresh.Text = "Refresh Grid"
        AddHandler Me.btnRefresh.Click, AddressOf Me.btnRefresh_Click

        Me.dgvEmployees.Location = New Point(18, 174)
        Me.dgvEmployees.Size = New Size(560, 220)
        Me.dgvEmployees.AutoSizeColumnsMode = DataGridViewAutoSizeColumnsMode.Fill
        Me.dgvEmployees.ReadOnly = True
        Me.dgvEmployees.AllowUserToAddRows = False

        Me.ClientSize = New Size(600, 420)
        Me.Controls.AddRange(New Control() {Me.lblEno, Me.lblEname, Me.lblSalary, Me.txtEno, Me.txtEname, Me.txtSalary, Me.btnAdd, Me.btnRefresh, Me.dgvEmployees})
        Me.StartPosition = FormStartPosition.CenterScreen
        Me.Text = "Employee Database"
        CType(Me.dgvEmployees, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)
        Me.PerformLayout()
    End Sub
End Class
Me.dgvEmployees.ReadOnly = True
Me.dgvEmployees.AllowUserToAddRows = False
'
' Form
'
Me.ClientSize = New Size(600, 420)
Me.Controls.AddRange(New Control() {Me.lblEno, Me.lblEname, Me.lblSalary, Me.txtEno, Me.txtEname, Me.txtSalary, Me.btnAdd, Me.btnRefresh, Me.dgvEmployees})
Me.StartPosition = FormStartPosition.CenterScreen
Me.Text = "Employee Database"
CType(Me.dgvEmployees, System.ComponentModel.ISupportInitialize).EndInit()
Me.ResumeLayout(False)
Me.PerformLayout()
End Sub
End Class
