package util;

public class SQLCommand {
	public static final String INSERT = "INSERT INTO UserInfo(userName, userEmail, userPhone, userAddress, userDoB)"
			+ "VALUES (?,?,?,?,?)";
	public static final String DELETE = "DELETE FROM UserInfo WHERE userId = ?";
	public static final String UPDATE = "UPDATE UserInfo Set userName=?, userEmail=?, userPhone=?, userAddress=?, userDoB=? WHERE userId = ?";
	public static final String SELECT = "SELECT * FROM UserInfo";
	public static final String FIND = "SELECT * FROM UserInfo WHERE userId = ?";
	public static final String LOGIN = "SELECT * FROM AdminLogIn WHERE loginName = ? && adminPassword = ?";
	public static final String FIND_ADMIN = "SELECT * FROM UserInfo WHERE loginName = ?";
}
