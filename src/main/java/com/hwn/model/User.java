package com.hwn.model;

public class User {
	
	private Integer id;
	private String username;
	private String email;
	private String password;
	private String createDate;
	private String role;
	private String phNo;
	
	
	public User() {}


	public User(String username, String email, String password, String createDate, String role, String phNo) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.role = role;
		this.phNo = phNo;
	}






	public User(Integer id, String username, String email, String password, String createDate, String role,
			String phNo) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.createDate = createDate;
		this.role = role;
		this.phNo = phNo;
	}






	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public String getPhNo() {
		return phNo;
	}


	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	
	
	
	

}
