package com.zybr.admin.controller;

import com.zybr.admin.AdminBaseController;
import com.zybr.common.dao.zybr.bean.user.Message;
import com.zybr.common.dao.zybr.param.user.MessageParam;
import com.zybr.common.dao.zybr.service.user.MessageWrapService;
import com.zybr.common.misc.CodeTool;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import com.zybr.common.misc.PageBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pst on 15-4-29.
 */
@Controller
@RequestMapping("/manage")
public class MessageController extends AdminBaseController {

    @Resource
    private MessageWrapService messageWrapService;

    @RequestMapping(value = "/message")
    public ModelAndView message(HttpServletRequest request, PageBean pageBean, RedirectAttributes redirectAttributes) throws Exception {
        try {
            checkLogin(request);
        } catch (MessageException e) {
            redirectAttributes.addFlashAttribute(e.getResultMessage());
            return CodeTool.redirect(Constant.REDIRECT_LOGIN_INPUT);
        }

        MessageParam messageParam = new MessageParam();
        messageParam.setPageBean(pageBean);
        messageParam.setOrderView("id desc");
        List<Message> messageList;
        try {
            messageList = messageWrapService.selectMessage(messageParam);
            pageBean.setTotal(messageWrapService.countMessage(messageParam));
            pageBean.compute();
        } catch (Exception e) {
            messageList = Collections.emptyList();
            logger.error(e.getMessage(), e);
        }

        Map<String, Object> model = new HashMap<>();
        model.put(Constant.IMPORT_MAIN, Constant.IMPORT_MESSAGE);
        model.put(Constant.NAV_ACTIVE, Constant.NAV_ACTIVE_MESSAGE);
        model.put("messageList", messageList);
        model.put("pageBean", pageBean);

        return new ModelAndView(Constant.VIEW_MAIN, model);
    }

}
