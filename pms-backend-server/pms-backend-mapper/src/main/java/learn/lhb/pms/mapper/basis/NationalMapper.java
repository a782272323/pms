package learn.lhb.pms.mapper.basis;

import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.domain.basis.National;
import org.springframework.stereotype.Repository;

/**
 * 民族表，数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 12:36
 */
@Repository
public interface NationalMapper extends BaseMapper<National> {

    /**
     * 根据名字获取id
     * @param name
     * @return
     */
    National getIdByName(String name);
}
