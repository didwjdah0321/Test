package com.mytest.mytest.dao;

import java.util.List;

import com.mytest.mytest.vo.MemberVO;

public interface MemberDAO {
	public MemberVO getMember(String id);
	public void insertMemeber(MemberVO memberVO);
	public void buyIntro(MemberVO memberVO);
	public void buyJava(MemberVO memberVO);
	public void buyC(MemberVO memberVO);
	public void ad(MemberVO memberVO);
	public List<MemberVO> showAllMember();
	public void updateMember(MemberVO memberVO);
	public void removeMember(MemberVO memberVO);
	public int count();
}
