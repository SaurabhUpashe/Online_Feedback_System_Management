package servletclasses;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		//FeedBackDAO feedback = new FeedBackDAO();
		boolean status = FeedBackDAO.isValidates(email,password);
		
		if(status)
		{
			response.sendRedirect("FeedbackServlet");
		}
		else
		{
			out.println("<html><head>");
			out.println("<style>");
			out.println("h2{font-size: 30px; border: 5px solid red; color : cyan}");
			out.println("</style>");
			out.println("<body>");
			out.println("<h2>Invalid login! Please register first.</h2>");
			out.println("<a href='user_login.html'>Back to Login</a>");
		}
		
	}
}
