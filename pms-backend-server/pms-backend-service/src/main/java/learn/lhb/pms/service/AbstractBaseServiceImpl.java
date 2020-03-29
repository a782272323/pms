package learn.lhb.pms.service;

import learn.lhb.pms.commons.persistence.BaseEntity;
import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.commons.persistence.BaseService;
import learn.lhb.pms.commons.vo.PageParams;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 所有业务逻辑层的实现类的抽象基类(ServiceImpl)
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 18:01
 */
public class AbstractBaseServiceImpl<T extends BaseEntity, M extends BaseMapper<T>> implements BaseService<T> {

    /**
     * 注入Mapper
     */
    @Resource
    protected M mapper;

    /**
     * 查询全部数据（分页，排序）
     * @param pageParams
     * @return
     */
    @Override
    public List<T> selectAll(PageParams pageParams) {
        return mapper.selectAll(pageParams);
    }
}
