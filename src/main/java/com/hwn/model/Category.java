package com.hwn.model;

public class Category {
	
	private int id;
	private String categoryType;
	private String description;
	
	Category(){}

	public Category(int id, String categoryType,String description) {
		super();
		this.id = id;
		this.categoryType = categoryType;
		this.description = description;
	}

	public Category(String categoryType, String description) {
		super();
		this.categoryType = categoryType;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategory_type(String categoryType) {
		this.categoryType = categoryType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
