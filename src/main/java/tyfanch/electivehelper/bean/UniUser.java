package tyfanch.electivehelper.bean;

import java.io.Serializable;

public class UniUser implements Serializable {
    private Integer id;
    private Integer type;
    private String account;
    private String password;
    private Integer userId;
    private String name;
    private String school;
    private String major;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return this.type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getAccount() {
        return this.account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return this.school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return this.major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "UniUser{" +
            "id=" + this.id +
            ", type=" + this.type +
            ", account='" + this.account + '\'' +
            ", password='" + this.password + '\'' +
            ", userId=" + this.userId +
            ", name='" + this.name + '\'' +
            ", school='" + this.school + '\'' +
            ", major='" + this.major + '\'' +
            '}';
    }
}
