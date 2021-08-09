package com.mytest.mytest.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mytest.mytest.vo.MemberVO;

@Repository("memberDAO")
public class MemberDAOImpl implements MemberDAO {
	@Autowired
	SqlSession sqlSession;

	@Override
	public MemberVO getMember(String id) {
		
		return sqlSession.selectOne("test.selectMemberInfo", id);
	}

	@Override
	public void insertMemeber(MemberVO memberVO) {
		sqlSession.insert("test.insertMember", memberVO);
	}

	@Override
	public void buyIntro(MemberVO memberVO) {
		sqlSession.update("test.buyIntro", memberVO);
	}

	@Override
	public void buyJava(MemberVO memberVO) {
		sqlSession.update("test.buyJava", memberVO);
	}

	@Override
	public void buyC(MemberVO memberVO) {
		sqlSession.update("test.buyC", memberVO);
	}

	@Override
	public void ad(MemberVO memberVO) {
		sqlSession.update("test.ad", memberVO);
	}

	@Override
	public List<MemberVO> showAllMember() {
		return sqlSession.selectList("test.showAllMember");
	}

	@Override
	public void updateMember(MemberVO memberVO) {
		sqlSession.update("test.updateMemeber", memberVO);		
	}

	@Override
	public void removeMember(MemberVO memberVO) {
		sqlSession.delete("test.removeMember", memberVO);
	}

	@Override
	public int count() {
		return sqlSession.update("test.updatePointBySchedule");
	}
	
	
	

}
