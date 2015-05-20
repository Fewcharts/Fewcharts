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

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Statement;
import com.qapro.entity.MemberInfo;
import com.qapro.util.DBConnectionUtil;

/**
 * Servlet implementation class CheckLogin
 */
public class CheckUtenteLoggato extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckUtenteLoggato() {
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
		
		
		PrintWriter pw = response.getWriter();
		 
		HttpSession session = request.getSession(false);
		if(session == null){
			response.sendRedirect("login.jsp");
		}else{
			
			String text = request.getParameter("topic");
			Long userid = (Long) session.getAttribute("userId");
			
			if (userid == null) {
				System.out.println ("niente da fare tutto nullo");
				response.sendRedirect("login.jsp");
			}
			else{
			Connection connection = null;
			PreparedStatement preparedStatement = null;
			String insertQuestionSql = "INSERT INTO heroku_f7be13520b27e62.question "
					+ "(text,insert_date,is_active,asker_id,up_vote,down_vote)"
					   +" VALUES (?,?,?,?,?,? )";
			try {
				
					//long currentTime = System.currentTimeMillis();
							
					connection = DBConnectionUtil.getConnection();	
					
					preparedStatement = connection.prepareStatement(insertQuestionSql);
					
					preparedStatement.setString(1, text);
					preparedStatement.setTimestamp(2, new Timestamp(new Date().getTime()));
					preparedStatement.setBoolean(3, true);
					preparedStatement.setLong(4, userid);
					preparedStatement.setInt(5,0);
					preparedStatement.setInt(6, 0);	
					connection.setAutoCommit(true);
					preparedStatement.executeUpdate();
				
					
					
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					int id = -1;
					
					
		// ANDAVA FATTO UN ALTRO TRY!!			
					try {
					   pstmt = connection.prepareStatement("SELECT MAX(id) FROM heroku_f7be13520b27e62.question WHERE asker_id = ?");
					   pstmt.setLong(1, userid);

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
		
		
			

		
		
		
		
		
	


