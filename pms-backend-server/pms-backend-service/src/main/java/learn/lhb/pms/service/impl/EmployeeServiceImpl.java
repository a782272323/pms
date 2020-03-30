package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.Employee;
import learn.lhb.pms.mapper.basis.EmployeeMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 员工业务逻辑层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 01:01
 */
@Service("employeeService")
public class EmployeeServiceImpl extends AbstractBaseServiceImpl<Employee, EmployeeMapper> implements EmployeeService  {

    @Resource
    private EmployeeMapper employeeMapper;

}
