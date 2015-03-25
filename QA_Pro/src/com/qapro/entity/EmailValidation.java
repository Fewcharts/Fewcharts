package com.qapro.entity;

import java.util.Date;

public class EmailValidation {

	private Long validationId;
	private String validationCode;
	private String email;
	private Long userId;
	private Boolean validated;
	private Date insertDate;
	private Date validationDate;
	
	
	
	
	public Long getValidationId() {
		return validationId;
	}
	public void setValidationId(Long validationId) {
		this.validationId = validationId;
	}
	public String getValidationCode() {
		return validationCode;
	}
	public void setValidationCode(String validationCode) {
		this.validationCode = validationCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Boolean getValidated() {
		return validated;
	}
	public void setValidated(Boolean validated) {
		this.validated = validated;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Date getValidationDate() {
		return validationDate;
	}
	public void setValidationDate(Date validationDate) {
		this.validationDate = validationDate;
	}
	
	
	
}
