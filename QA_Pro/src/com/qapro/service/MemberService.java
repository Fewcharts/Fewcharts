package com.qapro.service;

import java.util.Date;
import java.util.List;

import com.qapro.dao.EmailValidationDao;
import com.qapro.dao.MemberDao;
import com.qapro.dao.QuestionDao;
import com.qapro.entity.EmailValidation;
import com.qapro.entity.MemberInfo;
import com.qapro.entity.Question;

public class MemberService {

	MemberDao memberDao = new MemberDao();
	QuestionDao questionDao = new QuestionDao();
	EmailValidationDao emailValidationDao = new EmailValidationDao();
	
	public void addMember(MemberInfo member) throws Exception{

			if(null == memberDao.getMemberByUserName(member.getUserName())){
				
				Long memberId = memberDao.insertMember(member);		
				System.out.println("Member registered");
				EmailValidation validation = new EmailValidation();
				validation.setUserId(memberId);
				validation.setValidationCode(new Date().getTime()+"someotherstring");
				validation.setEmail(member.getEmail());
				emailValidationDao.insertValidation(validation);
				System.out.println("Validation code inserted");
				
			}
			else
			{
				System.out.println("Member already exists");
			}
	}
	
	
    public MemberInfo getUserAndQuestions(Long userId) throws Exception{
		
    	MemberInfo user = memberDao.getUserById(userId);
		
		if(user != null) {
			List<Question> questions = questionDao.getQuestionByAskerId(userId);
			
			user.setQuestions(questions);
		}
		
		return user;
	}
	
	public static void main (String args[]) throws Exception{
		
		MemberService memberService = new MemberService();
		
		MemberInfo member = new MemberInfo();
		member.setEmail("haruki@murakami.com");
		member.setName("haruki");
		member.setSurname("murakami");
		member.setUserName("harukimurakami");
		
		memberService.addMember(member);
		
		
	}
	
}
