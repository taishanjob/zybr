package com.zybr.common.dao.zybr.service.user.impl;

import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.dao.zybr.mapping.user.ProductTypeDao;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;
import com.zybr.common.dao.zybr.service.user.ProductTypeService;
import com.zybr.common.misc.CodeTool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductTypeServiceImpl implements ProductTypeService {

	@Resource
	private ProductTypeDao productTypeDao;

	@Override
	public List<ProductType> selectProductType(ProductTypeParam productTypeParam) {
		return productTypeDao.selectProductType(productTypeParam);
	}

	@Override
	public int countProductType(ProductTypeParam productTypeParam) {
		return productTypeDao.countProductType(productTypeParam);
	}

	@Override
	public void deleteProductType(ProductTypeParam productTypeParam) {
		productTypeDao.deleteProductType(productTypeParam);
	}

	@Override
	public void insertProductType(ProductType productType) {
		productTypeDao.insertProductType(productType);
	}
	
	@Override
	public void insertProductTypeCollection(Collection<ProductType> productTypeCollection) {
		if (CodeTool.isInvalid(productTypeCollection)) {
			return;
		}
		Collection<Collection<ProductType>> splitCollection = CodeTool.splitCollection(productTypeCollection, 500);
		for (Collection<ProductType> collection : splitCollection) {
			productTypeDao.insertProductTypeList(new ArrayList<ProductType>(collection));
		}
	}

	@Override
	public void updateProductType(ProductTypeParam productTypeParam) {
		productTypeDao.updateProductType(productTypeParam);
	}
	
}