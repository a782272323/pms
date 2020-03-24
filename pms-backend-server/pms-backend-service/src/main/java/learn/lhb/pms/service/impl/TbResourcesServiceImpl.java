package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.rbac.TbResources;
import learn.lhb.pms.mapper.rbac.TbResourcesMapper;
import learn.lhb.pms.service.TbResourcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private TbResourcesMapper tbResourcesMapper;

    /**
     * 查询资源表中url和角色表中role的对应关系,主要是用来做ant风格的路径匹配
     * @return
     */
    @Override
    public List<TbResources> getAllResources() {
        return tbResourcesMapper.getAllResources();
    }
}
