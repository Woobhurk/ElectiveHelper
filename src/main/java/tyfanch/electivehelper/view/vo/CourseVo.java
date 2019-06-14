package tyfanch.electivehelper.view.vo;

import java.io.Serializable;
import tyfanch.electivehelper.bean.Classroom;
import tyfanch.electivehelper.bean.Teacher;

public class CourseVo implements Serializable {
    private Integer id;
    private Teacher teacher;
    private String name;
    private String description;
    private String keywords = "";
    private String startTime;
    private String endTime;
    private Classroom classroom;
    private Integer dayOfWeek;
    private Integer classOfDay;
    private Integer rateTotal;
    private Integer rateCount;
    private Integer studentCount;
    private Integer replyCount;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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

    public Classroom getClassroom() {
        return this.classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
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

    public Integer getStudentCount() {
        return this.studentCount;
    }

    public void setStudentCount(Integer studentCount) {
        this.studentCount = studentCount;
    }

    public Integer getReplyCount() {
        return this.replyCount;
    }

    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    @Override
    public String toString() {
        return "CourseVo{" +
            "id=" + this.id +
            ", teacher=" + this.teacher +
            ", name='" + this.name + '\'' +
            ", description='" + this.description + '\'' +
            ", keywords='" + this.keywords + '\'' +
            ", startTime='" + this.startTime + '\'' +
            ", endTime='" + this.endTime + '\'' +
            ", classroom=" + this.classroom +
            ", dayOfWeek=" + this.dayOfWeek +
            ", classOfDay=" + this.classOfDay +
            ", rateTotal=" + this.rateTotal +
            ", rateCount=" + this.rateCount +
            ", studentCount=" + this.studentCount +
            ", replyCount=" + this.replyCount +
            '}';
    }
}
