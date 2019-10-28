package DAO;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import Entity.Admin;
import Entity.UserInfo;

public interface UserActionDAO {
	public boolean addNewUser(UserInfo user) throws SQLException, ParseException;

	public boolean updateUser(UserInfo user) throws SQLException, ParseException;

	public boolean deleteUser(int userId) throws SQLException;

	public List<UserInfo> allUserInfo() throws SQLException;
	
	public UserInfo findUser(int userId) throws SQLException;
	
	public Admin loginAdmin(String userName, String password) throws SQLException;
}
