package learn.lhb.pms.domain.rbac;

import learn.lhb.pms.commons.persistence.BaseEntity;

/**
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 10:35
 */
public class TbRole extends BaseEntity {

    private static final long serialVersionUID = -90030935L;

    /**
     * 名字（英文）
     */
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

    @Override
    public String toString() {
        return "TbRole{" +
                "name='" + name + '\'' +
                ", nameZh='" + nameZh + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
