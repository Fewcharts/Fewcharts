package com.qapro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.entity.GlobalData;
import com.qapro.entity.Question;
import com.qapro.service.QuestionService;

/**
 * Servlet implementation class DisplayQuestion
 */
public class SelectAllQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectAllQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * questo serve a far vederele domande e le risposte nella pagina topic 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionService questionService = new QuestionService();
		GlobalData question = null;
		
		try{
			
			
					question = questionService.getTextQuestions();	
		    		
	
		}
			
		catch(Exception e){
			
		}	
		
		for (Question q :  question.getQuestions())
    	{
    		System.out.println("3 - ");
    		System.out.println(q.getText());
    	}
		request.setAttribute("question", question);
		request.getRequestDispatcher("/UltimeDomande.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
