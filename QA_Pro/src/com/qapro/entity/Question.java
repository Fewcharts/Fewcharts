package com.qapro.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Question implements Serializable {

	private String domanda;
	private Long id;
	private String text;
	private Date insertDate;
	private Boolean active;
	private Long askerId;
	private Long upVote;
	private Long downVote;

	private List<Answer> answers = new ArrayList<Answer>();
	
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
	public Long getAskerId() {
		return askerId;
	}
	public void setAskerId(Long askerId) {
		this.askerId = askerId;
	}
	public Long getUpVote() {
		return upVote;
	}
	public void setUpVote(Long upVote) {
		this.upVote = upVote;
	}
	public Long getDownVote() {
		return downVote;
	}
	public void setDownVote(Long downVote) {
		this.downVote = downVote;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	}
