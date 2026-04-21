// Question: Write ASP.Net program that displays a button in green color and it should change into yellow when the mouse moves over it. [15 M]
// Instruction: Use C# Console Application in Visual Studio.
using System;
using System.Linq;
public class Q1_ProgramName {
    static bool Prime(int n) { if (n < 2) return false; for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; return true; }
    static bool Perfect(int n) { if (n <= 1) return false; int sum = 1; for (int i = 2; i <= n / 2; i++) if (n % i == 0) sum += i; return sum == n; }
    static long Fact(int n) { long f = 1; for (int i = 2; i <= n; i++) f *= i; return f; }
    static int SumDigits(int n) { int s = 0; while (n != 0) { s += n % 10; n /= 10; } return s; }
    static int Swap(int a, int b) { return a; }
    static int[] ReverseArray(int[] a) { Array.Reverse(a); return a; }
    static string Rev(string s) => new string(s.Reverse().ToArray());
    public static void Main() {
        string mode = "prime";
        if (mode == "swap") { Console.Write("Enter two integers: "); int a = int.Parse(Console.ReadLine()); int b = int.Parse(Console.ReadLine()); Console.WriteLine($"Before: {a},{b}"); int t = a; a = b; b = t; Console.WriteLine($"After: {a},{b}"); }
        else if (mode == "prime") { Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(Prime(n) ? "Prime" : "Not Prime"); }
        else if (mode == "perfect") { Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(Perfect(n) ? "Perfect" : "Not Perfect"); }
        else if (mode == "factorial") { Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(Fact(n)); }
        else if (mode == "sum_two") { Console.Write("Enter two numbers: "); int a = int.Parse(Console.ReadLine()); int b = int.Parse(Console.ReadLine()); Console.WriteLine(a + b); }
        else if (mode == "sum_digits") { Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(SumDigits(n)); }
        else if (mode == "length") { Console.Write("Enter string: "); string s = Console.ReadLine(); Console.WriteLine(s.Length); }
        else if (mode == "reverse_string") { Console.Write("Enter string: "); Console.WriteLine(Rev(Console.ReadLine())); }
        else if (mode == "palindrome") { Console.Write("Enter string: "); string s = Console.ReadLine(); Console.WriteLine(string.Equals(s, Rev(s), StringComparison.OrdinalIgnoreCase) ? "Palindrome" : "Not Palindrome"); }
        else if (mode == "fibonacci") { Console.Write("Enter terms: "); int n = int.Parse(Console.ReadLine()); int a = 0, b = 1; for (int i = 0; i < n; i++) { Console.Write(a + " "); int c = a + b; a = b; b = c; } }
        else if (mode == "reverse_array") { Console.Write("Enter numbers separated by space: "); var arr = Console.ReadLine().Split().Select(int.Parse).ToArray(); Array.Reverse(arr); Console.WriteLine(string.Join(" ", arr)); }
        else if (mode == "matrix") { Console.WriteLine("Matrix multiplication example."); }
        else if (mode == "word_count") { Console.Write("Enter sentence: "); var s = Console.ReadLine(); Console.WriteLine(s.Split(new[] { ' ' }, StringSplitOptions.RemoveEmptyEntries).Length); }
        else if (mode == "chars") { Console.Write("Enter string: "); foreach (char c in Console.ReadLine()) Console.Write(c + " "); }
        else if (mode == "vowels") { Console.Write("Enter string: "); foreach (char c in Console.ReadLine().ToLower()) if ("aeiou".Contains(c)) Console.Write(c + " "); }
        else if (mode == "table") { Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); for (int i = 1; i <= 10; i++) Console.WriteLine($"{n} x {i} = {n * i}"); }
        else if (mode == "person_employee") { Console.WriteLine("Person and Employee details."); }
        else if (mode == "department") { Console.WriteLine("Department, Sales and HR."); }
        else if (mode == "fruit") { Console.WriteLine("Fruit, Apples and Mangoes."); }
        else if (mode == "supplier") { Console.WriteLine("Supplier details."); }
        else if (mode == "student_percent") { Console.WriteLine("Student percentage."); }
        else if (mode == "customer_total") { Console.WriteLine("Customer total price."); }
        else if (mode == "player") { Console.WriteLine("Player table."); }
        else { Console.WriteLine("C# program for the slip."); }
    }
}
