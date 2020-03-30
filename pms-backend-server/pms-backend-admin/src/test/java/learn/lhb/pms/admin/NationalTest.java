package learn.lhb.pms.admin;

import learn.lhb.pms.domain.basis.National;
import learn.lhb.pms.mapper.basis.NationalMapper;
import learn.lhb.pms.service.NationalService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 民族表测试类
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 12:40
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class NationalTest {

    @Autowired
    private NationalMapper nationalService;

    @Test
    public void queryOne() {
        National national = new National();
        national.setName("汉族");
        System.out.println("id = " + nationalService.getIdByName("汉族").getId());
    }
}
