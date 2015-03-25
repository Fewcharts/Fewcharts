package com.qapro.service;

import java.util.Date;

import com.qapro.dao.QuestionDao;
import com.qapro.dao.VoteDao;
import com.qapro.entity.Vote;
import com.qapro.enums.VotingEnum;
import com.qapro.enums.VotingResult;

public class VoteService {

	public VoteDao voteDao = new VoteDao();
	
	public QuestionDao questionDao = new QuestionDao();
	
	public VotingResult saveVote(Vote vote) throws Exception{
		
		Vote checkVote = voteDao.getVoteByQuestionIdAndUserId(vote.getQuestionId(), vote.getUserId());
		
		if(checkVote != null){
			if(checkVote.getType() == VotingEnum.UP){
				return VotingResult.ALREADY_VOTED_UP;
			}
			else{
				return VotingResult.ALREADY_VOTED_DOWN;
			}
		}	
		
		
		voteDao.insertVote(vote);
		questionDao.voteQuestion(vote.getQuestionId(), vote.getType());
		
		return VotingResult.VOTING_SUCCESSFULL;
	}
	
	
	public static void main(String args[]){
		Vote vote = new Vote();
		vote.setUserId(3L);
		vote.setQuestionId(1L);
		vote.setType(VotingEnum.UP);
		vote.setDate(new Date());
		vote.setIsCancelled(false);
		VoteService voteService = new VoteService();
		VotingResult result = null;
		try {
			
			result = voteService.saveVote(vote);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result.name());
	}
	
}
