package Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        
        
        if (session == null) {
            response.getWriter().println("<h2>Chưa có session nào tồn tại!</h2>");
        } else {
            String username = (String) session.getAttribute("name");
            String role = (String) session.getAttribute("role");
            
            response.getWriter().println("<!DOCTYPE html><html><body>");
            response.getWriter().println("<h2>Thông tin Session</h2>");
            response.getWriter().println("Tên đăng nhập: " + username + "<br>");
            response.getWriter().println("Role: " + role + "<br>");
            response.getWriter().println("SessionID: " + session.getId() + "<br>");
            response.getWriter().println("Timeout: " + session.getMaxInactiveInterval() + " giây<br>");
            response.getWriter().println("</body></html>");
        }
    }
}
