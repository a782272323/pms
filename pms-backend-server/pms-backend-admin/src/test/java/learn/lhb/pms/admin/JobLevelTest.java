package learn.lhb.pms.admin;

import learn.lhb.pms.domain.basis.JobLevel;
import learn.lhb.pms.mapper.basis.JobLevelMapper;
import learn.lhb.pms.service.JobLevelService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JobLevelTest {

    @Autowired
    private JobLevelMapper jobLevelService;

    /**
     *
     */
    @Test
    public void queryOneTest() {
        JobLevel jobLevel = new JobLevel();
        jobLevel.setName("骨灰级工程师");
        System.out.println("id = " + jobLevelService.getIdByName("骨灰级工程师"));
    }
}
