package com.qapro.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.qapro.entity.MemberInfo;

public class MemberDao extends JavathlonJdbcTemplate<MemberInfo>{
	
	String getAllMemberSql = "select user_name, name, surname, email, insert_date from heroku_f7be13520b27e62.user";
	
	String insertMemberSql = "insert into heroku_f7be13520b27e62.user(name, surname, email, user_name, is_active) values ( :name , :surname , :email , :username , :is_active )";
	
	public List<MemberInfo> getAllMembers()
	{
		
		List<MemberInfo> allMembers = this.getList(getAllMemberSql, new SqlParameterValues(), new MemberInfoRowMapper());
		for(MemberInfo m: allMembers){
			System.out.println(m.getUserName());
		}
		return allMembers;
	}
	
	
	
	public Long insertMember(MemberInfo m) throws Exception
	{
		SqlParameterValues values = new SqlParameterValues();
		values.addValue("name", m.getName());
		values.addValue("surname", m.getSurname());
		values.addValue("email", m.getEmail());
		values.addValue("username", m.getUserName());	
		values.addValue("is_active",true);
		
		return this.insertItem(insertMemberSql, values);
		
	}
	
	
	
	public MemberInfo getMemberByUserName(String name) throws Exception
	{
		String sql = getAllMemberSql + " where user_name = :username";
		MemberInfo m = this.queryForObject(sql,new SqlParameterValues().addValue("username", name), new MemberInfoRowMapper());
		return m;
	}
	
	// prendo un soggetto tramite la id e mi ritorna un oggetto "m" di tipo memberinfo
	
	public MemberInfo getUserById (Long userId) throws Exception
	{
		String sql = getAllMemberSql + " where user_id = :userid";
		MemberInfo m = this.queryForObject(sql,new SqlParameterValues().addValue("userid", userId), new MemberInfoRowMapper());
		return m;
	}
	
	public static void main (String args[]){
		MemberInfo member = new MemberInfo();
		MemberDao memberDao = new MemberDao();
		try {
			//member = memberDao.getMemberByUserName("talhaocakci");
			member.setName("george");
			member.setSurname("lucas");
			member.setUserName("glucas");
			member.setEmail("glucas@hotmail.com");
			memberDao.insertMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(member.getName()+ " " + member.getSurname());
	}

}

class MemberInfoRowMapper implements SqlRowMapper<MemberInfo>{

	public MemberInfo mapSqlToObject(ResultSet resultSet) throws SQLException {
		MemberInfo member = new MemberInfo();
		member.setUserName(resultSet.getString(1));
		member.setName(resultSet.getString(2));
		member.setSurname(resultSet.getString(3));
		member.setEmail(resultSet.getString(4));
		return member;
	}
}



