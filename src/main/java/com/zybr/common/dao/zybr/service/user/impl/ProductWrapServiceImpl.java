package com.zybr.common.dao.zybr.service.user.impl;

import com.zybr.common.dao.zybr.bean.user.Product;
import com.zybr.common.dao.zybr.param.user.ProductParam;
import com.zybr.common.dao.zybr.service.user.ProductWrapService;
import com.zybr.common.misc.CodeTool;
import org.springframework.stereotype.Controller;

/**
 * Created by pst on 15-4-27.
 */
@Controller
public class ProductWrapServiceImpl extends ProductServiceImpl implements ProductWrapService {

    @Override
    public Product getProduct(Integer id) {
        if (id == null) {
            return null;
        }
        ProductParam productParam = new ProductParam();
        productParam.setId(id);
        return CodeTool.getUniqueBean(selectProduct(productParam));
    }

}
