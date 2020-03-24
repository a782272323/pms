package learn.lhb.pms.commons.constant;

/**
 * http 状态码 和 消息常量的封装
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 18:05
 */
public class HttpConstant {

    /* 状态码 */
    /**
     * 默认的成功的状态码
     */
    public static final int OK = 200;
    /**
     * 默认的失败的状态码
     */
    public static final int ERROR = 500;


    /* 常量 */
    /**
     * 默认成功返回的消息
     */
    public static final String MSG_DEFAULT_OK = "请求成功";
    /**
     * 默认失败返回的消息
     */
    public static final String MSG_DEFAULT_ERROR = "请求失败";
    /**
     * 默认系统异常返回的消息
     */
    public static final String MSG_DEFAULT_EXCEPTION = "系统异常，请联系管理员";
    /**
     * 用户名或者密码错误
     */
    public static final String MSG_USER_ERROR = "用户名或者密码错误";
    /**
     * 登录失败
     */
    public static final String MSG_LOGIN_ERROR = "登录失败,请检查用户名或密码是否有错";
    /**
     * 登录成功
     */
    public static final String MSG_LOGIN_OK = "登录成功";
}
