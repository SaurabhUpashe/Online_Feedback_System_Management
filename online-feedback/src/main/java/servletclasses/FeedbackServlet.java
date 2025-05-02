package servletclasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FeedbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        List<Question> questions = AdminDAO.getAllquestion();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='en'>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Feedback Form</title>");
        out.println("<link rel='stylesheet' href='css/style.css'>"); // ✅ Link your existing CSS file here
        out.println("<style>");
        out.println("body {");
        out.println("  margin: 0;");
        out.println("  font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;");
        out.println("  background: url('images/feedback-bg.jpg') no-repeat center center fixed;");
        out.println("  background-size: cover;");
        out.println("  overflow-x: hidden;");
        out.println("}");
        out.println(".blur-bg-overlay {");
        out.println("  position: fixed;");
        out.println("  top: 0;");
        out.println("  left: 0;");
        out.println("  width: 100%;");
        out.println("  height: 100%;");
        out.println("  backdrop-filter: blur(8px);");
        out.println("  z-index: -1;");
        out.println("}");
        out.println(".feedback-form-container {");
        out.println("  max-width: 600px;");
        out.println("  margin: 100px auto 50px auto;");
        out.println("  background: rgba(255, 255, 255, 0.9);");
        out.println("  padding: 30px;");
        out.println("  border-radius: 15px;");
        out.println("  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);");
        out.println("  transition: all 0.3s ease-in-out;");
        out.println("  animation: slideIn 0.6s ease-in-out;");
        out.println("}");
        out.println(".feedback-form-container:hover { transform: scale(1.01); }");
        out.println(".feedback-form-container h2 { color: #275360; margin-bottom: 20px; }");
        out.println(".feedback-form-container label { font-weight: 600; color: #333; display: block; margin-top: 15px; text-align: left; }");
        out.println(".feedback-form-container input[type='text'] { width: 100%; padding: 10px; margin-top: 5px; border-radius: 5px; border: 1px solid #ccc; transition: box-shadow 0.3s ease, border-color 0.3s ease; }");
        out.println(".feedback-form-container input[type='text']:focus { border-color: #00bcd4; box-shadow: 0 0 8px #00bcd4; outline: none; }");
        out.println(".feedback-form-container button { background: #00bcd4; color: white; padding: 12px 20px; border: none; border-radius: 5px; cursor: pointer; font-weight: bold; margin-top: 20px; transition: all 0.3s ease; position: relative; overflow: hidden; }");
        out.println(".feedback-form-container button::before { content: ''; position: absolute; top: 0; left: -100%; width: 100%; height: 100%; background: rgba(255, 255, 255, 0.2); transition: all 0.4s ease-in-out; }");
        out.println(".feedback-form-container button:hover::before { left: 0; }");
        out.println(".feedback-form-container button:hover { transform: scale(1.05); box-shadow: 0 8px 20px rgba(0, 188, 212, 0.4); }");
        out.println("@keyframes slideIn { from {opacity: 0; transform: translateY(40px);} to {opacity: 1; transform: translateY(0);} }");
        out.println("footer { text-align:center; color: white; padding: 20px; position: fixed; bottom: 0; width: 100%; background: rgba(0,0,0,0.6); font-weight: 500; backdrop-filter: blur(6px); transition: background 0.3s ease; }");
        out.println("</style>");

        out.println("</head>");
        out.println("<body>");

        out.println("<div class='blur-bg-overlay'></div>");

        out.println("<div class='feedback-form-container'>");
        out.println("<h2>Feedback Form</h2>");
        out.println("<form action='FeedbackServlet' method='post'>");
        for (Question question : questions) {
            out.println("<label>" + question.getQuestionText() + "</label>");
            out.println("<input type='hidden' name='question_text' value='" + question.getQuestionText() + "'>");
            out.println("<input type='text' name='answer' required><br>");
        }
        out.println("<button type='submit'>Submit Feedback</button>");
        out.println("</form>");
        out.println("</div>");

        // ✅ Footer
        out.println("<footer style='text-align:center; color: white; padding: 20px; position: fixed; bottom: 0; width: 100%; background: rgba(0,0,0,0.6);'>");
        out.println("&copy; 2025 Book Library System | All Rights Reserved");
        out.println("</footer>");

        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String[] questions = request.getParameterValues("question_text");
        String[] answers = request.getParameterValues("answer");
        
        boolean allSaved = true;
        for(int i=0;i<questions.length;i++)
        {
            boolean status = AdminDAO.saveFeedBack(questions[i],answers[i]);
            if(!status)
            {
                allSaved = false;
            }
        }
        
        out.println("<html><head><title>Feedback Submission</title>");
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
        out.println(".message-container {");
        out.println("  background: rgba(255, 255, 255, 0.95);");
        out.println("  padding: 30px;");
        out.println("  max-width: 450px;");
        out.println("  border-radius: 15px;");
        out.println("  box-shadow: 0 10px 25px rgba(0, 0, 0, 0.2);");
        out.println("  text-align: center;");
        out.println("  animation: popUp 0.5s ease;");
        out.println("}");
        out.println(".message {");
        out.println("  font-size: 20px;");
        out.println("  font-weight: bold;");
        out.println("  margin-bottom: 20px;");
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
        out.println("</style></head><body>");

        out.println("<div class='message-container'>");
        
        if(allSaved)
        {
            out.println("<p class='message' style='color: green;'>Feedback Submitted Successfully</p>");
            out.println("<button><a href='index.html'>GoTo Previous</a></button>");
        }
        else
        {
            out.println("<p class='message' style='color: red;'>Feedback Submission Failed</p>");
            out.println("<button><a href='index.html'>GoTo Previous</a></button>");
        }
        
        out.println("</div>");
        out.println("</body></html>");
    }

}