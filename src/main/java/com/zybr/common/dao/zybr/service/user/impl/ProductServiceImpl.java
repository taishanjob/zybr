package com.zybr.common.dao.zybr.service.user.impl;

import com.zybr.common.dao.zybr.bean.user.Product;
import com.zybr.common.dao.zybr.mapping.user.ProductDao;
import com.zybr.common.dao.zybr.param.user.ProductParam;
import com.zybr.common.dao.zybr.service.user.ProductService;
import com.zybr.common.misc.CodeTool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductServiceImpl implements ProductService {

	@Resource
	private ProductDao productDao;

	@Override
	public List<Product> selectProduct(ProductParam productParam) {
		return productDao.selectProduct(productParam);
	}

	@Override
	public int countProduct(ProductParam productParam) {
		return productDao.countProduct(productParam);
	}

	@Override
	public void deleteProduct(ProductParam productParam) {
		productDao.deleteProduct(productParam);
	}

	@Override
	public void insertProduct(Product product) {
		productDao.insertProduct(product);
	}
	
	@Override
	public void insertProductCollection(Collection<Product> productCollection) {
		if (CodeTool.isInvalid(productCollection)) {
			return;
		}
		Collection<Collection<Product>> splitCollection = CodeTool.splitCollection(productCollection, 500);
		for (Collection<Product> collection : splitCollection) {
			productDao.insertProductList(new ArrayList<Product>(collection));
		}
	}

	@Override
	public void updateProduct(ProductParam productParam) {
		productDao.updateProduct(productParam);
	}
	
}