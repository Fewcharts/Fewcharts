package com.qapro.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.entity.MemberInfo;
import com.qapro.service.MemberService;

/**
 * Servlet implementation class MemberManagementServlet
 */
public class MemberManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String username = request.getParameter("username");
		
		
		MemberInfo member = new MemberInfo();
		member.setName(name);
		member.setSurname(surname);
		member.setEmail(email);
		member.setPassword(password);
		member.setUserName(username);
		
		boolean isSuccess = true;
		try{
			MemberService memberService = new MemberService();
			memberService.addMember(member);
			request.getSession().setAttribute("memberInfo", username);
			response.sendRedirect("memberhome.jsp");
		
		}catch(Exception e){
			isSuccess = false;
		}
		
		if(!isSuccess)
		{
			request.getSession().setAttribute("message", "A database error occurred");
			response.sendRedirect("index.jsp");
		}
		
		
		
	}

}
