package com.zybr;

import com.zybr.common.json.ResultMessage;
import com.zybr.common.misc.Constant;
import com.zybr.common.misc.MessageException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pst on 15-4-23.
 */
public abstract class BaseController {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected void write(HttpServletResponse response, String value) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(value);
    }

    protected void checkLogin(HttpServletRequest request) throws MessageException {
        HttpSession session = request.getSession();
        if (session.getAttribute(Constant.LOGIN_MARK) == null) {
            throw new MessageException(new ResultMessage(Constant.CODE_FAILURE, "请登陆以后再操作"));
        }
    }

    protected void checkError(BindingResult bindingResult) throws MessageException {
        if (bindingResult.hasErrors()) {
            List<String> messageList = new ArrayList<>();
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError objectError : allErrors) {
                messageList.add(objectError.getDefaultMessage());
            }
            throw new MessageException(new ResultMessage(Constant.CODE_FAILURE, messageList));
        }
    }

}
