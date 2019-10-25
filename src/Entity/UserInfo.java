package Entity;

public class UserInfo {
	private int userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	private String userDoB;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserDoB() {
		return userDoB;
	}

	public void setUserDoB(String userDoB) {
		this.userDoB = userDoB;
	}

	public UserInfo(int userId, String userName, String userEmail, String userPhone, String userAddress,
			String userDoB) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userDoB = userDoB;
	}

	public UserInfo(String userName, String userEmail, String userPhone, String userAddress, String userDoB) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userDoB = userDoB;
	}

	public UserInfo() {
	}

}
