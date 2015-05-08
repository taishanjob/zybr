package com.zybr.common.dao.zybr.param.user;

import com.zybr.common.dao.zybr.bean.user.Product;
import com.zybr.common.misc.PageBean;

import java.util.Collection;

public class ProductParam extends Product {

	private Product updateProduct;
	private PageBean pageBean;
	private String groupView;
	private String orderView;
	private Collection<Integer> productIdCollection;
    private String likeName;

    public String getLikeName() {
        if (likeName != null) {
            return "%" + likeName + "%";
        }
        return likeName;
    }

    public void setLikeName(String likeName) {
        this.likeName = likeName;
    }

    public Product getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(Product updateProduct) {
		this.updateProduct = updateProduct;
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
	
	public Collection<Integer> getProductIdCollection() {
		return productIdCollection;
	}

	public void setProductIdCollection(Collection<Integer> productIdCollection) {
		this.productIdCollection = productIdCollection;
	}
	
}
