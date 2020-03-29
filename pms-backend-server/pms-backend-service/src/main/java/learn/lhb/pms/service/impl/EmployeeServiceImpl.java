package learn.lhb.pms.service.impl;

import learn.lhb.pms.domain.basis.Employee;
import learn.lhb.pms.commons.vo.PageParams;
import learn.lhb.pms.mapper.basis.EmployeeMapper;
import learn.lhb.pms.service.AbstractBaseServiceImpl;
import learn.lhb.pms.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 员工业务逻辑层实现类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 01:01
 */
@Service
public class EmployeeServiceImpl extends AbstractBaseServiceImpl<Employee, EmployeeMapper> implements EmployeeService  {

    @Resource
    private EmployeeMapper employeeMapper;

//    /**
//     * 获取全部数据
//     * @param  pageParams
//     * @return
//     */
//    @Override
//    public List<Employee> selectAll(PageParams pageParams) {
//        return employeeMapper.selectAll(pageParams);
//    }
}
