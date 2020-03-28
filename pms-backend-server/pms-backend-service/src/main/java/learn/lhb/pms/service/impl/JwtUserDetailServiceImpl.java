package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.JwtUser;
import learn.lhb.pms.domain.rbac.TbAccount;
import learn.lhb.pms.mapper.rbac.TbAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * UserDetailsService的实现
 * JwtAuthenticationProvider在进行登录信息校验是就会通过它查询用户信息
 *
 * @author 梁鸿斌
 * @date 2020/3/25.
 * @time 10:18
 */
@Component
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Resource
    private TbAccountMapper tbAccountMapper;

    /**日志**/
    private static final Logger LOG = LoggerFactory.getLogger(JwtUserDetailServiceImpl.class);

    @Lazy(true)
    @Autowired
    public JwtUserDetailServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * 数据库查询
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 校验数据库中用户名是否存在
        TbAccount tbAccount = tbAccountMapper.getTbAccountByUsername(username);

        if (tbAccount != null) {
            return new JwtUser(tbAccount.getUsername(), tbAccount.getPassword());
        }
        return null;




//        System.out.println("JwtUserDetailServiceImpl = "+username);
//        if ("admin".equals(username)) {
//            return new JwtUser("admin", passwordEncoder.encode("123456"));
//        }
//        if ("user".equals(username)) {
//            return new JwtUser("user", passwordEncoder.encode("123456"));
//        }
//        return null;

    }
}
