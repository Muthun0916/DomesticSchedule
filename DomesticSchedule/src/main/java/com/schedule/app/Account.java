package com.schedule.app;

public class Account {
	private String id;
	private String password;
	private String username;
	private boolean isAuthorized;

	public Account() {
		this.isAuthorized = false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void isValid() {

		if (this.username == null || this.username.isBlank()) {
			this.isAuthorized = false;
			return;
		}

		if (this.id == null || this.id.isBlank()) {
			this.isAuthorized = false;
			return;
		}

		if (this.password == null || this.password.isBlank()) {
			this.isAuthorized = false;
			return;
		}

		this.isAuthorized = true;
		return;
	}

	public boolean isAuthorized() {
		return this.isAuthorized;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", password=" + password + ", username=" + username + ", isAuthorized="
				+ isAuthorized + "]";
	}

}
