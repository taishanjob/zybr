package com.zybr.www.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.common.misc.Constant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pst on 15-4-23.
 */
@Controller
@RequestMapping("/www")
public class ForwardController extends AdminBaseController {

    @RequestMapping(value = "/index")
    public ModelAndView index() throws Exception {
        return new ModelAndView(Constant.VIEW_INDEX);
    }

}
