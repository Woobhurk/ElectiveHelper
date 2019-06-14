package tyfanch.electivehelper.bean;

import java.io.Serializable;

/**
 * 教室信息类
 */
public class Classroom implements Serializable {
    private Integer id = 0;
    // 教室楼栋
    private String building = "";
    // 教室名
    private String room = "";

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuilding() {
        return this.building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return this.room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Classroom{" +
            "id=" + this.id +
            ", building='" + this.building + '\'' +
            ", room='" + this.room + '\'' +
            '}';
    }
}
