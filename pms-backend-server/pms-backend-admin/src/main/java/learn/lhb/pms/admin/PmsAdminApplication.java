package learn.lhb.pms.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 00:04
 */
@SpringBootApplication(scanBasePackages = "learn.lhb.pms")
@MapperScan(basePackages = "learn.lhb.pms.mapper")
@EnableSwagger2
public class PmsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmsAdminApplication.class, args);
    }
}
