package com.jbk.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "user")
public class User {

	@Id
	@Column(name = "username", nullable = false, unique = true)
	@NotBlank
	private String username;
	  @Pattern(
		        regexp = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#$%^&+=]).*$", 
		        message = "Password must contain at least one digit, one letter, and one special character"
		    )
	@Column(name = "password", nullable = false)
	private String password;

	  @NotEmpty(message = "Invalid Question")
	@Column(name = "question", nullable = false)
	private String question;
	
	  @NotEmpty(message = "Invalid Answer")
	@Column(name = "answer", nullable = false)
	private String answer;

	  @NotEmpty(message = "Invalid Role")
	@Column(name = "role", nullable = false)
	private String role;

	public User() {
	}

	public User(String username, String password, String question, String answer, String role) {
		super();
		this.username = username;
		this.password = password;
		this.question = question;
		this.answer = answer;
		this.role = role;
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", question=" + question + ", answer=" + answer
				+ ", role=" + role + "]";
	}

}
