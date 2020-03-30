package learn.lhb.pms.domain.basis;

import learn.lhb.pms.commons.persistence.BaseEntity;

import java.io.Serializable;

/**
 * 政治地位（面貌）表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 00:02
 */
public class PoliticsStatus extends BaseEntity {


    private static final long serialVersionUID = 8095876979431322226L;
    /**
     * 政治地位名称
     */
    private String name;

    @Override
    public String toString() {
        return "PoliticsStatus{" +
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
