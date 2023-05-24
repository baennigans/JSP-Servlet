package day2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieTest2
 */
@WebServlet("/CookieTest2")
public class CookieTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=euc-kr");
		PrintWriter out = response.getWriter();
		
		//브라우저로부터 쿠키 가져오기
		Cookie[] cookies = request.getCookies();
		
		//쿠키가 있는지 확인
		if(cookies != null) {
			//쿠키가 있으면
			for(Cookie cookie : cookies) {
				//출력
				out.println("cookie : "+cookie.getName()+":"+cookie.getValue()+"<br/>");
			}	
		}
		
		//name과 value 입력받는 html 폼 생성
		out.println("<form method='post' action='CookieTest2'>");
		out.println("name<input type='text' name='name'/>");
		out.println("value<input type='text' name='value'/>");
		out.println("<input type='submit'/>");
		out.println("</form>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼에서 POST로 요청이오면
		//request에서 name, value 추출
		String name = request.getParameter("name");
		String value = request.getParameter("value");

		//쿠키로 저장
		Cookie c = new Cookie(name,value);
		response.addCookie(c);
		
		//서블릿 doGet으로 리다이랙션
		response.sendRedirect("CookieTest2");
	}

}
