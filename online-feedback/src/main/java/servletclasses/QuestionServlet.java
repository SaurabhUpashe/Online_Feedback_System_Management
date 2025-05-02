package servletclasses;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class QuestionServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	private Question question;

	public void init() {
		question = new Question();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
	    String action = request.getParameter("action");
	   
	    try {
	        if("add".equals(action)) {
	            int id = Integer.parseInt(request.getParameter("question_Id"));
	            String questionText = request.getParameter("question_text");

	            AdminDAO.addQuestion(id, questionText);
	        }
	        else if("delete".equals(action)) {
	            int id = Integer.parseInt(request.getParameter("questionId"));
	            AdminDAO.DeleteQuestion(id);
	        }
	        else if("update".equals(action)) {
	        	
	            int id = Integer.parseInt(request.getParameter("questionId"));
	            String updatedText = request.getParameter("updatedQuestionText");

	            AdminDAO.UpdateQuestion(id,updatedText);
	        }

	        response.sendRedirect("QuestionServlet"); 

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    AdminDAO adminDAO = new AdminDAO();
	    List<Question> questions = new ArrayList<>();

	    try {
	        questions = adminDAO.getAllquestion();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    out.println("<!DOCTYPE html>");
	    out.println("<html lang='en'>");
	    out.println("<head>");
	    out.println("<meta charset='UTF-8'>");
	    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
	    out.println("<title>Modify Feedback Question</title>");
	    out.println("<style>");
	    out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(to right, #74ebd5, #ACB6E5); padding: 40px 20px; margin: 0; text-align: center; animation: fadeIn 0.6s ease-in-out; }");
	    out.println("h2, h3 { color: #333; margin-bottom: 10px; }");
	    out.println("form { background: rgba(255,255,255,0.95); padding: 25px 30px; margin: 20px auto; border-radius: 15px; box-shadow: 0 10px 25px rgba(0,0,0,0.2); max-width: 500px; animation: popUp 0.4s ease; }");
	    out.println("label { font-weight: 600; display: block; margin-top: 15px; text-align: left; }");
	    out.println("input, select { width: 100%; padding: 10px; margin-top: 8px; border: 1px solid #ccc; border-radius: 6px; font-size: 16px; }");
	    out.println("button { background-color: #00bcd4; color: white; padding: 12px 20px; border: none; border-radius: 8px; font-weight: bold; font-size: 16px; cursor: pointer; margin-top: 20px; transition: background-color 0.3s ease, transform 0.3s ease; }");
	    out.println("button:hover { background-color: #0097a7; transform: scale(1.05); }");
	    out.println("button[style*='red'] { background-color: #dc3545 !important; }");
	    out.println("button[style*='red']:hover { background-color: #c82333 !important; }");
	    out.println("@keyframes fadeIn { from { opacity: 0; transform: translateY(30px); } to { opacity: 1; transform: translateY(0); } }");
	    out.println("@keyframes popUp { from { transform: scale(0.8); opacity: 0; } to { transform: scale(1); opacity: 1; } }");
	    out.println("</style>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h2>Modify Feedback Question</h2>");

	    // ADD QUESTION SECTION
	    out.println("<form action='QuestionServlet' method='post'>");
	    out.println("<h3>Add New Question</h3>");
	    out.println("<input type='text' name='question_Id' placeholder='Enter question ID' required>");
	    out.println("<input type='text' name='question_text' placeholder='Enter question text' required>");
	    out.println("<input type='hidden' name='action' value='add'>");
	    out.println("<button type='submit'>Add Question</button>");
	    out.println("</form>");

	    // UPDATE AND DELETE SECTIONS
	    if (!questions.isEmpty()) {
	        // UPDATE
	        out.println("<form action='QuestionServlet' method='post'>");
	        out.println("<h3>Update Existing Question</h3>");
	        out.println("<label>Select a question:</label>");
	        out.println("<select name='questionId' required>");
	        for (Question q : questions) {
	            out.println("<option value='" + q.getId() + "'>" + q.getQuestionText() + "</option>");
	        }
	        out.println("</select>");
	        out.println("<input type='text' name='updatedQuestionText' placeholder='New question text' required>");
	        out.println("<input type='hidden' name='action' value='update'>");
	        out.println("<button type='submit'>Update Question</button>");
	        out.println("</form>");

	        // DELETE
	        out.println("<form action='QuestionServlet' method='post'>");
	        out.println("<h3>Delete Existing Question</h3>");
	        out.println("<label>Select a question to delete:</label>");
	        out.println("<select name='questionId' required>");
	        for (Question q : questions) {
	            out.println("<option value='" + q.getId() + "'>" + q.getQuestionText() + "</option>");
	        }
	        out.println("</select>");
	        out.println("<input type='hidden' name='action' value='delete'>");
	        out.println("<button type='submit' style='background-color:red;'>Delete Question</button>");
	        out.println("</form>");
	    } else {
	        out.println("<p style='color: #ff4444; font-size: 18px;'>No questions available to modify.</p>");
	    }

	    // BACK BUTTON
	    out.println("<button onclick='window.history.back()'>Go to Previous</button>");
	}


}
