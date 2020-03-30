package learn.lhb.pms.domain.basis;

import learn.lhb.pms.commons.persistence.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * 员工表实体类
 *
 * @author 梁鸿斌
 * @date 2020/3/28.
 * @time 21:52
 */
public class Employee extends BaseEntity {
    // todo 百度枚举

    private static final long serialVersionUID = -90000066L;
    /**
     * 员工姓名
     */
    private String name;
    /**
     * 员工性别
     */
    private String gender;
    /**
     * 出生日期（年月日)
     */
    private Date birthday;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 婚姻状况（离异，未婚，已婚），要求下拉框
     */
    private String wedlock;
    /**
     * 名族id
     */
    private Integer nationalId;
    /**
     * 籍贯
     */
    private String nationalPlace;
    /**
     * 政治面貌（地位）id
     */
    private Integer politicId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 联系地址
     */
    private String address;
    /**
     * 部门id，所属部门
     */
    private Integer departmentId;
    /**
     * 职称ID
     */
    private Integer jobLevelId;
    /**
     * 职位ID
     */
    private Integer positionalId;
    /**
     * 聘用形式（两种，劳务合同,劳动合同）
     */
    private String engageForm;
    /**
     * 最高学历，要求下拉框
     * 博士，硕士，本科，大专，中专，高中，初中，小学，其他
     */
    private String tiptopDegree;
    /**
     * 所属专业
     *
     */
    private String specialty;
    /**
     * 毕业院校
     */
    private String school;
    /**
     * 入职日期（年月日）
     */
    private Date beginDate;
    /**
     * 在职状态
     */
    private String workState;
    /**
     * 工号(百度根据某一规则生成)
     */
    private String workId;
    /**
     * 合同期限,如1，1.5
     */
    private Double contractTerm;
    /**
     * 转正日期(年月日)
     */
    private Date conversionTime;
    /**
     * 离职日期(年月日)
     */
    private Date notWorkDate;
    /**
     * 合同起始日期(年月日）
     */
    private Date beginContract;
    /**
     * 合同终止日期（年月日）
     */
    private Date endContract;
    /**
     * 工龄
     */
    private Double workAge;

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", birthday=" + birthday +
                ", id_card='" + idCard + '\'' +
                ", wedlock='" + wedlock + '\'' +
                ", nationalId=" + nationalId +
                ", nationalPlace='" + nationalPlace + '\'' +
                ", politicId=" + politicId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", departmentId=" + departmentId +
                ", jobLevelId=" + jobLevelId +
                ", positionalId=" + positionalId +
                ", engageForm='" + engageForm + '\'' +
                ", tiptopDegree='" + tiptopDegree + '\'' +
                ", specialty='" + specialty + '\'' +
                ", school='" + school + '\'' +
                ", beginDate=" + beginDate +
                ", workState='" + workState + '\'' +
                ", workId='" + workId + '\'' +
                ", contractTerm=" + contractTerm +
                ", conversionTime=" + conversionTime +
                ", notWorkDate=" + notWorkDate +
                ", beginContract=" + beginContract +
                ", endContract=" + endContract +
                ", workAge=" + workAge +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getWedlock() {
        return wedlock;
    }

    public void setWedlock(String wedlock) {
        this.wedlock = wedlock;
    }

    public String getNationalPlace() {
        return nationalPlace;
    }

    public void setNationalPlace(String nationalPlace) {
        this.nationalPlace = nationalPlace;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEngageForm() {
        return engageForm;
    }

    public void setEngageForm(String engageForm) {
        this.engageForm = engageForm;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public String getWorkState() {
        return workState;
    }

    public void setWorkState(String workState) {
        this.workState = workState;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Double getContractTerm() {
        return contractTerm;
    }

    public void setContractTerm(Double contractTerm) {
        this.contractTerm = contractTerm;
    }

    public Date getConversionTime() {
        return conversionTime;
    }

    public void setConversionTime(Date conversionTime) {
        this.conversionTime = conversionTime;
    }

    public Date getNotWorkDate() {
        return notWorkDate;
    }

    public void setNotWorkDate(Date notWorkDate) {
        this.notWorkDate = notWorkDate;
    }

    public Date getBeginContract() {
        return beginContract;
    }

    public void setBeginContract(Date beginContract) {
        this.beginContract = beginContract;
    }

    public Date getEndContract() {
        return endContract;
    }

    public void setEndContract(Date endContract) {
        this.endContract = endContract;
    }

    public Double getWorkAge() {
        return workAge;
    }

    public void setWorkAge(Double workAge) {
        this.workAge = workAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTiptopDegree() {
        return tiptopDegree;
    }

    public void setTiptopDegree(String tiptopDegree) {
        this.tiptopDegree = tiptopDegree;
    }

    public Integer getNationalId() {
        return nationalId;
    }

    public void setNationalId(Integer nationalId) {
        this.nationalId = nationalId;
    }

    public Integer getPoliticId() {
        return politicId;
    }

    public void setPoliticId(Integer politicId) {
        this.politicId = politicId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(Integer jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    public Integer getPositionalId() {
        return positionalId;
    }

    public void setPositionalId(Integer positionalId) {
        this.positionalId = positionalId;
    }
}
