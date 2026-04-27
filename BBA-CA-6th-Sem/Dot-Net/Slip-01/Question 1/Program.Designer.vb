Imports System.Windows.Forms
Imports System.Drawing

Partial Class Program
    Inherits Form

    Private components As System.ComponentModel.IContainer
    Friend WithEvents txtNumbers As TextBox
    Friend WithEvents btnStartStop As Button
    Friend WithEvents numberTimer As Timer

    Protected Overrides Sub Dispose(disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Me.txtNumbers = New TextBox()
        Me.btnStartStop = New Button()
        Me.numberTimer = New Timer(Me.components)
        Me.SuspendLayout()

        Me.txtNumbers.Location = New Point(20, 20)
        Me.txtNumbers.Multiline = True
        Me.txtNumbers.ScrollBars = ScrollBars.Vertical
        Me.txtNumbers.Size = New Size(440, 250)
        Me.txtNumbers.ReadOnly = True

        Me.btnStartStop.Location = New Point(20, 285)
        Me.btnStartStop.Size = New Size(120, 35)
        Me.btnStartStop.Text = "Start"
        Me.btnStartStop.UseVisualStyleBackColor = True

        Me.numberTimer.Interval = 200

        Me.Controls.Add(Me.txtNumbers)
        Me.Controls.Add(Me.btnStartStop)
        Me.StartPosition = FormStartPosition.CenterScreen
        Me.Text = "Continuous Numbers"
        Me.ClientSize = New Size(484, 341)
        Me.ResumeLayout(False)
        Me.PerformLayout()
    End Sub
End Class
