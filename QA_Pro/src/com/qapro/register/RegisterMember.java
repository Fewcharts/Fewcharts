package com.qapro.register;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;
import com.qapro.service.Email;
import com.qapro.util.DBConnectionUtil;



/**
 * Servlet implementation class RegisterMember
 */
public class RegisterMember extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public RegisterMember() {
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
  	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");

		System.out.println(name + " "+ surname);
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
		String Conditions = request.getParameter("Conditions");

		if(name == null || surname == null || email == null || password == null || username == null){					
			request.getSession().setAttribute("message",  " please don't leave blank space into parameters");
			response.sendRedirect("register.jsp");							
			return;
		}				
		
		
		System.out.println(name +" "+surname+" "+ email+ " "+password);
		
		if (Conditions != null){
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		PreparedStatement userNameCountStatement;
		PreparedStatement emailCountStatement;
		try {
			
				//long currentTime = System.currentTimeMillis();
						
				connection = DBConnectionUtil.getConnection();
				
				//long lastTime = System.currentTimeMillis();
				
				//System.out.println(lastTime - currentTime + " ms elapsed for creating db pool");
				
				String userNameCountSql = "select count(user_name) from heroku_f7be13520b27e62.user where user_name = ?" ;
				
// aggiungere query per doppie mail
				
				userNameCountStatement = connection.prepareStatement(userNameCountSql);
				
				userNameCountStatement.setString(1, username);
				
				ResultSet rs = userNameCountStatement.executeQuery();
				
				long count = 0;
				if(rs.next()){					
					count = rs.getLong(1);					
				}
				
				if(count > 0){					
					request.getSession().setAttribute("message",  username+" user name has already been taken");
					response.sendRedirect("index.jsp");							
					return;
				}				
				
				String useremailCountSql = "select count(email) from heroku_f7be13520b27e62.user where email = ?" ;
				emailCountStatement = connection.prepareStatement(useremailCountSql);
				
				emailCountStatement.setString(1, email);
				
				ResultSet rs1 = emailCountStatement.executeQuery();
				
				long count1 = 0;
				if(rs1.next()){					
					count1 = rs1.getLong(1);					
				}
				
				if(count1 > 0){					
					request.getSession().setAttribute("message",  email +" email has already been taken");
					response.sendRedirect("register.jsp");							
					
				}				
				
				String userInsertSql = "INSERT INTO heroku_f7be13520b27e62.user "
						+	"(user_name, password, is_active, name, surname, email, insert_date)"
						+	" VALUES (?, ?, ?, ?,?,?, ?)";
				
				preparedStatement = connection.prepareStatement(userInsertSql, Statement.RETURN_GENERATED_KEYS);
				
				preparedStatement.setString(1, username);
				preparedStatement.setString(2, password);
				preparedStatement.setBoolean(3, true);
				preparedStatement.setString(4, name);
				preparedStatement.setString(5, surname);
				preparedStatement.setString(6, email);
				preparedStatement.setTimestamp(7, new Timestamp(new Date().getTime()));
				
				connection.setAutoCommit(false);
				
				int affectedRowCount = preparedStatement.executeUpdate();
				ResultSet autoIncrementResultSet = preparedStatement.getGeneratedKeys();
				int autoIncrementedUserId = 0;
				if(autoIncrementResultSet.next()){
					autoIncrementedUserId = autoIncrementResultSet.getInt(1);
				}
				
				if(affectedRowCount > 0)
					{
					request.getSession().setAttribute("username", username);
					
					//AGGIUNTO  DA ME PER fissare lo userid da utilizzare quando inserisco question
					request.getSession().setAttribute("autoIncrementedUserId", autoIncrementedUserId);
					}
				else
				{
					request.getSession().setAttribute("message", "A database error occurred");
					response.sendRedirect("index.jsp");
				}
				
				
				String key = new Date().getTime()+"";
				
				String emailValidationInsertSql = "INSERT INTO heroku_f7be13520b27e62.email_validation"
						+" (validation_code,email,user_id,is_validated,insert_date,validation_date)"
						+" VALUES	(?,?,?,?,?,?)";
				PreparedStatement validationStatement = connection.prepareStatement(emailValidationInsertSql);
				validationStatement.setString(1, key);
				validationStatement.setString(2, email);
				validationStatement.setInt(3, autoIncrementedUserId);
				validationStatement.setBoolean(4, false);
				validationStatement.setTimestamp(5, new Timestamp(new Date().getTime()));
				validationStatement.setTimestamp(6, null);
				validationStatement.executeUpdate();
				connection.commit();
				
				
				// localhost:8080/QA_Pro/validate?key=sdfsfsdf&userid=423
				String linkdacliccare = (request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/validate?key="+key+"&userid="+autoIncrementedUserId);
				System.out.print(linkdacliccare);
				//lastTime = System.currentTimeMillis();
				//System.out.println(lastTime - currentTime+" ms elapsed for inserting");
		
							   if (email != null){
								   
							        String subject = "Validate your email";
							        String content = "Ciao, ";
							        content += "to validate your email please copy and paste the following link on your web browser ";
							        content += " " ;
							        content +=	linkdacliccare;
							        content += " " ;
							        content += " ";
							        content += "Your password is:";
							        content +=	password;
							       
							        

							        String resultMessage = "";
							 
							        try {
							            Email.sendEmail(host, port, user, pass, email, subject,
							                    content);
							            System.out.println ( "The e-mail was sent successfully");
							            response.sendRedirect("verifyemail.jsp");
							        } catch (Exception ex) {
							            ex.printStackTrace();
							            System.out.println ("There were an error: " + ex.getMessage());
										response.sendRedirect("login.jsp");

							        } finally {
							            request.setAttribute("Message", resultMessage);
							           
							        }}}
				
				
				
				
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
		
		finally{

			try {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}				
		}		
	}
		else {
			request.getSession().setAttribute("message",  " Check Conditions box!!");

			response.sendRedirect("register.jsp");
		}
}}

