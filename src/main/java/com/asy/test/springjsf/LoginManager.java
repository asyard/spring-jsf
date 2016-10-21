package com.asy.test.springjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Created by asy
 */

@ManagedBean(name = "loginManager")
@RequestScoped
public class LoginManager {

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);

    public String loggedInUser;

    public String getLoggedInUser() {
        loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return loggedInUser;
    }
}
