package learn.lhb.pms.mapper.rbac;

import learn.lhb.pms.domain.rbac.TbResources;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 资源表数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/24.
 * @time 14:53
 */
@Repository
public interface TbResourcesMapper {

    /**
     * 查询资源表中url和角色表中role的对应关系,主要是用来做ant风格的路径匹配
     * 优先级问题，如:/a/b/c,能被/a/**匹配，也能被/a/b/**匹配，
     * 故查询数要对数据排序, 顺序如下，从上往下排
     * /a/b/c
     * /a/b/**
     * /a/**
     * @return
     */
    List<TbResources> getAllResources();

    /**
     * 查询资源表和角色表的所有字段的并集
     * @return
     */
    List<TbResources> getAllResourcesWithRole();

    /**
     * 根据角色名获取资源参数来做路由表
     * @param roleName
     * @return
     */
    List<Map> getRouteByRoleName(String roleName);
//    List<Map<String,Object>> getRouteByRoleName(String roleName);
//    List<TbResources> getRouteByRoleName(String roleName);

    /**
     * 递归查询,返回层级关系给前端做路由表
     * @return
     */
    List<Map<String, Object>> getResourcesTree(String name);

    /**
     * 根据角色名查询能访问的权限
     * @param roleName
     * @return
     */
    List<TbResources> getUrlByRoleName(String roleName);
}
