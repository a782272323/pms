package learn.lhb.pms.domain.rbac;

import learn.lhb.pms.commons.dto.BaseEntity;

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
     * vue组件component中的路由路径
     */
    private String Component;
    /**
     * 侧边栏的一级菜单名字
     */
    private String name;
    /**
     * 侧边栏一级菜单的图标的class样式
     */
    private String iconCls;
    /**
     * 未知
     */
    private String keepAlive;
    /**
     * 未知
     */
    private String requireAuth;
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
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIconCls() {
        return iconCls;
    }

    public void setIconCls(String iconCls) {
        this.iconCls = iconCls;
    }

    public String getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(String keepAlive) {
        this.keepAlive = keepAlive;
    }

    public String getRequireAuth() {
        return requireAuth;
    }

    public void setRequireAuth(String requireAuth) {
        this.requireAuth = requireAuth;
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
                ", Component='" + Component + '\'' +
                ", name='" + name + '\'' +
                ", iconCls='" + iconCls + '\'' +
                ", keepAlive='" + keepAlive + '\'' +
                ", requireAuth='" + requireAuth + '\'' +
                ", parentId=" + parentId +
                ", enabled=" + enabled +
                ", description='" + description + '\'' +
                '}';
    }
}
