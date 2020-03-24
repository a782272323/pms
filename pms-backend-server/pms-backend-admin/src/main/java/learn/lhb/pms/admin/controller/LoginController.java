package learn.lhb.pms.admin.controller;

import com.google.common.collect.Maps;
import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.constant.UrlConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.dto.LoginInfo;
import learn.lhb.pms.commons.dto.LoginParam;
import learn.lhb.pms.commons.utils.MapperUtils;
import learn.lhb.pms.commons.utils.OkHttpClientUtil;
import learn.lhb.pms.domain.rbac.TbRole;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 登录流程
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 17:21
 */
@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("v1/user")
public class LoginController {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Value("${oauth2.grant_type}")
    public String oauth2GrantType;

    @Value("${oauth2.client_id}")
    public String oauth2ClientId;

    @Value("${oauth2.client_secret}")
    public String oauth2ClientSecret;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Resource(name = "userDetailsService")
    private UserDetailsService userDetailsService;

    @Resource
    private TokenStore tokenStore;

    /**
     * 登录逻辑
     * @param loginParam
     * @return
     */
    @PostMapping("login")
    private BaseResult login(@RequestBody LoginParam loginParam) {
        LOG.debug("登录");
        LOG.debug(loginParam.toString());
        Map<String, Object> result = Maps.newHashMap();

        // 验证账户密码
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginParam.getUsername());
        if (userDetails == null || !passwordEncoder.matches(loginParam.getPassword(), userDetails.getPassword())) {
            return BaseResult.error(HttpConstant.MSG_USER_ERROR);
        }

        // 通过OKHttp3 客户端请求登录接口来获取token返回给前端
        Map<String, String> params = Maps.newHashMap();
        params.put("username", loginParam.getUsername());
        params.put("password", loginParam.getPassword());
        params.put("grant_type", oauth2GrantType);
        params.put("client_id", oauth2ClientId);
        params.put("client_secret", oauth2ClientSecret);
        try {
            // 解析响应结果封装并返回
            Response response = OkHttpClientUtil.getInstance().postData(UrlConstant.URL_OAUTH_TOKEN, params);
            String jsonString = Objects.requireNonNull(response.body().string());
            Map<String, Object> jsonMap = MapperUtils.json2map(jsonString);
            String token = String.valueOf(jsonMap.get("access_token"));
            result.put("token", token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BaseResult().put(HttpConstant.OK,HttpConstant.MSG_LOGIN_OK, DtoParamsConstant.DATA,result);
    }

    /**
     * 用户信息
     * @param authentication
     * @return
     * @throws Exception
     */
    @CrossOrigin
    @GetMapping("info")
    public BaseResult info(Authentication authentication) throws Exception {
        LOG.debug("获取用户消息登录到首页");
        String jsonString = authentication.getName();
        LOG.debug("jsonString = {}",jsonString);
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());
        loginInfo.setAvatar("");
        System.out.println(authentication.getAuthorities().getClass());
        loginInfo.setRoles("USER");
        return BaseResult.ok().put(HttpConstant.OK, HttpConstant.MSG_DEFAULT_OK, DtoParamsConstant.DATA, loginInfo);
    }

    /**
     * 退出/注销
     * @param request
     * @return
     */
    @PostMapping("logout")
    public BaseResult logout(HttpServletRequest request) {
        String token = request.getParameter("access_token");
        tokenStore.removeAccessToken(tokenStore.readAccessToken(token));
        return BaseResult.ok(200);
    }
}
