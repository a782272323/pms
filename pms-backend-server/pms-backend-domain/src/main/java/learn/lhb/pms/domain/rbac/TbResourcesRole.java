package learn.lhb.pms.domain.rbac;

import learn.lhb.pms.commons.dto.BaseEntity;

/**
 * 资源角色关系表
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 12:36
 */
public class TbResourcesRole extends BaseEntity {

    private static final long serialVersionUID = -90000009L;
    /**
     * 资源id
     */
    private Long resourcesId;
    /**
     * 角色id
     */
    private Long roleId;

    @Override
    public String toString() {
        return "TbResourcesRole{" +
                "resourcesId=" + resourcesId +
                ", roleId=" + roleId +
                '}';
    }

    public Long getResourcesId() {
        return resourcesId;
    }

    public void setResourcesId(Long resourcesId) {
        this.resourcesId = resourcesId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
