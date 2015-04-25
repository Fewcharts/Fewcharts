package com.qapro.service;

import java.util.ArrayList;
import java.util.List;

import com.qapro.dao.AnswerDao;
import com.qapro.dao.QuestionDao;
import com.qapro.entity.Answer;
import com.qapro.entity.GlobalData;
import com.qapro.entity.Question;

public class QuestionService {

	QuestionDao questionDao = new QuestionDao();
	AnswerDao answerDao = new AnswerDao();
	
	public Question getQuestionAndAnswers(Long questionId){
		
		Question question = questionDao.getQuestionById(questionId);
		
		if(question != null){
			List<Answer> answerList = answerDao.getAnswersToQuestion(questionId);
			
			question.setAnswers(answerList);
		}
		
		return question;
	}
	
    public List<Question> getAllQuestions(Long userId){
		
    	List<Question> questions = questionDao.getQuestionByAskerId(userId);
    	
    	for (Question q : questions){
    		System.out.println(q.getText());
    	}
    	
		return questions;
	}
    
    
public GlobalData getTextQuestions(){
		
    	GlobalData questions = new GlobalData();
    	
    	questions.setQuestions(questionDao.getQuestion());
    	
    	for (Question q :  questions.getQuestions())
    	{
    		System.out.println("2 - ");
    		System.out.println(q.getText());
    	}
    	
		return questions;
	}

public Question getTextQuestionById2(Long questionId){
	
	
	Question question = questionDao.getQuestionById(questionId);
	
	return question;
}


public GlobalData getTextQuestionsByDate(){
	
	GlobalData questions = new GlobalData();
	
	questions.setQuestions(questionDao.getQuestionByDate());
	
	for (Question q :  questions.getQuestions())
	{
		System.out.println("2 - ");
		System.out.println(q.getText());
	}
	
	return questions;
}

	public static void main(String args[]){
		QuestionService service = new QuestionService();
		
		Question question = service.getQuestionAndAnswers(1L);
		
		System.out.println(question);
	}
	
}
