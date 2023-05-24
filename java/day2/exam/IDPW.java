package day2.exam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IDPW")
public class IDPW extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	
    public IDPW() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html;charset=EUC-KR");
		PrintWriter out = response.getWriter();

		out.print("<form method='post' action='IDPW'>");
		out.print("ID<br><input type='text' name='id'><br>");
		out.print("PW<br><input type='password' name='pw'><br>");
		out.print("<input type='submit' value='ȸ������'>");
		out.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	    String pw = request.getParameter("pw");
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(id)) {
					System.out.println("�̹� ����ϰ��ִ� ID�Դϴ�.");
					return;
				}
			}
			System.out.print(id+"�� ȸ�������� �Ϸ�Ǿ����ϴ�.");
		}
		
		Cookie cookie = new Cookie(id,pw);
		response.addCookie(cookie);
		
		try {
            String filePath = System.getProperty("user.home") + "/Desktop/id.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
            writer.write("ID: " + id + ", PW: " + pw);
            writer.newLine();
            writer.close();
            System.out.println(" id/pw�� id.txt���Ͽ� ����Ǿ����ϴ�.");
        } catch (IOException e) {
            System.out.println("���Ͽ� ��Ű ���� �����ϴ� ���� ������ �߻��߽��ϴ�: " + e.getMessage());
        }
		response.sendRedirect("IDPW");
	}
}
