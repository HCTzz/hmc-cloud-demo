package com.hmc.auth;

import com.hmc.auth.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author HHF
 * @Description
 * @create 2020-06-29 下午 1:44
 */
@EnableConfigurationProperties({SecurityProperties.class})
public class AuthConfigure {


}
