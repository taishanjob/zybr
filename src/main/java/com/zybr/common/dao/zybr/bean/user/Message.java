package com.zybr.common.dao.zybr.bean.user;

import java.util.Date;

public class Message {

	private Integer id;//
	private String name;//
	private String company;//公司
	private String email;//
	private String phone;//
	private String message;//留言内容
	private Date createTime;//创建时间
	
	public Message() {
	}
	
	public Message(
		Integer id,
		String name, 
		String company, 
		String email, 
		String phone, 
		String message, 
		Date createTime) {
		this.id = id;
		this.name = name;
		this.company = company;
		this.email = email;
		this.phone = phone;
		this.message = message;
		this.createTime = createTime;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}