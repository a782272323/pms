package learn.lhb.pms.admin;

import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.mapper.rbac.TbResourcesMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 13:34
 */
@SpringBootTest(value = "PmsAdminApplication.class")
@RunWith(SpringRunner.class)
public class LoginTest {

    @Autowired
    private TbResourcesMapper tbResourcesMapper;


    @Test
    public void BaseResultTest() {
        BaseResult baseResult = BaseResult.error();
        baseResult = BaseResult.error(HttpConstant.MSG_USERNAME_ERROR);
        System.out.println(baseResult);
    }

    @Test
    public void t1Test() {
        System.out.println(tbResourcesMapper.getAllResources());
    }

    @Test
    public void getUrlByRoleNameTest() {
        System.out.println(tbResourcesMapper.getUrlByRoleName("ROLE_ADMIN"));
    }

}
