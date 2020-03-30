package learn.lhb.pms.admin;

import learn.lhb.pms.domain.basis.Position;
import learn.lhb.pms.mapper.basis.PositionMapper;
import learn.lhb.pms.service.PositionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 职位表测试用例
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 13:24
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PositionTest {

    @Autowired
    private PositionMapper positionService;

    /**
     * 单条数据查询（可根据任意字段查询并返回数据）
     */
    @Test
    public void queryOneTest() {
        Position position = new Position();
        position.setName("研发工程师");
        System.out.println("id = " + positionService.getIdByName("研发工程师"));
    }
}
