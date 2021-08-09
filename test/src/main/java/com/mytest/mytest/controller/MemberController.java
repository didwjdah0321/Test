package com.mytest.mytest.controller;

import javax.servlet.http.HttpServletRequest;

import org.quartz.SchedulerException;
import org.springframework.ui.Model;

import com.mytest.mytest.vo.MemberVO;

public interface MemberController {
	public String index();
	public String login(Model model, MemberVO memberVO, HttpServletRequest request);
	public String sign();
	public String insertMember(Model model, MemberVO memberVO);
	public String logout(Model model, HttpServletRequest request);
	public String buy(Model model, MemberVO memberVO, String subject);
	public String ad(Model model, MemberVO memberVO);
	public String modify(Model model, MemberVO memberVO);
	public String updateMember(Model model, MemberVO memberVO);
	public String removeMember(Model model, MemberVO memberVO);
	public String homeStart(Model model) throws SchedulerException;
	public String homeEnd(Model model) throws SchedulerException;
}
