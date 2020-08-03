package com.hmc.auth.filter.mobile;

import com.hmc.auth.bean.JwtUser;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author HHF
 * @Description
 * @create 2020-07-05 下午 4:35
 */
@Component("mobileUserDetailService")
public class MobileUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String mobile) throws UsernameNotFoundException {
        // 按手机号查询用户信息
        return new JwtUser("4000368163", "123", true, true, true,
                true, AuthorityUtils.commaSeparatedStringToAuthorityList("admin"));
    }


}
