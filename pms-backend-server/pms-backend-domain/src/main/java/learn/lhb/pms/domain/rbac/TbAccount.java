package learn.lhb.pms.domain.rbac;

import learn.lhb.pms.commons.dto.BaseEntity;

/**
 * 用户类，
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:24
 */
public class TbAccount extends BaseEntity {

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

    /**
     * getters 和 setters
     * userDetails属性设置
     */

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

    public Boolean getEnabled() {
        return enabled;
    }

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
}
