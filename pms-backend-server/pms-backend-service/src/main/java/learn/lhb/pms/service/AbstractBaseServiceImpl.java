package learn.lhb.pms.service;

import com.github.pagehelper.PageHelper;
import learn.lhb.pms.commons.persistence.BaseEntity;
import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.commons.persistence.BaseService;
import learn.lhb.pms.commons.dto.PageParams;
import org.springframework.beans.factory.annotation.Autowired;

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
    @Autowired
    protected M mapper;

    /**
     * 查询全部数据（分页，排序）
     * @param pageParams
     * @return
     */
    @Override
    public List<T> selectAll(PageParams pageParams) {
        PageHelper.startPage(pageParams.getPageIndex(),pageParams.getPageSize());
        return mapper.selectAll(pageParams);
    }

    /**
     * 查询结果的总笔数
     * @param entity
     * @return
     */
    @Override
    public Integer count(T entity) {
        return mapper.count(entity);
    }

    /**
     * 模糊查询数据（分页，排序)
     * @param pageParams
     * @param entity
     * @return
     */
    @Override
    public List<T> queryAll(PageParams pageParams, T entity) {
        PageHelper.startPage(pageParams.getPageIndex(),pageParams.getPageSize());
        return mapper.queryAll(pageParams,entity);
    }

    /**
     * 任意下拉框数据
     * @return
     */
    @Override
    public List<T> selectDropDownList() {
        return mapper.selectDropDownList();
    }

//    /**
//     * 根据表的某一字段，返回整张表的数据（单个）
//     * @param object
//     * @return
//     */
//    @Override
//    public T queryOne(Object object) {
//        return mapper.queryOne(object);
//    }


}
