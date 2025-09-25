package model;

import java.io.Serializable;

public class UserAccount implements Serializable {
	private int userId;
	private String name;
	private String password;

	public UserAccount() {
	}

	public UserAccount(int userId, String name, String passward) {
		this.userId = userId;
		this.name = name;
		this.password = passward;
	}

	public UserAccount(int userId, String name) {
		super();
		this.userId = userId;
		this.name = name;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassward() {
		return password;
	}

	public void setPassward(String passward) {
		this.password = passward;
	}

}
