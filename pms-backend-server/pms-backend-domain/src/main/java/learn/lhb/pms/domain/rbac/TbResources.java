package learn.lhb.pms.domain.rbac;

import com.google.common.collect.Lists;
import learn.lhb.pms.commons.persistence.BaseEntity;

import java.util.List;

/**
 * 资源表
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 12:25
 */
public class TbResources extends BaseEntity {

    private static final long serialVersionUID = -90006641L;

    /**
     * 路径匹配规则，例如：/admin/**
     */
    private String url;
    /**
     * vue路由中的path
     */
    private String path;
    /**
     * 面包屑重定向
     */
    private String redirect;
    /**
     * vue组件component中的路由路径
     */
    private String component;
    /**
     * 侧边栏菜单名字
     */
    private String name;
    /**
     * 侧边栏元数据 meta
     */
    private Meta meta;
    /**
     * 上一级资源id（父资源id），与资源id成为外键
     */
    private Long parentId;
    /**
     * 资源状态是否启用，启用：1，禁用：0，默认为启用状态
     */
    private Boolean enabled;
    /**
     * 描述
     */
    private String description;
    /**
     * 拥有的角色
     */
    private List<TbRole> roles;

    /**
     * 递归查询使用
     */
    private List<TbResources> children;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
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

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TbResources{" +
                "url='" + url + '\'' +
                ", path='" + path + '\'' +
                ", redirect='" + redirect + '\'' +
                ", component='" + component + '\'' +
                ", name='" + name + '\'' +
                ", meta=" + meta +
                ", parentId=" + parentId +
                ", enabled=" + enabled +
                ", description='" + description + '\'' +
                ", roles=" + roles +
                ", children=" + children +
                '}';
    }

    public List<TbRole> getRoles() {
        return roles;
    }

    public void setRoles(List<TbRole> roles) {
        this.roles = roles;
    }

    public List<TbResources> getChildren() {
        return children;
    }

    public void setChildren(List<TbResources> children) {
        this.children = children;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }
}
