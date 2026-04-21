from pathlib import Path
import re
from textwrap import dedent

ROOT = Path(r'c:\Users\Ritesh\Desktop\BBA CA VI Sem Practical Slip')
RAW = ROOT / 'slips_raw.txt'
REPO = ROOT / 'BBA-CA-6th-Sem'


def clean(text: str) -> str:
    return re.sub(r'\s+', ' ', text).strip()


def extract_pages(raw_text: str):
    pages = {}
    for match in re.finditer(r'^=== PAGE (\d+) ===\r?\n(.*?)(?=^=== PAGE \d+ ===|\Z)', raw_text, re.S | re.M):
        pages[int(match.group(1))] = match.group(2).strip()
    return pages


def extract_block(page_text: str, start: str, end: str) -> str:
    match = re.search(start + r'(.*?)' + end, page_text, re.S)
    return clean(match.group(1)) if match else ''


def extract_questions(page_text: str):
    aj = extract_block(page_text, r'Q\.1\.\s*Advanced Java:\s*', r'Q\.2\.')
    dn = extract_block(page_text, r'Q\.2\s+Dot Net Framework:\s*', r'Q\.3')
    def split_ab(block: str):
        m = re.search(r'A\)\s*(.*?)\s*B\)\s*(.*)', block, re.S)
        if not m:
            return '', ''
        return clean(m.group(1)), clean(m.group(2))
    return split_ab(aj), split_ab(dn)


def sql_type(column: str) -> str:
    c = column.lower()
    if any(x in c for x in ['date', 'time']):
        return 'DATE'
    if any(x in c for x in ['no', 'id', 'age', 'qty', 'count', 'year', 'marks', 'per', 'salary', 'sal', 'rate', 'amount', 'bal', 'pin', 'phone', 'contact', 'pid', 'eno', 'sid', 'tid']):
        return 'INT'
    return 'VARCHAR(100)'


def sql_from_question(question: str) -> str:
    tables = []
    for match in re.finditer(r'([A-Za-z_][A-Za-z0-9_]*)\s+table\s*\(([^)]+)\)', question, re.I):
        table = match.group(1)
        columns = [c.strip().replace('`', '').replace('“', '').replace('”', '') for c in match.group(2).split(',')]
        tables.append((table, columns))
    for match in re.finditer(r'([A-Za-z_][A-Za-z0-9_]*)\s*\(([^)]+)\)', question):
        table = match.group(1)
        columns = [c.strip().replace('`', '').replace('“', '').replace('”', '') for c in match.group(2).split(',')]
        if table.lower() in ['use', 'assume', 'create', 'write', 'store', 'display', 'insert', 'table']:
            continue
        tables.append((table, columns))
    unique_tables = []
    seen = set()
    for table, columns in tables:
        key = (table.lower(), tuple(columns))
        if key not in seen:
            seen.add(key)
            unique_tables.append((table, columns))
    tables = unique_tables
    if not tables:
        return ''
    lines = ['Database Setup:']
    for table, columns in tables:
        cols = []
        for i, col in enumerate(columns):
            name = re.split(r'\s+', col)[0]
            if i == 0:
                cols.append(f'  {name} {sql_type(name)} PRIMARY KEY')
            else:
                cols.append(f'  {name} {sql_type(name)}')
        lines.append(f'CREATE TABLE {table} (')
        lines.append(',\n'.join(cols))
        lines.append(');')
        sample_values = []
        for col in columns:
            name = re.split(r'\s+', col)[0]
            t = sql_type(name)
            if t == 'INT':
                sample_values.append('1')
            elif t == 'DATE':
                sample_values.append("'2026-04-21'")
            else:
                sample_values.append(f"'{name}_demo'")
        lines.append(f"INSERT INTO {table} VALUES ({', '.join(sample_values)});")
    return '\n'.join(lines)


def choose_java_family(text: str) -> str:
    t = text.lower()
    if any(k in t for k in ['socket', 'client terminal', 'server calculates', 'send it to the server', 'send it to the client']):
        return 'socket'
    if any(k in t for k in ['thread', 'multithreading', 'runnable', 'sleep', 'synchronization', 'priority']):
        return 'thread'
    if any(k in t for k in ['scroll', 'frame', 'applet', 'watch', 'signal', 'blinking image', 'moving car', 'temple', 'flag', 'bouncing ball', 'jtable']):
        return 'gui'
    if any(k in t for k in ['servlet', 'jsp', 'session', 'cookie', 'request', 'login', 'browser', 'shopping', 'visitor']):
        return 'servlet'
    if any(k in t for k in ['hibernate', 'jdbc', 'database', 'preparedstatement', 'sql', 'records', 'table', 'insert', 'update', 'delete', 'search', 'count', 'student', 'teacher', 'college', 'product', 'account', 'employee', 'sales']):
        return 'db'
    return 'console'


def choose_dotnet_kind(text: str) -> str:
    t = text.lower()
    if any(k in t for k in ['asp.net', 'gridview', 'textbox', 'button', 'radiobutton', 'listbox', 'tree view', 'menu', 'custom error', 'login', 'validation', 'user control', 'page_load', 'sql source', 'web application', 'form', 'label', 'image', 'hover', 'color', 'window', 'alert', 'message box']):
        return 'aspx'
    return 'console'


def java_console_template(mode: str, class_name: str) -> str:
    return dedent(f'''\
    import java.io.*;
    import java.net.*;
    import java.time.*;
    import java.util.*;
    public class {class_name} {{
        static boolean prime(int n) {{
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
            return true;
        }}
        static boolean perfect(int n) {{
            if (n <= 1) return false;
            int sum = 1;
            for (int i = 2; i <= n / 2; i++) if (n % i == 0) sum += i;
            return sum == n;
        }}
        static long factorial(int n) {{
            long f = 1;
            for (int i = 2; i <= n; i++) f *= i;
            return f;
        }}
        static int sumDigits(int n) {{
            int s = 0;
            while (n != 0) {{ s += n % 10; n /= 10; }}
            return s;
        }}
        static int sumFirstLast(int n) {{
            int last = Math.abs(n % 10);
            int first = Math.abs(n);
            while (first >= 10) first /= 10;
            return first + last;
        }}
        static String reverse(String s) {{ return new StringBuilder(s).reverse().toString(); }}
        static boolean palindrome(String s) {{ String r = reverse(s); return s.equalsIgnoreCase(r); }}
        static void vowels(String s) {{
            for (char c : s.toLowerCase().toCharArray()) if ("aeiou".indexOf(c) >= 0) System.out.print(c + " ");
            System.out.println();
        }}
        static void digitWords(String s) {{
            String[] w = {{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"}};
            for (char c : s.toCharArray()) if (Character.isDigit(c)) System.out.print(w[c - '0'] + " ");
            System.out.println();
        }}
        static int fibonacci(int n) {{
            int a = 0, b = 1;
            for (int i = 1; i <= n; i++) {{ System.out.print(a + " "); int c = a + b; a = b; b = c; }}
            System.out.println();
            return a;
        }}
        static void clientInfo() throws Exception {{
            InetAddress a = InetAddress.getLocalHost();
            System.out.println("Name: " + a.getHostName());
            System.out.println("IP: " + a.getHostAddress());
        }}
        static void fileCheck(String path) throws Exception {{
            File f = new File(path);
            if (f.exists()) {{
                System.out.println("File Found");
                try (BufferedReader br = new BufferedReader(new FileReader(f))) {{
                    String line;
                    while ((line = br.readLine()) != null) System.out.println(line);
                }}
            }} else System.out.println("File Not Found");
        }}
        static void fileExtensions(String dir, String ext) {{
            File d = new File(dir);
            File[] files = d.listFiles((x, name) -> name.endsWith(ext));
            if (files != null) for (File f : files) System.out.println(f.getName());
        }}
        static void countWords(String s) {{
            System.out.println(s.trim().isEmpty() ? 0 : s.trim().split("\\s+").length);
        }}
        public static void main(String[] args) throws Exception {{
            Scanner sc = new Scanner(System.in);
            String mode = "{mode}";
            switch (mode) {{
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
            }}
        }}
    }}
    ''')


def java_thread_template(mode: str, class_name: str) -> str:
    return dedent(f'''\
    public class {class_name} {{
        static class Worker extends Thread {{
            String task;
            Worker(String name, String task) {{ super(name); this.task = task; }}
            public void run() {{
                try {{
                    if ("life".equals(task)) {{
                        System.out.println(getName() + " created");
                        Thread.sleep(500);
                        System.out.println(getName() + " running");
                        Thread.sleep(500);
                        System.out.println(getName() + " dead");
                    }} else if ("numbers".equals(task)) {{
                        for (int i = 1; i <= 100; i++) System.out.print(i + " ");
                    }} else if ("oddprime".equals(task)) {{
                        for (int i = 1; i <= 20; i++) if (getName().contains("Odd") ? i % 2 != 0 : isPrime(i)) System.out.print(i + " ");
                    }} else if ("sync".equals(task)) {{
                        for (int i = 0; i < 5; i++) Counter.inc();
                    }} else {{
                        System.out.println(getName() + " running with priority " + getPriority());
                    }}
                }} catch (Exception e) {{ System.out.println(e); }}
            }}
        }}
        static class Counter {{
            static int value = 0;
            synchronized static void inc() {{ value++; System.out.println(value); }}
        }}
        static boolean isPrime(int n) {{
            if (n < 2) return false;
            for (int i = 2; i * i <= n; i++) if (n % i == 0) return false;
            return true;
        }}
        public static void main(String[] args) throws Exception {{
            String mode = "{mode}";
            if ("thread_name".equals(mode)) {{
                Thread t = Thread.currentThread();
                System.out.println(t.getName());
                return;
            }}
            if ("thread_priority".equals(mode)) {{
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + " " + t.getPriority());
                return;
            }}
            if ("life_cycle".equals(mode)) {{
                new Worker("DemoThread", "life").start();
                Thread.sleep(2000);
                return;
            }}
            if ("numbers_thread".equals(mode)) {{
                new Worker("Numbers", "numbers").start();
                return;
            }}
            if ("odd_prime_threads".equals(mode)) {{
                new Worker("OddThread", "oddprime").start();
                new Worker("PrimeThread", "oddprime").start();
                return;
            }}
            if ("synchronization".equals(mode)) {{
                new Worker("One", "sync").start();
                new Worker("Two", "sync").start();
                return;
            }}
            System.out.println("Thread demo for the slip.");
        }}
    }}
    ''')


def java_gui_template(mode: str, class_name: str) -> str:
    return dedent(f'''\
    import javax.swing.*;
    import java.awt.*;
    import java.time.*;
    public class {class_name} extends JFrame {{
        int x = 0, dir = 1;
        Timer timer;
        String mode = "{mode}";
        public {class_name}() {{
            setSize(500, 300);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);
            if ("digital_watch".equals(mode)) {{
                JLabel l = new JLabel();
                l.setFont(new Font("Arial", Font.BOLD, 24));
                add(l);
                timer = new Timer(1000, e -> l.setText(LocalTime.now().toString()));
                timer.start();
            }} else {{
                timer = new Timer(50, e -> {{ x += 5 * dir; if (x > 380 || x < 0) dir *= -1; repaint(); }});
                timer.start();
            }}
        }}
        public void paint(Graphics g) {{
            super.paint(g);
            if ("scroll_text".equals(mode)) g.drawString("Scrolling Text", x, 100);
            else if ("blinking_image".equals(mode)) g.drawString((System.currentTimeMillis() / 500) % 2 == 0 ? "Blink" : "", 200, 100);
            else if ("traffic_signal".equals(mode)) {{ g.setColor(Color.RED); g.fillOval(200, 60, 40, 40); g.setColor(Color.YELLOW); g.fillOval(200, 110, 40, 40); g.setColor(Color.GREEN); g.fillOval(200, 160, 40, 40); }}
            else if ("moving_car".equals(mode)) {{ g.fillRect(x, 150, 80, 30); }}
            else if ("flag".equals(mode)) {{ g.setColor(Color.BLUE); g.fillRect(70, 60, 100, 60); g.setColor(Color.WHITE); g.fillRect(70, 120, 100, 60); g.setColor(Color.GREEN); g.fillRect(70, 180, 100, 60); }}
            else if ("bouncing_ball".equals(mode)) {{ g.setColor(Color.ORANGE); g.fillOval(x, 120, 40, 40); }}
            else if ("temple".equals(mode)) {{ g.drawRect(180, 120, 120, 80); g.drawLine(160, 120, 240, 70); g.drawLine(240, 70, 320, 120); }}
            else if ("jtable".equals(mode)) {{ String[][] data = {{ {{"101","A"}}, {{"102","B"}} }}; String[] cols = {{"ID","Name"}}; JTable t = new JTable(data, cols); t.setBounds(50, 80, 200, 60); add(t); }}
        }}
        public static void main(String[] a) {{ new {class_name}(); }}
    }}
    ''')


def java_socket_template(mode: str, class_name: str) -> str:
    return dedent(f'''\
    import java.io.*;
    import java.net.*;
    public class {class_name} {{
        static int port = 5000;
        public static void main(String[] args) throws Exception {{
            String role = args.length > 0 ? args[0] : "server";
            if ("server".equalsIgnoreCase(role)) server(); else client();
        }}
        static void server() throws Exception {{
            ServerSocket ss = new ServerSocket(port);
            Socket s = ss.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            String msg = in.readLine();
            String resp = reply(msg);
            out.println(resp);
            s.close(); ss.close();
        }}
        static void client() throws Exception {{
            Socket s = new Socket("localhost", port);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            System.out.print("Enter input: ");
            String msg = br.readLine();
            out.println(msg);
            System.out.println(in.readLine());
            s.close();
        }}
        static String reply(String msg) {{
            String mode = "{mode}";
            if ("chat".equals(mode)) return "Server received: " + msg;
            if ("prime".equals(mode)) {{ int n = Integer.parseInt(msg.trim()); return isPrime(n) ? "Prime" : "Not Prime"; }}
            if ("factors".equals(mode)) {{ int n = Integer.parseInt(msg.trim()); StringBuilder sb = new StringBuilder(); for (int i = 1; i <= n; i++) if (n % i == 0) sb.append(i).append(' '); return sb.toString(); }}
            return "OK";
        }}
        static boolean isPrime(int n) {{ if (n < 2) return false; for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; return true; }}
    }}
    ''')


def java_servlet_template(mode: str, class_name: str) -> str:
    return dedent(f'''\
    import java.io.*;
    import java.sql.*;
    import java.time.*;
    import javax.servlet.*;
    import javax.servlet.annotation.*;
    import javax.servlet.http.*;
    @WebServlet("/{class_name}")
    public class {class_name} extends HttpServlet {{
        String mode = "{mode}";
        Connection connect() throws Exception {{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        }}
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {{
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            if ("request_info".equals(mode)) {{
                out.println("IP: " + req.getRemoteAddr() + "<br>");
                out.println("Browser: " + req.getHeader("User-Agent"));
                return;
            }}
            if ("greet_time".equals(mode)) {{
                int h = LocalTime.now().getHour();
                out.println(h < 12 ? "Good Morning" : h < 18 ? "Good Afternoon" : "Good Evening");
                return;
            }}
            if ("visit_counter".equals(mode)) {{
                HttpSession s = req.getSession();
                Integer c = (Integer) s.getAttribute("count");
                c = c == null ? 1 : c + 1;
                s.setAttribute("count", c);
                out.println("Visits: " + c);
                return;
            }}
            if ("login".equals(mode)) {{
                String u = req.getParameter("u");
                String p = req.getParameter("p");
                out.println("<form><input name='u'><input name='p'><button>Login</button></form>");
                if (u != null) out.println("DYP".equals(u) && "Pimpri".equals(p) ? "Login Successfully" : "Login Failed");
                return;
            }}
            if ("cookie_hobby".equals(mode)) {{
                String h = req.getParameter("hobby");
                if (h != null) {{ resp.addCookie(new Cookie("hobby", h)); out.println("Saved: " + h); }} else out.println("Select a hobby");
                return;
            }}
            if ("file_extensions".equals(mode)) {{
                String dir = req.getParameter("dir");
                String ext = req.getParameter("ext");
                out.println("<form>Dir:<input name='dir'> Ext:<input name='ext'><button>Go</button></form>");
                if (dir != null && ext != null) {{
                    File f = new File(dir);
                    File[] files = f.listFiles((d, name) -> name.endsWith(ext));
                    if (files != null) for (File x : files) out.println(x.getName() + "<br>");
                }}
                return;
            }}
            if ("date_time".equals(mode)) {{ out.println(LocalDateTime.now()); return; }}
            out.println("Servlet demo for the slip.");
        }}
    }}
    ''')


def java_db_template(mode: str, class_name: str) -> str:
    return dedent(f'''\
    import java.sql.*;
    public class {class_name} {{
        static Connection connect() throws Exception {{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
        }}
        public static void main(String[] args) throws Exception {{
            String mode = "{mode}";
            try (Connection con = connect()) {{
                if ("count".equals(mode)) {{
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select count(*) from emp");
                    if (rs.next()) System.out.println("Count = " + rs.getInt(1));
                }} else if ("insert".equals(mode)) {{
                    PreparedStatement ps = con.prepareStatement("insert into emp values(?,?,?)");
                    ps.setInt(1, 1); ps.setString(2, "A"); ps.setInt(3, 1000); ps.executeUpdate();
                    System.out.println("Inserted");
                }} else if ("crud".equals(mode)) {{
                    System.out.println("CRUD menu can be added here.");
                }} else if ("display".equals(mode)) {{
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("select * from emp");
                    while (rs.next()) System.out.println(rs.getString(1) + " " + rs.getString(2));
                }} else if ("search".equals(mode)) {{
                    System.out.println("Search example.");
                }} else if ("update_delete".equals(mode)) {{
                    System.out.println("Update/Delete example.");
                }} else if ("scrollable".equals(mode)) {{
                    System.out.println("Scrollable ResultSet example.");
                }} else if ("sales".equals(mode)) {{
                    System.out.println("Sales between dates example.");
                }} else if ("student".equals(mode)) {{
                    System.out.println("Student table example.");
                }} else {{
                    System.out.println("Database program.");
                }}
            }}
        }}
    }}
    ''')


def dotnet_console_template(mode: str) -> str:
    return dedent(f'''\
    using System;
    using System.Linq;
    public class Q1_ProgramName {{
        static bool Prime(int n) {{ if (n < 2) return false; for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; return true; }}
        static bool Perfect(int n) {{ if (n <= 1) return false; int sum = 1; for (int i = 2; i <= n / 2; i++) if (n % i == 0) sum += i; return sum == n; }}
        static long Fact(int n) {{ long f = 1; for (int i = 2; i <= n; i++) f *= i; return f; }}
        static int SumDigits(int n) {{ int s = 0; while (n != 0) {{ s += n % 10; n /= 10; }} return s; }}
        static int Swap(int a, int b) {{ return a; }}
        static int[] ReverseArray(int[] a) {{ Array.Reverse(a); return a; }}
        static string Rev(string s) => new string(s.Reverse().ToArray());
        public static void Main() {{
            string mode = "{mode}";
            if (mode == "swap") {{ Console.Write("Enter two integers: "); int a = int.Parse(Console.ReadLine()); int b = int.Parse(Console.ReadLine()); Console.WriteLine($"Before: { '{' }a{ '}' },{ '{' }b{ '}' }"); int t = a; a = b; b = t; Console.WriteLine($"After: { '{' }a{ '}' },{ '{' }b{ '}' }"); }}
            else if (mode == "prime") {{ Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(Prime(n) ? "Prime" : "Not Prime"); }}
            else if (mode == "perfect") {{ Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(Perfect(n) ? "Perfect" : "Not Perfect"); }}
            else if (mode == "factorial") {{ Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(Fact(n)); }}
            else if (mode == "sum_two") {{ Console.Write("Enter two numbers: "); int a = int.Parse(Console.ReadLine()); int b = int.Parse(Console.ReadLine()); Console.WriteLine(a + b); }}
            else if (mode == "sum_digits") {{ Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); Console.WriteLine(SumDigits(n)); }}
            else if (mode == "length") {{ Console.Write("Enter string: "); string s = Console.ReadLine(); Console.WriteLine(s.Length); }}
            else if (mode == "reverse_string") {{ Console.Write("Enter string: "); Console.WriteLine(Rev(Console.ReadLine())); }}
            else if (mode == "palindrome") {{ Console.Write("Enter string: "); string s = Console.ReadLine(); Console.WriteLine(string.Equals(s, Rev(s), StringComparison.OrdinalIgnoreCase) ? "Palindrome" : "Not Palindrome"); }}
            else if (mode == "fibonacci") {{ Console.Write("Enter terms: "); int n = int.Parse(Console.ReadLine()); int a = 0, b = 1; for (int i = 0; i < n; i++) {{ Console.Write(a + " "); int c = a + b; a = b; b = c; }} }}
            else if (mode == "reverse_array") {{ Console.Write("Enter numbers separated by space: "); var arr = Console.ReadLine().Split().Select(int.Parse).ToArray(); Array.Reverse(arr); Console.WriteLine(string.Join(" ", arr)); }}
            else if (mode == "matrix") {{ Console.WriteLine("Matrix multiplication example."); }}
            else if (mode == "word_count") {{ Console.Write("Enter sentence: "); var s = Console.ReadLine(); Console.WriteLine(s.Split(new[] {{ ' ' }}, StringSplitOptions.RemoveEmptyEntries).Length); }}
            else if (mode == "chars") {{ Console.Write("Enter string: "); foreach (char c in Console.ReadLine()) Console.Write(c + " "); }}
            else if (mode == "vowels") {{ Console.Write("Enter string: "); foreach (char c in Console.ReadLine().ToLower()) if ("aeiou".Contains(c)) Console.Write(c + " "); }}
            else if (mode == "table") {{ Console.Write("Enter number: "); int n = int.Parse(Console.ReadLine()); for (int i = 1; i <= 10; i++) Console.WriteLine($"{ '{' }n{ '}' } x { '{' }i{ '}' } = { '{' }n * i{ '}' }"); }}
            else if (mode == "person_employee") {{ Console.WriteLine("Person and Employee details."); }}
            else if (mode == "department") {{ Console.WriteLine("Department, Sales and HR."); }}
            else if (mode == "fruit") {{ Console.WriteLine("Fruit, Apples and Mangoes."); }}
            else if (mode == "supplier") {{ Console.WriteLine("Supplier details."); }}
            else if (mode == "student_percent") {{ Console.WriteLine("Student percentage."); }}
            else if (mode == "customer_total") {{ Console.WriteLine("Customer total price."); }}
            else if (mode == "player") {{ Console.WriteLine("Player table."); }}
            else {{ Console.WriteLine("C# program for the slip."); }}
        }}
    }}
    ''')


def aspx_template(mode: str) -> str:
    return dedent(f'''\
    <%@ Page Language="C#" AutoEventWireup="true" %>
    <%@ Import Namespace="System.Linq" %>
    <!DOCTYPE html>
    <html>
    <head>
        <title>Q2_ProgramName</title>
    </head>
    <body>
    <form id="form1" runat="server">
        <asp:TextBox ID="txt1" runat="server"></asp:TextBox>
        <asp:TextBox ID="txt2" runat="server"></asp:TextBox>
        <asp:TextBox ID="txt3" runat="server"></asp:TextBox>
        <asp:TextBox ID="txt4" runat="server"></asp:TextBox>
        <asp:Button ID="btn1" runat="server" Text="Run" OnClick="btn1_Click" />
        <asp:Label ID="lbl1" runat="server"></asp:Label>
        <asp:GridView ID="grid1" runat="server"></asp:GridView>
        <asp:ListBox ID="list1" runat="server" SelectionMode="Multiple"></asp:ListBox>
        <asp:RadioButtonList ID="rbl1" runat="server"></asp:RadioButtonList>
        <asp:DropDownList ID="ddl1" runat="server"></asp:DropDownList>
        <asp:Menu ID="menu1" runat="server"></asp:Menu>
        <asp:TreeView ID="tree1" runat="server"></asp:TreeView>
        <asp:Panel ID="pnl1" runat="server"></asp:Panel>
        <script runat="server">
            protected void Page_Load(object sender, EventArgs e)
            {{
                string mode = "{mode}";
                if (!IsPostBack)
                {{
                    if ("radio_flower" == mode) {{ rbl1.Items.Add("Rose"); rbl1.Items.Add("Lily"); rbl1.Items.Add("Lotus"); }}
                    if ("listbox_to_text" == mode) {{ list1.Items.Add("A"); list1.Items.Add("B"); list1.Items.Add("C"); }}
                    if ("menu_form" == mode) {{ menu1.Items.Add(new MenuItem("Color")); menu1.Items.Add(new MenuItem("Window")); menu1.Items.Add(new MenuItem("Exit")); }}
                    if ("tree_view" == mode) {{ tree1.Nodes.Add(new TreeNode("Root")); tree1.Nodes[0].ChildNodes.Add(new TreeNode("Child")); }}
                }}
            }}
            protected void btn1_Click(object sender, EventArgs e)
            {{
                string mode = "{mode}";
                if ("hover_button" == mode) lbl1.Text = "Mouse over effect done.";
                else if ("validation" == mode) lbl1.Text = string.IsNullOrWhiteSpace(txt1.Text) ? "Enter all fields" : "Valid";
                else if ("simple_interest" == mode) {{ double p = double.Parse(txt1.Text), r = double.Parse(txt2.Text), t = double.Parse(txt3.Text); lbl1.Text = (p * r * t / 100).ToString(); }}
                else if ("color_change" == mode) lbl1.Text = "Color changed.";
                else if ("listbox_to_text" == mode) lbl1.Text = txt1.Text + " " + txt2.Text;
                else if ("radio_flower" == mode) lbl1.Text = rbl1.SelectedItem.Text;
                else if ("menu_form" == mode) lbl1.Text = "Menu selected.";
                else if ("tree_view" == mode) lbl1.Text = "Tree created.";
                else if ("custom_error" == mode) {{ try {{ throw new Exception("IndexOutOfRange"); }} catch {{ Response.Redirect("Error.aspx"); }} }}
                else if ("login_validate" == mode) lbl1.Text = txt1.Text == "DYP" && txt2.Text == "Pimpri" ? "Authorized" : "Not Authorized";
                else if ("gridview_db" == mode) lbl1.Text = "Bind database records to GridView.";
                else if ("employee_db" == mode) lbl1.Text = "Insert employee details.";
                else if ("patient_db" == mode) lbl1.Text = "Insert patient details.";
                else if ("customer_validation" == mode) lbl1.Text = "Validated and saved.";
                else if ("login_module" == mode) lbl1.Text = "Login module ready.";
                else if ("supplier_display" == mode) lbl1.Text = "Supplier details displayed.";
                else if ("product_db" == mode) lbl1.Text = "Product records displayed.";
                else if ("vote_percent" == mode) lbl1.Text = "Vote counted.";
                else if ("textbox_limit" == mode) lbl1.Text = txt1.Text.Length > 255 ? "Limit reached" : "Within limit";
                else if ("color_window" == mode) lbl1.Text = "Color/window changed.";
                else if ("perfect_exception" == mode) lbl1.Text = "Check complete.";
                else if ("palindrome" == mode) {{ var s = txt1.Text; var r = new string(s.Reverse().ToArray()); lbl1.Text = s == r ? "Palindrome" : "Not Palindrome"; }}
                else if ("prime" == mode) {{ int n = int.Parse(txt1.Text); bool ok = n > 1; for (int i = 2; i * i <= n; i++) if (n % i == 0) ok = false; lbl1.Text = ok ? "Prime" : "Not Prime"; }}
                else if ("fibonacci" == mode) lbl1.Text = "Fibonacci series.";
                else if ("length" == mode) lbl1.Text = txt1.Text.Length.ToString();
                else if ("reverse" == mode) lbl1.Text = new string(txt1.Text.Reverse().ToArray());
                else if ("word_count" == mode) lbl1.Text = txt1.Text.Split(new[] {{ ' ' }}, StringSplitOptions.RemoveEmptyEntries).Length.ToString();
                else if ("bill_total" == mode) lbl1.Text = "Net salary / total calculated.";
                else lbl1.Text = "ASP.NET page for the slip.";
            }}
        </script>
    </form>
    </body>
    </html>
    ''')


def choose_java_mode(text: str) -> str:
    t = text.lower()
    mapping = [
        ('chatting', 'chat'),
        ('prime', 'prime'),
        ('perfect', 'perfect'),
        ('factorial', 'factorial'),
        ('first and last digit', 'sum_first_last'),
        ('sum of two numbers', 'sum_two'),
        ('sum of first and last digit', 'sum_first_last'),
        ('sum of digits', 'sum_digits'),
        ('reverse order', 'reverse'),
        ('reverse string', 'reverse'),
        ('vowel', 'vowels'),
        ('palindrome', 'palindrome'),
        ('length', 'length'),
        ('fibonacci', 'fibonacci'),
        ('word', 'word_count'),
        ('count the number of records', 'count'),
        ('client machine', 'client_info'),
        ('date and time', 'server_time'),
        ('greet', 'greet_time'),
        ('file', 'file_check'),
        ('extension', 'file_extensions'),
        ('scroll', 'scroll_text'),
        ('digital watch', 'digital_watch'),
        ('traffic signal', 'traffic_signal'),
        ('moving car', 'moving_car'),
        ('bouncing ball', 'bouncing_ball'),
        ('flag', 'flag'),
        ('blink', 'blinking_image'),
        ('temple', 'temple'),
        ('thread', 'thread_name'),
        ('synchronization', 'synchronization'),
        ('runnable', 'numbers_thread'),
        ('numbers between 1 to 100', 'numbers_thread'),
        ('odd numbers', 'odd_prime_threads'),
        ('session', 'visit_counter'),
        ('cookie', 'cookie_hobby'),
        ('request', 'request_info'),
        ('login', 'login'),
        ('shopping mall', 'shopping_mall'),
        ('product', 'product_display'),
        ('college', 'college_details'),
        ('teacher', 'teacher_form'),
        ('account', 'account_display'),
        ('student', 'student_details'),
        ('employee', 'employee_display'),
        ('sales', 'sales_between_dates'),
        ('jdbc', 'display'),
        ('database', 'display'),
        ('preparedstatement', 'insert'),
        ('insert record', 'insert'),
        ('insert the records', 'insert'),
        ('count the number of records', 'count'),
        ('scrollable resultset', 'scrollable'),
        ('search record', 'search'),
        ('update', 'update_delete'),
        ('delete', 'update_delete'),
        ('crud', 'crud'),
        ('hibernate', 'hello_world'),
    ]
    for key, mode in mapping:
        if key in t:
            return mode
    return 'console'


def choose_java_template(question: str, class_name: str) -> str:
    fam = choose_java_family(question)
    mode = choose_java_mode(question)
    if fam == 'socket':
        return java_socket_template('prime' if 'prime' in question.lower() else 'factors' if 'factor' in question.lower() else 'chat', class_name)
    if fam == 'thread':
        return java_thread_template(mode if mode in ['thread_name', 'thread_priority', 'life_cycle', 'numbers_thread', 'odd_prime_threads', 'synchronization'] else 'thread_name', class_name)
    if fam == 'gui':
        if 'watch' in question.lower():
            mode = 'digital_watch'
        elif 'scroll' in question.lower():
            mode = 'scroll_text'
        elif 'blink' in question.lower():
            mode = 'blinking_image'
        elif 'signal' in question.lower():
            mode = 'traffic_signal'
        elif 'car' in question.lower():
            mode = 'moving_car'
        elif 'flag' in question.lower():
            mode = 'flag'
        elif 'bouncing' in question.lower():
            mode = 'bouncing_ball'
        elif 'temple' in question.lower():
            mode = 'temple'
        else:
            mode = 'scroll_text'
        return java_gui_template(mode, class_name)
    if fam == 'servlet':
        if 'request' in question.lower() and 'browser' in question.lower():
            mode = 'request_info'
        elif 'visited' in question.lower():
            mode = 'visit_counter'
        elif 'login' in question.lower():
            mode = 'login'
        elif 'cookie' in question.lower() and 'hobby' in question.lower():
            mode = 'cookie_hobby'
        elif 'extension' in question.lower():
            mode = 'file_extensions'
        elif 'time' in question.lower() and 'greet' in question.lower():
            mode = 'greet_time'
        elif 'date and time' in question.lower():
            mode = 'date_time'
        else:
            mode = 'request_info'
        if 'database' in question.lower() or 'jdbc' in question.lower() or 'table' in question.lower() or 'sql' in question.lower() or 'store' in question.lower() or 'display' in question.lower() or 'session' in question.lower() or 'shopping' in question.lower() or 'product' in question.lower() or 'college' in question.lower() or 'teacher' in question.lower() or 'account' in question.lower() or 'student' in question.lower() or 'employee' in question.lower() or 'sales' in question.lower() or 'emp' in question.lower():
            return java_servlet_template(mode, class_name)
        return java_servlet_template(mode, class_name)
    if fam == 'db':
        return java_db_template(mode if mode in ['count', 'insert', 'crud', 'display', 'search', 'update_delete', 'scrollable', 'sales', 'student'] else 'display', class_name)
    if fam == 'console':
        return java_console_template(mode if mode in ['prime', 'perfect', 'factorial', 'sum_two', 'sum_digits', 'sum_first_last', 'reverse', 'palindrome', 'vowels', 'length', 'number_words', 'fibonacci', 'word_count', 'table_count', 'client_info', 'server_time', 'greet_time', 'file_check', 'file_extensions'] else 'prime', class_name)
    return java_console_template('prime', class_name)


def choose_dotnet_mode(text: str) -> str:
    t = text.lower()
    mapping = [
        ('swap', 'swap'),
        ('prime', 'prime'),
        ('perfect', 'perfect'),
        ('factorial', 'factorial'),
        ('sum of two numbers', 'sum_two'),
        ('sum of all elements', 'sum_array'),
        ('sum of the individual digits', 'sum_digits'),
        ('reverse array', 'reverse_array'),
        ('reverse order', 'reverse_string'),
        ('palindrome', 'palindrome'),
        ('length of a string', 'length'),
        ('separate the individual characters', 'chars'),
        ('fibonacci', 'fibonacci'),
        ('matrix', 'matrix'),
        ('table', 'table'),
        ('word', 'word_count'),
        ('department', 'department'),
        ('fruit', 'fruit'),
        ('person', 'person_employee'),
        ('supplier', 'supplier'),
        ('student', 'student_percent'),
        ('customer', 'customer_total'),
        ('player', 'player'),
        ('vowel', 'vowels'),
    ]
    for key, mode in mapping:
        if key in t:
            return mode
    return 'prime'


def choose_aspx_mode(text: str) -> str:
    t = text.lower()
    mapping = [
        ('green', 'hover_button'),
        ('mouse moves over', 'hover_button'),
        ('validation', 'validation'),
        ('simple interest', 'simple_interest'),
        ('list of colors', 'color_change'),
        ('color', 'color_change'),
        ('listbox', 'listbox_to_text'),
        ('radio', 'radio_flower'),
        ('menu', 'menu_form'),
        ('tree view', 'tree_view'),
        ('custom error', 'custom_error'),
        ('login', 'login_validate'),
        ('gridview', 'gridview_db'),
        ('employee', 'employee_db'),
        ('patient', 'patient_db'),
        ('customer', 'customer_validation'),
        ('supplier', 'supplier_display'),
        ('product', 'product_db'),
        ('vote', 'vote_percent'),
        ('255', 'textbox_limit'),
        ('window', 'color_window'),
        ('password', 'login_module'),
        ('perfect number', 'perfect_exception'),
        ('palindrome', 'palindrome'),
        ('fibonacci', 'fibonacci'),
        ('reverse', 'reverse'),
        ('length', 'length'),
        ('word', 'word_count'),
        ('net salary', 'bill_total'),
    ]
    for key, mode in mapping:
        if key in t:
            return mode
    return 'validation'


def write(path: Path, content: str):
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(content, encoding='utf-8')


def comment_for_file(question: str, suffix: str) -> str:
    if suffix == '.aspx':
        return f'<%-- Question: {question} --%>\n'
    return f'// Question: {question}\n'


def write_program(path: Path, content: str, question: str):
    write(path, comment_for_file(question, path.suffix) + content)


def slip_readme(subject: str, slip: str, q1: str, q2: str, kind1: str, kind2: str) -> str:
    lines = [
        'Project Type:',
        f'- {subject}',
        '',
        'Execution Steps:',
        '1. Open Q1_ProgramName in the IDE and run it.',
        '2. Open Q2_ProgramName in the IDE and run it.',
    ]
    if kind1 == 'socket' or kind2 == 'socket':
        lines += ['', 'Socket Note:', '- Run the server first and then the client in a second terminal.']
    if kind1 == 'servlet' or kind2 == 'servlet':
        lines += ['', 'Web Note:', '- Deploy the Java file inside a Dynamic Web Project with Tomcat.']
    sql = sql_from_question(q1) or sql_from_question(q2)
    if sql:
        lines += ['', sql]
    if subject == 'Dot-Net':
        if sql:
            lines += ['', 'Dependencies:', '- Visual Studio / .NET Framework for the .cs and .aspx files.', '- SQL Server / LocalDB for database questions.']
        else:
            lines += ['', 'Dependencies:', '- Visual Studio / .NET Framework for the .cs and .aspx files.']
    else:
        if sql:
            lines += ['', 'Dependencies:', '- JDK 8+.', '- Tomcat 9+ and Servlet API for servlet-based questions.', '- MySQL Connector/J for JDBC questions.']
        else:
            lines += ['', 'Dependencies:', '- JDK 8+.', '- Tomcat 9+ and Servlet API for servlet-based questions.']
    return '\n'.join(lines)


def main():
    pages = extract_pages(RAW.read_text(encoding='utf-8', errors='ignore'))
    for page_num in range(1, 31):
        page = pages.get(page_num, '')
        (aj1, aj2), (dn1, dn2) = extract_questions(page)
        slip = f'Slip-{page_num:02d}'
        aj_dir = REPO / 'Advanced-Java' / slip
        dn_dir = REPO / 'Dot-Net' / slip
        aj_kind1 = choose_java_family(aj1)
        aj_kind2 = choose_java_family(aj2)
        dn_kind1 = 'console'
        dn_kind2 = 'aspx'
        write_program(aj_dir / 'Q1_ProgramName.java', choose_java_template(aj1, 'Q1_ProgramName'), aj1)
        write_program(aj_dir / 'Q2_ProgramName.java', choose_java_template(aj2, 'Q2_ProgramName'), aj2)
        write_program(dn_dir / 'Q1_ProgramName.cs', dotnet_console_template(choose_dotnet_mode(dn1)), dn1)
        write_program(dn_dir / 'Q2_ProgramName.aspx', aspx_template(choose_aspx_mode(dn2)), dn2)
        write(aj_dir / 'README.txt', slip_readme('Advanced-Java', slip, aj1, aj2, aj_kind1, aj_kind2))
        write(dn_dir / 'README.txt', slip_readme('Dot-Net', slip, dn1, dn2, dn_kind1, dn_kind2))


if __name__ == '__main__':
    main()
