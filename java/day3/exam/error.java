package day3.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class error extends HttpServlet {
	
    private static final long serialVersionUID = 1L;

    public error() {
        super();
    }

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=EUC-KR");
        PrintWriter out = response.getWriter();

        out.println("<form method='get' action='Login'>");
        out.println("<p>ID �Ǵ� PW�� �߸��Է��Ͽ����ϴ�.</p>");
        out.println("<input type='submit' value='���ư���'>");
        out.println("</form>");
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}