package com.zybr.common.misc;

import com.zybr.common.json.ResultMessage;

/**
 * Created by pst on 15-4-23.
 */
public class MessageException extends RuntimeException {

    private ResultMessage resultMessage;

    public MessageException() {
        super();
    }

    public MessageException(ResultMessage resultMessage) {
        super();
        this.resultMessage = resultMessage;
    }

    public MessageException(Throwable cause, ResultMessage resultMessage) {
        super(cause);
        this.resultMessage = resultMessage;
    }

    public ResultMessage getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(ResultMessage resultMessage) {
        this.resultMessage = resultMessage;
    }

}
