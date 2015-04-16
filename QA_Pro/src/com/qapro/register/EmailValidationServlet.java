package com.qapro.register;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qapro.util.DBConnectionUtil;

/**
 * Servlet implementation class EmailValidation
 */
public class EmailValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String key = request.getParameter("key");
		String userId = request.getParameter("userid");
		
		
		String updateValidationSql = "UPDATE heroku_f7be13520b27e62.email_validation SET is_validated = ?, validation_date = ? where user_id = ? and validation_code = ?";
		
		Connection con = null;
		PreparedStatement ps= null;
		PreparedStatement ps2= null;
		
		try {
			con = DBConnectionUtil.getConnection();
			con.setAutoCommit(false);
			
			ps = con.prepareStatement(updateValidationSql);		
			ps.setBoolean(1, true);
			ps.setTimestamp(2, new Timestamp(new java.util.Date().getTime()));
			ps.setLong(3, Long.parseLong(userId));
			ps.setString(4, key);		
			ps.executeUpdate();
			
			
			String updateUserSql = "UPDATE heroku_f7be13520b27e62.user SET is_active = ? where user_id = ?";
			ps2 = con.prepareStatement(updateUserSql);
			
			ps2.setBoolean(1, true);
			ps2.setLong(2, Long.parseLong(userId));
			ps2.executeUpdate();
			
			con.commit();
            response.sendRedirect("emailverified.jsp");

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				if(con != null)
					con.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			e.printStackTrace();
		} catch (PropertyVetoException e) {
			try {
				if(con != null)
					con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}	
		
		finally{
			
				try {
					if(con != null){						
						con.close();
					}
					if(ps!=null)
						ps.close();
					if(ps2!=null)
						ps2.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
