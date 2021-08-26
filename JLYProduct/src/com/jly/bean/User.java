package com.jly.bean;

public class User {
	private int u_id; //用户id
	private String u_username; //用户名
	private String u_password; //密码
	private String u_nickname; //用户昵称
	private String u_hasstore; //用户是否是商家
	private String u_type;	   //用户类型
	private String u_head_old;	   //用户曾用名
	private String u_head_new;	   //用户新名称
	private String u_head_status;	   //用户身份是否为管理员
	public int getU_id() {
		return u_id;
	}
	public void setU_id(int u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public String getU_hasstore() {
		return u_hasstore;
	}
	public void setU_hasstore(String u_hasstore) {
		this.u_hasstore = u_hasstore;
	}
	public String getU_type() {
		return u_type;
	}
	public void setU_type(String u_type) {
		this.u_type = u_type;
	}
	public String getU_head_old() {
		return u_head_old;
	}
	public void setU_head_old(String u_head_old) {
		this.u_head_old = u_head_old;
	}
	public String getU_head_new() {
		return u_head_new;
	}
	public void setU_head_new(String u_head_new) {
		this.u_head_new = u_head_new;
	}
	public String getU_head_status() {
		return u_head_status;
	}
	public void setU_head_status(String u_head_status) {
		this.u_head_status = u_head_status;
	}
	

}
