package com.hmc.getaway.config;

import com.hmc.auth.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseCookie;
import org.springframework.web.server.session.CookieWebSessionIdResolver;
import org.springframework.web.server.session.WebSessionIdResolver;

import java.util.function.Consumer;

/**
 * @author HHF
 * @Description
 * @create 2020-07-03 下午 3:05
 */
//@Configuration
//@EnableRedisWebSession
public class WebSessionConfig {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public WebSessionIdResolver webSessionIdResolver() {
        CookieWebSessionIdResolver resolver = new MyCookieWebSessionIdResolver();
        resolver.setCookieName(securityProperties.getSession().getCookieName());
        Consumer<ResponseCookie.ResponseCookieBuilder> consumer = responseCookieBuilder -> {
            responseCookieBuilder.path("/");
        };
        resolver.addCookieInitializer(consumer);
        return resolver;
    }

}
