package com.zybr.admin.command;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by pst on 15-4-23.
 */
public class LoginCommand {

    @NotEmpty(message = "{login.username}")
    private String username;
    @NotEmpty(message = "{login.password}")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
