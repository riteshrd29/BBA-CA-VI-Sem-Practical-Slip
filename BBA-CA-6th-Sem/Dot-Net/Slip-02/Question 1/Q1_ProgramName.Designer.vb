Imports System.Windows.Forms
Imports System.Drawing

Partial Class Q1_ProgramName
    Inherits Form

    Friend WithEvents txtNumbers As TextBox
    Friend WithEvents btnStartStop As Button
    Friend WithEvents numberTimer As Timer
    Friend WithEvents lblMovingText As Label
    Friend WithEvents animationTimer As Timer

    Private Sub InitializeComponent()
        Me.components = New System.ComponentModel.Container()
        Me.txtNumbers = New TextBox()
        Me.btnStartStop = New Button()
        Me.numberTimer = New Timer(Me.components)
        Me.lblMovingText = New Label()
        Me.animationTimer = New Timer(Me.components)
        Me.SuspendLayout()
        ' 
        ' txtNumbers
        ' 
        Me.txtNumbers.Location = New Point(20, 20)
        Me.txtNumbers.Multiline = True
        Me.txtNumbers.ScrollBars = ScrollBars.Vertical
        Me.txtNumbers.Size = New Size(440, 250)
        Me.txtNumbers.ReadOnly = True
        ' 
        ' btnStartStop
        ' 
        Me.btnStartStop.Location = New Point(20, 285)
        Me.btnStartStop.Size = New Size(120, 35)
        Me.btnStartStop.Text = "Start"
        Me.btnStartStop.UseVisualStyleBackColor = True
        ' 
        ' numberTimer
        ' 
        Me.numberTimer.Interval = 200
        ' 
        ' lblMovingText
        ' 
        Me.lblMovingText.AutoSize = True
        Me.lblMovingText.Font = New Font("Microsoft Sans Serif", 16.0!, FontStyle.Bold)
        Me.lblMovingText.Location = New Point(0, 60)
        Me.lblMovingText.Text = "Pune University"
        ' 
        ' animationTimer
        ' 
        Me.animationTimer.Interval = 50
        ' 
        ' Q1_ProgramName (Form)
        ' 
        Me.AutoScaleDimensions = New SizeF(6.0F, 13.0F)
        Me.AutoScaleMode = AutoScaleMode.Font
        Me.ClientSize = New Size(484, 341)
        Me.Controls.Add(Me.txtNumbers)
        Me.Controls.Add(Me.btnStartStop)
        Me.Controls.Add(Me.lblMovingText)
        Me.StartPosition = FormStartPosition.CenterScreen
        Me.Text = "Continuous Numbers"
        AddHandler Me.Load, AddressOf Me.Q1_ProgramName_Load
        Me.ResumeLayout(False)
        Me.PerformLayout()
    End Sub

    Private components As System.ComponentModel.IContainer
End Class
