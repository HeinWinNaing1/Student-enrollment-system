package com.hwn.model;

public class Course {
	
	private  int id;
	private  String courseName;
	private  String instructorName;
	private  double price;
	private  String category;
	private  String description;
	private  String startDate;
	private  String period;
	
	
	public Course() {}
	
	public Course(int id, String courseName, String instructorName, double price, String category,
			String description, String startDate, String period) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.instructorName = instructorName;
		this.price = price;
		this.category = category;
		this.description = description;
		this.startDate = startDate;
		this.period = period;
	}
	
	public Course(String courseName, String instructorName, double price, String category, String description,
			String startDate, String period) {
		super();
		this.courseName = courseName;
		this.instructorName = instructorName;
		this.price = price;
		this.category = category;
		this.description = description;
		this.startDate = startDate;
		this.period = period;
	}



	public int getId() {
		return id;
	}



	public String getCourseName() {
		return courseName;
	}



	public String getInstructorName() {
		return instructorName;
	}



	public double getPrice() {
		return price;
	}



	public String getCategory() {
		return category;
	}



	public String getDescription() {
		return description;
	}



	public String getStartDate() {
		return startDate;
	}



	public String getPeriod() {
		return period;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", courseName=" + courseName + ", instructorName=" + instructorName + ", price="
				+ price + ", category=" + category + ", description=" + description + ", startDate=" + startDate
				+ ", period=" + period + "]";
	}
	
	
	
	
	
	

}
