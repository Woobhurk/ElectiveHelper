package tyfanch.electivehelper.bean;

import java.io.Serializable;

/**
 * 课程评论类
 */
public class Reply implements Serializable {
    private Integer id = 0;
    // 评论的课程id
    private Integer courseId = 0;
    // 评论者id
    private Integer senderId = 0;
    // 回复到的评论id
    private Integer replyTo = 0;
    // 评论时间
    private String replyTime = "";
    // 评论内容
    private String replyText = "";

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return this.courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getSenderId() {
        return this.senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReplyTo() {
        return this.replyTo;
    }

    public void setReplyTo(Integer replyTo) {
        this.replyTo = replyTo;
    }

    public String getReplyTime() {
        return this.replyTime;
    }

    public void setReplyTime(String replyTime) {
        this.replyTime = replyTime;
    }

    public String getReplyText() {
        return this.replyText;
    }

    public void setReplyText(String replyText) {
        this.replyText = replyText;
    }

    @Override
    public String toString() {
        return "Reply{" +
            "id=" + this.id +
            ", courseId=" + this.courseId +
            ", senderId=" + this.senderId +
            ", replyTo=" + this.replyTo +
            ", replyTime='" + this.replyTime + '\'' +
            ", replyText='" + this.replyText + '\'' +
            '}';
    }
}
