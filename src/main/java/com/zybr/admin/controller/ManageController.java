package com.zybr.admin.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.common.misc.Constant;
import com.zybr.www.command.TestCommand;
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
 * Created by pst on 15-4-23.
 */
@Controller
@RequestMapping("/manage")
public class ManageController extends AdminBaseController {

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletResponse response, @Valid TestCommand testCommand, BindingResult bindingResult) throws Exception {
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
        return new ModelAndView(Constant.VIEW_LOGIN, map);
    }

}
