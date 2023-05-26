package day3.exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MainServlet")
public class main extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public main() {
        super();
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
        String id = (String)session.getAttribute("id");

        if (id != null) {
            response.setContentType("text/html;charset=EUC-KR");
            PrintWriter out = response.getWriter();

            out.println(id+"¥‘ æ»≥Á«œººø‰!");
            out.println("<form method='post' action='Logout'>");
            out.println("<br><input type='submit' value='∑Œ±◊æ∆øÙ'>");
            out.println("</form>");
        } else {
            response.sendRedirect("Login");
        }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
