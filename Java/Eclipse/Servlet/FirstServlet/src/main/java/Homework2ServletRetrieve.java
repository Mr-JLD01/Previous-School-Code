import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Homework1ServletRetrieve
 */
@WebServlet("/Homework2ServletRetrieve")
public class Homework2ServletRetrieve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Homework2ServletRetrieve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name;
		String email;
		String location;
		String gender;
		String experience;
		// JDBC driver name and database URL
		 String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		 //String DB_URL = "jdbc:mysql://52.26.86.130:3306/student";
		 String DB_URL = "jdbc:mysql://localhost:3306/testDB";

		 // Database credentials
		 String USER = "root";
		 String PASS = "";

		 Connection conn = null;
		 Statement stmt = null;
		 //STEP 2: Register JDBC driver
		 try {
			String previous = request.getParameter("name");
			Class.forName(JDBC_DRIVER);
			//STEP 3: Open a connection
				 System.out.println("Connecting to database...");
				 conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
				 //STEP 4: Execute a query
				 System.out.println("Creating statement...");
				 stmt = (Statement) conn.createStatement();
				 String sql;
				 sql = "SELECT * FROM student WHERE name = '" + previous + "'";
				 
				 ResultSet rs = (ResultSet) stmt.executeQuery(sql);
				 System.out.println("Executed");
				 //STEP 5: Extract data from result set
				 rs.next();
				 //Retrieve by column name
				 name = rs.getString("name");
				 email = rs.getString("email");
				 location = rs.getString("location");
				 gender = rs.getString("gender");
				 experience = rs.getString("experience");
				 
				 //return the query results to client
					 
				 
				 response.setContentType("text / html");
				final PrintWriter out = response.getWriter();
				
				String docType = "<!DOCTYPE html public \"-//w3c//dtd thml 4.0 transitional//en\">\n";
				out.println(docType + 
				"<html>\n"+
				"<head><title>User registration</title></head>\n"+
				"<body>\n"+
				"<h1 align=\"center\"><img src='http://18.220.181.111/MyPic/Thanksgiving.gif'>Hello " + name +", the following is your profile info:</h1>"+
				"<ul>\n"+
				"\t<li><b>Your name</b>: " + name + "\n"+
				"\t<li><b>Your email</b>: " + email + "\n"+
				"\t<li><b>Your location</b>: " + location + "\n"+
				"\t<li><b>Your gender</b>: " + gender + "\n"+
				"\t<li><b>Your experience</b>: " + experience + "\n"+
				"</ul>\n"+
				"</body></html>");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				response.setContentType("text / html");
				final PrintWriter out = response.getWriter();
				
				String docType = "<!DOCTYPE html public \"-//w3c//dtd thml 4.0 transitional//en\">\n";
				out.println(docType + 
				"<html>\n"+
				"<head><title>No Data Found</title></head>\n"+
				"</html>");
				e.printStackTrace();
		}
				 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
