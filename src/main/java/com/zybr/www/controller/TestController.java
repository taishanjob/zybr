package com.zybr.www.controller;

import com.zybr.common.misc.Constant;
import com.zybr.www.WwwBaseController;
import com.zybr.www.command.TestCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pst on 15-4-21.
 */
@Controller
@RequestMapping("/test")
public class TestController extends WwwBaseController {

    @RequestMapping(value = "/t")
    public ModelAndView test(HttpServletResponse response, @Valid TestCommand testCommand, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                sb.append(objectError.getDefaultMessage());
            }
            write(response, sb.toString());
            return null;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("ok", "哈哈哈是");
        return new ModelAndView(Constant.VIEW_MAIN, map);
    }

}
