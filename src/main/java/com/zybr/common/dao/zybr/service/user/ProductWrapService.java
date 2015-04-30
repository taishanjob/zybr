package com.zybr.common.dao.zybr.service.user;

import com.zybr.common.dao.zybr.bean.user.Product;

/**
 * Created by pst on 15-4-27.
 */
public interface ProductWrapService extends ProductService {

    Product getProduct(Integer id);

}
