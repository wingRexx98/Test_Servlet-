package main;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserActionDAO;
import DAO.UserActionDAOImpl;
import Entity.UserInfo;

/**
 * Servlet implementation class ShowAllServlet
 */
@WebServlet("/ShowAllServlet")
public class ShowAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserActionDAO userActionDAO = new UserActionDAOImpl();
		String error = null;
		List<UserInfo> listOfUsers = new ArrayList<>();
		try {
			listOfUsers = userActionDAO.allUserInfo();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			error = e.getMessage();
		}
		request.setAttribute("Error", error);
		request.setAttribute("UserList", listOfUsers);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
