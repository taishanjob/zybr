package com.zybr.www.controller;

import com.zybr.common.dao.zybr.bean.user.Product;
import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.dao.zybr.param.user.ProductParam;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;
import com.zybr.common.dao.zybr.service.user.ProductTypeWrapService;
import com.zybr.common.dao.zybr.service.user.ProductWrapService;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.PageBean;
import com.zybr.www.WwwBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pst on 15-4-23.
 */
@Controller("WwwProductController")
@RequestMapping("/product")
public class ProductController extends WwwBaseController {

    @Resource
    private ProductWrapService productWrapService;
    @Resource
    private ProductTypeWrapService productTypeWrapService;

    @RequestMapping(value = "/list")
    public ModelAndView list(@RequestParam(value = "id", required = false) Integer id, PageBean pageBean) throws Exception {
        ProductParam productParam = new ProductParam();
        if (id != null && id > 0){
            productParam.setProductType(id);
        }
        pageBean.setRows(1);
        productParam.setPageBean(pageBean);
        productParam.setOrderView("id desc");
        List<Product> productList;
        List<ProductType> productTypeList;
        ProductType productType = new ProductType(0, "全部产品");
        try {
            productList = productWrapService.selectProduct(productParam);
            pageBean.setTotal(productWrapService.countProduct(productParam));
            pageBean.compute();
            ProductTypeParam productTypeParam = new ProductTypeParam();
            productTypeList = productTypeWrapService.selectProductType(productTypeParam);
            if (id != null && id > 0 && productTypeList != null) {
                for (ProductType productTypeItem : productTypeList){
                    if (productTypeItem.getId() == id){
                        productType = productTypeItem;
                    }
                }
            }
        } catch (Exception e) {
            productList = Collections.emptyList();
            productTypeList = Collections.emptyList();
            logger.error(e.getMessage(), e);
        }

        Map<String, Object> model = new HashMap<>();
        model.put("productList", productList);
        model.put("productTypeList", productTypeList);
        model.put("productType", productType);
        model.put("pageBean", pageBean);
        model.put("source", "products");
        return new ModelAndView(Constant.VIEW_PRODUCTS, model);
    }

    @RequestMapping(value = "/detail")
    public ModelAndView list(@RequestParam(value = "id", required = false) Integer id) throws Exception {
        Product product = null;
        List<ProductType> productTypeList;
        try {
            product = productWrapService.getProduct(id);
            ProductTypeParam productTypeParam = new ProductTypeParam();
            productTypeList = productTypeWrapService.selectProductType(productTypeParam);
        } catch (Exception e) {
            productTypeList = Collections.emptyList();
            logger.error(e.getMessage(), e);
        }


        Map<String, Object> model = new HashMap<>();
        model.put("productTypeList", productTypeList);
        model.put("product", product);
        model.put("source", "products");
        return new ModelAndView(Constant.VIEW_DETAIL, model);
    }
}
