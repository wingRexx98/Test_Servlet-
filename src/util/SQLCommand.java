package util;

public class SQLCommand {
	public static final String INSERT = "INSERT INTO UserInfo(userName, userEmail, userPhone, userAddress, userDoB)"
			+ "VALUES (?,?,?,?,?)";
	public static final String DELETE = "DELETE FROM UserInfo WHERE userId = ?";
	public static final String UPDATE = "UPDATE UserInfo Set userName=?, userEmail=?, userPhone=?, userAddress=?, userDoB=? WHERE userId = ?";
	public static final String SELECT = "SELECT * FROM UserInfo";
}
