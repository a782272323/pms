package learn.lhb.pms.commons.persistence;

import learn.lhb.pms.commons.dto.PageParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 所有业务逻辑层的基类
 *
 * @author 梁鸿斌
 * @date 2020/3/28.
 * @time 21:51
 */
public interface BaseService<T extends BaseEntity> {

    /**
     * 查询全部数据（分页，排序）
     * @param pageParams
     * @return
     */
    public List<T> selectAll(PageParams pageParams);

    /**
     * 查询结果的总笔数
     * @param entity
     * @return
     */
    public Integer count(T entity);

    /**
     * 模糊查询数据（分页，排序)
     * @param pageParams
     * @param entity
     * @return
     */
    public List<T> queryAll(PageParams pageParams, @Param("entity") T entity);

//    /**
//     * 根据表的某一字段，返回整张表的数据（单个）
//     * @param object
//     * @return
//     */
//    public T queryOne(@Param("object") Object object);

    /**
     * 任意下拉框数据
     * @return
     */
    public List<T> selectDropDownList();
}
