package tyfanch.electivehelper.view.vo;

import tyfanch.electivehelper.bean.User;

public class ReplyVo {
    private Integer id;
    private Integer courseId;
    private User sender;
    private Integer replyToId;
    private ReplyVo replyTo;
    private String replyTime;
    private String replyText;

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

    public User getSender() {
        return this.sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Integer getReplyToId() {
        return this.replyToId;
    }

    public void setReplyToId(Integer replyToId) {
        this.replyToId = replyToId;
    }

    public ReplyVo getReplyTo() {
        return this.replyTo;
    }

    public void setReplyTo(ReplyVo replyTo) {
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
        return "ReplyVo{" +
            "id=" + this.id +
            ", courseId=" + this.courseId +
            ", sender=" + this.sender +
            ", replyToId=" + this.replyToId +
            ", replyTo=" + this.replyTo +
            ", replyTime='" + this.replyTime + '\'' +
            ", replyText='" + this.replyText + '\'' +
            '}';
    }
}
