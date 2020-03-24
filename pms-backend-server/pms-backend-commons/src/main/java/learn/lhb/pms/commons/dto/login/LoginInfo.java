package learn.lhb.pms.commons.dto.login;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * 登录信息
 *
 * @author 梁鸿斌
 * @date 2020/3/23.
 * @time 13:38
 */
@ApiModel
public class LoginInfo implements Serializable {


    private static final long serialVersionUID = -90000027L;

    private String name;
    private String avatar;
    private String roles;

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
