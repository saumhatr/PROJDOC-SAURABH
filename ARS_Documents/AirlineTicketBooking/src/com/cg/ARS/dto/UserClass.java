package com.cg.ARS.dto;

public class UserClass {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String role;
	private String mobile_no;
	
	public UserClass() {
	
	}

	public UserClass(String firstName, String lastName, String username,
			String password, String role, String mobile_no) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = role;
		this.mobile_no = mobile_no;
	}

	public UserClass(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}

	@Override
	public String toString() {
		return "UserClass [firstName=" + firstName + ", lastName=" + lastName
				+ ", username=" + username + ", password=" + password
				+ ", role=" + role + ", mobile_no=" + mobile_no + "]";
	}

	
}
