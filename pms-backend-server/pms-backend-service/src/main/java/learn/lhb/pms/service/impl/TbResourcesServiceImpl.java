package learn.lhb.pms.service.impl;

import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.utils.MapperUtils;
import learn.lhb.pms.domain.rbac.TbAccount;
import learn.lhb.pms.domain.rbac.TbResources;
import learn.lhb.pms.mapper.rbac.TbAccountMapper;
import learn.lhb.pms.mapper.rbac.TbResourcesMapper;
import learn.lhb.pms.service.TbResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.util.List;

/**
 * 资源表逻辑控制层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 17:00
 */
@Service
public class TbResourcesServiceImpl implements TbResourcesService {

    @Resource
    private TbResourcesMapper tbResourcesMapper;



    /**
     * 查询资源表中url和角色表中role的对应关系,主要是用来做ant风格的路径匹配
     * @return
     */
    @Override
    public List<TbResources> getAllResources() {
        return tbResourcesMapper.getAllResources();
    }

    /**
     * 查询资源表和角色表的所有字段的并集
     * @return
     */
    @Override
    public List<TbResources> getAllResourcesWithRole() {
        return tbResourcesMapper.getAllResourcesWithRole();
    }


}
