package com.qapro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.qapro.entity.EmailValidation;

public class EmailValidationDao extends JavathlonJdbcTemplate<EmailValidation>{

	
	private String insertEmailValidationSql = "INSERT INTO heroku_f7be13520b27e62.email_validation "
				+" (validation_code,email,user_id,is_validated,insert_date)"	
				+" VALUES (:validation_code , :email , :user_id , :is_validated , :insert_date )";

	private String selectEmailValidationSql = "SELECT validation_id,  validation_code,  email, user_id, is_validated, insert_date, validation_date FROM heroku_f7be13520b27e62.email_validation";

	
	private String updateEmailValidation = "UPDATE heroku_f7be13520b27e62.email_validation set is_validated = :is_validated , validation_date = :validation_date where email = :email";
	
	
	
	public void  insertValidation(EmailValidation emailValidation) throws Exception{
		
		SqlParameterValues values = new SqlParameterValues();
		values.addValue("validation_code", emailValidation.getValidationCode());
		values.addValue("email", emailValidation.getEmail());
		values.addValue("user_id", emailValidation.getUserId());
		values.addValue("is_validated", false);
		values.addValue("insert_date", new Date());		
		this.insertItem(insertEmailValidationSql,values);
	}
	
	public EmailValidation getEmailValidationByEmail(String email){
		String sql = selectEmailValidationSql + " where email = :email";
		List<EmailValidation> allValidation = this.getList(sql, new SqlParameterValues().addValue("email", email), new EmailValidationRowMapper());
		if(allValidation != null && allValidation.size() > 0)
			return allValidation.get(0);
		else
			return null;
	}
	
	public void updateEmailValidationByEmail(EmailValidation emailValidation) throws Exception{
		
		SqlParameterValues values = new SqlParameterValues();
		values.addValue("is_validated", true);
		values.addValue("validation_date", new Date());
		values.addValue("email", emailValidation.getEmail());
		this.update(updateEmailValidation, values);
	}
	
	public static void main (String args[]){
		
		EmailValidation val = new EmailValidation();
		val.setEmail("test@test.com");
		val.setValidationCode("code");
		val.setUserId(4L);
		EmailValidationDao emailValidationDao = new EmailValidationDao();
		try {
			emailValidationDao.insertValidation(val);
			
			emailValidationDao.updateEmailValidationByEmail(val);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private class EmailValidationRowMapper  implements SqlRowMapper<EmailValidation>{

		public EmailValidation mapSqlToObject(ResultSet resultSet)
				throws SQLException {
			
			EmailValidation emv = new EmailValidation();
			emv.setValidationId(resultSet.getLong(1));
			emv.setValidationCode(resultSet.getString(2));
			emv.setEmail(resultSet.getString(3));
			emv.setUserId(resultSet.getLong(4));
			emv.setValidated(resultSet.getBoolean(5));
			emv.setInsertDate(resultSet.getDate(6));
			emv.setValidationDate(resultSet.getDate(7));
			return emv;
		}
		
	}
	
}