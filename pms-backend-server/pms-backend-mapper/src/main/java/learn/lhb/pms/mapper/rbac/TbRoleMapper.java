package learn.lhb.pms.mapper.rbac;

import learn.lhb.pms.domain.rbac.TbRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 梁鸿斌
 * @date 2020/3/25.
 * @time 17:45
 */
@Repository
public interface TbRoleMapper {

    /**
     * 用户名获取对应的角色name
     * @param username
     * @return
     */
    TbRole getRoleNameByUsername(String username);

}
