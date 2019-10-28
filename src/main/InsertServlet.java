package main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserActionDAO;
import DAO.UserActionDAOImpl;
import Entity.UserInfo;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserInfo user = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user = getUserFromInput(request);
		UserActionDAO userActionDAO = new UserActionDAOImpl();
		try {
			userActionDAO.addNewUser(user);
			response.sendRedirect("ShowAllServlet");
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			e.getCause();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	public UserInfo getUserFromInput(HttpServletRequest request) throws ServletException {
		UserInfo user = new UserInfo();
		user.setUserName(request.getParameter("name"));
		user.setUserEmail(request.getParameter("email"));
		user.setUserAddress(request.getParameter("address"));
		user.setUserPhone(request.getParameter("phone"));
		user.setUserDoB(request.getParameter("date"));
		return user;
	}

}
