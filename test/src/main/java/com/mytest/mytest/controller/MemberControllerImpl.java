package com.mytest.mytest.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mytest.mytest.service.MemberService;
import com.mytest.mytest.util.MyJob;
import com.mytest.mytest.vo.MemberVO;

@Controller
public class MemberControllerImpl implements MemberController{
	@Autowired
	MemberService memberService;

	@Override
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {	
		return "login";
	}

	@Override
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(Model model, MemberVO memberVO, HttpServletRequest request) {
		MemberVO info = memberService.getMember(memberVO.getId());
		String dbPW = info.getPw();
		if(dbPW == null) { //아이디 없음
			model.addAttribute("msg", "아이디를 확인해 주세요.");
			return "login";
		}else {
			if(dbPW.equals(memberVO.getPw())) {//로그인 성공
				HttpSession session = request.getSession();
				session.setAttribute("loginID", memberVO.getId());
				if(memberVO.getId().equals("admin")) {
					model.addAttribute("msg", "관리자 로그인 성공");
					model.addAttribute("info", memberService.showAllMember());
					return "admin";
				}
				model.addAttribute("msg", memberVO.getId() + "님 환영합니다.");
				model.addAttribute("info", info);
				return "main";
			}else {
				model.addAttribute("msg", "비밀번호를 확인해 주세요.");
				return "login";				
			}
		}	
	}
	

	@Override
	@RequestMapping(value = "/logout")
	public String logout(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		model.addAttribute("msg", "로그아웃 되었습니다.");
		return "login";
	}

	@Override
	@RequestMapping(value = "/sign")
	public String sign() {		
		return "sign";
	}

	@Override
	@RequestMapping(value = "/insertMember", method = RequestMethod.POST)
	public String insertMember(Model model, MemberVO memberVO) {
		memberService.insertMemeber(memberVO);
		model.addAttribute("msg", "가입이 완료 되었습니다.");
		return "login";
	}

	@Override
	@RequestMapping(value = "/buy", method = RequestMethod.GET)
	public String buy(Model model, MemberVO memberVO, String subject) {
		switch(subject) {
		case "intro":
			if(memberVO.getPoint() >= 100000) {
				memberService.buySubject(memberVO, subject);
				model.addAttribute("msg", "컨텐츠(intro) 구입이 완료되었습니다.");
				model.addAttribute("info", memberService.getMember(memberVO.getId()));
				return "main";
			}else {
				model.addAttribute("msg", "포인트가 부족합니다. 광고를 클릭하세요.");
				model.addAttribute("info", memberService.getMember(memberVO.getId()));
				return "main";
			}
		case "java":
			if(memberVO.getPoint() >= 500000) {
				memberService.buySubject(memberVO, subject);
				model.addAttribute("msg", "컨텐츠(java) 구입이 완료되었습니다.");
				model.addAttribute("info", memberService.getMember(memberVO.getId()));
				return "main";
			}else {
				model.addAttribute("msg", "포인트가 부족합니다. 광고를 클릭하세요.");
				model.addAttribute("info", memberService.getMember(memberVO.getId()));
				return "main";
			}			
		case "c":
			if(memberVO.getPoint() >= 300000) {
				memberService.buySubject(memberVO, subject);
				model.addAttribute("msg", "컨텐츠(c) 구입이 완료되었습니다.");
				model.addAttribute("info", memberService.getMember(memberVO.getId()));
				return "main";
			}else {
				model.addAttribute("msg", "포인트가 부족합니다. 광고를 클릭하세요.");
				model.addAttribute("info", memberService.getMember(memberVO.getId()));
				return "main";
			}						
		}
		return "main";
	}

	@Override
	@RequestMapping(value = "/ad", method = RequestMethod.GET)
	public String ad(Model model, MemberVO memberVO) {
		memberService.ad(memberVO);
		model.addAttribute("msg", "1000점이 적립되었습니다.");		
		model.addAttribute("info", memberService.getMember(memberVO.getId()));
		return "main";
	}

	@Override
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(Model model, MemberVO memberVO) {
		model.addAttribute("info", memberService.getMember(memberVO.getId()));
		return "modify";
	}

	@Override
	@RequestMapping(value = "/updateMember", method = RequestMethod.POST)
	public String updateMember(Model model, MemberVO memberVO) {
		memberService.updateMember(memberVO);
		model.addAttribute("msg", "수정되었습니다.");
		model.addAttribute("info", memberService.showAllMember());
		return "admin";
	}
	
	@Override
	@RequestMapping(value = "/removeMember", method = RequestMethod.GET)
	public String removeMember(Model model, MemberVO memberVO) {
		memberService.removeMember(memberVO);
		model.addAttribute("msg", "삭제되었습니다.");
		model.addAttribute("info", memberService.showAllMember());
		return "admin";
	}
	
	@RequestMapping(value = "/start")  // 스케줄러 시작할게요 (= 10초마다 MyJob 실행할게요).
	public String homeStart(Model model) throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		
		  // define the job and tie it to our HelloJob class
		  JobDetail job = JobBuilder.newJob(MyJob.class)
		      .withIdentity("job1", "group1")
		      .build();

		  // Trigger the job to run now, and then repeat every 40 seconds
		  Trigger trigger = TriggerBuilder.newTrigger()
		      .withIdentity("trigger1", "group1")
		      .startNow()
		      .withSchedule(CronScheduleBuilder.cronSchedule("0/20 * * * * ?"))
		      .build();

		  // Tell quartz to schedule the job using our trigger
		  scheduler.scheduleJob(job, trigger);
		  scheduler.start();
		  model.addAttribute("info", memberService.showAllMember());
		  System.out.println("스케줄러가 시작됨.");
		return "admin";
	}
	
	@RequestMapping(value = "/end")    // 스케줄러 끝낼게요 (= MyJob 그만 할게요).
	public String homeEnd(Model model) throws SchedulerException {
		Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
		scheduler.shutdown();
		model.addAttribute("info", memberService.showAllMember());
		System.out.println("스케줄러가 종료됨.");
		return "admin";
	}
	
	
	
	
}


