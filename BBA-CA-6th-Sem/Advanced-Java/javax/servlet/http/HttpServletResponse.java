package javax.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

public interface HttpServletResponse {
    void setContentType(String type);

    PrintWriter getWriter() throws IOException;

    void addCookie(Cookie cookie);
}
