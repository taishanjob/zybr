package com.zybr.common.dao.zybr.service.user;

import java.util.Collection;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;

public interface ProductTypeService {

	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<ProductType> selectProductType(ProductTypeParam productTypeParam);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public int countProductType(ProductTypeParam productTypeParam);
	
	@Transactional
	public void insertProductType(ProductType productType);
	
	@Transactional
	public void insertProductTypeCollection(Collection<ProductType> productTypeCollection);
	
	@Transactional
	public void updateProductType(ProductTypeParam productTypeParam);
	
	@Transactional
	public void deleteProductType(ProductTypeParam productTypeParam);
	
}