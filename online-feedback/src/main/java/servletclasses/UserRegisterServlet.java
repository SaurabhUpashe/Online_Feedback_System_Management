package servletclasses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserRegisterServlet extends HttpServlet {
		
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
       // FeedBackDAO  feedback = new FeedBackDAO();
        boolean status = FeedBackDAO.insertUser(name, email, password);
        
        out.println("<html><head><title>Registration Status</title>");
        out.println("<style>");
        out.println("body {");
        out.println("  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("  background: linear-gradient(135deg, #74ebd5, #9face6);");
        out.println("  min-height: 100vh;");
        out.println("  margin: 0;");
        out.println("  display: flex;");
        out.println("  align-items: center;");
        out.println("  justify-content: center;");
        out.println("  animation: fadeIn 0.6s ease-in-out;");
        out.println("}");
        out.println(".container {");
        out.println("  background: rgba(255, 255, 255, 0.95);");
        out.println("  padding: 30px;");
        out.println("  max-width: 450px;");
        out.println("  border-radius: 15px;");
        out.println("  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);");
        out.println("  text-align: center;");
        out.println("  animation: popUp 0.5s ease;");
        out.println("}");
        out.println("h2 {");
        out.println("  font-size: 24px;");
        out.println("  color: #275360;");
        out.println("  margin-bottom: 15px;");
        out.println("}");
        out.println("button {");
        out.println("  background-color: #00bcd4;");
        out.println("  color: white;");
        out.println("  padding: 12px 25px;");
        out.println("  border: none;");
        out.println("  border-radius: 6px;");
        out.println("  cursor: pointer;");
        out.println("  font-weight: bold;");
        out.println("  font-size: 16px;");
        out.println("  margin-top: 20px;");
        out.println("  transition: transform 0.3s ease, background-color 0.3s ease;");
        out.println("}");
        out.println("button:hover {");
        out.println("  background-color: #0097a7;");
        out.println("  transform: scale(1.05);");
        out.println("}");
        out.println("button a {");
        out.println("  color: white;");
        out.println("  text-decoration: none;");
        out.println("}");
        out.println("@keyframes fadeIn {");
        out.println("  from { opacity: 0; transform: translateY(20px); }");
        out.println("  to { opacity: 1; transform: translateY(0); }");
        out.println("}");
        out.println("@keyframes popUp {");
        out.println("  from { transform: scale(0.8); opacity: 0; }");
        out.println("  to { transform: scale(1); opacity: 1; }");
        out.println("}");
        out.println("</style>");

        out.println("</head><body>");
        out.println("<div class='container'>");
        if (status) {
            out.println("<h2>Registration Successful</h2>");
            out.println("<button><a href='index.html'>Go Back</a></button>");

        } else {
            out.println("<h2>Registration Failed</h2>");
            out.println("<button><a href='index.html'>Go Back</a></button>");
        }
        out.println("</div>");
        out.println("</body></html>");
	}
	
}