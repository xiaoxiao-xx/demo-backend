package com.microcore.center.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * View Model object for storing a user's credentials.
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class LoginVM {

    @NotNull
    @Size(min = 1, max = 50)
    private String username;

    @NotNull
    @Size(min =8, max = 36)
    private String password;

    private Boolean rememberMe;

    @Override
    public String toString() {
        return "LoginVM{" +
            "username='" + username + '\'' +
            ", rememberMe=" + rememberMe +
            '}';
    }
}
