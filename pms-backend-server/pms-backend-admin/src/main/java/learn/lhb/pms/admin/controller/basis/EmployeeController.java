package learn.lhb.pms.admin.controller.basis;

import com.google.common.collect.Maps;
import learn.lhb.pms.admin.abstracts.AbstractBaseController;
import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.dto.PageParams;
import learn.lhb.pms.commons.dto.basic.EmployeeSortDto;
import learn.lhb.pms.domain.basis.Employee;
import learn.lhb.pms.mapper.basis.DepartmentMapper;
import learn.lhb.pms.mapper.basis.JobLevelMapper;
import learn.lhb.pms.mapper.basis.NationalMapper;
import learn.lhb.pms.mapper.basis.PositionMapper;
import learn.lhb.pms.service.EmployeeService;
import learn.lhb.pms.service.PoliticsStatusService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 员工资料
 * 基本资料，高级资料
 *
 * @author 梁鸿斌
 * @date 2020/3/28.
 * @time 21:49
 */
@RestController
@RequestMapping("/v1/employee")
public class EmployeeController extends AbstractBaseController<Employee, EmployeeService> {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private PoliticsStatusService politicsStatusService;

    @Autowired
    private NationalMapper nationalMapper;

    @Autowired
    private PositionMapper positionMapper;

    @Autowired
    private JobLevelMapper jobLevelMapper;

    /**
     * 模糊查询，重写
     * @param authentication
     * @return
     */
    @GetMapping("listss")
    public BaseResult queryAll(Authentication authentication, PageParams pageParams,@RequestBody EmployeeSortDto employeeSortDto) {
        LOG.trace("重写的模糊查询");
        LOG.trace(pageParams.toString());
        LOG.trace(employeeSortDto.toString());

        // 把前端传过来的数据传入实体类
        Employee employee = new Employee();
        // 判断从前端获取的值是否为空
        if (StringUtils.isNotBlank(employeeSortDto.getName())) {
            employee.setName(employeeSortDto.getName());
        }
        if (StringUtils.isNotBlank(employeeSortDto.getPoliticsName())) {
            employee.setPoliticId(politicsStatusService.getIdByName(employeeSortDto.getPoliticsName()).getId());
        }
        if (StringUtils.isNotBlank(employeeSortDto.getNationalName())) {
            employee.setNationalId(nationalMapper.getIdByName(employeeSortDto.getNationalName()).getId());
        }
        if (StringUtils.isNotBlank(employeeSortDto.getPositionName())) {
            employee.setPositionalId(positionMapper.getIdByName(employeeSortDto.getPositionName()).getId());
        }
        if (StringUtils.isNotBlank(employeeSortDto.getJobLevelName())) {
            employee.setJobLevelId(jobLevelMapper.getIdByName(employeeSortDto.getJobLevelName()).getId());
        }
        if (StringUtils.isNotBlank(employeeSortDto.getEngageForm())) {
            employee.setEngageForm(employeeSortDto.getEngageForm());
        }
        if (StringUtils.isNotBlank(employeeSortDto.getDepartmentName())) {
            employee.setDepartmentId(departmentMapper.getIdByName(employeeSortDto.getDepartmentName()).getId());
        }
        LOG.info(employee.toString());
        Map<String, Object> map = Maps.newHashMap();
        map.put(DtoParamsConstant.LIST, employeeService.queryAll(pageParams, employee));
        map.put(DtoParamsConstant.COUNT, employeeService.count(employee));
        return BaseResult.ok().put(HttpConstant.OK,HttpConstant.MSG_DEFAULT_OK,DtoParamsConstant.DATA,map);
    }
}
