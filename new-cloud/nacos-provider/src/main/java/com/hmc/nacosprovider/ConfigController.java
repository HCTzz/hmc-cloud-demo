package com.hmc.nacosprovider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author HHF
 * @Description
 * @create 2020-06-22 上午 11:15
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${test:no}")
    private String test;

    @RequestMapping("/get")
    public String get() {
        return test;
    }

}
