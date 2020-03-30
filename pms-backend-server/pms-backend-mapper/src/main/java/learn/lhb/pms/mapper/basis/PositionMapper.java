package learn.lhb.pms.mapper.basis;

import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.domain.basis.Position;
import org.springframework.stereotype.Repository;

/**
 * 职位表数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 13:15
 */
@Repository
public interface PositionMapper extends BaseMapper<Position> {

    /**
     * 根据名字获取id
     * @param name
     * @return
     */
    Position getIdByName(String name);
}
