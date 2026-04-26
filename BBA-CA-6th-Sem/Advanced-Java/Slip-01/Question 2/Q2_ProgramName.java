// Question: Write a socket program in java for chatting application.(Use Swing) [25 M]
import java.io.*;
import java.net.*;
public class Q2_ProgramName {
    static int port = 5000;
    public static void main(String[] args) throws Exception {
        String role = args.length > 0 ? args[0] : "server";
        if ("server".equalsIgnoreCase(role)) server(); else client();
    }
    static void server() throws Exception {
        ServerSocket ss = new ServerSocket(port);
        Socket s = ss.accept();
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        String msg = in.readLine();
        String resp = reply(msg);
        out.println(resp);
        s.close(); ss.close();
    }
    static void client() throws Exception {
        Socket s = new Socket("localhost", port);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        System.out.print("Enter input: ");
        String msg = br.readLine();
        out.println(msg);
        System.out.println(in.readLine());
        s.close();
    }
    static String reply(String msg) {
        String mode = "chat";
        if ("chat".equals(mode)) return "Server received: " + msg;
        if ("prime".equals(mode)) { int n = Integer.parseInt(msg.trim()); return isPrime(n) ? "Prime" : "Not Prime"; }
        if ("factors".equals(mode)) { int n = Integer.parseInt(msg.trim()); StringBuilder sb = new StringBuilder(); for (int i = 1; i <= n; i++) if (n % i == 0) sb.append(i).append(' '); return sb.toString(); }
        return "OK";
    }
    static boolean isPrime(int n) { if (n < 2) return false; for (int i = 2; i * i <= n; i++) if (n % i == 0) return false; return true; }
}
