package learn.lhb.pms.service.impl;

import com.google.common.collect.Lists;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.utils.MapperUtils;
import learn.lhb.pms.domain.rbac.TbAccount;
import learn.lhb.pms.mapper.rbac.TbAccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbAccount tbAccount = tbAccountMapper.loadUserByUsername(username);
        if (tbAccount == null) {
            throw new UsernameNotFoundException(MapperUtils.mapToJson(BaseResult.error(HttpConstant.MSG_USERNAME_ERROR)));
        } else {
            List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
            // 授权
            String roles = "USER,ROLE";
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles);
            grantedAuthorities.add(grantedAuthority);
            // 返回的密码不用加密，只用加密后存储在数据库就行
            return new User(tbAccount.getUsername(), tbAccount.getPassword(), grantedAuthorities);
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        TbAccount tbAccount = tbAccountMapper.loadUserByUsername(username);
//        if (tbAccount == null) {
//            throw new UsernameNotFoundException(MapperUtils.mapToJson(BaseResult.error(HttpConstant.MSG_USERNAME_ERROR)));
//        }
//        return tbAccount;
//    }


}
