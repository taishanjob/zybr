package com.zybr.common.dao.zybr.mapping.user;

import java.util.List;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;
import com.zybr.common.dao.zybr.bean.user.ProductType;

public interface ProductTypeDao {

	public List<ProductType> selectProductType(ProductTypeParam productTypeParam);

	public int countProductType(ProductTypeParam productTypeParam);
	
	public void insertProductType(ProductType productType);
	
	public void insertProductTypeList(List<ProductType> productTypeList);
	
	public void updateProductType(ProductTypeParam productTypeParam);
	
	public void deleteProductType(ProductTypeParam productTypeParam);
	
}