package learn.lhb.pms.service;

import learn.lhb.pms.domain.rbac.TbResources;

import java.util.List;

/**
 * 资源表逻辑控制层
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 17:00
 */
public interface TbResourcesService {

    /**
     * 查询资源表中url和角色表中role的对应关系,主要是用来做ant风格的路径匹配
     * @return
     */
    List<TbResources> getAllResources();
}
