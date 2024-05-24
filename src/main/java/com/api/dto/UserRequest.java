package com.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class UserRequest {

	@NotNull(message = "user name should not be null")
	private String name;
	@Email(message = "Invalid email address")
	private String email;
    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile no entered")
	private String mobile;
	private String gender;
	@Min(18)
	@Max(30)
	private String age;
	@NotBlank
	private String nationality ;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public UserRequest(String name, String email, String mobile, String gender, String age, String nationality) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.gender = gender;
		this.age = age;
		this.nationality = nationality;
	}
	public UserRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "UserRequest [name=" + name + ", email=" + email + ", mobile=" + mobile + ", gender=" + gender + ", age="
				+ age + ", nationality=" + nationality + "]";
	}
	
	

}
