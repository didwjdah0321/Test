package com.mytest.mytest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytest.mytest.dao.MemberDAO;
import com.mytest.mytest.vo.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public MemberVO getMember(String id) {
		return memberDAO.getMember(id);
	}

	@Override
	public void insertMemeber(MemberVO memberVO) {
		memberDAO.insertMemeber(memberVO);
	}

	@Override
	public void buySubject(MemberVO memberVO, String subject) {
		switch(subject) {
		case "intro":
			memberDAO.buyIntro(memberVO);
			break;

		case "java":
			memberDAO.buyJava(memberVO);
			break;
			
		case "c":
			memberDAO.buyC(memberVO);
			break;			
		}
	}

	@Override
	public void ad(MemberVO memberVO) {
		memberDAO.ad(memberVO);
	}

	@Override
	public List<MemberVO> showAllMember() {
		return memberDAO.showAllMember();
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		memberDAO.updateMember(memberVO);		
	}

	@Override
	public void removeMember(MemberVO memberVO) {
		memberDAO.removeMember(memberVO);
		
	}

	@Override
	public int count() {
		return memberDAO.count();		
	}
	
	
	
}
