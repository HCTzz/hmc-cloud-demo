package com.hmc.auth.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author HHF
 * @Description
 * @create 2020-06-29 下午 1:54
 */
@Getter
@Setter
public class SessionProperties {

    /**
     * session仓库类型（redis/jdbc）
     */
    private String type = "redis";

    private String cookieName = "";


}
