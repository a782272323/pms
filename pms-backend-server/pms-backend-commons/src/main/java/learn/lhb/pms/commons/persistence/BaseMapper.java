package learn.lhb.pms.commons.persistence;

import learn.lhb.pms.commons.dto.PageParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 所有数据访问层的基类
 *
 * @author 梁鸿斌
 * @date 2020/3/28.
 * @time 21:51
 */
public interface BaseMapper<T extends BaseEntity> {

    /**
     * 查询全部（分页，排序)
     * @param pageParams
     * @return
     */
    List<T> selectAll(PageParams pageParams);

    /**
     * 查询结果的总笔数
     * @param entity
     * @return
     */
    Integer count(@Param("entity") T entity);

    /**
     * 模糊查询数据（分页，排序)
     * @param pageParams
     * @param entity
     * @return
     */
    List<T> queryAll(@Param("page") PageParams pageParams, @Param("entity") T entity);

//    /**
//     * 单条数据查询（可根据任意字段查询并返回数据）
//     * @param object
//     * @return
//     */
//    T queryOne(@Param("object")Object object);

    /**
     * 任意下拉框数据
     * @return
     */
    List<T> selectDropDownList();
}
