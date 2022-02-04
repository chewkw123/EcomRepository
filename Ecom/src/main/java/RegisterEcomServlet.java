
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.util.*;

/**
 * Servlet implementation class RegisterEcomServlet
 */
@WebServlet("/RegisterEcomServlet")
public class RegisterEcomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterEcomServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String n = request.getParameter("username");
		String p = request.getParameter("password");
		String e = request.getParameter("email");
		String m = request.getParameter("mobile number");
		String g = request.getParameter("gender");

		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userdetails", "root",
					"password123");

			// Step 4: implement the sql query using prepared statement

			PreparedStatement ps = con.prepareStatement("insert into USERDETAILS values(?,?,?,?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			ps.setString(1, n);
			ps.setString(2, p);
			ps.setString(3, e);
			ps.setString(4, m);
			ps.setString(5, g);
			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();

			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,
			if (i > 0) {
				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully registered an account!" + "</h1>");
				writer.close();
			}

//			Button b = new Button("push me");
//			b.addActionListener((ActionListener) new ActionListener() {
//
//			    public void actionPerformed1(ActionEvent e) {
//			        //your actions
//			    }
//
//				@Override
//				public void actionPerformed(ActionEvent e) {
//					// TODO Auto-generated method stub
//					
//				}
//			});
			
			
		
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}

		doGet(request, response);
	}
	
	

}
