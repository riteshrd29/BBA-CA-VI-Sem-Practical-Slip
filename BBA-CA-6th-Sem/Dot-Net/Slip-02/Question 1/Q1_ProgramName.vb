' Question: Write a VB.Net program to move the text "Pune University" continuously from Left to Right and Vice Versa. [15 M]
Imports System
Imports System.Windows.Forms

Public Partial Class Q1_ProgramName
    Inherits Form

    Private movingRight As Boolean = True
    Private Const StepSize As Integer = 5

    Public Sub New()
        InitializeComponent()
    End Sub

    Private Sub Q1_ProgramName_Load(sender As Object, e As EventArgs) Handles MyBase.Load
        lblMovingText.Left = 0
        animationTimer.Start()
    End Sub

    Private Sub animationTimer_Tick(sender As Object, e As EventArgs) Handles animationTimer.Tick
        If movingRight Then
            lblMovingText.Left += StepSize
            If lblMovingText.Right >= ClientSize.Width Then
                movingRight = False
            End If
        Else
            lblMovingText.Left -= StepSize
            If lblMovingText.Left <= 0 Then
                movingRight = True
            End If
        End If
    End Sub
End Class
