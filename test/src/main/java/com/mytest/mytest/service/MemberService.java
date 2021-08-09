package com.mytest.mytest.service;

import java.util.List;

import com.mytest.mytest.vo.MemberVO;

public interface MemberService {
	public MemberVO getMember(String id);
	public void insertMemeber(MemberVO memberVO);
	public void buySubject(MemberVO memberVO, String subject);
	public void ad(MemberVO memberVO);
	public List<MemberVO> showAllMember();
	public void updateMember(MemberVO memberVO);
	public void removeMember(MemberVO memberVO);
	public int count();
}
