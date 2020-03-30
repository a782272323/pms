package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.JobLevel;
import learn.lhb.pms.mapper.basis.JobLevelMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.JobLevelService;
import org.springframework.stereotype.Service;

/**
 * 职称等级表业务逻辑层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:16
 */
@Service
public class JobLevelServiceImpl extends AbstractBaseServiceImpl<JobLevel, JobLevelMapper> implements JobLevelService {
}
