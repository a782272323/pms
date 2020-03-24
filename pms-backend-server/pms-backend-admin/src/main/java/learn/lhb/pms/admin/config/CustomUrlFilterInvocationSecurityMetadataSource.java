//package learn.lhb.pms.admin.config;
//
//import learn.lhb.pms.commons.constant.RoleConstant;
//import learn.lhb.pms.commons.constant.UrlConstant;
//import learn.lhb.pms.domain.rbac.TbResources;
//import learn.lhb.pms.domain.rbac.TbRole;
//import learn.lhb.pms.service.TbResourcesService;
//import org.checkerframework.checker.units.qual.A;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.access.SecurityConfig;
//import org.springframework.security.web.FilterInvocation;
//import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//
//import java.util.Collection;
//import java.util.List;
//
///**
// * 自定义请求地址处理类
// *
// * @author 梁鸿斌
// * @date 2020/3/24.
// * @time 14:49
// */
//@Component
//public class CustomUrlFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
//
//    private static final Logger LOG = LoggerFactory.getLogger(CustomUrlFilterInvocationSecurityMetadataSource.class);
//
//    @Autowired
//    private TbResourcesService tbResourcesService;
//    /**
//     * ant风格的路径匹配规则
//     */
//    AntPathMatcher antPathMatcher = new AntPathMatcher();
//
//    /**
//     * 通过当前的请求地址，获取该地址需要的用户角色
//     *
//     * @param object
//     * @return 返回的角色集合，将传给 AccessDecisionManger
//     * @throws IllegalArgumentException
//     */
//    @Override
//    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
//        // 获取请求地址，从 object 中提起 url
//        String requestUrl = ((FilterInvocation) object).getRequestUrl();
//        LOG.debug("用户的请求地址为 {}",requestUrl);
//        // 如果请求地址为登录的路径，不需要任何角色即可访问，直接返回null。
//        if (UrlConstant.LOGIN_URL.equals(requestUrl)) {
//            return null;
//        }
//        // 从数据库查询url和role的关系，并存入list
//        List<TbResources> resources = tbResourcesService.getAllResources();
//        // 遍历资源表，进行请求地址获取的 url 和数据库查询的 url 进行比对
//        for (TbResources resource : resources) {
//            if (antPathMatcher.match(resource.getUrl(), requestUrl) && resource.getRoles().size() > 0) {
//                List<TbRole> roles = resource.getRoles();
//                int size = roles.size();
//                String[] values = new String[size];
//                // 资源表对应的角色可能有多个，遍历角色
//                for (int i = 0; i < size; i++) {
//                    values[i] = roles.get(i).getName();
//                }
//                // 创建一个角色集合
//                return SecurityConfig.createList(values);
//            }
//        }
//        // 没有匹配以上的资源，默认为登录访问
//        return SecurityConfig.createList(RoleConstant.LOGIN);
//    }
//
//    @Override
//    public Collection<ConfigAttribute> getAllConfigAttributes() {
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return true;
//    }
//}
