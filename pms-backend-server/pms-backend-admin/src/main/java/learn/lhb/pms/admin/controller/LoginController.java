package learn.lhb.pms.admin.controller;

import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import learn.lhb.pms.commons.constant.DtoParamsConstant;
import learn.lhb.pms.commons.constant.HttpConstant;
import learn.lhb.pms.commons.dto.BaseResult;
import learn.lhb.pms.commons.dto.login.LoginInfo;
import learn.lhb.pms.domain.rbac.TbResources;
import learn.lhb.pms.mapper.rbac.TbResourcesMapper;
import learn.lhb.pms.mapper.rbac.TbRoleMapper;
import learn.lhb.pms.service.impl.TbAccountServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
@Api(tags = "登录相关接口")
public class LoginController {

    /**
     * 日志
     */
    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Resource
    private TbAccountServiceImpl tbAccountService;

    @Resource
    private TbRoleMapper tbRoleMapper;

    @Resource
    private TbResourcesMapper tbResourcesMapper;

    /**
     * 用户信息
     * @param authentication
     * @return
     * @throws Exception
     */
    @ApiOperation("跳转首页，需要携带token，token不写在url后面")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username", value = "用户名", required = true)
    })
    @CrossOrigin
    @GetMapping("info")
    public BaseResult info(Authentication authentication) throws Exception {
        LOG.debug("获取用户消息登录到首页");
        String jsonString = authentication.getName();
        LOG.debug("jsonString = {}",jsonString);
        Map<String,Object> map = Maps.newHashMap();
        map.clear();
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setName(authentication.getName());
        loginInfo.setAvatar("");
        loginInfo.setRoles(tbRoleMapper.getRoleNameByUsername(authentication.getName()).getName());
//        map.put("name", authentication.getName());
//        map.put("roles", tbRoleMapper.getRoleNameByUsername(authentication.getName()).getName());
//        map.put("avatar", "");
//        map.put(DtoParamsConstant.ROUTER_TREE, tbResourcesMapper.getResourcesTree(tbRoleMapper.getRoleNameByUsername(authentication.getName()).getName()));
        return BaseResult.ok().put(HttpConstant.OK, HttpConstant.MSG_DEFAULT_OK, DtoParamsConstant.DATA, loginInfo);
    }

    /**
     * 退出/注销
     * @return
     */
    @ApiOperation("注销/退出")
    @PostMapping("logout")
    public BaseResult logout() {
        return BaseResult.ok(200);
    }

    /**
     * 获取前端动态加载路由需要的路由表
     * @return
     */
    @ApiOperation("获取前端动态加载路由需要的路由表")
    @GetMapping("router")
    public BaseResult router(Authentication authentication) {
        Map<String,Object> map = Maps.newHashMap();
        map.clear();
        map.put(DtoParamsConstant.ROUTER_TREE, tbResourcesMapper.getResourcesTree(tbRoleMapper.getRoleNameByUsername(authentication.getName()).getName()));
        return BaseResult.ok().put(HttpConstant.OK, HttpConstant.MSG_DEFAULT_OK, DtoParamsConstant.DATA, map);
    }
}
