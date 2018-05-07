package model.bean;

public class User {
	int idUser;
	String username;
	String password;
	String fullName;
	int role;
	
	public User() {
		super();
	}

	public User(int idUser, String username, String password, String fullName, int role) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.role = role;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + ", fullName=" + fullName
				+ ", role=" + role + "]";
	}

	
		
}
