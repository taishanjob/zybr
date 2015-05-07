package com.zybr.www.controller;

import com.zybr.common.misc.Constant;
import com.zybr.www.WwwBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pst on 15-4-23.
 */
@Controller
@RequestMapping("/static")
public class ForwardController extends WwwBaseController {

    @RequestMapping(value = "/index")
    public ModelAndView index() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("source", "index");
        return new ModelAndView(Constant.VIEW_INDEX, model);
    }

    @RequestMapping(value = "/contactus")
    public ModelAndView contactus() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("source", "contactus");
        return new ModelAndView(Constant.VIEW_CONTACTUS, model);
    }

    @RequestMapping(value = "/recruitment")
    public ModelAndView recruitment() throws Exception {
        Map<String, Object> model = new HashMap<>();
        model.put("source", "recruitment");
        return new ModelAndView(Constant.VIEW_RECRUITMENT, model);
    }

}
