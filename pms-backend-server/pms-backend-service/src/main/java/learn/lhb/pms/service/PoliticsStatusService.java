package learn.lhb.pms.service;

import learn.lhb.pms.commons.persistence.BaseService;
import learn.lhb.pms.domain.basis.PoliticsStatus;

/**
 * 政治面貌表业务逻辑层
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:50
 */
public interface PoliticsStatusService extends BaseService<PoliticsStatus> {

    /**
     * 根据名字获取id
     * @param name
     * @return
     */
    PoliticsStatus getIdByName(String name);
}
