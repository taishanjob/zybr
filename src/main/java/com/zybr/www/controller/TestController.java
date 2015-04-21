package com.zybr.www.controller;

import com.zybr.www.BaseController;
import com.zybr.www.command.TestCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by pst on 15-4-21.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController {

    @Value("${aa}")
    private String ss;

    @RequestMapping(value = "/t")
    public void test(HttpServletResponse response, @Valid TestCommand testCommand, BindingResult bindingResult) throws Exception {
        if (bindingResult.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                sb.append(objectError.getDefaultMessage());
            }
            response.setContentType("text/html;charset=UTF-8");
            response.getWriter().write(sb.toString());
            return;
        }
        response.getWriter().write("ok " + ss);
    }

}
