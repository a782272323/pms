package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.Department;
import learn.lhb.pms.mapper.basis.DepartmentMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.DepartmentService;
import org.springframework.stereotype.Service;

/**
 * 部门表，业务逻辑层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 12:04
 */
@Service("departmentService")
public class DepartmentServiceImpl extends AbstractBaseServiceImpl<Department, DepartmentMapper> implements DepartmentService {
}
