package com.qapro.login;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.entity.MemberInfo;
import com.qapro.util.DBConnectionUtil;

/**
 * Servlet implementation class CheckLogin
 */
public class CheckLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogin() {
      
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		String selectUserSql =  "SELECT user_name, name, role_name, is_active, user_id from heroku_f7be13520b27e62.user where email = ? and password = ? ";
		
		Connection con;
		MemberInfo memberInfo = new MemberInfo();
		
		try {
			con = DBConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(selectUserSql);
			ps.setString(1, email);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				String userName = rs.getString(1);
				String name =  rs.getString(2);
				String role_name = rs.getString(3);
				boolean isActive = rs.getBoolean(4);
				Long userId = rs.getLong(5);
				
				memberInfo.setUserName(userName);
				memberInfo.setName(name);
				memberInfo.setMemberRole(role_name);
				memberInfo.setUserId(userId);
				
				
					System.out.println("Login is successful");	
					
					
									
				}
				
			else{
				
				response.sendRedirect("login.jsp");
				request.getSession().setAttribute("message1", "Wrong email or password");
				
				System.out.println("Wrong email or password");
			}
				}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (PropertyVetoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		String SelectValidation =  "SELECT is_validated from heroku_f7be13520b27e62.email_validation where user_id = ?";
		Connection con1;
		
		
		try {
			con1 = DBConnectionUtil.getConnection();
			PreparedStatement ps1 = con1.prepareStatement(SelectValidation);
			ps1.setLong(1, memberInfo.getUserId());
			
			
			ResultSet rs1 = ps1.executeQuery();
		
			if(rs1.next()){
				
				Long validation = Long.parseLong (rs1.getString(1));
				
			
		if( validation == 0){
			
			request.getSession().setAttribute("message1",  "Please activate your membership a mail must be sent!");
			response.sendRedirect("login.jsp");
			
			System.out.println("Please activate your membership");
		}
		else{
			System.out.println("adesso fisso la session con member info e la user id e poi dovresti andare su memberhome");
			request.getSession(true);
			
			request.getSession().setAttribute("memberInfo", memberInfo);
			request.getSession().setAttribute("userId", memberInfo.getUserId());
			response.sendRedirect("DisplayAllQuestions");
			
		}}
		else { 
			System.out.println("non risulta il tuo account");
			response.sendRedirect("login.jsp");
		}
			}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
		
public void doGet(HttpServletRequest request, HttpServletResponse response)
 throws ServletException,IOException{

}}
		
			

