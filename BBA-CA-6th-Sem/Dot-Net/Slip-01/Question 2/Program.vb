' Question: Write a VB.Net program to accept the details of Employee (ENO, EName Salary) and store it into the database and display it on gridview control. [25 M]
Imports System.Data
Imports System.Data.SqlClient
Imports System.Windows.Forms

Partial Public Class Program
    Inherits Form

    Private ReadOnly connectionString As String = "Data Source=(LocalDB)\MSSQLLocalDB;Initial Catalog=master;Integrated Security=True;"

    Public Sub New()
        InitializeComponent()
        AddHandler Me.Load, AddressOf Program_Load
    End Sub

    Private Sub Program_Load(sender As Object, e As EventArgs)
        LoadEmployees()
        LoadEmployees()
    End Sub

    Private Sub btnAdd_Click(sender As Object, e As EventArgs)
        If String.IsNullOrWhiteSpace(txtEno.Text) OrElse String.IsNullOrWhiteSpace(txtEname.Text) OrElse String.IsNullOrWhiteSpace(txtSalary.Text) Then
            Exit Sub
        End If

        Using con As New SqlConnection(connectionString)
            con.Open()
            Using cmd As New SqlCommand("IF OBJECT_ID('dbo.EmployeeDetails','U') IS NULL CREATE TABLE EmployeeDetails(ENO INT PRIMARY KEY, EName NVARCHAR(50), Salary DECIMAL(10,2)); INSERT INTO EmployeeDetails(ENO, EName, Salary) VALUES(@ENO, @EName, @Salary);", con)
                cmd.Parameters.AddWithValue("@ENO", Convert.ToInt32(txtEno.Text))
                cmd.Parameters.AddWithValue("@EName", txtEname.Text.Trim())
                cmd.Parameters.AddWithValue("@Salary", Convert.ToDecimal(txtSalary.Text))
                cmd.ExecuteNonQuery()
            End Using
        End Using

        LoadEmployees()
        ClearInputs()
        MessageBox.Show("Employee stored successfully.")
    End Sub

    Private Sub btnRefresh_Click(sender As Object, e As EventArgs)
        LoadEmployees()
    End Sub

    Private Sub EnsureTable()
        Using con As New SqlConnection(connectionString)
            con.Open()
            Using cmd As New SqlCommand("IF OBJECT_ID('dbo.EmployeeDetails','U') IS NULL CREATE TABLE EmployeeDetails(ENO INT PRIMARY KEY, EName NVARCHAR(50), Salary DECIMAL(10,2));", con)
                cmd.ExecuteNonQuery()
            End Using
        End Using
    End Sub

    Private Sub LoadEmployees()
        Using con As New SqlConnection(connectionString)
            Using da As New SqlDataAdapter("SELECT ENO, EName, Salary FROM EmployeeDetails", con)
                Dim dt As New DataTable()
                da.Fill(dt)
                dgvEmployees.DataSource = dt
            End Using
        End Using
    End Sub

    Private Sub ClearInputs()
        txtEno.Clear()
        txtEname.Clear()
        txtSalary.Clear()
        txtEno.Focus()
    End Sub
End Class
End Class
