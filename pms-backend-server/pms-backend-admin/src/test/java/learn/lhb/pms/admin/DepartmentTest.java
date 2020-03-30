package learn.lhb.pms.admin;

import learn.lhb.pms.domain.basis.Department;
import learn.lhb.pms.mapper.basis.DepartmentMapper;
import learn.lhb.pms.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 12:13
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DepartmentTest {

    @Resource
    private DepartmentMapper departmentService;

    /**
     * 根据某一任意字段查询任意字段
     */
    @Test
    public void selectOne() {
        Department department = new Department();
        department.setName("股东会");
        System.out.println("id = " + departmentService.getIdByName("股东会"));
    }
}
