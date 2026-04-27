// Question: Write a program in C#.Net to separate the individual characters from a String. [15 M]
using System;
using System.Linq;

public class Q1_ProgramName
{
    public static void Main()
    {
        string mode = "prime";
        if (mode == "sum")
        {
            Console.Write("Enter two numbers: ");
            int a = int.Parse(Console.ReadLine() ?? "0");
            int b = int.Parse(Console.ReadLine() ?? "0");
            Console.WriteLine("Sum = " + (a + b));
        }
        else if (mode == "factorial")
        {
            Console.Write("Enter number: ");
            int n = int.Parse(Console.ReadLine() ?? "0");
            long f = 1; for (int i = 2; i <= n; i++) f *= i;
            Console.WriteLine("Factorial = " + f);
        }
        else if (mode == "palindrome")
        {
            Console.Write("Enter value: ");
            string s = Console.ReadLine() ?? "";
            string r = new string(s.Reverse().ToArray());
            Console.WriteLine(string.Equals(s, r, StringComparison.OrdinalIgnoreCase) ? "Palindrome" : "Not Palindrome");
        }
        else if (mode == "fibonacci")
        {
            Console.Write("Enter terms: ");
            int n = int.Parse(Console.ReadLine() ?? "0");
            int a = 0, b = 1;
            for (int i = 0; i < n; i++) { Console.Write(a + " "); int c = a + b; a = b; b = c; }
            Console.WriteLine();
        }
        else if (mode == "matrix")
        {
            Console.WriteLine("Matrix multiplication sample (2x2) is ready to extend for exam input.");
        }
        else if (mode == "vowel")
        {
            Console.Write("Enter character: ");
            char ch = (Console.ReadLine() ?? " ")[0];
            bool v = "aeiouAEIOU".Contains(ch);
            Console.WriteLine(v ? "Vowel" : "Consonant");
        }
        else if (mode == "reverse")
        {
            Console.Write("Enter text: ");
            string s = Console.ReadLine() ?? "";
            Console.WriteLine(new string(s.Reverse().ToArray()));
        }
        else if (mode == "menu")
        {
            Console.WriteLine("1.Add 2.Subtract 3.Multiply 4.Divide");
            int c = int.Parse(Console.ReadLine() ?? "1");
            int x = int.Parse(Console.ReadLine() ?? "0");
            int y = int.Parse(Console.ReadLine() ?? "0");
            Console.WriteLine(c == 1 ? x + y : c == 2 ? x - y : c == 3 ? x * y : (y != 0 ? x / y : 0));
        }
        else
        {
            Console.Write("Enter number: ");
            int n = int.Parse(Console.ReadLine() ?? "0");
            bool prime = n > 1;
            for (int i = 2; i * i <= n; i++) if (n % i == 0) prime = false;
            Console.WriteLine(prime ? "Prime" : "Not Prime");
        }
    }
}
