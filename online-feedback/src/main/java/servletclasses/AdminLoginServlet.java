package servletclasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AdminLoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	{
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");
	    
	  
	    if(email.equals("Saurabh@company.com") && password.equals("saurabh@1234"))
	    {
	    	out.println("<!DOCTYPE html>");
	    	out.println("<html>");
	    	out.println("<head>");
	    	out.println("<title>Admin Page</title>");
	    	out.println("<style>");
	    	out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #74ebd5, #9face6); display: flex; flex-direction: column; align-items: center; justify-content: center; min-height: 100vh; margin: 0; animation: fadeIn 0.6s ease-in-out; }");
	    	out.println(".container { background: rgba(255, 255, 255, 0.95); padding: 40px; border-radius: 15px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); text-align: center; animation: popUp 0.5s ease; margin-bottom: 30px; }");
	    	out.println("h1 { color: #4CAF50; font-size: 28px; margin-bottom: 15px; }");
	    	out.println("p { font-size: 18px; color: #555; margin-bottom: 20px; }");
	    	out.println("form, .nav-button { margin: 10px; }");
	    	out.println("button { background-color: #00bcd4; color: white; padding: 12px 25px; border: none; border-radius: 6px; cursor: pointer; font-weight: bold; font-size: 16px; transition: transform 0.3s ease, background-color 0.3s ease; }");
	    	out.println("button:hover { background-color: #0097a7; transform: scale(1.05); }");
	    	out.println("button a { color: white; text-decoration: none; display: block; }");
	    	out.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }");
	    	out.println("@keyframes popUp { from { transform: scale(0.8); opacity: 0; } to { transform: scale(1); opacity: 1; } }");
	    	out.println("</style>");
	    	out.println("</head>");
	    	out.println("<body>");

	    	out.println("<div class='container'>");
	    	out.println("<h1>Admin Successfully Logged In</h1>");
	    	out.println("<p>Welcome to the Admin Panel.</p>");
	    	out.println("</div>");

	    	out.println("<form action='QuestionServlet' method='get'>");
	    	out.println("<button type='submit'>Modify Feedback</button>");
	    	out.println("</form>");

	    	out.println("<form action='ResultServlet' method='get'>");
	    	out.println("<button type='submit'>Check User Data</button>");
	    	out.println("</form>");

	    	out.println("<div class='nav-button'>");
	    	out.println("<button><a href='index.html'>Go Previous</a></button>");
	    	out.println("</div>");

	    	out.println("</body>");
	    	out.println("</html>");

	    }
	    else
	    {
	    	out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Admin Page</title>");
	        out.println("<style>");
	        out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #74ebd5, #9face6); display: flex; align-items: center; justify-content: center; min-height: 100vh; margin: 0; animation: fadeIn 0.6s ease-in-out; }");
	        out.println(".container { background: rgba(255, 255, 255, 0.95); padding: 40px; border-radius: 15px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); text-align: center; animation: popUp 0.5s ease; }");
	        out.println("h1 { color: #f44336; font-size: 28px; margin-bottom: 20px; }");
	        out.println("button { background-color: #00bcd4; color: white; padding: 12px 25px; border: none; border-radius: 6px; cursor: pointer; font-weight: bold; font-size: 16px; transition: transform 0.3s ease, background-color 0.3s ease; }");
	        out.println("button:hover { background-color: #0097a7; transform: scale(1.05); }");
	        out.println("button a { color: white; text-decoration: none; }");
	        out.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }");
	        out.println("@keyframes popUp { from { transform: scale(0.8); opacity: 0; } to { transform: scale(1); opacity: 1; } }");
	        out.println("</style>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class='container'>");
	        out.println("<h1>Admin Failed</h1>");
	        
	        out.println("<button><a href='admin_login.html'>GoTo Privous</a></button>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");
	    }
	    
	    
	}
	
}