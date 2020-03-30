package learn.lhb.pms.domain.basis;

import learn.lhb.pms.commons.persistence.BaseEntity;

/**
 * 职位表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/28.
 * @time 23:59
 */
public class Position extends BaseEntity {

    private static final long serialVersionUID = -90000001L;

    /**
     * 职位名称
     */
    private String name;
    /**
     * 是否启用，1启用，0禁用，默认为启用状态
     */
    private Boolean enabled;

    @Override
    public String toString() {
        return "Position{" +
                "name='" + name + '\'' +
                ", enabled=" + enabled +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
