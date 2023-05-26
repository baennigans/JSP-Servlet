package day3.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Login() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");

		if (id != null) {
			response.sendRedirect("MainServlet");
		} else {
			request.setCharacterEncoding("euc-kr");
			response.setContentType("text/html;charset=EUC-KR");
			PrintWriter out = response.getWriter();

			out.print("<form method='post' action='Login'>");
			out.println("<h1>로그인하세요</h1>");
			out.print("ID<br><input type='text' name='id'><br>");
			out.print("PW<br><input type='password' name='pw'><br><br>");
			out.print("<input type='submit' value='로그인'>");
			out.print("</form>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		String validUsername = "bae";
		String validPassword = "123";

		if (id.equals(validUsername) && pw.equals(validPassword)) {
			session.setAttribute("id", id);
			response.sendRedirect("MainServlet");
		} else {
			response.sendRedirect("ErrorServlet");
		}
	}

}
