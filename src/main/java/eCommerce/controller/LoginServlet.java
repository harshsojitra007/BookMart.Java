package eCommerce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	String email = request.getParameter("email"), password = request.getParameter("password");
    	
    	try {
			
			String dbURL = "jdbc:mysql://localhost:3306/test";
			Connection myConnection = DriverManager.getConnection(dbURL, "root", "");
			
			PreparedStatement myPreparedStatement = myConnection.prepareStatement("SELECT * FROM USERDETAILS WHERE CUSTOMEREMAIL = ?");
			myPreparedStatement.setString(1, email);
			
			ResultSet result = myPreparedStatement.executeQuery();
			if(result.next()) {
				
				String orgPassword = result.getString(6), userName = result.getString(5);
				
				System.out.println(orgPassword + userName);
				
				HttpSession session = request.getSession();
				session.setAttribute("isAdmin", false);
				
				if(orgPassword.equals(password)) {
					
					session.setAttribute("username", userName);
					session.setAttribute("loggedIn", true);
					
					if(email.equals("admin@adminsite.com"))
						session.setAttribute("isAdmin", true);
					
					myPreparedStatement.close();
					myConnection.close();
					
					response.sendRedirect(request.getContextPath() + "/home");
					
				}else {
					
					session.setAttribute("userName", session.getId());
					session.setAttribute("loggedIn", false);
					
					myPreparedStatement.close();
					myConnection.close();
					
					response.sendRedirect(request.getContextPath() + "/login");
				}
			}
			myPreparedStatement.close();
			myConnection.close();
						
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			
		}
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
