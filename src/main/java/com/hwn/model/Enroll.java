package com.hwn.model;

public class Enroll {
	
	private Integer id;
	private String courseName;
	private String studentName;
	private String email;
	private String enrollDate;
	
	 public Enroll() {}

	public Enroll(Integer id, String courseName, String studentName, String email, String enrollDate) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.studentName = studentName;
		this.email = email;
		this.enrollDate = enrollDate;
	}

	public Enroll(String courseName, String studentName, String email, String enrollDate) {
		super();
		this.courseName = courseName;
		this.studentName = studentName;
		this.email = email;
		this.enrollDate = enrollDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	 
	 
	
	

}
