package com.mytest.mytest.util;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

import com.mytest.mytest.dao.MemberDAO;
import com.mytest.mytest.service.MemberService;

public class MyJob implements Job {
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
			
		//System.out.println("Job이 실행됨 : " + new Date(System.currentTimeMillis()) + "   " + memberDAO.count() + "명에게 포인트 부여 (1점)..");  << memberDAO에서 Null값 나와요..		
		System.out.println("Job이 실행됨 : " + new Date(System.currentTimeMillis()) + "    명에게 포인트 부여 (1점)..");
	}

}