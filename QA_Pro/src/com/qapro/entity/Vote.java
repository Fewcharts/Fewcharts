package com.qapro.entity;

import java.util.Date;

import com.qapro.enums.VotingEnum;

public class Vote {

	private Long id;
	private Long questionId;
	
	private Long userId;
	private Date date;
	private Boolean isCancelled;
	private Long answerId;
	private VotingEnum type;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(Long answerId) {
		this.answerId = answerId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Boolean getIsCancelled() {
		return isCancelled;
	}
	public void setIsCancelled(Boolean isCancelled) {
		this.isCancelled = isCancelled;
	}
	public VotingEnum getType() {
		return type;
	}
	public void setType(VotingEnum type) {
		this.type = type;
	}
	
	
	
}
