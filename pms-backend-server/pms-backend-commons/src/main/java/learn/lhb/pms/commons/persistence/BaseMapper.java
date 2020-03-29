package learn.lhb.pms.commons.persistence;

import learn.lhb.pms.commons.vo.PageParams;
import org.springframework.security.core.parameters.P;

import java.util.List;
import java.util.Map;

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
}
