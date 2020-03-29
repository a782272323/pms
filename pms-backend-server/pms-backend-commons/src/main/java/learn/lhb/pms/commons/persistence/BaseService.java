package learn.lhb.pms.commons.persistence;

import learn.lhb.pms.commons.vo.PageParams;

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
}
