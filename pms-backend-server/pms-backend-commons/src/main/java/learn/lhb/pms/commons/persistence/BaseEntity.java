package learn.lhb.pms.commons.persistence;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:42
 */
public class BaseEntity implements Serializable {


    private static final long serialVersionUID = -90000017L;
    /**
     * id，自增
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
