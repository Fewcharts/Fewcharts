package com.qapro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qapro.entity.Vote;
import com.qapro.enums.VotingEnum;

public class VoteDaoAnswer extends JavathlonJdbcTemplate<Vote> {
	
	
	private String getAllVotes = "SELECT vote.id,vote.question_id,vote.user_id, vote.type,  vote.date, vote.is_cancelled, vote.answer_id FROM heroku_f7be13520b27e62.vote";
	private String insertVote = "INSERT INTO heroku_f7be13520b27e62.vote(question_id,user_id,type,date,is_cancelled,answer_id)"
					+ " VALUES	(:question_id , :user_id , :type , :date , :is_cancelled , :answer_id )";
	
	
	
	
	public Vote getVoteByAnswerIdAndUserId(Long answerId, Long userId){
		String sql = getAllVotes + " where vote.answer_id = :answer_id and user_id = :user_id";
		
		List<Vote> voteList = this.getList(sql, new SqlParameterValues()
														.addValue("answer_id", answerId)
														.addValue("user_id", userId), new VoteRowMapper());
		if(voteList != null && voteList.size() > 0){
			return voteList.get(0);
		}
		else return null;
		
		
	}
	
	public void insertVote(Vote vote) throws Exception{
		

		
		SqlParameterValues values = new SqlParameterValues();
		values.addValue("question_id", vote.getQuestionId());
		values.addValue("user_id", vote.getUserId());
		values.addValue("type", vote.getType().name());
		values.addValue("date", vote.getDate());
		values.addValue("is_cancelled", vote.getIsCancelled());	
		values.addValue("answer_id", vote.getAnswerId());
		
		this.insertItem(insertVote, values);
	}
	
	
	private class VoteRowMapper implements SqlRowMapper<Vote>{

		public Vote mapSqlToObject(ResultSet resultSet) throws SQLException {
			Vote vote = new Vote();
			vote.setId(resultSet.getLong(1));
			vote.setQuestionId(resultSet.getLong(2));
			vote.setUserId(resultSet.getLong(3));
			vote.setType(VotingEnum.valueOf(resultSet.getString(4)));
			vote.setDate(resultSet.getTimestamp(5));
			vote.setIsCancelled(resultSet.getBoolean(6));	
			vote.setAnswerId(resultSet.getLong(7));
			return vote;
		}
		
	}

}
