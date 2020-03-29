package learn.lhb.pms.commons.vo;

import java.io.Serializable;

/**
 * 和前端交互的实体类
 * 分页，排序参数
 *
 * @author 梁鸿斌
 * @date 2020/3/29.
 * @time 18:04
 */
public class PageParams implements Serializable {


    private static final long serialVersionUID = -90000067L;
    /**
     * 分页的页数
     */
    private Integer pageIndex;
    /**
     * 页面加载的数据条数
     */
    private Integer pageSize;
    /**
     * 排序的类型
     */
    private String sortType;
    /**
     * 排序的字段名
     */
    private String sortName;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortType() {
        return sortType;
    }

    public void setSortType(String sortType) {
        this.sortType = sortType;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @Override
    public String toString() {
        return "PageParams{" +
                "pageIndex=" + pageIndex +
                ", pageSize=" + pageSize +
                ", sortType='" + sortType + '\'' +
                ", sortName='" + sortName + '\'' +
                '}';
    }
}
