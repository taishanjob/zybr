package com.zybr.common.dao.zybr.mapping.user;

import java.util.List;
import com.zybr.common.dao.zybr.param.user.ProductParam;
import com.zybr.common.dao.zybr.bean.user.Product;

public interface ProductDao {

	public List<Product> selectProduct(ProductParam productParam);

	public int countProduct(ProductParam productParam);
	
	public void insertProduct(Product product);
	
	public void insertProductList(List<Product> productList);
	
	public void updateProduct(ProductParam productParam);
	
	public void deleteProduct(ProductParam productParam);
	
}