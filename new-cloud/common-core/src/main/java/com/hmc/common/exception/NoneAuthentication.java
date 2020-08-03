package com.hmc.common.exception;

import javax.security.sasl.AuthenticationException;

/**未验证
 * @author HHF
 * @Description
 * @create 2020-06-30 下午 4:18
 */
public class NoneAuthentication extends AuthenticationException {

    private String message ;

    public NoneAuthentication(String message){
        super(message);
        this.message = message;
    }
}
