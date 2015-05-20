

package com.qapro.entity;


import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
import com.qapro.util.DBConnectionUtil;

public class MainMenu extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String code="";

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		code = request.getParameter("code");
		
		if (code == null || code.equals("")) {
			throw new RuntimeException(
					"ERROR: Didn't get code parameter in callback.");
		}
		FBConnection fbConnection = new FBConnection();
		String accessToken = fbConnection.getAccessToken(code);
		

		FBGraph fbGraph = new FBGraph(accessToken);
		String graph = fbGraph.getFBGraph();
		Map<String, String> fbProfileData = fbGraph.getGraphData(graph);
		ServletOutputStream out = response.getOutputStream();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement userNameCountStatement;
		PreparedStatement emailCountStatement;
		MemberInfo memberInfo = new MemberInfo();

		try {
			
					
			connection = DBConnectionUtil.getConnection();
					
			String useremailCountSql = "SELECT user_name, name, role_name, is_active, user_id from heroku_f7be13520b27e62.user where email = ? ";
			emailCountStatement = connection.prepareStatement(useremailCountSql);
			
			emailCountStatement.setString(1, fbProfileData.get("email"));
			
			ResultSet rs1 = emailCountStatement.executeQuery();
			
			long count1 = 0;
			
			
			if(rs1.next()){					
				
				count1 = 1;

				
				String userName = rs1.getString(1);
				String name =  rs1.getString(2);
				String role_name = rs1.getString(3);
				boolean isActive = rs1.getBoolean(4);
				Long userId = rs1.getLong(5);
				
				memberInfo.setUserName(userName);
				memberInfo.setName(name);
				memberInfo.setMemberRole(role_name);
				memberInfo.setUserId(userId);
				
				System.out.println(" l'utente matcha con quelli nel database");
				request.getSession(true);
				request.getSession().setAttribute("memberInfo", memberInfo);
				request.getSession().setAttribute("userId", memberInfo.getUserId());
				response.sendRedirect("index.jsp");

	}
			
		
		
		if(count1 == 0){	
			
			String userInsertSql = "INSERT INTO heroku_f7be13520b27e62.user "
					+	"(user_name, password, is_active, name, surname, email, insert_date)"
					+	" VALUES (?, ?, ?, ?,?,?, ?)";
			
			preparedStatement = connection.prepareStatement(userInsertSql, Statement.RETURN_GENERATED_KEYS);
			
			preparedStatement.setString(1, fbProfileData.get("first_name"));
			preparedStatement.setString(2,null);
			preparedStatement.setBoolean(3, true);
			preparedStatement.setString(4, fbProfileData.get("first_name"));
			preparedStatement.setString(5, null);
			preparedStatement.setString(6, fbProfileData.get("email"));
			preparedStatement.setTimestamp(7, new Timestamp(new Date().getTime()));
			
			connection.setAutoCommit(false);
			
			int affectedRowCount = preparedStatement.executeUpdate();
			int autoIncrementedUserId = 0;
			
			
			
			if(affectedRowCount > 0)
				{
				request.getSession().setAttribute("user", fbProfileData.get("first_name"));
				
				//AGGIUNTO  DA ME PER fissare lo userid da utilizzare quando inserisco question
				request.getSession().setAttribute("autoIncrementedUserId", autoIncrementedUserId);
				}
			
			
			String key = new Date().getTime()+"";
			
			String emailValidationInsertSql = "INSERT INTO heroku_f7be13520b27e62.email_validation"
					+" (validation_code,email,is_validated,insert_date,validation_date)"
					+" VALUES	(?,?,?,?,?)";
			PreparedStatement validationStatement = connection.prepareStatement(emailValidationInsertSql);
			validationStatement.setString(1, null);
			validationStatement.setString(2, fbProfileData.get("email"));
			validationStatement.setBoolean(3, true);
			validationStatement.setTimestamp(4, new Timestamp(new Date().getTime()));
			validationStatement.setTimestamp(5, null);
			validationStatement.executeUpdate();
			connection.commit();
		
			request.getSession().setAttribute("memberInfo", memberInfo);
			request.getSession().setAttribute("userId", memberInfo.getUserId());

			response.sendRedirect("topic.jsp");
			
	
			
									
			
		}	
		}
	
	
	
	
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e){
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
}}
