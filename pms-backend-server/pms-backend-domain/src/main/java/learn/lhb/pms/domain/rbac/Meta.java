package learn.lhb.pms.domain.rbac;

import java.io.Serializable;

/**
 * 元数据表
 *
 * @author 梁鸿斌
 * @date 2020/3/27.
 * @time 01:11
 */
public class Meta implements Serializable {


    private static final long serialVersionUID = -90000101L;

    /**
     * 侧边栏标题
     */
    private String title;
    /**
     * 侧边栏菜单的图标样式
     */
    private String icon;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "Meta{" +
                "title='" + title + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }
}
