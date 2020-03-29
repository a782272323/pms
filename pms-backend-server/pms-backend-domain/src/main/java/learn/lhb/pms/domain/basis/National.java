package learn.lhb.pms.domain.basis;

import java.io.Serializable;

/**
 * 民族表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 00:01
 */
public class National implements Serializable {

    private static final long serialVersionUID = -140994580626L;
    /**
     * 民族id，自增
     */
    private Long id;
    /**
     * 民族名称
     */
    private String name;

    @Override
    public String toString() {
        return "National{" +
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
