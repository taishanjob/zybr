package com.zybr.admin.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.common.dao.zybr.bean.user.ProductType;
import com.zybr.common.dao.zybr.param.user.ProductTypeParam;
import com.zybr.common.dao.zybr.service.user.ProductTypeWrapService;
import com.zybr.common.misc.CodeTool;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import com.zybr.common.misc.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pst on 15-4-29.
 */
@Controller
@RequestMapping("/manage")
public class ProductTypeController extends AdminBaseController {

    @Resource
    private ProductTypeWrapService productTypeWrapService;

    @RequestMapping(value = "/product/type")
    public ModelAndView productType(HttpServletRequest request, PageBean pageBean, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        ProductTypeParam productTypeParam = new ProductTypeParam();
        productTypeParam.setPageBean(pageBean);
        productTypeParam.setOrderView("id desc");
        List<ProductType> productTypeList;
        try {
            productTypeList = productTypeWrapService.selectProductType(productTypeParam);
            pageBean.setTotal(productTypeWrapService.countProductType(productTypeParam));
            pageBean.compute();
        } catch (Exception e) {
            productTypeList = Collections.emptyList();
            logger.error(e.getMessage(), e);
        }

        Map<String, Object> model = new HashMap<>();
        model.put(Constant.IMPORT_MAIN, Constant.IMPORT_PRODUCT_TYPE);
        model.put(Constant.NAV_ACTIVE, Constant.NAV_ACTIVE_PRODUCT_TYPE);
        model.put("productTypeList", productTypeList);
        model.put("pageBean", pageBean);

        return new ModelAndView(Constant.VIEW_MAIN, model);
    }

    @RequestMapping(value = "/product/type/input")
    public ModelAndView productTypeInput(HttpServletRequest request, @RequestParam(value = "id", required = false) Integer id, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        ProductType productType = productTypeWrapService.getProductType(id);

        Map<String, Object> model = new HashMap<>();
        model.put(Constant.IMPORT_MAIN, Constant.IMPORT_PRODUCT_TYPE_INPUT);
        model.put(Constant.NAV_ACTIVE, Constant.NAV_ACTIVE_PRODUCT_TYPE);
        model.put("productType", productType);

        return new ModelAndView(Constant.VIEW_MAIN, model);
    }

    @RequestMapping(value = "/product/type/manage")
    public ModelAndView productTypeManage(HttpServletRequest request, @Valid ProductType productType, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        try {
            checkError(bindingResult);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_PRODUCT_TYPE);
        }

        Integer id = productType.getId();
        if (id == null) {
            productTypeWrapService.insertProductType(productType);
        } else {
            ProductTypeParam productTypeParam = new ProductTypeParam();
            productTypeParam.setId(id);
            productTypeParam.setUpdateProductType(productType);
            productTypeWrapService.updateProductType(productTypeParam);
        }

        return CodeTool.redirect(Constant.REDIRECT_PRODUCT_TYPE);
    }

    @RequestMapping(value = "/product/type/delete")
    public ModelAndView productTypeDelete(HttpServletRequest request, @RequestParam("id") Integer id, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        ProductTypeParam productTypeParam = new ProductTypeParam();
        productTypeParam.setId(id);
        productTypeWrapService.deleteProductType(productTypeParam);

        return CodeTool.redirect(Constant.REDIRECT_PRODUCT_TYPE);
    }

}
