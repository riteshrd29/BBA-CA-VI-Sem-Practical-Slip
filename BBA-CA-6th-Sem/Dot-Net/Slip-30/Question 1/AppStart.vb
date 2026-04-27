Imports System
Imports System.Windows.Forms

Module AppStart
    <STAThread()>
    Sub Main()
        Application.EnableVisualStyles()
        Application.SetCompatibleTextRenderingDefault(False)
        Application.Run(New Program())
    End Sub
End Module
