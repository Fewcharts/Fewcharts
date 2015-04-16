package com.qapro.servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.qapro.entity.MemberInfo;
import com.qapro.entity.Vote;
import com.qapro.enums.VotingEnum;
import com.qapro.enums.VotingResult;
import com.qapro.service.VoteService;
import com.qapro.service.VoteServiceAnswer;

/**
 * Servlet implementation class VotingServlet
 */
public class VotingServletAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VotingServletAnswer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long answerId = 0L;
		Long questionId = 0L;
				
		questionId = Long.parseLong(request.getParameter("questionId"));
		answerId = Long.parseLong(request.getParameter("answerId"));
		
		MemberInfo memberInfo = (MemberInfo)request.getSession().getAttribute("memberInfo");
		Long userId  = null;
		if(memberInfo != null){
			userId = memberInfo.getUserId();
		
		VotingEnum type = VotingEnum.valueOf(request.getParameter("type"));
		
		
		VoteServiceAnswer voteService = new VoteServiceAnswer();
		Vote vote = new Vote();
		vote.setUserId(userId);
		vote.setQuestionId(questionId);
		vote.setAnswerId(answerId);
		vote.setType(type);
		vote.setDate(new Date());
		vote.setIsCancelled(false);
		
		VotingResult result = null;
		try {
			
			result = voteService.saveVote(vote);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(vote.getUserId());
			e.printStackTrace();
		}
		
		if(result == VotingResult.VOTING_SUCCESSFULL){
			request.getSession().setAttribute("message", "Your vote is saved, thanks.");
			System.out.println ("Your voting is saved, thanks.");
		}
		else if(result == VotingResult.ALREADY_VOTED_DOWN)
			request.getSession().setAttribute("message", "You already voted this question down");
		else if(result == VotingResult.ALREADY_VOTED_UP)
			request.getSession().setAttribute("message", "You already voted this question up");
		else
			request.getSession().setAttribute("message", "Your vote could not be saved");

		
response.getWriter().write(result.name());
}
		else
			response.sendRedirect("login.jsp");
	}
	
	
	}

