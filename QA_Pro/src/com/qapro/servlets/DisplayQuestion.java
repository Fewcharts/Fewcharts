package com.qapro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.entity.Question;
import com.qapro.service.QuestionService;

/**
 * Servlet implementation class DisplayQuestion
 */
public class DisplayQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayQuestion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * questo serve a far vederele domande e le risposte nella pagina topic 
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String questionId = request.getParameter("qId");
		String questionText = request.getParameter("");

		QuestionService questionService = new QuestionService();
		Question question = null;
		try{
			Long questionIdLong =  0L;
			if(questionId != null)
					questionIdLong = Long.parseLong(questionId);
					question = questionService.getQuestionAndAnswers(questionIdLong);
			}
			
		catch(Exception e){
			
		}		
		
		request.setAttribute("question", question);
		request.setAttribute("Url", "http://www.fewcharts.com/DisplayQuestion?qId=" + questionId);
		request.setAttribute("Text", question.getText());

		request.getRequestDispatcher("/displayQuestion2.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
