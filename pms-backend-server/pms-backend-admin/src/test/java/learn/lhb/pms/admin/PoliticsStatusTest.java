package learn.lhb.pms.admin;

import learn.lhb.pms.commons.dto.basic.EmployeeSortDto;
import learn.lhb.pms.domain.basis.Employee;
import learn.lhb.pms.domain.basis.PoliticsStatus;
import learn.lhb.pms.mapper.basis.PoliticsStatusMapper;
import learn.lhb.pms.service.PoliticsStatusService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.parameters.P;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 政治面貌表测试用例
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PoliticsStatusTest {

    @Autowired
    private PoliticsStatusService politicsStatusMapper;

    /**
     *
     */
    @Test
    public void queryOneTest() {
        PoliticsStatus politicsStatus = new PoliticsStatus();
        politicsStatus.setName("普通公民");
        EmployeeSortDto employeeSortDto = new EmployeeSortDto();
        employeeSortDto.setPoliticsName("普通公民");
        System.out.println(employeeSortDto.getPoliticsName()+" , "+employeeSortDto.getPoliticsName().getClass());
        System.out.println("id = "+politicsStatusMapper.getIdByName(employeeSortDto.getPoliticsName()).getId()+", "+politicsStatusMapper.getIdByName("普通公民").getId().getClass());
        Employee employee = new Employee();
//        if (politicsStatusMapper.getIdByName(employeeSortDto.getPositionName()).getId() == null) {
//            System.out.println("为空");
//        }
//        employee.setPoliticId(politicsStatusMapper.getIdByName("普通公民").getId());
        employee.setPoliticId(politicsStatusMapper.getIdByName(employeeSortDto.getPoliticsName()).getId());
//        employee.setPoliticId(politicsStatusMapper.getIdByName(employeeSortDto.getPositionName()).getId());
        System.out.println(employee.getPoliticId());
    }
}
