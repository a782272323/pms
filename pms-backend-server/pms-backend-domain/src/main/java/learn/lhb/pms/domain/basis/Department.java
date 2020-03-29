package learn.lhb.pms.domain.basis;

import java.io.Serializable;

/**
 * 部门表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/28.
 * @time 23:55
 */
public class Department implements Serializable {

    private static final long serialVersionUID = -90032664L;
    /**
     * 部门表id，自增
     */
    private Long id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门id（上一级部门id）
     */
    private Long parentId;
    /**
     * ant风格路径，1.4.5
     */
    private String depPath;
    /**
     * 是否启用，1启用，0禁用，默认启用状态
     */
    private Boolean enabled;
    /**
     * 判断是否是父级部门（1有子部门，0无子部门)
     */
    private Boolean isParent;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", parentId=" + parentId +
                ", depPath='" + depPath + '\'' +
                ", enabled=" + enabled +
                ", isParent=" + isParent +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getDepPath() {
        return depPath;
    }

    public void setDepPath(String depPath) {
        this.depPath = depPath;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
