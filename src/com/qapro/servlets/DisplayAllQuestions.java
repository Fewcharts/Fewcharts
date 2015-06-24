package com.qapro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.entity.MemberInfo;
import com.qapro.entity.Question;
import com.qapro.service.MemberService;
import com.qapro.service.QuestionService;

/**
 * Servlet implementation class DisplayAllQuestions
 */
public class DisplayAllQuestions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayAllQuestions() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Long userId = (Long) request.getSession().getAttribute("userId");
		
		MemberService memberService = new MemberService();
		MemberInfo user = null;
		
		try{
			Long userIdLong =  0L;
			
			if(userId != null){
					userIdLong = userId; //Long.parseLong(userId);
					user = memberService.getUserAndQuestions(userIdLong);
					System.out.println ("ho selezionato domande e risposte e poi dovrei andare su memberhome");
					request.setAttribute("user", user);
					request.getRequestDispatcher("memberhome.jsp").forward(request,
							response);	
			}
			else {
				request.getRequestDispatcher("/login.jsp").forward(request,
						response);
			}
			}
		
			
		catch(Exception e){
			
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
