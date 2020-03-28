package learn.lhb.pms.service;

import learn.lhb.pms.domain.basis.IgnoreUrl;
import learn.lhb.pms.domain.rbac.TbResources;
import learn.lhb.pms.mapper.basis.IgnoreUrlMapper;
import learn.lhb.pms.mapper.rbac.TbResourcesMapper;
import learn.lhb.pms.mapper.rbac.TbRoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 配置路径访问限制,若你的用户角色比较简单,不需要存数据库,
 * 可以在ApplicationConfigurerAdapter里配置如
 * httpSecurity
 * .authorizeRequests()
 * .antMatchers("/order").....
 *
 * @author 梁鸿斌
 * @date 2020/3/25.
 * @time 10:24
 */
@Component("accessDecisionService")
public class AccessDecisionService {

    public static final Logger LOG = LoggerFactory.getLogger(AccessDecisionService.class);

    @Resource
    private IgnoreUrlMapper ignoreUrlMapper;

    @Resource
    private TbRoleMapper tbRoleMapper;

    @Resource
    private TbResourcesMapper tbResourcesMapper;

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {

        // 不被拦截的路径
        List<IgnoreUrl> ignoreUrls = ignoreUrlMapper.getIgnoreUrl();
        String[] noUrl = new String[ignoreUrls.size()];
        for (int i = 0; i < ignoreUrls.size(); i++) {
            noUrl[i] = ignoreUrls.get(i).getUrl();
        }
        for (String url : Arrays.asList(noUrl)) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }

        if (authentication instanceof AnonymousAuthenticationToken) {
            return false;
        }

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        // 根据用户名查出拥有哪些权限
        List<String> urls = queryUrlByUserName(userDetails.getUsername());
        for (String url : urls) {
            if (antPathMatcher.match(url, request.getRequestURI())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 这里模拟数据库查询用户权限
     */
    private List<String > queryUrlByUserName(String username) {
        List<TbResources> resources = tbResourcesMapper.getUrlByRoleName(tbRoleMapper.getRoleNameByUsername(username).getName());
        String[] strings = new String[resources.size()];
        for (int i = 0; i < resources.size(); i++) {
            strings[i] = resources.get(i).getUrl();
        }
        // todo Arrays用法百度
        return Arrays.asList(strings);
//        switch (username) {
//            case "admin":
//                return Arrays.asList("/innerMsg", "/secret","/v1/user/info","/v1/user/logout","/v1/user/router");
//            case "user":
//                return Arrays.asList("/innerMsg");
//            default:
//                return new ArrayList<>();
//        }
    }
}