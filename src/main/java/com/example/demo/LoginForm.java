package com.example.demo;

import jakarta.validation.constraints.NotEmpty;

public class LoginForm {

	@NotEmpty(message="メールアドレスを入力してください。")
	private String email;
	@NotEmpty(message="パスワードを入力してください。")
	private String password;
	
	public LoginForm() {}
	
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
}
