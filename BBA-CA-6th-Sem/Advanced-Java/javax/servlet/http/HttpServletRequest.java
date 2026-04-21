package javax.servlet.http;

public interface HttpServletRequest {
    String getRemoteAddr();

    String getHeader(String name);

    HttpSession getSession();

    String getParameter(String name);
}
