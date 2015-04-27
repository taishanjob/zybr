package com.zybr.common.dao.zybr.bean.user;

public class Product {

	private Integer id;//
	private Integer productType;//类型
	private String name;//名称
	private String img;//图片
	private String introduction;//简介
	private String parameter;//参数
	
	public Product() {
	}
	
	public Product(
		Integer id,
		Integer productType, 
		String name, 
		String img, 
		String introduction, 
		String parameter) {
		this.id = id;
		this.productType = productType;
		this.name = name;
		this.img = img;
		this.introduction = introduction;
		this.parameter = parameter;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getProductType() {
		return productType;
	}

	public void setProductType(Integer productType) {
		this.productType = productType;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}
	
	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String getParameter() {
		return parameter;
	}

	public void setParameter(String parameter) {
		this.parameter = parameter;
	}

}