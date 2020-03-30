package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.PoliticsStatus;
import learn.lhb.pms.mapper.basis.PoliticsStatusMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.PoliticsStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 政治面貌表业务逻辑层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:51
 */
@Service
public class PoliticsStatusServiceImpl extends AbstractBaseServiceImpl<PoliticsStatus, PoliticsStatusMapper> implements PoliticsStatusService {

    @Autowired
    private PoliticsStatusMapper politicsStatusMapper;

    @Override
    public PoliticsStatus getIdByName(String name) {
        return politicsStatusMapper.getIdByName(name);
    }
}
