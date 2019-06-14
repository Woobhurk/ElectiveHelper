package tyfanch.electivehelper.view.vo;

import java.io.Serializable;
import java.util.Arrays;

public class UpdateVo implements Serializable {
    // 更新的表
    private String tableName = "";
    // 更新的方法
    private Integer updateMethod = 0;
    // 要更新的列
    private String[] updateColumns = {};
    // 更新后的值
    private Object[] updateValues = {};
    // 条件字段
    private String[] columns = {};
    // 比较方法
    private String[] compares = {};
    // 比较值
    private Object[] values = {};
    // 连接词
    private String[] connectors = {};
    // 数据
    private Object bean = null;
    // 数据类型
    private Class beanClass = null;

    public UpdateVo() {}

    public UpdateVo(String tableName, Class beanClass) {
        this.tableName = tableName;
        this.beanClass = beanClass;
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getUpdateMethod() {
        return this.updateMethod;
    }

    public void setUpdateMethod(Integer updateMethod) {
        this.updateMethod = updateMethod;
    }

    public String[] getUpdateColumns() {
        return this.updateColumns;
    }

    public void setUpdateColumns(String... updateColumns) {
        this.updateColumns = updateColumns;
    }

    public Object[] getUpdateValues() {
        return this.updateValues;
    }

    public void setUpdateValues(Object... updateValues) {
        this.updateValues = updateValues;
    }

    public String[] getColumns() {
        return this.columns;
    }

    public void setColumns(String... columns) {
        this.columns = columns;
    }

    public String[] getCompares() {
        return this.compares;
    }

    public void setCompares(String... compares) {
        this.compares = compares;
    }

    public Object[] getValues() {
        return this.values;
    }

    public void setValues(Object... values) {
        this.values = values;
    }

    public String[] getConnectors() {
        return this.connectors;
    }

    public void setConnectors(String... connectors) {
        this.connectors = connectors;
    }

    public Object getBean() {
        return this.bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Class getBeanClass() {
        return this.beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    @Override
    public String toString() {
        return "UpdateVo{" +
            "tableName='" + this.tableName + '\'' +
            ", updateMethod=" + this.updateMethod +
            ", updateColumns=" + Arrays.toString(this.updateColumns) +
            ", updateValues=" + Arrays.toString(this.updateValues) +
            ", columns=" + Arrays.toString(this.columns) +
            ", compares=" + Arrays.toString(this.compares) +
            ", values=" + Arrays.toString(this.values) +
            ", connectors=" + Arrays.toString(this.connectors) +
            ", bean=" + this.bean +
            ", beanClass=" + this.beanClass +
            '}';
    }
}
