package com.hmc.auth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hmc.auth.JwtUtils;
import com.hmc.auth.bean.JwtUser;
import com.hmc.auth.properties.SecurityProperties;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 * @author HHF
 * @Description
 * @create 2020-07-03 下午 5:17
 */
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private SecurityProperties securityProperties;

    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,SecurityProperties securityProperties) {
        this.authenticationManager = authenticationManager;
        this.securityProperties = securityProperties;
        super.setFilterProcessesUrl(securityProperties.getAuth().getLoginUrl());
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        String userName = request.getParameter(securityProperties.getAuth().getUserNameParameter());
        String password = request.getParameter(securityProperties.getAuth().getPasswordParameter());
//        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(password)){
//            unsuccessfulAuthentication(request, response, new UsernameNotFoundException("用户名/密码不能为空"));
//            return null;
//        }
        return authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, password)
        );
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult)  {

        JwtUser jwtUser = (JwtUser) authResult.getPrincipal();
        System.out.println("jwtUser:" + jwtUser.toString());

        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }

        String token = JwtUtils.createToken(jwtUser.getUsername(), role);
        //String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String tokenStr = JwtUtils.TOKEN_PREFIX + token;
        response.setHeader("token",tokenStr);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}

