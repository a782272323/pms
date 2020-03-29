package learn.lhb.pms.admin;

import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.service.EmployeeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 01:12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeTest {

    @Resource
    private EmployeeService employeeService;

    @Test
    public void selectAllTest() {
//        System.out.println(BaseResult.ok().put(HttpConstant.OK, HttpConstant.MSG_DEFAULT_OK, DtoParamsConstant.DATA, employeeService.selectAll()));
    }
}
