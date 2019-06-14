package tyfanch.electivehelper.bean;

import java.io.Serializable;

public class StudentCourse implements Serializable {
    private Integer id;
    private Integer studentId;
    private Integer courseId;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "StudentCourse{" +
            "id=" + this.id +
            ", studentId=" + this.studentId +
            ", courseId=" + this.courseId +
            '}';
    }
}
