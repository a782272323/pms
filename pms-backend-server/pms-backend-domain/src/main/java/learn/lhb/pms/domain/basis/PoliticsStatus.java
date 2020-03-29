package learn.lhb.pms.domain.basis;

import java.io.Serializable;

/**
 * 政治地位（面貌）表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 00:02
 */
public class PoliticsStatus implements Serializable {


    private static final long serialVersionUID = 8095876979431322226L;
    /**
     * 政治地位表id，自增
     */
    private Long id;
    /**
     * 政治地位名称
     */
    private String name;

    @Override
    public String toString() {
        return "PoliticsStatus{" +
                "id=" + id +
                ", name='" + name + '\'' +
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
}
