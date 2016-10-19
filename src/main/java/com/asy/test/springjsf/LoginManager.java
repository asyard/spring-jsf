package com.asy.test.springjsf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by asy
 */

@ManagedBean(name = "loginManager")
@RequestScoped
public class LoginManager {

    private static final Logger logger = LoggerFactory.getLogger(LoginManager.class);



}
