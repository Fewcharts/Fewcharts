package com.qapro.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemberInfo {

	long userId;
	
	private Date registrationTime;	
	
	private String userName;
	
	private String password;
	
	private String name;
	
	private String surname;
	
	private String email;
	
	private String memberRole;
	
	private ArrayList<String> privileges;
	
	private List<Question> questions = new ArrayList<Question>();

	public Date getRegistrationTime() {
		return registrationTime;
	}

	public void setRegistrationTime(Date registrationTime) {
		this.registrationTime = registrationTime;
	}

	public ArrayList<String> getPrivileges() {
		return privileges;
	}

	public void setPrivileges(ArrayList<String> privileges) {
		this.privileges = privileges;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getMemberRole() {
		return memberRole;
	}

	public void setMemberRole(String memberRole) {
		this.memberRole = memberRole;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
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
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	
	
	
	
}
