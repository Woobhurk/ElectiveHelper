package tyfanch.electivehelper.bean;

import java.io.Serializable;

/**
 * 用户信息类
 */
public class User implements Serializable {
    // 用户ID
    private Integer id = 0;
    // 用户uuid
    private String uuid = "";
    // 用户类型
    private Integer type = 0;
    // 用户名
    private String username = "";
    // 邮箱
    private String email = "";
    // 密码
    private String password = "";
    // 其他信息
    private String comment = "";

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + this.id +
            ", uuid='" + this.uuid + '\'' +
            ", type=" + this.type +
            ", username='" + this.username + '\'' +
            ", email='" + this.email + '\'' +
            ", password='" + this.password + '\'' +
            ", comment='" + this.comment + '\'' +
            '}';
    }
}
