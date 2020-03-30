package learn.lhb.pms.commons.dto.basic;

import learn.lhb.pms.commons.persistence.BaseEntity;

import java.io.Serializable;

/**
 * 员工资料模块，表格参数（前端传递）
 *
 * @author 梁鸿斌
 * @date 2020/3/30.
 * @time 14:54
 */
public class EmployeeSortDto extends BaseEntity {

    private static final long serialVersionUID = -90000012L;
    /**
     * 员工名称
     */
    private String name;
    /**
     * 政治面貌名称
     */
    private String politicsName;
    /**
     * 名字名称
     */
    private String nationalName;
    /**
     * 职位名称
     */
    private String positionName;
    /**
     * 职位等级名称
     */
    private String jobLevelName;
    /**
     * 部门名称
     */
    private String departmentName;
    /**
     * 聘用形式
     */
    private String engageForm;

    public String getPoliticsName() {
        return politicsName;
    }

    public void setPoliticsName(String politicsName) {
        this.politicsName = politicsName;
    }

    public String getNationalName() {
        return nationalName;
    }

    public void setNationalName(String nationalName) {
        this.nationalName = nationalName;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public String getJobLevelName() {
        return jobLevelName;
    }

    public void setJobLevelName(String jobLevelName) {
        this.jobLevelName = jobLevelName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "EmployeeSortDto{" +
                "politicsName='" + politicsName + '\'' +
                ", nationalName='" + nationalName + '\'' +
                ", positionName='" + positionName + '\'' +
                ", jobLevelName='" + jobLevelName + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", engageForm='" + engageForm + '\'' +
                '}';
    }
}
