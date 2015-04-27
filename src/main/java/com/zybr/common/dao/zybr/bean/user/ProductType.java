package com.zybr.common.dao.zybr.bean.user;

public class ProductType {

	private Integer id;//
	private String name;//
	
	public ProductType() {
	}
	
	public ProductType(
		Integer id,
		String name) {
		this.id = id;
		this.name = name;
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

}