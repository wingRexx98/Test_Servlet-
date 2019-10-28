package main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserActionDAO;
import DAO.UserActionDAOImpl;
import Entity.UserInfo;

/**
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfo user = null;
	private static int userId = 0;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		userId = Integer.parseInt(request.getParameter("userId"));
		UserActionDAO userActionDAO = new UserActionDAOImpl();
		String error = null;
		List<UserInfo> listOfUsers = null;
		try {
			listOfUsers = userActionDAO.findUser(userId);
			request.setAttribute("UpdateServlet", listOfUsers);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/Update.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	// DoPost called since the form method is POST
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserActionDAO userActionDAO = new UserActionDAOImpl();
		try {
			user = getUserFromInput(request, userId);
			userActionDAO.updateUser(user);
			response.sendRedirect("ShowAllServlet");
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public UserInfo getUserFromInput(HttpServletRequest request, int userId) throws ServletException {
		UserInfo user = new UserInfo();
		user.setUserId(userId);
		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhone(request.getParameter("phone"));
		user.setUserDoB(request.getParameter("date"));
		return user;
	}

}
