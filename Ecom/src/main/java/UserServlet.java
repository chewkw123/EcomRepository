
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")

public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/userdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "password123";

	private static final String INSERT_USERS_SQL = "INSERT INTO UserDetails"
			+ " (username, password, email, mobilenumber, gender) VALUES " + " (?, ?, ?, ?);";
	private static final String SELECT_USER_BY_ID = "select username,password,email,mobilenumber, gender from UserDetails where username =?";
	private static final String SELECT_ALL_USERS = "select * from UserDetails ";
	private static final String DELETE_USERS_SQL = "delete from UserDetails where username = ?;";
	private static final String UPDATE_USERS_SQL = "update UserDetails set username = ?,password= ?,email =?,mobilenumber =?, gender =? where username = ?;";

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	private void listUsers(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<User> users = new ArrayList<>();
		try (Connection connection = getConnection();

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String username = rs.getString("username");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String mobilenumber = rs.getString("mobilenumber");
				String gender = rs.getString("gender");
				users.add(new User(username, password, email, mobilenumber, gender));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		request.setAttribute("listUsers", users);
		request.getRequestDispatcher("/userManagement.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
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

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/insert":
				break;
			case "/delete":
				break;
			case "/edit":
				break;
			case "/update":
				break;
			default:
				listUsers(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
