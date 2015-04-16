package com.qapro.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GlobalData implements Serializable {

	private List<Question> questions = new ArrayList<Question>();
	
	
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	
}
	
}
