package Filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import util.DBConnection;

//@WebFilter(filterName = "jdbcFilter", urlPatterns = { "/*" })
public class JDBCFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		//only create connection for reuest for certant path
		if(this.needJDBC(req)) {
			Connection conn = null;
			try {
				conn = DBConnection.getInstance().getConnection();
				//get manual control instead of auto
				conn.setAutoCommit(false);
				//store the connection
				request.setAttribute("ATTRIBUTE_FOR_CONNECTION", conn);
				//allow the request to move to next chain
				chain.doFilter(request, response);
				//complete
				conn.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				throw new ServletException();
			}
			finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}//for other request just move to next chain without creating connection
		else {
			chain.doFilter(request, response);
		}

	}

	public JDBCFilter() {
	}

	@Override
	public void init(FilterConfig fConfig) throws ServletException {

	}

	@Override
	public void destroy() {

	}
	//check if the request needs connection to db
	private boolean needJDBC(HttpServletRequest request) {
		//get the servlet path from the request
		String servletPath = request.getServletPath();
		//get information about the path
		String pathInfo = request.getPathInfo();
		//create variable for the path's pattern
		String urlPattern = servletPath;
		if(pathInfo != null) {
			urlPattern = servletPath + "/*";
		}
		//? is the value since the value type has not been given an instance of
		Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext().getServletRegistrations();
		
		//collection of the servlet in the project
		Collection<? extends ServletRegistration> values = servletRegistrations.values();
		for(ServletRegistration sr : values) {
			Collection<String> mapping = sr.getMappings();
			if(mapping.contains(urlPattern))
				return true;
		}
		return false;
	}
	
	
}
