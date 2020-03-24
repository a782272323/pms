//package learn.lhb.pms.admin.config;
//
//import learn.lhb.pms.commons.constant.DtoParamsConstant;
//import learn.lhb.pms.commons.constant.HttpConstant;
//import learn.lhb.pms.commons.constant.RoleConstant;
//import learn.lhb.pms.commons.dto.BaseResult;
//import learn.lhb.pms.commons.utils.MapperUtils;
//import org.springframework.security.access.AccessDecisionManager;
//import org.springframework.security.access.AccessDeniedException;
//import org.springframework.security.access.ConfigAttribute;
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.InsufficientAuthenticationException;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.stereotype.Component;
//
//import java.util.Collection;
//import java.util.Iterator;
//
///**
// * 从传入的角色集合判断用户的登录信息，以及具备的权限
// * 情况： 假设当前用户具备角色A、角色B，当前请求需要角色B、角色C，
// * 那么是要当前用户要包含所有请求角色才算授权成功还是只要包含一个就算授权成功？
// * 我这里采用了第二种方案，即只要包含一个即可。
// *
// * @author 梁鸿斌
// * @date 2020/3/24.
// * @time 17:48
// */
//@Component
//public class CustomUrlDecisionManager implements AccessDecisionManager {
//
//
//    /**
//     * 检查用户是否登录，以及是否具备相应的访问权限
//     * @param authentication 保存当前用户的登录的用户信息
//     * @param object
//     * @param configAttributes 接收 CustomUrlFilterInvocationSecurityMetadataSource 类传来的角色集合
//     * @throws AccessDeniedException
//     * @throws InsufficientAuthenticationException
//     */
//    @Override
//    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
//        // todo 百度 Iterator
//        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
//        while (iterator.hasNext()) {
//            ConfigAttribute attribute = iterator.next();
//            // 当前请求需要的权限
//            String currentRole = attribute.getAttribute();
//            // 如果权限为 ROLE_LOGIN 当前用户没有登录，没有登录就抛一个BadCredentialsException异常，登录了就直接返回，则这个请求将被成功执行
//            if (RoleConstant.LOGIN.equals(currentRole)) {
//                if (authentication instanceof AnonymousAuthenticationToken) {
//                    throw new BadCredentialsException(MapperUtils.mapToJson(BaseResult.error(200, HttpConstant.MSG_NOT_LOGIN)));
//                } else {
//                    return;
//                }
//            }
//            // 遍历collection，同时查看当前用户拥有的权限列表中是否具备需要的权限，具备就返回，否则抛异常
//            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
//            for (GrantedAuthority authority : authorities) {
//                if (authority.getAuthority().equals(currentRole)) {
//                    return;
//                }
//            }
//        }
//        throw new AccessDeniedException("权限不足");
//    }
//
////    @Override
////    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {
////        for (ConfigAttribute configAttribute : configAttributes) {
////            String currentRole = configAttribute.getAttribute();
////            if (RoleConstant.LOGIN.equals(currentRole)) {
////                if (authentication instanceof AnonymousAuthenticationToken) {
////                    throw new AccessDeniedException(MapperUtils.mapToJson(BaseResult.error(HttpConstant.MSG_NOT_LOGIN)));
////                } else {
////                    return;
////                }
////            }
////            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
////            for (GrantedAuthority authority : authorities) {
////                if (authority.getAuthority().equals(currentRole)) {
////                    return;
////                }
////            }
////        }
////        throw new AccessDeniedException(HttpConstant.MSG_NOT_ALLOW);
////    }
//
//    @Override
//    public boolean supports(ConfigAttribute attribute) {
//        return true;
//    }
//
//    @Override
//    public boolean supports(Class<?> clazz) {
//        return true;
//    }
//}
