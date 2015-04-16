package com.qapro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.qapro.entity.Answer;
import com.qapro.entity.EmailValidation;
import com.qapro.enums.VotingEnum;

public class AnswerDao extends JavathlonJdbcTemplate<Answer> {

	
	String insertAnswerSql = "INSERT INTO heroku_f7be13520b27e62.answer (text,insert_date,is_active,responder_id,question_id)"
							+"VALUES (:text ,	:insert_date , :is_active ,	:responder_id ,	:question_id )";
	
	String selectAnswerSql = "select id,text,insert_date,is_active,responder_id,question_id, UpVote  from heroku_f7be13520b27e62.answer ";
	
	String updateAnswerSql = "UPDATE heroku_f7be13520b27e62.answer	SET id = :id ,	text = :text ,	responder_id = :responder_id ,	question_id = :question_id	WHERE id = :answer_id";
		
	
	
	public void insertAnswer(Answer answer) throws Exception{
		SqlParameterValues values = new SqlParameterValues();
		values.addValue("text", answer.getText());
		values.addValue("insert_date", new Date());
		values.addValue("is_active", true);
		values.addValue("responder_id", answer.getResponderId());
		values.addValue("question_id", answer.getQuestionId());		
		
		this.insertItem(insertAnswerSql, values);
	}
	
	public List<Answer> getAnswersToQuestion(Long questionId){
		String sql = selectAnswerSql + " where question_id = :question_id"+ " order by UpVote DESC";
		
		return this.getList(sql, new SqlParameterValues().addValue("question_id", questionId), new AnswerRowMapper());
	}
	
	public Answer getAnswerById(Long id){
		String sql = selectAnswerSql + " where id = :id";
		
		List<Answer> answerList = this.getList(sql, new SqlParameterValues().addValue("id", id), new AnswerRowMapper());
		if(answerList != null && answerList.size() > 0){
			return answerList.get(0);
		}
		else return null;
	}
	
	public void voteAnswer(Long answerId, VotingEnum type) throws Exception
	{
		System.out.println (answerId);
		
		String upVoteSql = "UPDATE heroku_f7be13520b27e62.answer SET Upvote = Upvote +1 where id = :answer_id";
		
		String downVoteSql = "UPDATE heroku_f7be13520b27e62.question SET down_vote = down_vote +1 where id = :question_id";
		
		if(VotingEnum.UP == type)
			this.update(upVoteSql, new SqlParameterValues().addValue("answer_id", answerId));
		else if(VotingEnum.DOWN == type)
			this.update(downVoteSql, new SqlParameterValues().addValue("answer_id", answerId));
		
		
	}
	
	
	public static void main(String args[]){
		
		AnswerDao answerDao = new AnswerDao();
		
		
		try {
			/*Answer answer = new Answer();			
			answer.setText("Of course Javathlon");
			answer.setQuestionId(4L);
			answer.setResponderId(1L);
			answerDao.insertAnswer(answer);*/
			
			Answer answer2 = answerDao.getAnswerById(3L);
			if(answer2 != null)
				System.out.println(answer2.getText());
			else
				System.out.println("answer can not be found");
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private class AnswerRowMapper implements SqlRowMapper<Answer>{

		public Answer mapSqlToObject(ResultSet resultSet) throws SQLException {
			Answer answer = new Answer();
			answer.setId(resultSet.getLong(1));
			answer.setText(resultSet.getString(2));
			answer.setInsertDate(resultSet.getDate(3));
			answer.setActive(resultSet.getBoolean(4));
			answer.setResponderId(resultSet.getLong(5));
			answer.setQuestionId(resultSet.getLong(6));	
			answer.setUpVote(resultSet.getLong(7));
			return answer;
		}
		
	}
}
