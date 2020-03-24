package learn.lhb.pms.commons.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的基类
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:42
 */
public class BaseMapper implements Serializable {


    private static final long serialVersionUID = -90000017L;
    /**
     * id，自增
     */
    private Long id;
    /**
     * 创建时间
     */
    private Date created;
    /**
     * 更新时间
     */
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
