package Session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("Lam".equals(username) && "04112005".equals(password)) {
   
            HttpSession session = request.getSession();
            session.setAttribute("name", username);
            session.setAttribute("role", "User");
            session.setMaxInactiveInterval(300);

            response.getWriter().println("Chào mừng bạn, " + username + "<br/>");
            response.getWriter().println("<a href='Profile'>Vào trang Profile</a>");
        } else {
            response.getWriter().println("Tài khoản hoặc mật khẩu không chính xác");
            // Quay về form Login.html
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            rd.include(request, response);
        }
    }
}
