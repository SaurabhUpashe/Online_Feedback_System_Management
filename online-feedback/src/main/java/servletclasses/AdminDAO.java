package servletclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {
	
	private static final String URL = "jdbc:mysql://localhost:3306/feedback_db";
	private static final String USER = "root";
	private static final String PASSWORD = "Saurabh@123";
	
	public AdminDAO()
	{
        // Load the MySQL JDBC driver
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	// Utility method to get a DB connection
	private static Connection getConnection()throws SQLException 
	{
		return DriverManager.getConnection(URL,USER,PASSWORD);
	}
	
	//Save the feedback of user on database
	public static boolean saveFeedBack(String question ,String answer)
	{
		String query = "INSERT INTO feedback(question, answer) VALUES (?,?)";
		boolean status = false;
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query))
		{
			ps.setString(1, question);
			ps.setString(2, answer);
			int row = ps.executeUpdate();
			if(row > 0)
			{
				status = true;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	//Add method for insert data on database where questions table
	public static void addQuestion(int id, String questionText) {
	    String query = "INSERT INTO questions (id, question_text) VALUES (?, ?)";
	    try (Connection conn = getConnection();
	         PreparedStatement ps = conn.prepareStatement(query)) {
	        ps.setInt(1, id);
	        ps.setString(2, questionText);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	//Delete method for delete data on database where questions table
	public static void DeleteQuestion(int id)
	{
		String query = "DELETE FROM questions WHERE id =? ";
		try(Connection conn =getConnection(); PreparedStatement ps = conn.prepareStatement(query))
		{
			ps.setInt(1,id);
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//update method for update data on database where questions table
	public static void UpdateQuestion(int id, String updatequestion)
	{
		String query = "UPDATE questions SET question_text = ? WHERE id = ? ";
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query))
		{
			ps.setString(1, updatequestion);
			ps.setInt(2,id);
			
			ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//this method is used for fetching data on database 
	public static List<Question> getAllquestion() 
	{
	    List<Question> questionList = new ArrayList<>();
	    String query = "SELECT * FROM questions";
	    try (Connection conn = getConnection();
	         PreparedStatement ps = conn.prepareStatement(query);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) 
	        {
	            Question q = new Question();
	            q.setId(rs.getInt("id"));
	            q.setQuestion(rs.getString("question_text"));
	            questionList.add(q);
	          
	        }
	        System.out.println("Fetched Questions: " + questionList.size());
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return questionList;
	}
}
