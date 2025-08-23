package Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/Profile")
public class Profile extends HttpServlet {
   
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession(false); //

        if (session != null && session.getAttribute("name") != null) {
            String name = (String) session.getAttribute("name");
            response.getWriter().println("<h2>Chào bạn, " + name + " đến với trang quản lý tài khoản</h2>");
            response.getWriter().println("<a href='LogoutServlet'>Đăng xuất</a>");
        } else {
            response.sendRedirect("Login.html");
        }
    }
}
