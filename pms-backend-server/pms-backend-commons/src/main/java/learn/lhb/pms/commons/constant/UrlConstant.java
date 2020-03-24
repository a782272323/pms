package learn.lhb.pms.commons.constant;

/**
 * 请求地址常量封装
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 16:59
 */
public class UrlConstant {

    /**
     * 获取token
     */
    public static final String URL_OAUTH_TOKEN = "http://localhost:11111/oauth/token";
    /**
     * 从请求中获取的地址，若如下
     */
    public static final String LOGIN_URL = "/v1/user/login";
    /**
     * Swagger2 文档地址
     */
    public static final String SWAGGER2 = "/swagger-ui.html";
    /**
     * Swagger2 资源地址
     */
    public static final String SWAGGER2_RESOURCES = "/swagger-resources/**";
}
