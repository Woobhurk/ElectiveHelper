package tyfanch.electivehelper.view.vo;

import java.io.Serializable;

public class UniUserVo implements Serializable {
    private Integer type;
    private String account;
    private String password;
    private Boolean passwordEncrypted;

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

    public Boolean getPasswordEncrypted() {
        return this.passwordEncrypted;
    }

    public void setPasswordEncrypted(Boolean passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    @Override
    public String toString() {
        return "UniUserVo{" +
            "type=" + this.type +
            ", account='" + this.account + '\'' +
            ", password='" + this.password + '\'' +
            ", passwordEncrypted=" + this.passwordEncrypted +
            '}';
    }
}
