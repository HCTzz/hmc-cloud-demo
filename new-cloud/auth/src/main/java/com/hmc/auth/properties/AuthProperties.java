package com.hmc.auth.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 认证配置
 *
 * @author zlt
 */
@Setter
@Getter
public class AuthProperties {
    /**
     * 配置要认证的url（默认不需要配置）
     *
     * 优先级大于忽略认证配置
     * 意思是如果同一个url同时配置了`忽略认证`和`需要认证`，则该url还是会被认证
     */
    private String[] httpUrls = {};

    private String loginUrl;

    private String passwordParameter = "userName";

    private String userNameParameter = "password";

    private String loginoutUrl;

    private int maximumSessions = 1;

    private boolean maxSessionsPreventsLogin = true;

}
