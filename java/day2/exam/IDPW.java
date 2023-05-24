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
		out.print("<input type='submit' value='회원가입'>");
		out.print("</form>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
	    String pw = request.getParameter("pw");
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals(id)) {
					System.out.println("이미 사용하고있는 ID입니다.");
					return;
				}
			}
			System.out.print(id+"님 회원가입이 완료되었습니다.");
		}
		
		Cookie cookie = new Cookie(id,pw);
		response.addCookie(cookie);
		
		try {
            String filePath = System.getProperty("user.home") + "/Desktop/id.txt";
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath,true));
            writer.write("ID: " + id + ", PW: " + pw);
            writer.newLine();
            writer.close();
            System.out.println(" id/pw는 id.txt파일에 저장되었습니다.");
        } catch (IOException e) {
            System.out.println("파일에 쿠키 값을 저장하는 동안 오류가 발생했습니다: " + e.getMessage());
        }
		response.sendRedirect("IDPW");
	}
}
