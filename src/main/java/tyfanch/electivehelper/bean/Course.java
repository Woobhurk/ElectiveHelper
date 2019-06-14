package tyfanch.electivehelper.bean;

import java.io.Serializable;

/**
 * 课程信息类
 */
public class Course implements Serializable {
    private Integer id = 0;
    // 课程名称
    private String name = "";
    private Integer teacherId = 0;
    // 课程描述
    private String description = "";
    // 关键词
    private String keywords = "";
    // 起始时间
    private String startTime = "";
    // 结束时间
    private String endTime = "";
    // 上课教室id
    private Integer classroomId = 0;
    // 每周上课时间
    private Integer dayOfWeek = 0;
    // 每天上课时间
    private Integer classOfDay = 0;
    // 总评分
    private Integer rateTotal = 0;
    // 评分人数
    private Integer rateCount = 0;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return this.teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getClassroomId() {
        return this.classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Integer getDayOfWeek() {
        return this.dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getClassOfDay() {
        return this.classOfDay;
    }

    public void setClassOfDay(Integer classOfDay) {
        this.classOfDay = classOfDay;
    }

    public Integer getRateTotal() {
        return this.rateTotal;
    }

    public void setRateTotal(Integer rateTotal) {
        this.rateTotal = rateTotal;
    }

    public Integer getRateCount() {
        return this.rateCount;
    }

    public void setRateCount(Integer rateCount) {
        this.rateCount = rateCount;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + this.id +
            ", name='" + this.name + '\'' +
            ", teacherId=" + this.teacherId +
            ", description='" + this.description + '\'' +
            ", keywords='" + this.keywords + '\'' +
            ", startTime='" + this.startTime + '\'' +
            ", endTime='" + this.endTime + '\'' +
            ", classroomId=" + this.classroomId +
            ", dayOfWeek=" + this.dayOfWeek +
            ", classOfDay=" + this.classOfDay +
            ", rateTotal=" + this.rateTotal +
            ", rateCount=" + this.rateCount +
            '}';
    }
}
