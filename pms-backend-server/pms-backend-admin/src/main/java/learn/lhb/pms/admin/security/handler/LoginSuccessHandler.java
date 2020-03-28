package learn.lhb.pms.admin.security.handler;

import com.google.common.collect.Maps;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.utils.MapperUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录成功处理
 *
 * @author 梁鸿斌
 * @date 2020/3/25.
 * @time 10:16
 */
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    /**日志**/
    private static final Logger LOG = LoggerFactory.getLogger(LoginSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        response.setContentType("application/json;charset=UTF-8");
        String userJsonStr = null;
        try {
            userJsonStr = MapperUtils.obj2json(authentication.getPrincipal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.debug("--------userJsonStr = "+userJsonStr);

        //生成token的方法一
        String token = Jwts.builder()
                .setSubject(userJsonStr)
                //设置token有效时间
                .setExpiration(new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000))
                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
                .compact();



        Map<String,Object> map = Maps.newHashMap();
        map.put("token",token);

        //签发token
        response.getWriter().write(MapperUtils.mapToJson(BaseResult.ok().put(HttpConstant.OK,HttpConstant.MSG_LOGIN_OK, DtoParamsConstant.DATA,map)));

    }

}
