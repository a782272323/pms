package learn.lhb.pms.admin;

import learn.lhb.pms.commons.dto.BaseResult;
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
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 测试密码加密
     */
    @Test
    public void passwordEncoderTest() {
        System.out.println(passwordEncoder.encode("123456"));
    }

    @Test
    public void BaseResultTest() {
        BaseResult baseResult = BaseResult.error();
        System.out.println(baseResult);
    }

}
