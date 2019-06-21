package com.training.bean;

public class AddCategoriesBean {
	private String userName;
	private String password;
	private String categoryName;
	private String description;
	private String metaTagDescription;
	private String metaTagTitle;

	public AddCategoriesBean() {
	}

	public AddCategoriesBean(String categoryName, String description, String metaTagTitle, String metaTagDescription) {
		super();
		this.categoryName = categoryName;
		this.description = description;
		this.metaTagTitle = metaTagTitle;
		this.metaTagDescription = metaTagDescription;
	}

	public String getcategoryName() {
		return categoryName;
	}

	public void setcategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}
	
	public String getmetaTagTitle() {
		return metaTagTitle;
	}

	public void setmetaTagTitle(String metaTagTitle) {
		this.metaTagTitle = metaTagTitle;
	}
	
	public String getmetaTagDescription() {
		return metaTagDescription;
	}

	public void setmetaTagDescription(String metaTagDescription) {
		this.metaTagDescription = metaTagDescription;
	}

	
	@Override
	public String toString() {
		return "AddCategoriesBean [categoryName=" + categoryName + ", description=" + description + ", metaTagTitle=" + metaTagTitle + ", metaTagDescription=" + metaTagDescription + "]";
	}
}
