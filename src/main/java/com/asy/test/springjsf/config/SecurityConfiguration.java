package com.asy.test.springjsf.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by asy
 */

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        logger.debug("adding users");
        auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("pass").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("dba").password("pass").roles("ADMIN","DBA");//dba have two roles.
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        logger.debug("configuring");
        http.authorizeRequests()
                .antMatchers("/", "/index.xhtml", "/login.xhtml", "/login").permitAll()
                .antMatchers("/javax.faces.resource/**").permitAll()
                //.antMatchers("/admin/**").access("hasRole('ADMIN')")
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest().authenticated()
                .and().formLogin().loginPage("/login.xhtml").usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/pages/menu.xhtml").permitAll()
                .and().exceptionHandling().accessDeniedPage("/login.xhtml?error=denied")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/index.xhtml").permitAll();


        http.csrf().disable();

    }




}