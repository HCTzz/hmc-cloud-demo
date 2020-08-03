package com.hmc.common.exception;

/**分布式锁异常
 * @author HHF
 * @Description
 * @create 2020-06-29 上午 10:08
 */
public class LockException extends RuntimeException{

    private static final long serialVersionUID = 6610083281801529147L;

    public LockException(String message) {
        super(message);
    }

}
