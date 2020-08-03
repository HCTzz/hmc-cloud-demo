package com.hmc.auth.config;

import com.hmc.auth.filter.mobile.MobileAuthenticationFilter;
import com.hmc.auth.filter.mobile.MobileAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author HHF
 * @Description
 * @create 2020-07-05 下午 4:47
 */
public class MobileAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {

    @Autowired
    private AuthenticationSuccessHandler successHandler;

    @Autowired
    private AuthenticationFailureHandler failureHandler;

    @Autowired
    private UserDetailsService mobileUserDetailService;

    @Override
    public void configure(HttpSecurity builder) throws Exception {

        // 1. 初始化 SmsCodeAuthenticationFilter
        MobileAuthenticationFilter filter = new MobileAuthenticationFilter();
        filter.setAuthenticationManager(builder.getSharedObject(AuthenticationManager.class));
        filter.setAuthenticationSuccessHandler(successHandler);
        filter.setAuthenticationFailureHandler(failureHandler);

        // 2. 初始化 SmsCodeAuthenticationProvider
        MobileAuthenticationProvider provider = new MobileAuthenticationProvider();
        provider.setUserDetailsService(mobileUserDetailService);

        // 3. 将设置完毕的 Filter 与 Provider 添加到配置中，将自定义的 Filter 加到 UsernamePasswordAuthenticationFilter 之前
        builder.authenticationProvider(provider).addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
    }


}
