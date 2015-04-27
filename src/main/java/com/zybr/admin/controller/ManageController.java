package com.zybr.admin.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.admin.command.LoginCommand;
import com.zybr.common.json.ResultMessage;
import com.zybr.common.misc.CodeTool;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Created by pst on 15-4-23.
 */
@Controller
@RequestMapping("/manage")
public class ManageController extends AdminBaseController {

    @Value("${admin.username}")
    private String username;
    @Value("${admin.password}")
    private String password;

    @RequestMapping(value = "/login.html")
    public ModelAndView loginHtml() throws Exception {
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, @Valid LoginCommand loginCommand, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkError(bindingResult);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect("/action/manage/login.html");
        }

        if (username.equals(loginCommand.getUsername()) && password.equals(loginCommand.getPassword())) {
            request.getSession().setAttribute(Constant.LOGIN_MARK, Constant.LOGIN_MARK);
        } else {
            redirectAttributes.addFlashAttribute(new ResultMessage(Constant.CODE_FAILURE, "账号或者密码错误，请重新输入"));
            return CodeTool.redirect("/action/manage/login.html");
        }

        return CodeTool.redirect("welcome");
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome(HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            write(response, CodeTool.toJsonString(e.getResultMessage()));
            return null;
        }
        return new ModelAndView(Constant.VIEW_WELCOME);
    }

}
