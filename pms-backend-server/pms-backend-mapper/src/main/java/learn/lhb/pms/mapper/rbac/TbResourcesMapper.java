package learn.lhb.pms.mapper.rbac;

import learn.lhb.pms.domain.rbac.TbResources;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

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
}
