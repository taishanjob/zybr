package com.zybr.common.dao.zybr.param.user;

import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.misc.PageBean;

import java.util.Collection;

public class ProductTypeParam extends ProductType {

	private ProductType updateProductType;
	private PageBean pageBean;
	private String groupView;
	private String orderView;
	private Collection<Integer> productTypeIdCollection;
    private String likeName;

    public String getLikeName() {
        if (likeName != null) {
            return likeName + "%";
        }
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public ProductType getUpdateProductType() {
		return updateProductType;
	}

	public void setUpdateProductType(ProductType updateProductType) {
		this.updateProductType = updateProductType;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	public String getGroupView() {
		return groupView;
	}

	public void setGroupView(String groupView) {
		this.groupView = groupView;
	}
	
	public String getOrderView() {
		return orderView;
	}

	public void setOrderView(String orderView) {
		this.orderView = orderView;
	}
	
	public Collection<Integer> getProductTypeIdCollection() {
		return productTypeIdCollection;
	}

	public void setProductTypeIdCollection(Collection<Integer> productTypeIdCollection) {
		this.productTypeIdCollection = productTypeIdCollection;
	}
	
}
