package com.zybr.common.dao.zybr.service.user;

import com.zybr.common.dao.zybr.bean.user.ProductType;

/**
 * Created by pst on 15-4-27.
 */
public interface ProductTypeWrapService extends ProductTypeService {

    ProductType getProductType(Integer id);

}
