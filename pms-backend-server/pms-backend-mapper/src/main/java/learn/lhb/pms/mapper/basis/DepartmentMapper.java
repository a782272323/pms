package learn.lhb.pms.mapper.basis;

import learn.lhb.pms.commons.persistence.BaseMapper;
import learn.lhb.pms.domain.basis.Department;
import org.springframework.stereotype.Repository;

/**
 * 部门表数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 11:39
 */
@Repository
public interface DepartmentMapper extends BaseMapper<Department> {

    /**
     * 根据名字获取id
     * @param name
     * @return
     */
    Department getIdByName(String name);
}
