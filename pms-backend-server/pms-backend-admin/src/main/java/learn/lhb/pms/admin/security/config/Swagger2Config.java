package learn.lhb.pms.admin.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2 配置
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 21:57
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("learn.lhb.pms.admin.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("松果人事管理系统接口文档")
                .description("后台网关接口: http://localhost:22222/v1")
                .version("1.0.0")
//                .license("The Apache License")
                .termsOfServiceUrl("http://www.baidu.com")
//                .contact(new Contact("您好","http://未上线.com","782272323@qq.com"))
                .build();
    }
}
