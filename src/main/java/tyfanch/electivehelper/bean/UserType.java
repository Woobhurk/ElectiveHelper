package tyfanch.electivehelper.bean;

import java.io.Serializable;

/**
 * 用户类型类
 */
public class UserType implements Serializable {
    private Integer id = 0;
    // 用户类型
    private Integer type = 0;
    // 用户类型名
    private String typeName = "";

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

    public String getTypeName() {
        return this.typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
            "id=" + this.id +
            ", type=" + this.type +
            ", typeName='" + this.typeName + '\'' +
            '}';
    }
}
