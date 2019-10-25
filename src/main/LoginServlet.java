package main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String userName = "user1";
			String password = "123456";

			String userInputName = request.getParameter("userName");
			String inputPassword = request.getParameter("password");

			if (userInputName.equals(userName) && inputPassword.equals(password)) {
				HttpSession session = request.getSession(true);
				//set the attribute to the session 
				session.setAttribute("CurrentUser", userInputName);
				response.sendRedirect("LoggedIn.jsp");
			}
			else {
				response.sendRedirect("InvalidLogin.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("The exception: " + e.getMessage());
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
