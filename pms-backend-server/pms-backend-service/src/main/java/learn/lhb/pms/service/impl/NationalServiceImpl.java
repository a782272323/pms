package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.National;
import learn.lhb.pms.mapper.basis.NationalMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.NationalService;
import org.springframework.stereotype.Service;

/**
 * 民族表业务逻辑层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 12:39
 */
@Service
public class NationalServiceImpl extends AbstractBaseServiceImpl<National, NationalMapper> implements NationalService {
}
