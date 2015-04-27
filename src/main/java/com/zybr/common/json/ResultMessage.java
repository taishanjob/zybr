package com.zybr.common.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pst on 15-4-23.
 */
public class ResultMessage {

    private int code;
    private List<String> msg;

    public ResultMessage() {
    }

    public ResultMessage(int code, String format, Object... args) {
        this.code = code;
        this.msg = Arrays.asList(String.format(format, args));
    }

    public ResultMessage(int code, List<String> msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<String> getMsg() {
        return msg;
    }

    public void setMsg(List<String> msg) {
        this.msg = msg;
    }
}
