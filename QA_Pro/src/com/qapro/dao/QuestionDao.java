package com.qapro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.qapro.entity.EmailValidation;
import com.qapro.entity.MemberInfo;
import com.qapro.entity.Question;
import com.qapro.enums.VotingEnum;

public class QuestionDao extends JavathlonJdbcTemplate<Question>{
	
	private String insertQuestionSql = "INSERT INTO heroku_f7be13520b27e62.question (text,insert_date,is_active,asker_id,up_vote,down_vote)"
							   +" VALUES (:text , :insert_date , :is_active , :asker_id , :up_vote , :down_vote )";
	
	private String selectQuestionSql = "select id,text,insert_date,is_active,asker_id,up_vote,down_vote from heroku_f7be13520b27e62.question ";
	
	private String selectTextSql = "select id, text from heroku_f7be13520b27e62.question";

	
	public Long insertQuestion(Question question) throws Exception{
		SqlParameterValues values = new SqlParameterValues();
		values.addValue("text", question.getText());
		values.addValue("insert_date", new Date());
		values.addValue("is_active", true);
		values.addValue("asker_id", question.getAskerId());
		values.addValue("up_vote", 0L);
		values.addValue("down_vote", 0L);
		
		return this.insertItem(insertQuestionSql, values);
	}
	
	public Question getQuestionById(Long id)
	{
		String sql = selectQuestionSql + " where id = :question_id";
		List<Question> questionList = this.getList(sql, new SqlParameterValues().addValue("question_id", id), new QuestionRowMapper());
		
		if(questionList != null && questionList.size() > 0)
			
			return questionList.get(0);
		else return null;
		
	}
	
	
	
	public List<Question> getQuestion()
	{
		String sql = selectQuestionSql ;
		List<Question> questionList = this.getList(sql, new SqlParameterValues(), new QuestionRowMapper());
		
		for (Question q :  questionList)
    	{
			System.out.println("1 - ");
    		System.out.println(q.getText());
    	}
		if(questionList != null && questionList.size() > 0)
			
			return questionList;
		else return null;
		
	}
	
	public List<Question> getQuestionByDate()
	{
		String sql = selectQuestionSql + " order by insert_date DESC" ;
		List<Question> questionList = this.getList(sql, new SqlParameterValues(), new QuestionRowMapper());
		
		for (Question q :  questionList)
    	{
			System.out.println("1 - ");
    		System.out.println(q.getText());
    	}
		if(questionList != null && questionList.size() > 0)
			
			return questionList;
		else return null;
		
	}
	
	public List<Question> getQuestionByAskerId(Long userId)
	{
		String sql = selectQuestionSql + " where asker_id = :asker_id";
		List<Question> questionList = this.getList(sql, new SqlParameterValues().addValue("asker_id", userId), new QuestionRowMapper());
		
		if(questionList != null && questionList.size() > 0)
			
			
			return questionList;
		else return null;
		
	}
	

	
	public void voteQuestion(Long questionId, VotingEnum type) throws Exception
	{
		String upVoteSql = "UPDATE question SET up_vote = up_vote +1 where id = :question_id";
		String downVoteSql = "UPDATE question SET down_vote = down_vote +1 where id = :question_id";
		
		if(VotingEnum.UP == type)
			this.update(upVoteSql, new SqlParameterValues().addValue("question_id", questionId));
		else if(VotingEnum.DOWN == type)
			this.update(downVoteSql, new SqlParameterValues().addValue("question_id", questionId));
		
		
	}
	
	public static void main(String args[]){
		
		try {
			QuestionDao questionDao = new QuestionDao();
			
			Question question = new Question();
			question.setText("What is the best resource for Java training?");
			question.setAskerId(3L);			
			questionDao.insertQuestion(question);
			
//			Question question2 = questionDao.getQuestionById(4L);
//			if(question2 != null)
//				System.out.println("question is: " + question2.getText());
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	private class QuestionRowMapper  implements SqlRowMapper<Question>{

		public Question mapSqlToObject(ResultSet resultSet) throws SQLException {
			
			Question question = new Question();
			question.setId(resultSet.getLong(1));
			question.setText(resultSet.getString(2));
			question.setInsertDate(resultSet.getDate(3));			
			question.setActive(resultSet.getBoolean(4));
			question.setAskerId(resultSet.getLong(5));
			question.setUpVote(resultSet.getLong(6));
			question.setDownVote(resultSet.getLong(7));
		
			return question;
		}
		
	}
	
}