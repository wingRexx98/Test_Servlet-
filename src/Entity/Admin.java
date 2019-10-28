package Entity;

public class Admin {
	private String adminName;
	private String userName;
	private String password;

	public Admin(String adminName, String userName, String password) {
		super();
		this.adminName = adminName;
		this.userName = userName;
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Admin() {
		super();
	}

}
