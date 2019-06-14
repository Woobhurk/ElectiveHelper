package tyfanch.electivehelper.bean;

import java.io.Serializable;

/**
 * 聊天记录类
 */
public class Msg implements Serializable {
    // 聊天记录ID
    private Integer id = 0;
    // 发送方id
    private Integer senderId = 0;
    // 接收方id
    private Integer receiverId = 0;
    // 聊天记录时间
    private String msgTime = "";
    // 聊天记录内容
    private String msgText = "";

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return this.senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getReceiverId() {
        return this.receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
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
        return "Msg{" +
            "id=" + this.id +
            ", senderId=" + this.senderId +
            ", receiverId=" + this.receiverId +
            ", msgTime='" + this.msgTime + '\'' +
            ", msgText='" + this.msgText + '\'' +
            '}';
    }
}
