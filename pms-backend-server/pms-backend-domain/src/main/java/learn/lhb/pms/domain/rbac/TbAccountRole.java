package learn.lhb.pms.domain.rbac;

import learn.lhb.pms.commons.persistence.BaseEntity;

/**
 * 用户角色关系表
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 12:32
 */
public class TbAccountRole extends BaseEntity {


    private static final long serialVersionUID = -90000022L;
    /**
     * 用户id
     */
    private Long accountId;
    /**
     * 角色id
     */
    private Long roleId;

    @Override
    public String toString() {
        return "TbAccountRole{" +
                "accountId=" + accountId +
                ", roleId=" + roleId +
                '}';
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
