using System;
using System.Web.UI;

namespace Slip20Q2
{
    public partial class Q2_ProgramName : Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
        }

        protected void btnGenerateError_Click(object sender, EventArgs e)
        {
            // Deliberately access invalid index to raise IndexOutOfRangeException.
            int[] numbers = { 10, 20, 30 };
            int value = numbers[5];
            lblInfo.Text = value.ToString();
        }
    }
}
