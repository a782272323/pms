package learn.lhb.pms.admin.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.constant.UrlConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.utils.MapperUtils;
import learn.lhb.pms.domain.rbac.TbAccount;
import learn.lhb.pms.service.TbAccountService;
import learn.lhb.pms.service.impl.UserDetailsServiceImpl;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * 认证服务器安全配置
 * 及资源服务器配置
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 17:27
 */
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


//    @Resource
//    private CustomUrlFilterInvocationSecurityMetadataSource customUrlFilterInvocationSecurityMetadataSource;
//
//    @Resource
//    private CustomUrlDecisionManager customUrlDecisionManager;

    /**
     * 注入默认的密码编码器
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 注入登录用户名校验
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 注入认证管理器
     * 此项目仅采用密码模式
     *
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 不被 security 拦截的路径
     * 不需要进行权限校验
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                // 登录接口不拦截
                .antMatchers(UrlConstant.LOGIN_URL)
                // 放开swagger2的url
                .antMatchers(UrlConstant.SWAGGER2)
                .antMatchers("/v2/**")
                .antMatchers(UrlConstant.SWAGGER2_RESOURCES)
                .antMatchers("/course/coursebase/**")
                .antMatchers("/webjars/**")
//                .antMatchers("/index.html")
//                .antMatchers("/static/**")
                ;
    }

    /**
     * 安全拦截机制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {


        /**
         * oauth2 的配置
         */
        http
                // 支持跨域
                .cors()
                .and()
                .csrf().disable()
                // 允许配置错误处理
                .exceptionHandling()
                .and()
                // 禁止使用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 允许基于 HttpServletRequest 限制访问
                .authorizeRequests()
                // 配置授权规则,受保护的资源
                .antMatchers("/v1/user/info").hasAnyAuthority("USER")
                .antMatchers("/v1/user/logout").hasAnyAuthority("USER")
                // 放行的路径
//                .antMatchers("/v2/api-docs", "/swagger-resources/configuration/ui",
//                        "/swagger-resources","/swagger-resources/configuration/security",
//                        "/swagger-ui.html","/course/coursebase/**").permitAll()
//                .antMatchers(UrlConstant.SWAGGER2,"/v2/**",UrlConstant.SWAGGER2_RESOURCES).permitAll()
                .anyRequest().permitAll()

        ;


//        http.authorizeRequests()
//                .withObjectPostProcessor(new ObjectPostProcessor<FilterSecurityInterceptor>() {
//                    @Override
//                    public <O extends FilterSecurityInterceptor> O postProcess(O object) {
//                        object.setAccessDecisionManager(customUrlDecisionManager);
//                        object.setSecurityMetadataSource(customUrlFilterInvocationSecurityMetadataSource);
//                        return object;
//                    }
//                })
//                .and()
//                .formLogin()
//                .usernameParameter("username")
//                .passwordParameter("password")
//                .loginProcessingUrl(UrlConstant.LOGIN_URL)
//                .successHandler(new AuthenticationSuccessHandler() {
//                    @Override
//                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                        response.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = response.getWriter();
//                        TbAccount tbAccount = (TbAccount) authentication.getPrincipal();
//                        tbAccount.setPassword(null);
//                        String s = new ObjectMapper().writeValueAsString(BaseResult.ok(HttpConstant.MSG_LOGIN_OK));
//                        out.write(s);
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .failureHandler(new AuthenticationFailureHandler(){
//                    @Override
//                    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
//                        response.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = response.getWriter();
//                        BaseResult baseResult = BaseResult.ok();
//                        if (exception instanceof LockedException) {
//                            baseResult = BaseResult.error();
//                        } else if (exception instanceof CredentialsExpiredException) {
//                            baseResult = BaseResult.error();
//                        } else if (exception instanceof AccountExpiredException) {
//                            baseResult = BaseResult.error();
//                        } else if (exception instanceof DisabledException) {
//                            baseResult = BaseResult.error();
//                        } else if (exception instanceof BadCredentialsException) {
//                            baseResult = BaseResult.error();
//                        }
//                        String str = new ObjectMapper().writeValueAsString(baseResult);
//                        out.write(str);
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessHandler(new LogoutSuccessHandler() {
//                    @Override
//                    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                        response.setContentType("application/json;charset=utf-8");
//                        PrintWriter out = response.getWriter();
//                        out.write(new ObjectMapper().writeValueAsString(MapperUtils.mapToJson(BaseResult.ok())));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                .permitAll()
//                .and()
//                .csrf().disable().exceptionHandling()
//                // 没有认证时，在这里处理结果，不要重定向
//                .authenticationEntryPoint(new AuthenticationEntryPoint() {
//                    @Override
//                    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
//                        response.setContentType("application/json;charset=utf-8");
//                        response.setStatus(401);
//                        PrintWriter out = response.getWriter();
//                        BaseResult baseResult = BaseResult.ok();
//                        if (authException instanceof InsufficientAuthenticationException) {
//                            baseResult = BaseResult.ok(HttpConstant.MSG_DEFAULT_EXCEPTION);
//                        }
//                        out.write(new ObjectMapper().writeValueAsString(baseResult));
//                        out.flush();
//                        out.close();
//                    }
//                })
//                ;
    }
}
