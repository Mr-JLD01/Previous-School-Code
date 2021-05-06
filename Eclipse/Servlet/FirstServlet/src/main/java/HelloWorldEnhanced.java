

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloWorldEnhanced
 */
@WebServlet("/HelloWorldEnhanced")
public class HelloWorldEnhanced extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloWorldEnhanced() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String location = request.getParameter("loc");
		String gender = request.getParameter("gender");
		String experience = request.getParameter("exp");
		
		final PrintWriter out = response.getWriter();
		
		String docType = "<!doctype html public \"-//w3c//dtd thml 4.0 transitional//en\">\n";
		out.println(docType + 
		"<html>\n"+
		"<head><title>User registration</title></head>\n"+
		"<body>\n"+
		"<h1 align=\"center\">Welcome " + name +"</h1>"+
		"<ul>\n"+
		"\t<li><b>Your name</b>: " + name + "\n"+
		"\t<li><b>Your email</b>: " + email + "\n"+
		"\t<li><b>Your location</b>: " + location + "\n"+
		"\t<li><b>Your gender</b>: " + gender + "\n"+
		"\t<li><b>Your experience</b>: " + experience + "\n"+
		"</ul>\n"+
		"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
