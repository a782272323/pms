package learn.lhb.pms.domain.rbac;

import learn.lhb.pms.commons.dto.BaseMapper;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:35
 */
public class TbRole extends BaseMapper {

    private static final long serialVersionUID = -90030935L;

    private String name;
    private String nameZh;
    private String description;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameZh() {
        return nameZh;
    }

    public void setNameZh(String nameZh) {
        this.nameZh = nameZh;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
