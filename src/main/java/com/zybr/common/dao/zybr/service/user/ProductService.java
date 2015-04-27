package com.zybr.common.dao.zybr.service.user;

import java.util.Collection;
import java.util.List;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.zybr.common.dao.zybr.bean.user.Product;
import com.zybr.common.dao.zybr.param.user.ProductParam;

public interface ProductService {

	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public List<Product> selectProduct(ProductParam productParam);
	
	@Transactional(propagation=Propagation.NOT_SUPPORTED, readOnly=true)
	public int countProduct(ProductParam productParam);
	
	@Transactional
	public void insertProduct(Product product);
	
	@Transactional
	public void insertProductCollection(Collection<Product> productCollection);
	
	@Transactional
	public void updateProduct(ProductParam productParam);
	
	@Transactional
	public void deleteProduct(ProductParam productParam);
	
}