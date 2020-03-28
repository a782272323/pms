package learn.lhb.pms.domain.rbac;

import com.google.common.collect.Lists;
import learn.lhb.pms.commons.persistence.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * 用户类，
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:24
 */
public class TbAccount extends BaseEntity implements UserDetails {

    private static final long serialVersionUID = -90000004L;

    private String name;
    private String phone;
    private String email;
    private String telephone;
    private String address;
    /**
     * 账户状态是否启用，启用：1，禁用：0，默认为启用状态
     */
    private Boolean enabled;
    private String username;
    private String password;
    /**
     * 用户头像，先存本地，到时配合fastDFS使用
     */
    private String userFace;
    private String remark;
    private List<TbRole> roles;

    @Override
    public String toString() {
        return "TbAccount{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", enabled=" + enabled +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", userFace='" + userFace + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }


    /**
     * getters 和 setters
     * userDetails属性设置
     */

    /**
     * 获取当前用户所具有的角色
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = Lists.newArrayList();
        // 遍历角色对象来获取该用户对应的角色名
        for (TbRole role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    public Boolean getEnabled() {
//        return enabled;
//    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserFace() {
        return userFace;
    }

    public void setUserFace(String userFace) {
        this.userFace = userFace;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 账户是否过期
     * @return
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户是否锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 令牌是否过期，token
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 账户是否被禁用
     * @return
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }



    public List<TbRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TbRole> roles) {
        this.roles = roles;
    }
}
