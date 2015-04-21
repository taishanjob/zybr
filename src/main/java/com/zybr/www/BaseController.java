package com.zybr.www;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by pst on 15-4-21.
 */
public class BaseController {

    protected void write(HttpServletResponse response, String value) throws Exception {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().write(value);
    }

}
