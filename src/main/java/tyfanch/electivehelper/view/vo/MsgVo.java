package tyfanch.electivehelper.view.vo;

import tyfanch.electivehelper.bean.User;

public class MsgVo {
    private Integer id;
    private User sender;
    private User receiver;
    private String msgTime;
    private String msgText;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getSender() {
        return this.sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return this.receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMsgTime() {
        return this.msgTime;
    }

    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }

    public String getMsgText() {
        return this.msgText;
    }

    public void setMsgText(String msgText) {
        this.msgText = msgText;
    }

    @Override
    public String toString() {
        return "MsgVo{" +
            "id=" + this.id +
            ", sender=" + this.sender +
            ", receiver=" + this.receiver +
            ", msgTime='" + this.msgTime + '\'' +
            ", msgText='" + this.msgText + '\'' +
            '}';
    }
}
