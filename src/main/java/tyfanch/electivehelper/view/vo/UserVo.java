package tyfanch.electivehelper.view.vo;

import java.io.Serializable;

/**
 * 用户视图数据
 */
public class UserVo implements Serializable {
    private Integer id = 0;
    private Integer type = 0;
    // 用户名
    private String username = "";
    // 邮箱
    private String email = "";
    // 密码
    private String password = "";
    // 确认密码
    private String confPassword = "";
    private String comment = "";
    // 验证码
    private String captcha = "";
    // 判断密码是否已经加密
    private Boolean passwordEncrypted = false;

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

    public String getConfPassword() {
        return this.confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCaptcha() {
        return this.captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public Boolean getPasswordEncrypted() {
        return this.passwordEncrypted;
    }

    public void setPasswordEncrypted(Boolean passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    @Override
    public String toString() {
        return "UserVo{" +
            "id=" + this.id +
            ", type='" + this.type + '\'' +
            ", username='" + this.username + '\'' +
            ", email='" + this.email + '\'' +
            ", password='" + this.password + '\'' +
            ", confPassword='" + this.confPassword + '\'' +
            ", comment='" + this.comment + '\'' +
            ", captcha='" + this.captcha + '\'' +
            ", passwordEncrypted=" + this.passwordEncrypted +
            '}';
    }
}
