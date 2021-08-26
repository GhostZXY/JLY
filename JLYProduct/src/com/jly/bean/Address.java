package com.jly.bean;

public class Address {
	private int a_id;		  //地址id
	private String a_address; //联系电话
	private String a_tel;	  //电话
	private String a_name;	  //地址名称
	private User u;			  //用户id
	private String a_isdefult;//详细地址
	public int getA_id() {
		return a_id;
	}
	public void setA_id(int a_id) {
		this.a_id = a_id;
	}
	public String getA_address() {
		return a_address;
	}
	public void setA_address(String a_address) {
		this.a_address = a_address;
	}
	public String getA_tel() {
		return a_tel;
	}
	public void setA_tel(String a_tel) {
		this.a_tel = a_tel;
	}
	public String getA_name() {
		return a_name;
	}
	public void setA_name(String a_name) {
		this.a_name = a_name;
	}
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	public String getA_isdefult() {
		return a_isdefult;
	}
	public void setA_isdefult(String a_isdefult) {
		this.a_isdefult = a_isdefult;
	}
	
	
	
}
