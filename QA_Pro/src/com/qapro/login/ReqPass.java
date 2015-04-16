package com.qapro.login;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.entity.MemberInfo;
import com.qapro.service.Email;
import com.qapro.util.DBConnectionUtil;

/**
 * Servlet implementation class CheckLogin
 */
public class ReqPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReqPass()  {
        // TODO Auto-generated constructor stub
    }
    private String host;
    private String port;
    private String user;
    private String pass;
 
    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        user = context.getInitParameter("user");
        pass = context.getInitParameter("pass");
    }
      
        // TODO Auto-generated constructor stub


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");
		
		String selectUserSql =  "SELECT user_name, password, name, role_name, is_active, user_id from heroku_f7be13520b27e62.user where email = ? ";
		
		Connection con;
		MemberInfo memberInfo = new MemberInfo();
		
		try {
			con = DBConnectionUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(selectUserSql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				
				String userName = rs.getString(1);
				String password = rs.getString(2);
				String name =  rs.getString(3);
				String role_name = rs.getString(4);
				boolean isActive = rs.getBoolean(5);
				Long userId = rs.getLong(6);
				
				memberInfo.setUserName(userName);
				memberInfo.setName(password);
				memberInfo.setName(name);
				memberInfo.setMemberRole(role_name);
				memberInfo.setUserId(userId);
				
				
					System.out.println(password);	
					
					   if (email != null){
						   
					        String subject = "Hai richiesto la tua password";
					        String content = "la tua password è:  " + password;
					 
					        String resultMessage = "";
					 
					        try {
					            Email.sendEmail(host, port, user, pass, email, subject,
					                    content);
					            System.out.println ( "The e-mail was sent successfully");
					            response.sendRedirect("verifypass.jsp");
					        } catch (Exception ex) {
					            ex.printStackTrace();
					            System.out.println ("There were an error: " + ex.getMessage());
								response.sendRedirect("passreq.jsp");

					        } finally {
					            request.setAttribute("Message", resultMessage);
					           
					        }}}
		
		else{
			System.out.println ("your email is not in our database please insert different email");
		}
		}
		
catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
} catch (PropertyVetoException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}	}	}
		
		
			

