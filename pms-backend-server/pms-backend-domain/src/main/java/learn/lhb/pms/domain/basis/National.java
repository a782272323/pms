package learn.lhb.pms.domain.basis;

import learn.lhb.pms.commons.persistence.BaseEntity;

import java.io.Serializable;

/**
 * 民族表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 00:01
 */
public class National extends BaseEntity {

    private static final long serialVersionUID = -140994580626L;
    /**
     * 民族名称
     */
    private String name;

    @Override
    public String toString() {
        return "National{" +
                ", name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
