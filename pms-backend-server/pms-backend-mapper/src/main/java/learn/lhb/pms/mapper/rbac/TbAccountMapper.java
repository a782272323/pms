package learn.lhb.pms.mapper.rbac;

import learn.lhb.pms.domain.rbac.TbAccount;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * 用户表数据访问层
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 11:08
 */
@Repository
public interface TbAccountMapper {

    /**
     * 根据用户名查询数据库是否存在记录
     * @param username
     * @return
     */
    TbAccount loadUserByUsername(String username);
}
