package Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CreateSession")
public class CreateSession extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(); // tạo session mới nếu chưa có
        session.setAttribute("name", "Mai Hoang Truc Lam");
        session.setAttribute("role", "Admin");
        session.setMaxInactiveInterval(300); // 30 giây

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<h2>Session đã được tạo thành công!</h2>");
    }
}
