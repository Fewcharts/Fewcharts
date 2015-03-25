package com.qapro.entity;

import java.io.Serializable;
import java.util.Date;

public class Answer implements Serializable{
	
	private Long id;
	private String text;
	private Date insertDate;
	private Boolean active;
	private Long responderId;
	private Long questionId;
	private Long upVote;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public Long getResponderId() {
		return responderId;
	}
	public void setResponderId(Long responderId) {
		this.responderId = responderId;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	public Long getUpVote() {
		return upVote;
	}
	public void setUpVote(Long upVote) {
		this.upVote = upVote;
	}
	
	
}
