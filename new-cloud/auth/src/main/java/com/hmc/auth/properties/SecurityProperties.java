package com.hmc.auth.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author zlt
 * @date 2019/1/4
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "hmc.security")
@RefreshScope
public class SecurityProperties {

    private AuthProperties auth = new AuthProperties();

    private PermitProperties ignore = new PermitProperties();

    private SessionProperties session = new SessionProperties();
}
