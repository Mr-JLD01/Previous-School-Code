import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class UserRegistrationServlet
 */
@WebServlet("/UserRegistrationServlet")
@MultipartConfig
public class UserRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
		final PrintWriter out = response.getWriter();
	        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String location = request.getParameter("location");
        String gender = request.getParameter("gender");
        String experience = request.getParameter("experience");
        String fileName = request.getParameter("fileName");
        
        /*	
         * request.getPart is to get the uploaded file handler. 
         * You can use filePart.getInputStream() to read the streaming data from client, for example:
         * InputStream filecontent = filePart.getInputStream();
        */
	    Part filePart = request.getPart("file");
	    InputStream filecontent = filePart.getInputStream();
	    
	    /*
	     * fileout is for you to save the uploaded picture in your local disk. 
	     * */
	    OutputStream fileout = null;
	    
	    String docType = "<!doctype html public \"-//w3c//dtd thml 4.0 transitional//en\">\n";	    
	    /*
	     * Write your code here
	     * Step 1: check whether the client's inputs are complete or not; if anything is missing, return a web page that contains a link to go back to the registration page (e.g., UserRegistration.html)
	     * Step 2: save the uploaded picture under your project WebContent directory, for example, mine is "F:\workspace\UserRegistrationProject\WebContent". 
	     * Step 3: send back the client's registration information to the client, remember, the client should be able to see all the information, including the profile picture. 
	     * */
	    //Step 1
	    if(name.equals("") || email.equals("") || location.equals("") || gender.equals("") || experience.equals("") || fileName.equals("") || filePart.getSize() == 0){
	    	out.println(docType + 
					"<html>\n"+
					"<body>Your input information is not complete, try again <a href= \"UserRegistration.html\">go back</a>.</body></html>");
	    }

	    else {
		    //Step 2
	    	fileout = new FileOutputStream("C:\\Programming assignments\\Servlet\\UserRegistrationProject\\src\\main\\webapp\\images\\" + fileName);
	    	int nRead = 0;
		    byte[] buffer = new byte[40000];
		    while((nRead = filecontent.read(buffer)) != -1){
                fileout.write(buffer);
                fileout.flush();
            }
		    fileout.close();
		    //Step 3
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
			"\t<li><b>Your profile picture " + fileName + " has been uploaded successfully:</b></br><img src='images\\" + fileName + "'>" + "\n"+
			"</ul>\n"+
			"</body></html>");
		    
		    for(int i = 0; i < 100000; i++){;}
		    
	    }
	    
	    filecontent.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}