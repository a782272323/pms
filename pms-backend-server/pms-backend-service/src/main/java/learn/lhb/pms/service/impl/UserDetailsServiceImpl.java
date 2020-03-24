package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.rbac.TbAccount;
import learn.lhb.pms.mapper.TbAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.LinkedList;
import java.util.List;

/**
 * 自定义认证校验
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 17:28
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "$2a$10$XFSfCISi8m1IVURYQt7u5OE1aqiNfkCkCYsD4AF/nqzrG7vUaRXUu";

    @Autowired
    private TbAccountMapper tbAccountMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 用户名匹配
        if (username.equals(USERNAME)) {
            List<GrantedAuthority> grantedAuthorities = new LinkedList<>();
            // 授权
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("USER");
            grantedAuthorities.add(grantedAuthority);
            return new User(USERNAME, PASSWORD, grantedAuthorities);
        }
        // 不匹配
        else {
            return null;
        }
    }
}
