package learn.lhb.pms.admin.abstracts;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.PageParams;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.persistence.BaseEntity;
import learn.lhb.pms.commons.persistence.BaseService;
import learn.lhb.pms.domain.basis.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 所有Controller的抽象类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 18:01
 */
public class AbstractBaseController<T extends BaseEntity, S extends BaseService<T>>{

    private static final Logger LOG = LoggerFactory.getLogger(AbstractBaseController.class);

    /**
     * 注入业务逻辑层
     */
    @Autowired
    private S service;

    /**
     * 查询全部信息
     * @param authentication
     * @param pageParams
     * @param entity
     * @return
     */
    @GetMapping("list")
    public BaseResult selectAll(Authentication authentication, @RequestBody PageParams pageParams, T entity) {
        LOG.trace("查询全部信息");
        LOG.trace(pageParams.toString());
        LOG.trace(entity.toString());
        Map<String, Object> map = Maps.newHashMap();
        // 查询数据
        map.put(DtoParamsConstant.LIST, service.selectAll(pageParams));
        // 查询数据的条数
        map.put(DtoParamsConstant.COUNT, service.count(entity));
        return BaseResult.ok().put(HttpConstant.OK,HttpConstant.MSG_DEFAULT_OK,DtoParamsConstant.DATA,map);
    }

    /**
     * 模糊查询
     * @param authentication
     * @param pageParams
     * @param entity
     * @return
     */
    @GetMapping("lists")
    public BaseResult queryAll(Authentication authentication, PageParams pageParams, T entity) {
        LOG.trace("模糊查询");
        LOG.trace(pageParams.toString());
        LOG.trace(entity.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put(DtoParamsConstant.LIST, service.queryAll(pageParams, entity));
        map.put(DtoParamsConstant.COUNT, service.count(entity));
        return BaseResult.ok().put(HttpConstant.OK, HttpConstant.MSG_DEFAULT_OK, DtoParamsConstant.DATA, map);
    }

}
