package learn.lhb.pms.mapper.basis;

import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.domain.basis.PoliticsStatus;
import org.springframework.stereotype.Repository;

/**
 * 政治面貌表数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:45
 */
@Repository
public interface PoliticsStatusMapper extends BaseMapper<PoliticsStatus> {

    /**
     * 根据名字获取id
     * @param name
     * @return
     */
    PoliticsStatus getIdByName(String name);
}
