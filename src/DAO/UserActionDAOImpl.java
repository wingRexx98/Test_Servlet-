package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.sql.PreparedStatement;

import Entity.UserInfo;
import util.DBConnection;
import util.SQLCommand;

public class UserActionDAOImpl implements UserActionDAO {
	private Connection conn = null;
	private PreparedStatement preStatement = null;
	private ResultSet resultSet = null;

	@Override
	public boolean addNewUser(UserInfo user) throws SQLException, ParseException {
		boolean check = false;
		try {
			conn = DBConnection.getInstance().getConnection();
			preStatement = conn.prepareStatement(SQLCommand.INSERT);
			preStatement.setString(1, user.getUserName());
			preStatement.setString(2, user.getUserEmail());
			preStatement.setString(3, user.getUserPhone());
			preStatement.setString(4, user.getUserAddress());
			preStatement.setDate(5, Date.valueOf(user.getUserDoB()));
			check = preStatement.execute();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	@Override
	public boolean updateUser(UserInfo user) throws SQLException, ParseException {
		boolean check = false;
		try {
			conn = DBConnection.getInstance().getConnection();
			preStatement = conn.prepareStatement(SQLCommand.UPDATE);
			preStatement.setString(1, user.getUserName());
			preStatement.setString(2, user.getUserEmail());
			preStatement.setString(3, user.getUserPhone());
			preStatement.setString(4, user.getUserAddress());
			preStatement.setDate(5, Date.valueOf(user.getUserDoB()));
			preStatement.setInt(6, user.getUserId());
			check = preStatement.execute();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	@Override
	public boolean deleteUser(int userId) throws SQLException {
		boolean check = false;
		try {
			conn = DBConnection.getInstance().getConnection();
			preStatement = conn.prepareStatement(SQLCommand.DELETE);
			preStatement.setInt(1, userId);
			check = preStatement.execute();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (preStatement != null) {
					preStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return check;
	}

	@Override
	public List<UserInfo> allUserInfo() throws SQLException {
		List<UserInfo> listOfUser = new ArrayList<UserInfo>();
		UserInfo user = null;
		conn = DBConnection.getInstance().getConnection();
		preStatement = conn.prepareStatement(SQLCommand.SELECT);
		resultSet = preStatement.executeQuery();
		while(resultSet.next()) {
			user = new UserInfo();
			user.setUserId(resultSet.getInt("userId"));
			user.setUserName(resultSet.getString("userName"));
			user.setUserEmail(resultSet.getString("userEmail"));
			user.setUserPhone(resultSet.getString("userPhone"));
			user.setUserAddress(resultSet.getString("userAddress"));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(resultSet.getDate("userDoB"));
			user.setUserDoB(date);
			listOfUser.add(user);
		}
		return listOfUser;
	}

	@Override
	public UserInfo findUser(int userId) throws SQLException {
		UserInfo user = new UserInfo();
		conn = DBConnection.getInstance().getConnection();
		preStatement = conn.prepareStatement(SQLCommand.FIND);
		preStatement.setInt(1, userId);
		resultSet = preStatement.executeQuery();
		while(resultSet.next()) {
			user = new UserInfo();
			user.setUserId(resultSet.getInt("userId"));
			user.setUserName(resultSet.getString("userName"));
			user.setUserEmail(resultSet.getString("userEmail"));
			user.setUserPhone(resultSet.getString("userPhone"));
			user.setUserAddress(resultSet.getString("userAddress"));
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String date = df.format(resultSet.getDate("userDoB"));
			user.setUserDoB(date);
		}
		return user;
	}

}
