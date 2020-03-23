package learn.lhb.pms.admin.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

import javax.annotation.Resource;

/**
 * 配置认证服务器
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 17:26
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    /**
     * 密码编码器
     */
    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource
    private AuthenticationManager authenticationManager;

    /**
     * 先基于内存存储令牌
     * 后续看情况改成基于数据库存储令牌
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }

    /**
     * 配置令牌访问端点
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints
                // 认证管理器，开启密码模式
                .authenticationManager(authenticationManager)
                // token存储策略
                .tokenStore(tokenStore())
                ;
    }

    /**
     * 令牌端点的安全约束
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                // 允许客户端访问 /oauth/check_token 来检查 token
                .checkTokenAccess("isAuthenticated()")
                // 允许表单认证
                .allowFormAuthenticationForClients()
                ;
    }

    /**
     * 客户端详情
     * 可以从内存配置，也可以从数据库读取
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 使用内存配置
        clients
                .inMemory()
                .withClient("client")
                .secret(passwordEncoder.encode("secret"))
                .authorizedGrantTypes("password","refresh_token")
                .scopes("backend")
                .resourceIds("backend-resources")
                .accessTokenValiditySeconds(24 * 60 * 60)
                .refreshTokenValiditySeconds(30 * 24 * 60 * 60)
                ;
    }
}
