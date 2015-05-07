package com.zybr.www.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.common.misc.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pst on 15-4-23.
 */
@Controller("WwwProductController")
@RequestMapping("/product")
public class ProductController extends AdminBaseController {

    @RequestMapping(value = "/list")
    public ModelAndView list() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("source", "products");
        return new ModelAndView(Constant.VIEW_PRODUCTS, model);
    }

}
