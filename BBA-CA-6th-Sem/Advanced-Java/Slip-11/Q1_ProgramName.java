// Question: Write a java program to display IPAddress and name of client machine.[15 M]
import java.io.*;
import java.net.*;
import java.time.*;
import java.util.*;
public class Q1_ProgramName {
    static boolean prime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
        return true;
    }
    static boolean perfect(int n) {
        if (n <= 1) return false;
        int sum = 1;
        for (int i = 2; i <= n / 2; i++) if (n % i == 0) sum += i;
        return sum == n;
    }
    static long factorial(int n) {
        long f = 1;
        for (int i = 2; i <= n; i++) f *= i;
        return f;
    }
    static int sumDigits(int n) {
        int s = 0;
        while (n != 0) { s += n % 10; n /= 10; }
        return s;
    }
    static int sumFirstLast(int n) {
        int last = Math.abs(n % 10);
        int first = Math.abs(n);
        while (first >= 10) first /= 10;
        return first + last;
    }
    static String reverse(String s) { return new StringBuilder(s).reverse().toString(); }
    static boolean palindrome(String s) { String r = reverse(s); return s.equalsIgnoreCase(r); }
    static void vowels(String s) {
        for (char c : s.toLowerCase().toCharArray()) if ("aeiou".indexOf(c) >= 0) System.out.print(c + " ");
        System.out.println();
    }
    static void digitWords(String s) {
        String[] w = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        for (char c : s.toCharArray()) if (Character.isDigit(c)) System.out.print(w[c - '0'] + " ");
        System.out.println();
    }
    static int fibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 1; i <= n; i++) { System.out.print(a + " "); int c = a + b; a = b; b = c; }
        System.out.println();
        return a;
    }
    static void clientInfo() throws Exception {
        InetAddress a = InetAddress.getLocalHost();
        System.out.println("Name: " + a.getHostName());
        System.out.println("IP: " + a.getHostAddress());
    }
    static void fileCheck(String path) throws Exception {
        File f = new File(path);
        if (f.exists()) {
            System.out.println("File Found");
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                String line;
                while ((line = br.readLine()) != null) System.out.println(line);
            }
        } else System.out.println("File Not Found");
    }
    static void fileExtensions(String dir, String ext) {
        File d = new File(dir);
        File[] files = d.listFiles((x, name) -> name.endsWith(ext));
        if (files != null) for (File f : files) System.out.println(f.getName());
    }
    static void countWords(String s) {
        System.out.println(s.trim().isEmpty() ? 0 : s.trim().split("\s+").length);
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String mode = "client_info";
        switch (mode) {
            case "prime": System.out.print("Enter number: "); int p = sc.nextInt(); System.out.println(prime(p) ? "Prime" : "Not Prime"); break;
            case "perfect": System.out.print("Enter number: "); int pf = sc.nextInt(); System.out.println(perfect(pf) ? "Perfect" : "Not Perfect"); break;
            case "factorial": System.out.print("Enter number: "); int n = sc.nextInt(); System.out.println(factorial(n)); break;
            case "sum_two": System.out.print("Enter two numbers: "); System.out.println(sc.nextInt() + sc.nextInt()); break;
            case "sum_digits": System.out.print("Enter number: "); System.out.println(sumDigits(sc.nextInt())); break;
            case "sum_first_last": System.out.print("Enter number: "); System.out.println(sumFirstLast(sc.nextInt())); break;
            case "reverse": System.out.print("Enter string: "); sc.nextLine(); System.out.println(reverse(sc.nextLine())); break;
            case "palindrome": System.out.print("Enter string: "); sc.nextLine(); String s = sc.nextLine(); System.out.println(palindrome(s) ? "Palindrome" : "Not Palindrome"); break;
            case "vowels": System.out.print("Enter string: "); sc.nextLine(); vowels(sc.nextLine()); break;
            case "length": System.out.print("Enter string: "); sc.nextLine(); System.out.println(sc.nextLine().length()); break;
            case "number_words": System.out.print("Enter number: "); sc.nextLine(); digitWords(sc.nextLine()); break;
            case "fibonacci": System.out.print("Enter terms: "); fibonacci(sc.nextInt()); break;
            case "word_count": System.out.print("Enter sentence: "); sc.nextLine(); countWords(sc.nextLine()); break;
            case "table_count": System.out.print("Enter record count: "); System.out.println("Count = " + sc.nextInt()); break;
            case "client_info": clientInfo(); break;
            case "server_time": System.out.println(LocalDateTime.now()); break;
            case "greet_time": System.out.print("Enter name: "); sc.nextLine(); String name = sc.nextLine(); int h = LocalTime.now().getHour(); System.out.println((h < 12 ? "Good Morning, " : h < 18 ? "Good Afternoon, " : "Good Evening, ") + name); break;
            case "file_check": System.out.print("Enter file path: "); sc.nextLine(); fileCheck(sc.nextLine()); break;
            case "file_extensions": System.out.print("Enter directory: "); sc.nextLine(); String d = sc.nextLine(); System.out.print("Enter extension like .txt: "); String ext = sc.nextLine(); fileExtensions(d, ext); break;
            default: System.out.println("Simple Java program for the given slip.");
        }
    }
}
