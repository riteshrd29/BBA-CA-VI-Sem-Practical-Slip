' Question: Write a VB.Net Program to display the numbers continuously in TextBox by clicking on Button. [15 M]
Imports System
Imports System.Windows.Forms

Public Partial Class Program
    Inherits Form

    Private currentNumber As Integer = 1

    Public Sub New()
        InitializeComponent()
    End Sub

    Private Sub btnStartStop_Click(sender As Object, e As EventArgs) Handles btnStartStop.Click
        numberTimer.Enabled = Not numberTimer.Enabled
        btnStartStop.Text = If(numberTimer.Enabled, "Stop", "Start")
    End Sub

    Private Sub numberTimer_Tick(sender As Object, e As EventArgs) Handles numberTimer.Tick
        txtNumbers.AppendText(currentNumber.ToString() & " ")
        currentNumber += 1

        If txtNumbers.TextLength > 3000 Then
            txtNumbers.Clear()
            currentNumber = 1
        End If
    End Sub
End Class
