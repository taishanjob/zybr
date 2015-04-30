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

    @RequestMapping(value = "/login/input")
    public ModelAndView loginInput() throws Exception {
        return new ModelAndView(Constant.VIEW_LOGIN);
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest request, @Valid LoginCommand loginCommand, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkError(bindingResult);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        if (username.equals(loginCommand.getUsername()) && password.equals(loginCommand.getPassword())) {
            request.getSession().setAttribute(Constant.LOGIN_MARK, Constant.LOGIN_MARK);
        } else {
            redirectAttributes.addFlashAttribute(new ResultMessage(Constant.CODE_FAILURE, "账号或者密码错误，请重新输入"));
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        return CodeTool.redirect(Constant.REDIRECT_MESSAGE);
    }

}
