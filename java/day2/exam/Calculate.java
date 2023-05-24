package day2.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculate")
public class Calculate extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public Calculate() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				out.println(cookie.getName() + "=" + cookie.getValue() + "<br/>");
			}
		}

		out.print("<form method='post' action='Calculate'>");
		out.print("첫번째숫자 : <input type='text' name='num1'><br>");
		out.print("두번째숫자 : <input type='text' name='num2'><br><br>");
		out.print("<input type='radio' name='calculation' value='+'>+<br>");
		out.print("<input type='radio' name='calculation' value='-'>-<br>");
		out.print("<input type='radio' name='calculation' value='*'>*<br>");
		out.print("<input type='radio' name='calculation' value='/'>/<br><br>");
		out.print("<input type='submit' value='계산하기'/>");
		out.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String calculate = request.getParameter("calculation");
		double result = 0;

		System.out.println("사칙연산 실습하기");

		switch (calculate) {
		case "+":
			result = num1 + num2;
			break;
		case "-":
			result = num1 - num2;
			break;
		case "*":
			result = num1 * num2;
			break;
		case "/":
			result = num1 / num2;
			break;
		}

		System.out.println(num1 + " " + calculate + " " + num2 + " = " + result);

		String str1 = num1 + calculate + num2;
		String str2 = String.valueOf(result);

		Cookie cookie = new Cookie(str1, str2);
		response.addCookie(cookie);
		response.sendRedirect("Calculate");
	}
}
