// Question: Write a SERVLET program to Design an HTML page containing 4 option buttons (Painting, Drawing, Singing and swimming) and 2 buttons reset and submit. When the user clicks submit, the server responds by adding cookie containing the selected hobby and sends the HTML page to the client. Program should not allow duplicate cookies to be written. [25 M]
import java.io.*;
import java.sql.*;
import java.time.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@WebServlet("/Q2_ProgramName")
public class Q2_ProgramName extends HttpServlet {
    String mode = "cookie_hobby";
    Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        if ("request_info".equals(mode)) {
            out.println("IP: " + req.getRemoteAddr() + "<br>");
            out.println("Browser: " + req.getHeader("User-Agent"));
            return;
        }
        if ("greet_time".equals(mode)) {
            int h = LocalTime.now().getHour();
            out.println(h < 12 ? "Good Morning" : h < 18 ? "Good Afternoon" : "Good Evening");
            return;
        }
        if ("visit_counter".equals(mode)) {
            HttpSession s = req.getSession();
            Integer c = (Integer) s.getAttribute("count");
            c = c == null ? 1 : c + 1;
            s.setAttribute("count", c);
            out.println("Visits: " + c);
            return;
        }
        if ("login".equals(mode)) {
            String u = req.getParameter("u");
            String p = req.getParameter("p");
            out.println("<form><input name='u'><input name='p'><button>Login</button></form>");
            if (u != null) out.println("DYP".equals(u) && "Pimpri".equals(p) ? "Login Successfully" : "Login Failed");
            return;
        }
        if ("cookie_hobby".equals(mode)) {
            String h = req.getParameter("hobby");
            if (h != null) { resp.addCookie(new Cookie("hobby", h)); out.println("Saved: " + h); } else out.println("Select a hobby");
            return;
        }
        if ("file_extensions".equals(mode)) {
            String dir = req.getParameter("dir");
            String ext = req.getParameter("ext");
            out.println("<form>Dir:<input name='dir'> Ext:<input name='ext'><button>Go</button></form>");
            if (dir != null && ext != null) {
                File f = new File(dir);
                File[] files = f.listFiles((d, name) -> name.endsWith(ext));
                if (files != null) for (File x : files) out.println(x.getName() + "<br>");
            }
            return;
        }
        if ("date_time".equals(mode)) { out.println(LocalDateTime.now()); return; }
        out.println("Servlet demo for the slip.");
    }
}
