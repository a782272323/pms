package learn.lhb.pms.domain.basis;

import java.io.Serializable;
import java.util.Date;

/**
 * 职称等级表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 00:10
 */
public class JobLevel implements Serializable {

    private static final long serialVersionUID = -90000097L;
    /**
     * 职称等级表id，自增
     */
    private Long id;
    /**
     * 职称等级名称
     */
    private String name;
    /**
     * 职称等级，下拉框
     * 正高级，副高级，中级，初级，员级
     */
    private String titleLevel;
    /**
     * 创建时间（插入表数据时自动生成)
     */
    private Date created;
    /**
     * 是否启用，1启用，0禁用，默认启用状态
     */
    private Boolean enabled;

    @Override
    public String toString() {
        return "JobLevel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", titleLevel='" + titleLevel + '\'' +
                ", created=" + created +
                ", enabled=" + enabled +
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

    public String getTitleLevel() {
        return titleLevel;
    }

    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

