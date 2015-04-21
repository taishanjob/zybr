package com.zybr.www.command;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created by pst on 15-4-21.
 */
public class TestCommand extends BaseCommand {

    @Max(value = 100, message = "最大值为100，{fll}")
    @Min(value = 1, message = "最小值为1")
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
