package learn.lhb.pms.admin.controller.basis;

import com.github.pagehelper.PageHelper;
import learn.lhb.pms.admin.abstracts.AbstractBaseController;
import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.vo.PageParams;
import learn.lhb.pms.domain.basis.Employee;
import learn.lhb.pms.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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

    @Resource
    private EmployeeService employeeService;

//    /**
//     * 获取全部信息
//     * @param authentication
//     * @return
//     */
//    @GetMapping("list")
//    public BaseResult list(Authentication authentication, @RequestBody PageParams pageParams) {
//        LOG.debug("获取全部员工数据用于加载页面");
//        LOG.debug(pageParams.toString());
//        PageHelper.startPage(pageParams.getPageIndex(), pageParams.getPageSize());
//        return BaseResult.ok().put(HttpConstant.OK,HttpConstant.MSG_DEFAULT_OK,
//                DtoParamsConstant.DATA,employeeService.selectAll(pageParams));
//    }
}
