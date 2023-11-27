package com.chenddd.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;

/**
* Author: chenddd
* Date: 2022/4/11 17:03
* FileName: WebSecurityConfig
* Description: SpringSecurity配置类
*/
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MyUserDetailService userDetailService;

    @Autowired
    public WebSecurityConfig(MyUserDetailService userDetailService){
        this.userDetailService = userDetailService;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService);
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/index").permitAll()//放行资源写在前面
                .mvcMatchers("/hello").authenticated()
                .and()
                .formLogin()
                .usernameParameter("uname")
                .passwordParameter("passwd")
                .loginPage("/login.html")
                .loginProcessingUrl("/doLogin")
//                .successForwardUrl("/index")
                .successHandler(new MySuccessHandler())//认证成功处理，前后端分离解决方案
                .failureHandler(new MyFailHandler())
                .and()
                .logout()
                .logoutUrl("/logout")//默认请求方式必须:GET
                //.invalidateHttpSession(true)//默认会话失效
                //.clearAuthentication(true)//默认清除认证标记
                //.logoutSuccessUrl("/login.html")
                .logoutRequestMatcher(new OrRequestMatcher(
                        new AntPathRequestMatcher("/logout","GET"),
                        new AntPathRequestMatcher("/logout","POST")
                ))
                .logoutSuccessHandler(new MyLogoutSuccessHandler())
                .and()
                .csrf().disable();
    }
}
