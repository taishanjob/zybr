package com.zybr.www.controller;

import com.zybr.common.dao.zybr.bean.user.Message;
import com.zybr.common.dao.zybr.service.user.MessageWrapService;
import com.zybr.common.json.ResultMessage;
import com.zybr.common.misc.CodeTool;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import com.zybr.www.WwwBaseController;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;

/**
 * Created by pst on 15-5-7.
 */
@Controller("WwwManageController")
@RequestMapping("/manage")
public class ManageController extends WwwBaseController {

    @Resource
    private MessageWrapService messageWrapService;

    @RequestMapping(value = "/contactus")
    public ModelAndView contactus(@Valid Message message, BindingResult bindingResult, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkError(bindingResult);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_CONTACTUS);
        }

        message.setCreateTime(new Date());
        messageWrapService.insertMessage(message);

        redirectAttributes.addFlashAttribute(new ResultMessage(Constant.CODE_SUCCESS, "留言成功"));
        return CodeTool.redirect(Constant.REDIRECT_CONTACTUS);
    }

}
