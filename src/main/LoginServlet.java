package main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserActionDAO;
import DAO.UserActionDAOImpl;
import Entity.Admin;

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
		Admin admin = new Admin();
		UserActionDAO actionDAO = new UserActionDAOImpl();
		String errorMessage = null;
		try {

			String userInputName = request.getParameter("userName");
			String inputPassword = request.getParameter("password");

			admin = actionDAO.loginAdmin(userInputName, inputPassword);
			if(admin != null)
			{
				HttpSession session = request.getSession(true);
				//set the attribute to the session 
				session.setAttribute("CurrentUser", admin.getAdminName());
				response.sendRedirect("Home.jsp");
			}
			else {
//				response.sendRedirect("InvalidLogin.jsp");
				errorMessage = "Incorrect username or password";
				request.setAttribute("errorString", errorMessage);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/LoginPage.jsp");

				dispatcher.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			errorMessage = "The exception: " + e.getMessage();
			request.setAttribute("errorString", errorMessage);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/LoginPage.jsp");

			dispatcher.forward(request, response);
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
