package Filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.UserActionDAO;
import DAO.UserActionDAOImpl;
import Entity.Admin;

//If the user had already login recently then the login is automatic
@WebFilter(filterName = "cookieFilter", urlPatterns = { "/*" })
public class CookiesFilter implements Filter {
	public CookiesFilter() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		// get the curent sesion
		HttpSession session = req.getSession();
		UserActionDAO actionDAO = new UserActionDAOImpl();
		Admin loginAdmin = getLoginedUser(session);
		//if the session has the user info the move to next chain
		if(loginAdmin != null) {
			//set attribute(attribute name, value)
			session.setAttribute("Cookie_check", "checked");
			chain.doFilter(request, response);
			return;
		}
		try {
			//flag to check the cookie
			String checked = (String) session.getAttribute("Cookie_check");
			if(checked == null) {
				String adminName = getUserNameInCookie(req);
				//store the current login user
				Admin admin = actionDAO.findAdmin(adminName);
				storeLoginedUser(session, admin);
			}
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chain.doFilter(request, response);
	}

	public void storeLoginedUser(HttpSession session, Admin loginedAdmin) {
		// Save the recent login in the cookie
		session.setAttribute("loginedUser", loginedAdmin);
	}

	// get the user info and put it into the session
	public Admin getLoginedUser(HttpSession session) {
		Admin loginedUser = (Admin) session.getAttribute("loginedAdmin");
		return loginedUser;
	}

	// Save the recent cookie
	public void storeUserCookie(HttpServletResponse response, Admin user) {
		System.out.println("Store user cookie");
		Cookie cookieUserName = new Cookie("ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE", user.getUserName());
		// 1 day change into seconds
		cookieUserName.setMaxAge(24 * 60 * 60);
		response.addCookie(cookieUserName);
	}

	// get the user's name from the cookie
	public String getUserNameInCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE".equals(cookie.getName())) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	// Delete the cookie with the user info 
	public void deleteUserCookie(HttpServletResponse response) {
		Cookie cookieUserName = new Cookie("ATTRIBUTE_FOR_STORE_USER_NAME_IN_COOKIE", null);
		// make sure that thí cookie is used imidiately 
		cookieUserName.setMaxAge(0);
		response.addCookie(cookieUserName);
	}

}
