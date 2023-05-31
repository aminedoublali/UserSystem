package com.example.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class CreateForm {

	@NotEmpty(message="名前を入力してください")
	private String name;
	
	@Email
	@NotEmpty(message="住所を入力してください")
	private String email;
	
	@NotEmpty(message="パスワードを入力してください")
	private String password;
	
	@NotEmpty(message="住所を入力してください")
	private String address;
	
	public CreateForm() {}
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
