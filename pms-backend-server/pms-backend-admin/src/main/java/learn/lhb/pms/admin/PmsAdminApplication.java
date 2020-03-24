package learn.lhb.pms.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 00:04
 */
@SpringBootApplication(scanBasePackages = "learn.lhb.pms")
@MapperScan(basePackages = "learn.lhb.pms.mapper")
public class PmsAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(PmsAdminApplication.class, args);
    }
}
