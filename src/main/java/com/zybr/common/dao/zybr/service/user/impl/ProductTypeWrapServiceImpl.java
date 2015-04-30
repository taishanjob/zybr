package com.zybr.common.dao.zybr.service.user.impl;

import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;
import com.zybr.common.dao.zybr.service.user.ProductTypeWrapService;
import com.zybr.common.misc.CodeTool;
import org.springframework.stereotype.Controller;

/**
 * Created by pst on 15-4-27.
 */
@Controller
public class ProductTypeWrapServiceImpl extends ProductTypeServiceImpl implements ProductTypeWrapService {

    @Override
    public ProductType getProductType(Integer id) {
        if (id == null) {
            return null;
        }
        ProductTypeParam productTypeParam = new ProductTypeParam();
        productTypeParam.setId(id);
        return CodeTool.getUniqueBean(selectProductType(productTypeParam));
    }

}
