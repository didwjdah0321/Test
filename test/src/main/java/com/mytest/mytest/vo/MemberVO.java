package com.mytest.mytest.vo;

public class MemberVO {
	private String id;
	private String name;
	private String pw;
	private int point;
	
	MemberVO(){
		
	}
	MemberVO(String id, String name, String pw, int point){
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.point = point;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	
	
}
