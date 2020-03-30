package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.Position;
import learn.lhb.pms.mapper.basis.PositionMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.PositionService;
import org.springframework.stereotype.Service;

/**
 * 职位表业务逻辑层的实现类
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 13:19
 */
@Service
public class PositionServiceImpl extends AbstractBaseServiceImpl<Position, PositionMapper> implements PositionService {
}
