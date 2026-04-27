' Question: Write a Vb.net program to design the following form; it contains the three menus Color (Red, Blue, and Green), Window (Maximize, Minimize, and Restore) and Exit. On Selection of any menu or submenu result should affect the form control( for example if user selecte d Red color from Color menu back color of form should get changed to Red and if user selected Maximize from Window Menu then form should get maximized). [25 M]
Imports System.Windows.Forms

Public Partial Class Program
    Inherits Form

    Public Sub New()
        InitializeComponent()
    End Sub
End Class
