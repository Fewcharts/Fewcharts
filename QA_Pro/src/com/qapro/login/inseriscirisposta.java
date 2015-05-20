package com.qapro.login;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;
import com.qapro.entity.MemberInfo;
import com.qapro.entity.Question;
import com.qapro.service.Email;
import com.qapro.util.DBConnectionUtil;

/**
 * Servlet implementation class CheckLogin
 */
public class inseriscirisposta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public inseriscirisposta() {
        super();
        // TODO Auto-generated constructor stubhj
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


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw = response.getWriter();
		
		
		
		HttpSession session = request.getSession(false);
		
		System.out.println (session);
		
		if(session == null){
			response.sendRedirect("login.jsp");
		}else{
			
			String text = request.getParameter("risposta");
			Long useridLong = (Long) session.getAttribute("userId");
			Long userid = (Long) session.getAttribute("userId");
			int askerId = Integer.parseInt(request.getParameter("askerId"));
			int questionIdInt = Integer.parseInt(request.getParameter("questionId"));
			Long questionid =Long.parseLong(request.getParameter("questionId"));
			
			if (useridLong == null) {
				System.out.println ("devi loggarti per poter commentare");
				response.sendRedirect("login.jsp");
			}
			else{
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String insertAnswerSql = "INSERT INTO heroku_f7be13520b27e62.answer "
					+ "(text,insert_date,is_active,responder_id, question_id, Upvote)"
					   +" VALUES (?,?,?,?,?,?)";
			String getEmailquestion = "SELECT (email) FROM heroku_f7be13520b27e62.user WHERE user_id = ?";
			try {
				
					//long currentTime = System.currentTimeMillis();
							
					connection = DBConnectionUtil.getConnection();	
					
					preparedStatement = connection.prepareStatement(insertAnswerSql);
					
					
					preparedStatement.setString(1, text);
					preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
					preparedStatement.setBoolean(3, true);
					preparedStatement.setInt(4, 4);
					preparedStatement.setInt(5, questionIdInt);
					preparedStatement.setLong(6, 1);
					connection.setAutoCommit(true);
					preparedStatement.executeUpdate();
				
					
					
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					int id = -1;
					

					try {
						   pstmt = connection.prepareStatement(getEmailquestion);
						   pstmt.setInt(1, askerId);

						   rs = pstmt.executeQuery();
						   if ((rs != null) && rs.next())  {
							   String MailAsker = rs.getString(1);
							   System.out.println (rs.getString(1));
						        String subject = "You just received a reply on Fewcharts";
						        String content = " Your topic just received a reply on Fewcharts. Discover who's the new n.1 http://www.fewcharts.com";
						 
						        String resultMessage = "";
						 
						        try {
						            Email.sendEmail(host, port, user, pass, MailAsker, subject,
						                    content);
						            System.out.println ( "The e-mail was sent successfully");
						        } catch (Exception ex) {
						            ex.printStackTrace();
						            System.out.println ("There were an error: " + ex.getMessage());
						        } finally {
						            request.setAttribute("Message", resultMessage);
						           
						        }
						    }
						if (id >= 0) {
							response.sendRedirect("DisplayQuestion?qId="+ id );	
						}}
					
						catch(SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();}
					
					try {
						   pstmt = connection.prepareStatement("SELECT (id) FROM heroku_f7be13520b27e62.question WHERE id = ?");
						   pstmt.setInt(1, questionIdInt);

						   rs = pstmt.executeQuery();
						   if ((rs != null) && rs.next()) {
						      id = rs.getInt( 1 );
						   }
						} catch (Exception e) {
						   e.printStackTrace();
						} finally {
						   if (rs != null) {
						      try { rs.close(); } catch (Exception e) { }
						   }
						   if (pstmt != null) {
						      try { pstmt.close(); } catch (Exception e) { }
						   }
						}

						if (id >= 0) {
							response.sendRedirect("DisplayQuestion?qId="+ id );	
						}
				
						
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();}
			 catch (PropertyVetoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			}
		
							
			
			
			
}}}
		
		
			

		
		
		
		
		
	


