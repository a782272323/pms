package learn.lhb.pms.service.impl;

import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.utils.MapperUtils;
import learn.lhb.pms.domain.rbac.TbAccount;
import learn.lhb.pms.mapper.rbac.TbAccountMapper;
import learn.lhb.pms.service.TbAccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 用户表逻辑控制层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:56
 */
@Service
@Transactional
public class TbAccountServiceImpl implements TbAccountService {

    @Resource
    private TbAccountMapper tbAccountMapper;

}
