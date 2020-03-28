package learn.lhb.pms.domain.basis;

import java.io.Serializable;

/**
 * 不用进行权限认证的请求地址的实体类
 * @author 梁鸿斌
 * @date 2020/3/25.
 * @time 13:38
 */
public class IgnoreUrl implements Serializable {


    private static final long serialVersionUID = -90010224L;
    private Long id;
    private String url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
