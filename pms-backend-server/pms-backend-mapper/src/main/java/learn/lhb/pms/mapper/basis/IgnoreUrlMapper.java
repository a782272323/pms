package learn.lhb.pms.mapper.basis;

import learn.lhb.pms.domain.basis.IgnoreUrl;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 不用进行权限认证的请求地址的数据访问层
 *
 * @author 梁鸿斌
 * @date 2020/3/25.
 * @time 13:39
 */
@Repository
public interface IgnoreUrlMapper {
    /**
     * 获取 ignore url
     * @return
     */
    List<IgnoreUrl> getIgnoreUrl();
}
