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
		
		//�������κ��� ��Ű ��������
		Cookie[] cookies = request.getCookies();
		
		//��Ű�� �ִ��� Ȯ��
		if(cookies != null) {
			//��Ű�� ������
			for(Cookie cookie : cookies) {
				//���
				out.println("cookie : "+cookie.getName()+":"+cookie.getValue()+"<br/>");
			}	
		}
		
		//name�� value �Է¹޴� html �� ����
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
		//������ POST�� ��û�̿���
		//request���� name, value ����
		String name = request.getParameter("name");
		String value = request.getParameter("value");

		//��Ű�� ����
		Cookie c = new Cookie(name,value);
		response.addCookie(c);
		
		//���� doGet���� �����̷���
		response.sendRedirect("CookieTest2");
	}

}
