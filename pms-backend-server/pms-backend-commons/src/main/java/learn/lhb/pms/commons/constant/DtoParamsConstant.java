package learn.lhb.pms.commons.constant;

/**
 * 数据传输对象常量封装
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 16:59
 */
public class DtoParamsConstant {

    /**
     * 返回前端的json数据的总称（处理code，message，time）
     */
    public static final String DATA = "data";
    /**
     * 获取列表数据（不管有多少行，只要是表格的数据)
     */
    public static final String LIST = "getList";
    /**
     * 返回数据的数量
     */
    public static final String COUNT = "COUNT";
    /**
     * 获取路由树
     */
    public static final String ROUTER_TREE = "getRouterTree";
    /**
     * vue需要的登录参数
     */
    public static final String LOGIN_INFO = "getLoginInfo";
}
