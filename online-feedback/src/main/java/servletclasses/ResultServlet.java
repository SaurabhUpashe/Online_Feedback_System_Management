package servletclasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<html><head><title>User Feedback</title>");
	    out.println("<style>");
	    out.println("body { font-family: 'Segoe UI', sans-serif; background: linear-gradient(to right, #fbc2eb, #a6c1ee); margin: 0; padding: 40px 20px; text-align: center; animation: fadeIn 0.6s ease-in; }");
	    out.println("h2 { color: #333; font-size: 28px; margin-bottom: 30px; }");
	    out.println("table { width: 90%; max-width: 1000px; margin: auto; border-collapse: collapse; border-radius: 12px; overflow: hidden; box-shadow: 0 8px 20px rgba(0,0,0,0.2); background-color: #ffffff; }");
	    out.println("th, td { padding: 15px 20px; border-bottom: 1px solid #ddd; text-align: left; }");
	    out.println("th { background-color: #007bff; color: #ffffff; }");
	    out.println("tr:nth-child(even) { background-color: #f9f9f9; }");
	    out.println("tr:hover { background-color: #f1f1f1; transition: background-color 0.3s ease; }");
	    out.println("button { margin-top: 30px; padding: 12px 25px; font-size: 16px; font-weight: bold; background-color: #007bff; color: #fff; border: none; border-radius: 8px; cursor: pointer; transition: background-color 0.3s ease, transform 0.3s ease; }");
	    out.println("button:hover { background-color: #0056b3; transform: scale(1.05); }");
	    out.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }");
	    out.println("</style>");
	    out.println("</head><body>");

	    out.println("<h2>User Feedback</h2>");
	    out.println("<table><tr><th>ID</th><th>Question</th><th>Feedback</th></tr>");

	    String query = "SELECT id, question, answer FROM feedback";

	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/feedback_db", "root", "Saurabh@123");
	         PreparedStatement stmt = conn.prepareStatement(query);
	         ResultSet rs = stmt.executeQuery()) {

	        while (rs.next()) {
	            out.println("<tr>");
	            out.println("<td>" + rs.getInt("id") + "</td>");
	            out.println("<td>" + rs.getString("question") + "</td>");
	            out.println("<td>" + rs.getString("answer") + "</td>");
	            out.println("</tr>");
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	        out.println("<p style='color:red; font-weight:bold;'>Error fetching feedback.</p>");
	    }

	    out.println("</table>");
	    out.println("<button onclick='window.history.back();'>Back to Dashboard</button>");
	    out.println("</body></html>");
	}
}
