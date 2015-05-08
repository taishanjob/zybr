package com.zybr.common.dao.zybr.bean.user;

import com.zybr.common.misc.CodeTool;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Product {

	private Integer id;//
    @NotNull(message = "{product.productType}")
	private Integer productType;//类型
    @NotEmpty(message = "{product.name}")
	private String name;//名称
    @NotEmpty(message = "{product.img}")
	private String img;//图片
    @NotEmpty(message = "{product.introduction}")
	private String introduction;//简介
    @NotEmpty(message = "{product.parameter}")
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

    public String getDescription(){
        String shortIntroduction = "";
        if(introduction != null) {
            try {
                String parserString = CodeTool.parser(introduction);
                if (parserString.length() > 50) {
                    shortIntroduction = parserString.substring(0, 50)+"...";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return shortIntroduction;
    }
}