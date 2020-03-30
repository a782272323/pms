package learn.lhb.pms.mapper.basis;

import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.domain.basis.JobLevel;
import org.springframework.stereotype.Repository;

/**
 * 职称等级表数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:09
 */
@Repository
public interface JobLevelMapper extends BaseMapper<JobLevel> {

    /**
     * 根据名字获取id
     * @param name
     * @return
     */
    JobLevel getIdByName(String name);
}
