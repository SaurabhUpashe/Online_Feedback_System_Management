package servletclasses;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FeedBackDAO {
	public final static String URL = "jdbc:mysql://localhost:3306/feedback_db";
	public final static String USER = "root";
	public final static String PASSWORD = "Saurabh@123";
	
	public FeedBackDAO() {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER,PASSWORD);
    }
	
	// Insert a new user record
	public static boolean insertUser(String name, String email, String password)
	{
		String query = "INSERT INTO users (name, email, password) VALUES (?,?,?)";
		boolean status = false;
		
		
		try(Connection conn = getConnection(); PreparedStatement ps = conn.prepareStatement(query))
		{
			
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			int rowsInserted = ps.executeUpdate();
			
			if(rowsInserted > 0)
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
	
	
	//check the user is valid or not
	public static boolean isValidates(String email, String password)
	{
		String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		boolean status = false;
		try(Connection conn = DriverManager.getConnection(URL, USER,PASSWORD); PreparedStatement ps = conn.prepareStatement(query))
		{
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
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
	
}
