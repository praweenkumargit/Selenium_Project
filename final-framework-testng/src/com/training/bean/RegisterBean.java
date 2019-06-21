package com.training.bean;

public class RegisterBean {
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	private String address1;
	private String telePhone;
	private String confirmPassword;
	private String city;

	public RegisterBean() {
	}

	public RegisterBean(String firstName, String lastName, String email, String telePhone, String address1, String  city, String password, String confirmPassword) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.telePhone = telePhone;
		this.address1 = address1;
		this.city = city;
		this.password = password;
		this.confirmPassword = confirmPassword;
	}

	public String getfirstName() {
		return firstName;
	}

	public void setfirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String gettelePhone() {
		return telePhone;
	}

	public void settelePhone(String telePhone) {
		this.telePhone = telePhone;
	}
	
	public String getaddress1() {
		return address1;
	}

	public void setaddress1(String address1) {
		this.address1 = address1;
	}
	
	public String getcity() {
		return city;
	}

	public void setcity(String city) {
		this.city = city;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getconfirmPassword() {
		return confirmPassword;
	}

	public void setconfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String toString() {
		return "RegisterBean [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", telePhone=" + telePhone + ", address1=" + address1 + ", city= " + city + ",password=" + password + ", confirmPassword= " + confirmPassword + "]";
	}

}


